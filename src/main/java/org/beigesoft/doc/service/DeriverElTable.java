package org.beigesoft.doc.service;

/*
 * Copyright (c) 2015-2017 Beigesoft ™
 *
 * Licensed under the GNU General Public License (GPL), Version 2.0
 * (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html
 */

import java.util.ArrayList;
import java.util.List;

import org.beigesoft.doc.exception.ExceptionBdw;
import org.beigesoft.doc.model.DocString;
import org.beigesoft.doc.model.DocLine;
import org.beigesoft.doc.model.IDerivingElements;
import org.beigesoft.doc.model.DocTable;
import org.beigesoft.doc.model.DocPage;
import org.beigesoft.doc.model.TableCell;
import org.beigesoft.doc.model.TableRow;
import org.beigesoft.doc.model.TableColumn;
import org.beigesoft.doc.model.MetricsString;
import org.beigesoft.doc.model.IDocContainer;
import org.beigesoft.doc.model.EWraping;
import org.beigesoft.doc.model.EAlignHorizontal;
import org.beigesoft.doc.model.EAlignVertical;

/**
 * <p>Service that derives atomic elements from DocTable.
 * Here DocTable padding don't used.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DeriverElTable<WI> implements IDeriverElements<WI, DocTable<WI>> {

  /**
   * <p>Element factory.</p>
   **/
  private IFctElement<WI> elementFactory;

  /**
   * <p>Document maker.</p>
   **/
  private IDocumentMaker<WI> documentMaker;

  /**
   * <p>MetricsString evaluator.</p>
   **/
  private IEvalMetricsString evalMetricsString;

  /**
   * <p>Derives (generates) document atomic elements.</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  @Override
  public final void derive(final DocTable<WI> pTbl) throws Exception {
    // A. When table fill parent (the most used method) or its width is fixed.
    //    Algorithm:
    // 1. eval table start position according parent, its horizontal alignment,
    //    margins.
    // 2. eval cell's content size, and size of columns/rows that wrap content.
    // 3. eval width for columns that non-wraping and non-fixed.
    // 4. eval content positions (X1/X2/Y1/Y2). It may involve creating new
    //    page and adding repeated head and so on...
    // Seldom usage way:
    // B. If table wrap content then all children must either wrap content
    //    or be fixed! Algorithm:
    // 1. eval cell's content size, and size of columns/rows,
    //    if there is one that don't wrap content or fixed,
    //    then ExceptionBdw will occurred
    // 2. eval table start position according parent, its horizontal alignment,
    //    margins, content size.
    // 3. eval content positions (X1/X2/Y1/Y2). It might involve creating new
    //    page and adding repeated head and so on...
    if (EWraping.FILL_PARENT.equals(pTbl.getWraping())
      && pTbl.getIsWidthFixed() && pTbl.getWidthInPercentage() < 3.0) {
      throw new ExceptionBdw(
        "Table that Fill parent has wrong fixed width in no %!!!: "
          + pTbl.getWidthInPercentage());
    }
    if (pTbl.getIsWidthFixed()
      && EWraping.WRAP_CONTENT.equals(pTbl.getWraping())) {
      throw new ExceptionBdw("Table has Wrap content and fixed width!!!");
    }
    if (EWraping.FILL_PARENT.equals(pTbl.getWraping())) {
      // 1. !pTbl.getIsWidthFixed() means 100% of parent
      // 2. pTbl.getIsWidthFixed() && pTbl.getIsWidthInPercentage()
      //    && pTbl.width=70 means 70% of parent
      evalWidthPosForTableAndRows(pTbl);
      evalWrappedContentSize(pTbl, pTbl.getWidth());
      evalFloatColumnWidths(pTbl);
      evalColumnPosX(pTbl);
      evalContentHeightsAndPosY(pTbl);
    } else {
      // 1. pTbl.getIsWidthFixed() && !pTbl.getIsWidthInPercentage()
      //    && pTbl.width=200 means 200 UOM
      // 2. EWraping.WRAP_CONTENT.equals(pTbl.getWraping())
      //    means table width = content width and content mustn't fill parent
      evalWidthPosForTableAndRows(pTbl);
      evalColumnPosX(pTbl);
      evalContentHeightsAndPosY(pTbl);
    }
    generateAtomics(pTbl);
  }

  /**
   * <p>Init data after possible changes.</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  @Override
  public final void initAfterChanges(final DocTable<WI> pTbl) throws Exception {
    for (TableCell cel : pTbl.getItsCells()) {
      cel.setMetricsString(null);
      if (cel.getMergedCells() != null) {
        for (TableCell mcel : cel.getMergedCells()) {
          mcel.setIsMerged(false);
        }
        cel.setMergedCells(null);
      }
    }
    for (TableRow row : pTbl.getItsRows()) {
      if (!row.getIsHeightFixed()) {
        row.setWidth(0.0);
        row.setWidthInPercentage(0.0);
        row.setX1(0.0);
        row.setX2(0.0);
        row.setHeight(0.0);
        row.setY1(0.0);
        row.setY2(0.0);
      }
    }
    for (TableColumn col : pTbl.getItsColumns()) {
      if (!col.getIsWidthFixed()) {
        col.setWidth(0.0);
        col.setWidthInPercentage(0.0);
        col.setX1(0.0);
        col.setX2(0.0);
      }
    }
    if (!pTbl.getIsWidthFixed()) {
      pTbl.setWidth(0.0);
      pTbl.setWidthInPercentage(0.0);
      pTbl.setX1(0.0);
      pTbl.setX2(0.0);
    }
  }

  /**
   * <p>Add top row line.</p>
   * @param pTbl table
   * @param pRow Row
   * @param pPgNum Page Number
   * @throws Exception an Exception
   **/
  public final void addTopRowLine(final DocTable<WI> pTbl,
    final TableRow pRow, final Integer pPgNum) throws Exception {
    DocLine<WI> dln = this.elementFactory.createDocLine(pTbl);
    dln.setWidth(pTbl.getBorder());
    dln.setX1(pRow.getX1());
    dln.setY1(pRow.getY1());
    dln.setX2(pRow.getX2());
    dln.setY2(pRow.getY1());
    pTbl.getDocument().getPages().get(pPgNum - 1).getElements().add(dln);
  }

  /**
   * <p>Add bottom, left, right row lines.</p>
   * @param pTbl table
   * @param pRow Row
   * @param pPgNum Page Number
   * @throws Exception an Exception
   **/
  public final void addBlrRowLines(final DocTable<WI> pTbl,
    final TableRow pRow, final Integer pPgNum) throws Exception {
    // bottom pRow line
    DocLine<WI> dlnb = this.elementFactory.createDocLine(pTbl);
    dlnb.setWidth(pTbl.getBorder());
    dlnb.setX1(pRow.getX1());
    dlnb.setY1(pRow.getY2());
    dlnb.setX2(pRow.getX2());
    dlnb.setY2(pRow.getY2());
    pTbl.getDocument().getPages().get(pPgNum - 1)
      .getElements().add(dlnb);
    // left pRow line
    DocLine<WI> dlnl = this.elementFactory.createDocLine(pTbl);
    dlnl.setWidth(pTbl.getBorder());
    dlnl.setX1(pRow.getX1());
    dlnl.setY1(pRow.getY1());
    dlnl.setX2(pRow.getX1());
    dlnl.setY2(pRow.getY2());
    pTbl.getDocument().getPages().get(pPgNum - 1)
      .getElements().add(dlnl);
    // right pRow line
    DocLine<WI> dlnr = this.elementFactory.createDocLine(pTbl);
    dlnr.setWidth(pTbl.getBorder());
    dlnr.setX1(pRow.getX2());
    dlnr.setY1(pRow.getY1());
    dlnr.setX2(pRow.getX2());
    dlnr.setY2(pRow.getY2());
    pTbl.getDocument().getPages().get(pPgNum - 1)
      .getElements().add(dlnr);
  }

  /**
   * <p>Add right columns line for rows.</p>
   * @param pTbl table
   * @param pCol cloumn
   * @param pRows Rows
   * @param pPgNum Page Number for all rows if apply
   * @throws Exception an Exception
   **/
  public final void addRightColumnLineForRows(final DocTable<WI> pTbl,
    final TableColumn pCol, final List<TableRow> pRows,
      final Integer pPgNum) throws Exception {
    // right column line
    for (TableRow row : pRows) {
      DocLine<WI> dlnr = this.elementFactory.createDocLine(pTbl);
      dlnr.setWidth(pTbl.getBorder());
      dlnr.setX1(pCol.getX2());
      dlnr.setY1(row.getY1());
      dlnr.setX2(pCol.getX2());
      dlnr.setY2(row.getY2());
      Integer pgNum = pPgNum;
      if (pgNum == null) {
        pgNum = row.getPageNumber();
      }
      pTbl.getDocument().getPages().get(pgNum - 1).getElements().add(dlnr);
    }
  }

  /**
   * <p>Generate atomic strings for given cells/rows.</p>
   * @param pTbl table
   * @param pCells Cells
   * @param pRows Rows
   * @param pPgNum Page Number for all rows if apply
   * @throws Exception an Exception
   **/
  public final void generateStrings(final DocTable<WI> pTbl,
    final List<TableCell> pCells, final List<TableRow> pRows,
      final Integer pPgNum) throws Exception {
    int colCnt = pTbl.getItsColumns().size();
    int colIdx = 0;
    int rowIdx = 0;
    TableRow row = null;
    for (TableCell cel : pCells) {
      if (!cel.getIsMerged()) {
        TableColumn col = pTbl.getItsColumns().get(colIdx);
        if (row == null) {
          row = pRows.get(rowIdx);
        }
        for (int i = 0; i < cel.getMetricsString().getStrings().size(); i++) {
          String str = cel.getMetricsString().getStrings().get(i);
          DocString<WI> dstr = this.elementFactory.createDocString(pTbl);
          dstr.setFontNumber(cel.getFontNumber());
          dstr.setFontSize(cel.getFontSize());
          dstr.setValue(str);
          if (cel.getAlignHorizontal() == null
            || EAlignHorizontal.LEFT.equals(cel.getAlignHorizontal())) {
            dstr.setX1(col.getX1() + pTbl.getBorder() + col.getPaddingLeft());
          } else if (EAlignHorizontal.RIGHT.equals(cel.getAlignHorizontal())) {
            dstr.setX1(col.getX2() - pTbl.getBorder() - col.getPaddingRight()
              - cel.getMetricsString().getWidths().get(i));
          } else if (EAlignHorizontal.CENTER.equals(cel.getAlignHorizontal())) {
            double dw =
              (col.getWidth() - cel.getMetricsString().getWidths().get(i)) / 2;
            if (cel.getMergedCell() != null) {
              throw new ExceptionBdw("Not yet implemented!");
            }
            dstr.setX1(col.getX1() + dw);
          }
          dstr.setX2(dstr.getX1() + cel.getMetricsString().getWidth());
          if (!row.getIsHeightFixed() || cel.getAlignVertical() == null
            || EAlignVertical.TOP.equals(cel.getAlignVertical())) {
            dstr.setY1(row.getY1() + pTbl.getBorder() + row.getPaddingTop()
              + (cel.getFontSize() * i));
          } else if (row.getIsHeightFixed()
            && EAlignVertical.BOTTOM.equals(cel.getAlignVertical())) {
            dstr.setY1(row.getY2() - pTbl.getBorder() - row.getPaddingTop()
              - cel.getMetricsString().getHeight() + (cel.getFontSize() * i));
          } else if (row.getIsHeightFixed()
            && EAlignVertical.MIDDLE.equals(cel.getAlignVertical())) {
            double dh =
              (row.getWidth() - cel.getMetricsString().getHeight()) / 2;
            if (cel.getMergedCell() != null) {
              throw new ExceptionBdw("Not yet implemented!");
            }
            dstr.setY1(row.getY1() + dh + (cel.getFontSize() * i));
          }
          dstr.setY2(dstr.getY1() + cel.getFontSize());
          Integer pgNum = pPgNum;
          if (pgNum == null) {
            pgNum = row.getPageNumber();
          }
          pTbl.getDocument().getPages().get(pgNum - 1).getElements().add(dstr);
        }
      }
      colIdx++;
      if (colIdx == colCnt) {
        colIdx = 0;
        rowIdx++;
        row = null;
      }
    }
  }

  /**
   * <p>Generate atomic elements.</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  public final void generateAtomics(final DocTable<WI> pTbl) throws Exception {
    int colCnt = pTbl.getItsColumns().size();
    if (pTbl.getBorder() > 0.0000001
      && !pTbl.getIsThereCellWithCustomBorder()) {
      // repeated head:
      Integer pgFistRow = pTbl.getItsRows().get(0).getPageNumber();
      Integer pgLastRow = pTbl.getItsRows()
        .get(pTbl.getItsRows().size() - 1).getPageNumber();
      boolean isFirst = true;
      if (pTbl.getIsRepeatHead() && !pgFistRow.equals(pgLastRow)) {
        for (Integer pgCurr = pgFistRow + 1; pgCurr <= pgLastRow; pgCurr++) {
          isFirst = true;
          for (TableRow row : pTbl.getRepHeadRows()) {
            if (isFirst) {
              // top row line
              isFirst = false;
              addTopRowLine(pTbl, row, pgCurr);
            }
            addBlrRowLines(pTbl, row, pgCurr);
          }
          int colIdx = 0;
          for (TableColumn col : pTbl.getItsColumns()) {
            if (colIdx + 1 < colCnt) {
              addRightColumnLineForRows(pTbl, col, pTbl.getRepHeadRows(),
                pgCurr);
            }
            colIdx++;
          }
          generateStrings(pTbl, pTbl.getRepHeadCells(),
            pTbl.getRepHeadRows(), pgCurr);
        }
      }
      isFirst = true;
      Integer curPgNum = pTbl.getItsRows().get(0).getPageNumber();
      for (TableRow row : pTbl.getItsRows()) {
        if (isFirst || !curPgNum.equals(row.getPageNumber())
          && !pTbl.getIsRepeatHead()) {
          // top row line
          isFirst = false;
          curPgNum = row.getPageNumber();
          addTopRowLine(pTbl, row, row.getPageNumber());
        }
        addBlrRowLines(pTbl, row, row.getPageNumber());
      }
      int colIdx = 0;
      for (TableColumn col : pTbl.getItsColumns()) {
        if (colIdx + 1 < colCnt) {
          addRightColumnLineForRows(pTbl, col, pTbl.getItsRows(), null);
        }
        colIdx++;
      }
    } else if (pTbl.getBorder() > 0.0000001
      && pTbl.getIsThereCellWithCustomBorder()) {
      throw new ExceptionBdw("Not yet implemented!");
    }
    generateStrings(pTbl, pTbl.getItsCells(), pTbl.getItsRows(), null);
  }

  /**
   * <p>Evaluate X positions, widths for float columns.</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  public final void evalFloatColumnWidths(
    final DocTable<WI> pTbl) throws Exception {
    //widths percentage 100% = table width - widths fixed (include wrap):
    //e.g. t=120 c1=10, c2=30 c3=10(wrap) c4=70% c5, c6=fill parent
    //so wd100%=120-10-30-10=80 c4=80*0.7 c5=c6=80*0.15
    double fixedColWd = 0.0;
    double fixedPrColWdPr = 0.0;
    double floatColWdPr = 0.0;
    int floatColCn = 0;
    for (TableColumn col : pTbl.getItsColumns()) {
      if (EWraping.WRAP_CONTENT.equals(col.getWraping())) {
        fixedColWd += col.getWidth();
      } else if (col.getIsWidthFixed()
        && !EWraping.FILL_PARENT.equals(col.getWraping())) {
        fixedColWd += col.getWidth();
      } else if (col.getIsWidthFixed()
        && EWraping.FILL_PARENT.equals(col.getWraping())) {
        if (col.getWidthInPercentage() < 2.0) {
          throw new ExceptionBdw("Wrong float column width%: "
            + col.getWidthInPercentage());
        }
        fixedPrColWdPr += col.getWidthInPercentage();
      } else {
        floatColCn++;
      }
    }
    double tblWidth = pTbl.getX2() - pTbl.getX1();
    double wd100pr = tblWidth - fixedColWd;
    if (wd100pr < 0.0) {
      throw new ExceptionBdw("Wrong fixed column widths: tbl/cols"
        + tblWidth + "/" + fixedColWd);
    }
    if (wd100pr < 0.0001 && (fixedPrColWdPr > 2.0 || floatColCn > 0)) {
      throw new ExceptionBdw("Wrong fixed column widths: tbl/cols"
        + tblWidth + "/" + fixedColWd);
    }
    if (fixedPrColWdPr > 100.0) {
      throw new ExceptionBdw("Wrong fixed column percentage widths: "
        + fixedPrColWdPr);
    }
    if (floatColCn > 0) {
      if (100.0 - fixedPrColWdPr < 2.0) {
        throw new ExceptionBdw("There is no place for float columns: "
          + fixedPrColWdPr);
      }
      floatColWdPr = (100.0 - fixedPrColWdPr) / floatColCn;
    }
    for (TableColumn col : pTbl.getItsColumns()) {
      if (EWraping.FILL_PARENT.equals(col.getWraping())
        && col.getIsWidthFixed()) { //float fixed %
        col.setWidth(wd100pr * col.getWidthInPercentage() / 100.0);
      } else if (EWraping.FILL_PARENT.equals(col.getWraping())) {
        //float unwrapping:
        col.setWidth(wd100pr * floatColWdPr / 100.0);
      }
    }
  }

  /**
   * <p>Evaluate X positions for columns.</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  public final void evalColumnPosX(
    final DocTable<WI> pTbl) throws Exception {
    double lastX2 = pTbl.getX1();
    for (TableColumn col : pTbl.getItsColumns()) {
      col.setX1(lastX2);
      col.setX2(lastX2 + col.getWidth());
      lastX2 = col.getX2();
    }
  }

  /**
   * <p>Evaluate content heights and Y positions.
   * It might involve creating new page(s).</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  public final void evalContentHeightsAndPosY(
    final DocTable<WI> pTbl) throws Exception {
    int colCnt = pTbl.getItsColumns().size();
    int rowIdx = 0;
    int colIdx = 0;
    // 1. eval content (rows) height:
    TableRow row = pTbl.getItsRows().get(0);
    for (TableCell cel : pTbl.getItsCells()) {
      TableColumn col = pTbl.getItsColumns().get(colIdx);
      if (row == null) {
        row = pTbl.getItsRows().get(rowIdx);
      }
      double borderWd;
      if (colIdx == 0) {
        borderWd = col.getBorder() * 2.0;
      } else {
        borderWd = col.getBorder();
      }
      double borderHt;
      if (rowIdx == 0) {
        borderHt = col.getBorder() * 2.0;
      } else {
        borderHt = col.getBorder();
      }
      if (!cel.getIsMerged() && cel.getMergedCell() == null
        && !EWraping.WRAP_CONTENT.equals(col.getWraping())) {
        double colWd = col.getWidth();
        String fntNm = pTbl.getDocument().getFonts()
          .get(cel.getFontNumber() - 1).getItsName();
        MetricsString ms = this.evalMetricsString.eval(cel.getItsContent(),
          fntNm, cel.getFontSize(), colWd - col.getPaddingLeft()
            - col.getPaddingRight() - borderWd, 0.0);
        cel.setMetricsString(ms);
        double celHeight = row.getPaddingTop() + ms.getHeight()
          + row.getPaddingBottom() + borderHt;
        if (row.getHeight() < celHeight) {
          row.setHeight(celHeight);
        }
      }
      colIdx++;
      if (colIdx == colCnt) {
        colIdx = 0;
        rowIdx++;
        row = null;
      }
    }
    // 2. evaluate header if exist
    DocPage<WI> curPg = pTbl.getStartPage();
    rowIdx = 0;
    colIdx = 0;
    row = pTbl.getItsRows().get(0);
    double repHeaderHeight = 0.0;
    if (pTbl.getIsRepeatHead()) {
      pTbl.setRepHeadRows(new ArrayList<TableRow>());
      TableRow hrow;
      TableRow hrowPrev;
      if (row.getIsHead()) {
        hrow = new TableRow(row);
        pTbl.getRepHeadRows().add(hrow);
        repHeaderHeight += hrow.getHeight();
        hrow.setY1(curPg.getMarginBottom() + pTbl.getMarginTop());
        hrow.setY2(hrow.getY1() + hrow.getHeight());
        hrowPrev = hrow;
      } else {
        throw new ExceptionBdw("Repeated header without itself!!!");
      }
      pTbl.setRepHeadCells(new ArrayList<TableCell>());
      for (TableCell cel : pTbl.getItsCells()) {
        if (row == null) {
          row = pTbl.getItsRows().get(rowIdx);
          if (row.getIsHead()) {
            if (pTbl.getRepHeadRows().size() == rowIdx) {
              hrow = new TableRow(row);
              pTbl.getRepHeadRows().add(hrow);
              repHeaderHeight += hrow.getHeight();
              hrow.setY1(hrowPrev.getY2());
              hrow.setY2(hrow.getY1() + hrow.getHeight());
              hrowPrev = hrow;
            } else {
              throw new ExceptionBdw("Row header after non-header!!! idx "
                + rowIdx);
            }
          }
        }
        if (row.getIsHead()) {
          pTbl.getRepHeadCells().add(cel);
        }
        colIdx++;
        if (colIdx == colCnt) {
          colIdx = 0;
          rowIdx++;
          row = null;
        }
      }
    }
    // 3. final evaluate table position, add pages and table headers if need
      //the first row might exceed page, so table move at new/next page
    row = pTbl.getItsRows().get(0);
    if (pTbl.getY1() + row.getHeight() > curPg.getHeight()) {
      if (pTbl.getIsY1Fixed()) {
        throw new ExceptionBdw("Table Y1 fixed exceed page! Y1/row1 height: "
          + pTbl.getY1() + "/" + row.getHeight());
      }
      curPg = evalNextOrNewPage(pTbl, curPg);
      pTbl.setY1(curPg.getMarginBottom() + pTbl.getMarginTop());
    }
    row.setPageNumber(pTbl.getDocument().getPageNumber());
    row.setY1(pTbl.getY1());
    row.setY2(pTbl.getY1() + row.getHeight());
    for (int i = 1; i < pTbl.getItsRows().size(); i++) {
      TableRow rowPrev = row;
      row = pTbl.getItsRows().get(i);
      if (rowPrev.getY2() + row.getHeight()
        > curPg.getHeight() - curPg.getMarginBottom()) {
        curPg = evalNextOrNewPage(pTbl, curPg);
        row.setY1(curPg.getMarginBottom() + repHeaderHeight);
      } else {
        row.setY1(rowPrev.getY2());
      }
      row.setPageNumber(pTbl.getDocument().getPageNumber());
      row.setY2(row.getY1() + row.getHeight());
    }
    pTbl.setY2(row.getY2());
  }

  /**
   * <p>Evaluates next or new page after given.</p>
   * @param pTbl table
   * @param pDocPg current page
   * @return next or new page
   * @throws Exception an Exception
   **/
  public final DocPage<WI> evalNextOrNewPage(
    final DocTable<WI> pTbl, final DocPage pDocPg) throws Exception {
    int pgIdx = pTbl.getDocument().getPages().indexOf(pDocPg);
    if (pgIdx + 1 == pTbl.getDocument().getPages().size()) {
      this.documentMaker.addPage(pTbl.getDocument());
    }
    return pTbl.getDocument().getPages().get(pgIdx + 1);
  }

  /**
   * <p>Evaluates merged cells, checks for ambigous data.</p>
   * @param pTbl table
   * @param pCel start merged cell
   * @param pCol start merged column
   * @param pCelIdx start cell index
   * @param pRowIdx start row index
   * @param pColIdx start col index
   * @return if there is wrapping merged
   * @throws Exception an Exception
   **/
  public final boolean evalMergedCells(
    final DocTable<WI> pTbl, final TableCell pCel, final TableColumn pCol,
      final int pCelIdx, final int pRowIdx,
        final int pColIdx) throws Exception {
    int colCnt = pTbl.getItsColumns().size();
    TableCell mcel = pCel.getMergedCell();
    int mcelIdx = pTbl.getItsCells().indexOf(mcel);
    int mcolIdx = (mcelIdx + colCnt) % colCnt;
    int mrowIdx = (mcelIdx + 1) / colCnt;
    boolean isMergedColumns = mcelIdx - pCelIdx == 1;
    if (isMergedColumns && mrowIdx != pRowIdx) {
      throw new ExceptionBdw(
        "Merged cells ambigous! cel #/# " + mcelIdx + "/" + pCelIdx);
    }
    if (!isMergedColumns && mcolIdx != pColIdx && mrowIdx - pRowIdx != 1) {
      throw new ExceptionBdw(
        "Merged cells ambigous! cel #/# " + mcelIdx + "/" + pCelIdx);
    }
    TableColumn mcol = pTbl.getItsColumns().get(mcolIdx);
    boolean wasMergedWrapped = true;
    if (EWraping.WRAP_CONTENT.equals(pCol.getWraping())) {
      wasMergedWrapped = true;
      if (isMergedColumns && !(EWraping.WRAP_CONTENT
        .equals(mcol.getWraping()) || mcol.getIsWidthFixed()
          && !EWraping.FILL_PARENT.equals(mcol.getWraping()))) {
        throw new ExceptionBdw(
          "Merged columns must has wraping or fixed widths! # "
            + mcolIdx);
      }
    }
    pCel.setMergedCells(new ArrayList<TableCell>());
    pCel.getMergedCells().add(mcel);
    while ((mcel = mcel.getMergedCell()) != null) {
      int mcelPrevIdx = mcelIdx;
      int mcolPrevIdx = mcolIdx;
      int mrowPrevIdx = mrowIdx;
      mcelIdx = pTbl.getItsCells().indexOf(mcel);
      mcolIdx = (mcelIdx + colCnt) % colCnt;
      mrowIdx = (mcelIdx + 1) / colCnt;
      if (isMergedColumns && mrowIdx != mrowPrevIdx) {
        throw new ExceptionBdw("Merged cells ambigous! cel #/# "
          + mcelIdx + "/" + mcelPrevIdx);
      }
      if (!isMergedColumns && mcolIdx != mcolPrevIdx
        && mrowIdx - mrowPrevIdx != 1) {
        throw new ExceptionBdw("Merged cells ambigous! cel #/# "
          + mcelIdx + "/" + mcelPrevIdx);
      }
      mcol = pTbl.getItsColumns().get(mcolIdx);
      if (isMergedColumns && !(EWraping.WRAP_CONTENT
        .equals(mcol.getWraping()) || mcol.getIsWidthFixed()
          && !EWraping.FILL_PARENT.equals(mcol.getWraping()))) {
        throw new ExceptionBdw(
          "Merged columns must has wraping or fixed widths! # "
            + mcolIdx);
      }
      mcel.setIsMerged(true);
      pCel.getMergedCells().add(mcel);
    }
    return wasMergedWrapped;
  }

  /**
   * <p>Evaluate wrapped and merged columns width.</p>
   * @param pTbl table
   * @param pCel current cell
   * @param pRow current row
   * @param pHeight height
   * @throws Exception an Exception
   **/
  public final void evalWrappedMergedRowsHeight(
    final DocTable<WI> pTbl, final TableCell pCel,
      final TableRow pRow, final double pHeight) throws Exception {
    throw new ExceptionBdw("Wrapped rows height not yet implemented!");
  }

  /**
   * <p>Evaluate wrapped and merged columns width.</p>
   * @param pTbl table
   * @param pCel current cell
   * @param pCol current column
   * @param pWidth width
   * @throws Exception an Exception
   **/
  public final void evalWrappedMergedColumnsWidth(
    final DocTable<WI> pTbl, final TableCell pCel,
      final TableColumn pCol, final double pWidth) throws Exception {
    int colCnt = pTbl.getItsColumns().size();
    double wrappedWidths = pCol.getWidth();
    double fixedWidths = 0.0;
    int wrapingCount = 1;
    for (TableCell mcel : pCel.getMergedCells()) {
      int mcelIdx = pTbl.getItsCells().indexOf(mcel);
      int mcolIdx = (mcelIdx + colCnt) % colCnt;
      TableColumn mcol = pTbl.getItsColumns().get(mcolIdx);
      if (EWraping.WRAP_CONTENT.equals(mcol.getWraping())) {
        wrapingCount++;
        wrappedWidths += mcol.getWidth();
      } else {
        fixedWidths += mcol.getWidth();
      }
    }
    if (fixedWidths + wrappedWidths < pWidth) {
      if (wrapingCount == 1) {
        //only master cell is wraping
        if (pCol.getWidth() < pWidth) {
          pCol.setWidth(pWidth);
        }
      } else {
        double awd = (pWidth - fixedWidths) / wrapingCount;
        double wrapedWidthNonCorrected = 0.0;
        int wrapingNonCorrectedCount = 0;
        for (TableCell mcel : pCel.getMergedCells()) {
          int mcelIdx = pTbl.getItsCells().indexOf(mcel);
          int mcolIdx = (mcelIdx + colCnt) % colCnt;
          TableColumn mcol = pTbl.getItsColumns().get(mcolIdx);
          if (EWraping.WRAP_CONTENT.equals(mcol.getWraping())) {
            if (mcol.getWidth() < awd) {
              mcol.setWidth(mcol.getWidth() + awd);
            } else {
              wrapedWidthNonCorrected += awd;
              wrapingNonCorrectedCount++;
              awd = (pWidth - fixedWidths - wrapedWidthNonCorrected)
                / (wrapingCount - wrapingNonCorrectedCount);
            }
          }
        }
      }
    }
  }

  /**
   * <p>Evaluate wrapped and merged content size.</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  public final void evalWrappedMergedContentSize(
    final DocTable<WI> pTbl) throws Exception {
    int colCnt = pTbl.getItsColumns().size();
    int celIdx = 0;
    int colIdx = 0;
    int rowIdx = 0;
    TableRow row = null;
    for (TableCell cel : pTbl.getItsCells()) {
      if (!cel.getIsMerged()) {
        TableColumn col = pTbl.getItsColumns().get(colIdx);
        if (row == null) {
          row = pTbl.getItsRows().get(rowIdx);
        }
        double borderWd;
        if (colIdx == 0) {
          borderWd = col.getBorder() * 2.0;
        } else {
          borderWd = col.getBorder();
        }
        double borderHt;
        if (rowIdx == 0) {
          borderHt = col.getBorder() * 2.0;
        } else {
          borderHt = col.getBorder();
        }
        if (cel.getMergedCell() != null
          && EWraping.WRAP_CONTENT.equals(col.getWraping())) {
          //either merged columns or rows:
          int mcelIdx = pTbl.getItsCells().indexOf(cel.getMergedCell());
          double wd = col.getPaddingLeft() + cel.getMetricsString().getWidth()
            + col.getPaddingLeft() + borderWd
              + (col.getBorder() * cel.getMergedCells().size());
          double ht = row.getPaddingTop() + cel.getMetricsString().getHeight()
            + row.getPaddingBottom() + borderHt;
          if (mcelIdx - celIdx == 1) { // merged columns:
            if (row.getHeight() < ht) {
              row.setHeight(ht);
            }
            evalWrappedMergedColumnsWidth(pTbl, cel, col, wd);
          } else { // merged rows:
            if (col.getWidth() < wd) {
              col.setWidth(wd);
            }
            evalWrappedMergedRowsHeight(pTbl, cel, row, ht);
          }
        }
      }
      celIdx++;
      colIdx++;
      if (colIdx == colCnt) {
        colIdx = 0;
        rowIdx++;
        row = null;
      }
    }
  }

  /**
   * <p>Evaluate wrapped content widths, heights (of cells, rows, columns)
   * include merged cells, also evaluate merged cells.
   * <pre>
   * Algorithm:
   * 1. for every unmerged cell:
   *    if has merged then evaluate all merged and check for errors
   *      (it also notes if there is wraping merged)
   *    else if wraping - evaluate size content -> column -> row
   * 2. if there is wraping merged then evaluate size for it/them
   * </pre>
   * </p>
   * @param pTbl table
   * @param pMaxWidth table max width
   * @throws Exception an Exception
   **/
  public final void evalWrappedContentSize(
    final DocTable<WI> pTbl, final double pMaxWidth) throws Exception {
    int colCnt = pTbl.getItsColumns().size();
    int rowIdx = 0;
    int colIdx = 0;
    int celIdx = 0;
    TableRow row = null;
    boolean wasMergedWrapped = false;
    for (TableCell cel : pTbl.getItsCells()) {
      if (!cel.getIsMerged()) {
        TableColumn col = pTbl.getItsColumns().get(colIdx);
        if (row == null) {
          row = pTbl.getItsRows().get(rowIdx);
        }
        double borderWd;
        if (colIdx == 0) {
          borderWd = col.getBorder() * 2.0;
        } else {
          borderWd = col.getBorder();
        }
        double borderHt;
        if (rowIdx == 0) {
          borderHt = col.getBorder() * 2.0;
        } else {
          borderHt = col.getBorder();
        }
        if (cel.getMergedCell() != null) {
          wasMergedWrapped = evalMergedCells(pTbl, cel, col,
            celIdx, rowIdx, colIdx);
        } else {
          if (EWraping.WRAP_CONTENT.equals(pTbl.getWraping())
            && EWraping.FILL_PARENT.equals(col.getWraping())) {
            throw new ExceptionBdw("Column fill for wrapping parent! # "
              + colIdx);
          }
          if (EWraping.WRAP_CONTENT.equals(col.getWraping())
            && col.getIsWidthFixed()) {
            throw new ExceptionBdw("Column has wraping and fixed widths! # "
              + colIdx);
          }
          if (EWraping.WRAP_CONTENT.equals(col.getWraping())) {
            String fntNm = pTbl.getDocument().getFonts()
              .get(cel.getFontNumber() - 1).getItsName();
            MetricsString ms = this.evalMetricsString.eval(cel.getItsContent(),
              fntNm, cel.getFontSize(), pMaxWidth, 0.0);
            cel.setMetricsString(ms);
            double wd = col.getPaddingLeft() + ms.getWidth()
              + col.getPaddingLeft() + borderWd;
            if (col.getWidth() < wd) {
              col.setWidth(wd);
            }
            double ht = row.getPaddingTop() + ms.getHeight()
              + row.getPaddingBottom() + borderHt;
            if (row.getHeight() < ht) {
              row.setHeight(ht);
            }
          }
        }
      }
      celIdx++;
      colIdx++;
      if (colIdx == colCnt) {
        colIdx = 0;
        rowIdx++;
        row = null;
      }
    }
    if (wasMergedWrapped) {
      evalWrappedMergedContentSize(pTbl);
    }
  }

  /**
   * <p>Evaluates width and positions X1, X2, Y1 for table and rows.</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  public final void evalWidthPosForTableAndRows(
    final DocTable<WI> pTbl) throws Exception {
    //parent/previous/page:
    IDocContainer prnt = pTbl.getParent();
    IDerivingElements prev = null;
    if (prnt == null) {
      int idxTbl = pTbl.getDocument().getDerivingElementsList().indexOf(pTbl);
      if (idxTbl > 0) { //previous:
        for (int i = idxTbl - 1; i >= 0; i--) {
          if (pTbl.getDocument().getDerivingElementsList()
            .get(i).getIsAffectedOnOtherPositions()) {
            prev = pTbl.getDocument().getDerivingElementsList().get(i);
            break;
          }
        }
      }
    }
    //Y1:
    if (!pTbl.getIsY1Fixed()) {
      if (prnt != null) {
        pTbl.setY1(prnt.getY2() + prnt.getPaddingBottom()
          + pTbl.getMarginTop());
      } else if (prev != null) {
        pTbl.setY1(prev.getY2() + prev.getMarginBottom() + pTbl.getMarginTop());
      } else {
        //page:
        pTbl.setY1(pTbl.getStartPage().getMarginTop() + pTbl.getMarginTop());
      }
    }
    double parentWd;
    if (prnt != null) {
      parentWd = prnt.getX2() - prnt.getX1() - prnt.getPaddingLeft()
        - prnt.getPaddingRight() - pTbl.getMarginLeft()
          - pTbl.getMarginRight() - prnt.getBorder() * 2;
    } else {
      parentWd = pTbl.getStartPage().getWidth()
        - pTbl.getStartPage().getMarginLeft() - pTbl.getStartPage()
          .getMarginRight() - pTbl.getMarginLeft() - pTbl.getMarginRight();
    }
    // widths:
    if (EWraping.WRAP_CONTENT.equals(pTbl.getWraping())) {
      //Width for wrapping table:
      double maxWd;
      if (prnt != null) {
        maxWd = prnt.getWidth();
      } else {
        maxWd = pTbl.getStartPage().getWidth() - pTbl.getStartPage()
          .getMarginLeft() - pTbl.getStartPage().getMarginRight();
      }
      if (maxWd < pTbl.getStartPage().getWidth() / 40.0) {
        throw new ExceptionBdw("Can't evaluate table max width!!!");
      }
      evalWrappedContentSize(pTbl, maxWd);
      double tblWd = 0.0;
      for (TableColumn col : pTbl.getItsColumns()) {
        tblWd += col.getWidth();
      }
      pTbl.setWidth(tblWd);
    } else if (EWraping.FILL_PARENT.equals(pTbl.getWraping())) {
      //Width for table that fills parent 100% or less:
      double wdprc;
      if (pTbl.getIsWidthFixed()) {
        if (pTbl.getWidthInPercentage() > 100.0
          || pTbl.getWidthInPercentage() < 3.0) {
          throw new ExceptionBdw("Wrong fixed width %!!!: "
            + pTbl.getWidthInPercentage());
        }
        wdprc = pTbl.getWidthInPercentage();
      } else {
        wdprc = 100.0;
      }
      pTbl.setWidth(parentWd * wdprc / 100.0);
    } else if (pTbl.getIsWidthFixed() && pTbl.getWidth() > parentWd
      || pTbl.getWidth() < parentWd * 0.1) {
      throw new ExceptionBdw("Wrong fixed width!!!: wd/parent wd "
        + pTbl.getWidth() + "/" + parentWd);
    }
    //X1, X2:
    if (!pTbl.getIsX1Fixed() && !pTbl.getIsX2Fixed()) {
      if (EAlignHorizontal.CENTER.equals(pTbl.getAlignHorizontal())) {
        double sp = (parentWd - pTbl.getWidth()) / 2;
        if (prnt != null) {
          pTbl.setX1(prnt.getX1() + prnt.getPaddingLeft() + prnt.getBorder()
            + pTbl.getMarginLeft() + sp);
        } else {
          pTbl.setX1(pTbl.getStartPage().getMarginLeft()
            + pTbl.getMarginLeft() + sp);
        }
        pTbl.setX2(pTbl.getX1() + pTbl.getWidth());
      } else if (EAlignHorizontal.LEFT.equals(pTbl.getAlignHorizontal())) {
        if (prnt != null) {
          pTbl.setX1(prnt.getX1() + prnt.getPaddingLeft() + prnt.getBorder()
            + pTbl.getMarginLeft());
        } else {
          pTbl.setX1(pTbl.getStartPage().getMarginLeft()
            + pTbl.getMarginLeft());
        }
        pTbl.setX2(pTbl.getX1() + pTbl.getWidth());
      } else if (EAlignHorizontal.RIGHT.equals(pTbl.getAlignHorizontal())) {
        if (prnt != null) {
          pTbl.setX2(prnt.getX2() - prnt.getPaddingRight() - prnt.getBorder()
            - pTbl.getMarginRight());
        } else {
          pTbl.setX2(pTbl.getStartPage().getWidth() - pTbl.getStartPage()
            .getMarginRight() - pTbl.getMarginRight());
        }
        pTbl.setX1(pTbl.getX2() - pTbl.getWidth());
      }
    } else if (!pTbl.getIsX1Fixed() && pTbl.getIsX2Fixed()) {
      pTbl.setX1(pTbl.getX2() - pTbl.getWidth());
    } else if (pTbl.getIsX1Fixed() && !pTbl.getIsX2Fixed()) {
      pTbl.setX2(pTbl.getX1() + pTbl.getWidth());
    } else if (pTbl.getWidth() - pTbl.getX2() + pTbl.getX1() < 0.00001) {
      // both fixed and wrong data
      throw new ExceptionBdw("Wrong table fixed width, X1, X2: "
        + pTbl.getWidth() + ", " + pTbl.getX1() + ", " + pTbl.getX2());
    }
    //final rows:
    for (TableRow row : pTbl.getItsRows()) {
      row.setX1(pTbl.getX1());
      row.setX2(pTbl.getX2());
      row.setWidth(pTbl.getWidth());
    }
  }

  //Simple getters and setters:
  /**
   * <p>Getter for elementFactory.</p>
   * @return IFctElement
   **/
  public final IFctElement<WI> getElementFactory() {
    return this.elementFactory;
  }

  /**
   * <p>Setter for elementFactory.</p>
   * @param pElementFactory reference
   **/
  public final void setElementFactory(final IFctElement<WI> pElementFactory) {
    this.elementFactory = pElementFactory;
  }

  /**
   * <p>Getter for documentMaker.</p>
   * @return IDocumentMaker<WI>
   **/
  public final IDocumentMaker<WI> getDocumentMaker() {
    return this.documentMaker;
  }

  /**
   * <p>Setter for documentMaker.</p>
   * @param pDocumentMaker reference
   **/
  public final void setDocumentMaker(final IDocumentMaker<WI> pDocumentMaker) {
    this.documentMaker = pDocumentMaker;
  }

  /**
   * <p>Getter for evalMetricsString.</p>
   * @return IEvalMetricsString
   **/
  public final IEvalMetricsString getEvalMetricsString() {
    return this.evalMetricsString;
  }

  /**
   * <p>Setter for evalMetricsString.</p>
   * @param pEvalMetricsString reference
   **/
  public final void setEvalMetricsString(
    final IEvalMetricsString pEvalMetricsString) {
    this.evalMetricsString = pEvalMetricsString;
  }
}
