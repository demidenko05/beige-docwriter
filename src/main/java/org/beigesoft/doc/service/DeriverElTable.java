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
    if (pTbl.getIsWidthFixed() || EWraping.FILL_PARENT
      .equals(pTbl.getWraping())) {
      evalPosWidForTabMeth1(pTbl);
      evalWrappedContentSize(pTbl);
      evalColumnsRowsPosWidths(pTbl);
      evalContentPosHeight(pTbl);
    } else {
      throw new ExceptionBdw(
        "Method table wrapped content not yet implemented!");
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
        col.setX1(0.0);
        col.setX2(0.0);
      }
    }
    if (!pTbl.getIsWidthFixed()) {
      pTbl.setWidth(0.0);
      pTbl.setX1(0.0);
      pTbl.setX2(0.0);
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
      boolean isFirst = true;
      for (TableRow row : pTbl.getItsRows()) {
        if (isFirst) {
          isFirst = false;
          // top row line
          DocLine<WI> dlnt = this.elementFactory.createDocLine();
          dlnt.setWidth(pTbl.getBorder());
          dlnt.setX1(row.getX1());
          dlnt.setY1(row.getY1());
          dlnt.setX2(row.getX2());
          dlnt.setY2(row.getY1());
          pTbl.getStartPage().getElements().add(dlnt);
        }
        // bottom row line
        DocLine<WI> dlnb = this.elementFactory.createDocLine();
        dlnb.setWidth(pTbl.getBorder());
        dlnb.setX1(row.getX1());
        dlnb.setY1(row.getY2());
        dlnb.setX2(row.getX2());
        dlnb.setY2(row.getY2());
        pTbl.getStartPage().getElements().add(dlnb);
        // left row line
        DocLine<WI> dlnl = this.elementFactory.createDocLine();
        dlnl.setWidth(pTbl.getBorder());
        dlnl.setX1(row.getX1());
        dlnl.setY1(row.getY1());
        dlnl.setX2(row.getX1());
        dlnl.setY2(row.getY2());
        pTbl.getStartPage().getElements().add(dlnl);
        // right row line
        DocLine<WI> dlnr = this.elementFactory.createDocLine();
        dlnr.setWidth(pTbl.getBorder());
        dlnr.setX1(row.getX2());
        dlnr.setY1(row.getY1());
        dlnr.setX2(row.getX2());
        dlnr.setY2(row.getY2());
        pTbl.getStartPage().getElements().add(dlnr);
      }
      int colIdx = 0;
      int rowIdx = 0;
      TableRow row = pTbl.getItsRows().get(rowIdx);
      for (TableColumn col : pTbl.getItsColumns()) {
        if (colIdx + 1 < colCnt) {
          // right column line
          DocLine<WI> dlnr = this.elementFactory.createDocLine();
          dlnr.setWidth(pTbl.getBorder());
          dlnr.setX1(col.getX2());
          dlnr.setY1(row.getY1());
          dlnr.setX2(col.getX2());
          dlnr.setY2(row.getY2());
          pTbl.getStartPage().getElements().add(dlnr);
        }
        colIdx++;
        if (colIdx == colCnt && rowIdx + 1 < pTbl.getItsRows().size()) {
          colIdx = 0;
          rowIdx++;
          row = pTbl.getItsRows().get(rowIdx);
        }
      }
    }
    int colIdx = 0;
    int rowIdx = 0;
    TableRow row = pTbl.getItsRows().get(rowIdx);
    for (TableCell cel : pTbl.getItsCells()) {
      //TODO custom cell borders
      if (!cel.getIsMerged()) {
        TableColumn col = pTbl.getItsColumns().get(colIdx);
        for (int i = 0; i < cel.getMetricsString().getStrings().size(); i++) {
          String str = cel.getMetricsString().getStrings().get(i);
          DocString<WI> dstr = this.elementFactory.createDocString();
          dstr.setFontNumber(cel.getFontNumber());
          dstr.setFontSize(cel.getFontSize());
          dstr.setValue(str);
          dstr.setX1(col.getX1() + pTbl.getBorder() + col.getPaddingLeft());
          dstr.setX2(dstr.getX1() + cel.getMetricsString().getWidth());
          dstr.setY1(row.getY1() + pTbl.getBorder() + row.getPaddingTop()
            + (cel.getFontSize() * i));
          dstr.setY2(dstr.getY1() + cel.getFontSize());
          pTbl.getStartPage().getElements().add(dstr);
        }
      }
      colIdx++;
      if (colIdx == colCnt && rowIdx + 1 < pTbl.getItsRows().size()) {
        colIdx = 0;
        rowIdx++;
        row = pTbl.getItsRows().get(rowIdx);
      }
    }
  }

  /**
   * <p>Evaluate columns, rows positions, widths.</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  public final void evalColumnsRowsPosWidths(
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
      } else if (col.getIsWidthFixed()) {
        if (!col.getIsWidthInPercentage()) {
          fixedColWd += col.getWidth();
        } else {
          fixedPrColWdPr += col.getWidth();
        }
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
    double lastX2 = pTbl.getX1();
    int colCount = pTbl.getItsColumns().size();
    int colIdx = 0;
    int rowIdx = 0;
    TableRow row = null;
    for (TableColumn col : pTbl.getItsColumns()) {
      col.setX1(lastX2);
      if (row == null) {
        row = pTbl.getItsRows().get(rowIdx);
        row.setX1(col.getX1());
      }
      if (col.getIsWidthFixed()) {
        if (col.getIsWidthInPercentage()) { //float fixed %
          col.setWidth(wd100pr * col.getWidth() / 100.0);
        }
      } else if (!EWraping.WRAP_CONTENT.equals(col.getWraping())) {
        //float unwrapping:
        col.setWidth(wd100pr * floatColWdPr / 100.0);
      }
      col.setX2(lastX2 + col.getWidth());
      lastX2 = col.getX2();
      colIdx++;
      if (colIdx == colCount) {
        row.setX2(col.getX2());
        row.setWidth(row.getX2() - row.getX1());
        row = null;
        colIdx = 0;
        rowIdx++;
      }
    }
  }

  /**
   * <p>Evaluate content height and positions.
   * It might involve creating new page(s).</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  public final void evalContentPosHeight(
    final DocTable<WI> pTbl) throws Exception {
    int colCnt = pTbl.getItsColumns().size();
    int rowIdx = 0;
    int colIdx = 0;
    List<TableRow> header = null;
    TableRow row = pTbl.getItsRows().get(0);
    if (pTbl.getIsRepeatHead()) {
      header = new ArrayList<TableRow>();
      if (row.getIsHead()) {
        header.add(row);
      } else {
        throw new ExceptionBdw("Repeated header without itself!!!");
      }
    }
    // 1. eval content (rows) height:
    for (TableCell cel : pTbl.getItsCells()) {
      TableColumn col = pTbl.getItsColumns().get(colIdx);
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
      if (colIdx == colCnt && rowIdx + 1 < pTbl.getItsRows().size()) {
        colIdx = 0;
        rowIdx++;
        row = pTbl.getItsRows().get(rowIdx);
        if (header != null && row.getIsHead()) {
          if (header.size() == rowIdx) {
            header.add(row);
          } else {
            throw new ExceptionBdw("Row header after non-header!!! idx "
              + rowIdx);
          }
        }
      }
    }
    // 2. final evaluate table position, add pages if need
      //the first row might exceed page, so table move at new/next page
    row = pTbl.getItsRows().get(0);
    DocPage<WI> curPg = pTbl.getStartPage();
    if (pTbl.getY1() + row.getHeight() > curPg.getHeight()) {
      curPg = evalNextOrNewPage(pTbl, curPg);
      pTbl.setY1(curPg.getMarginBottom() + pTbl.getMarginTop());
    }
    row.setY1(pTbl.getY1());
    row.setY2(pTbl.getY1() + row.getHeight());
    for (int i = 1; i < pTbl.getItsRows().size(); i++) {
      TableRow trowPrev = row;
      row = pTbl.getItsRows().get(i);
      if (trowPrev.getY2() + row.getHeight() > curPg.getHeight()) {
        curPg = evalNextOrNewPage(pTbl, pTbl.getStartPage());
        row.setY1(curPg.getMarginBottom());
      } else {
        row.setY1(trowPrev.getY2());
      }
      row.setY2(row.getY1() + row.getHeight());
    }
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
    } //TODO insert!!!
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
          && !mcol.getIsWidthInPercentage())) {
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
          && !mcol.getIsWidthInPercentage())) {
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
    TableRow row = pTbl.getItsRows().get(0);
    for (TableCell cel : pTbl.getItsCells()) {
      if (!cel.getIsMerged()) {
        TableColumn col = pTbl.getItsColumns().get(colIdx);
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
      if (colIdx == colCnt && rowIdx + 1 < pTbl.getItsRows().size()) {
        colIdx = 0;
        rowIdx++;
        row = pTbl.getItsRows().get(rowIdx);
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
   * @throws Exception an Exception
   **/
  public final void evalWrappedContentSize(
    final DocTable<WI> pTbl) throws Exception {
    int colCnt = pTbl.getItsColumns().size();
    int rowIdx = 0;
    int colIdx = 0;
    int celIdx = 0;
    double tblWidth = pTbl.getX2() - pTbl.getX1();
    TableRow row = pTbl.getItsRows().get(0);
    boolean wasMergedWrapped = false;
    for (TableCell cel : pTbl.getItsCells()) {
      if (!cel.getIsMerged()) {
        TableColumn col = pTbl.getItsColumns().get(colIdx);
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
          if (EWraping.WRAP_CONTENT.equals(col.getWraping())
            && col.getIsWidthFixed()) {
            throw new ExceptionBdw("Column has wraping and fixed widths! # "
              + colIdx);
          }
          if (EWraping.WRAP_CONTENT.equals(col.getWraping())) {
            String fntNm = pTbl.getDocument().getFonts()
              .get(cel.getFontNumber() - 1).getItsName();
            MetricsString ms = this.evalMetricsString.eval(cel.getItsContent(),
              fntNm, cel.getFontSize(), tblWidth, 0.0);
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
      if (colIdx == colCnt && rowIdx + 1 < pTbl.getItsRows().size()) {
        colIdx = 0;
        rowIdx++;
        row = pTbl.getItsRows().get(rowIdx);
      }
    }
    if (wasMergedWrapped) {
      evalWrappedContentSize(pTbl);
    }
  }

  /**
   * <p>Evaluates position and width for table that fill parent
   * or has fixed width.</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  public final void evalPosWidForTabMeth1(
    final DocTable<WI> pTbl) throws Exception {
    if (pTbl.getIsWidthFixed() && pTbl.getIsX1Fixed()
      && pTbl.getIsX2Fixed()) {
      throw new ExceptionBdw("Table's X1, X2, width are fixed!!!");
    }
    if (!(pTbl.getIsWidthFixed() || EWraping.FILL_PARENT
      .equals(pTbl.getWraping()))) {
      throw new ExceptionBdw("Table must fills parent or has fixed width!!!");
    }
    //parent/previous/page:
    IDocContainer prnt = pTbl.getParent();
    IDerivingElements prev = null;
    if (prnt == null) {
      int idxTbl = pTbl.getDocument().getDerivingElementsList().indexOf(pTbl);
      if (idxTbl > 0) { //previous:
        prev = pTbl.getDocument().getDerivingElementsList()
          .get(idxTbl - 1);
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
    //X1, X2
    if (pTbl.getIsWidthFixed()) {
      double wd;
      if (pTbl.getIsWidthInPercentage()) {
        if (pTbl.getWidth() > 100.0) {
          throw new ExceptionBdw("Wrong fixed width %!!!: " + pTbl.getWidth());
        }
        if (prnt != null) {
          wd = prnt.getX2() - prnt.getX1() - prnt.getPaddingLeft()
            - prnt.getPaddingRight() - pTbl.getMarginLeft()
              - pTbl.getMarginRight() - prnt.getBorder() * 2;
        } else {
          wd = pTbl.getStartPage().getWidth()
            - pTbl.getStartPage().getMarginLeft() - pTbl.getStartPage()
              .getMarginRight() - pTbl.getMarginLeft() - pTbl.getMarginRight();
        }
        wd = wd * pTbl.getWidth() / 100.0;
      } else {
        wd = pTbl.getWidth();
      }
      double wdp;
      if (prnt != null) {
        wdp = prnt.getX2() - prnt.getX1() - prnt.getPaddingLeft()
         - prnt.getPaddingRight() - prnt.getBorder() * 2;
      } else {
        wdp = pTbl.getStartPage().getWidth() - pTbl.getStartPage()
          .getMarginLeft() - pTbl.getStartPage().getMarginRight();
      }
      if (wd > wdp) {
        throw new ExceptionBdw("Wrong fixed width!!!: wd/pwd "
          + wd + "/" + wdp);
      }
      double sp = (wdp - wd) / 2;
      if (!pTbl.getIsX1Fixed() && !pTbl.getIsX2Fixed()) {
        if (EAlignHorizontal.CENTER.equals(pTbl.getAlignHorizontal())) {
          if (prnt != null) {
            pTbl.setX1(prnt.getX1() + prnt.getPaddingLeft() + prnt.getBorder()
              + pTbl.getMarginLeft() + sp);
          } else {
            pTbl.setX1(pTbl.getStartPage().getMarginLeft()
              + pTbl.getMarginLeft() + sp);
          }
          pTbl.setX2(pTbl.getX1() + wd);
        } else if (EAlignHorizontal.LEFT.equals(pTbl.getAlignHorizontal())) {
          if (prnt != null) {
            pTbl.setX1(prnt.getX1() + prnt.getPaddingLeft() + prnt.getBorder()
              + pTbl.getMarginLeft());
          } else {
            pTbl.setX1(pTbl.getStartPage().getMarginLeft()
              + pTbl.getMarginLeft());
          }
          pTbl.setX2(pTbl.getX1() + wd);
        } else if (EAlignHorizontal.RIGHT.equals(pTbl.getAlignHorizontal())) {
          if (prnt != null) {
            pTbl.setX2(prnt.getX2() - prnt.getPaddingRight() - prnt.getBorder()
              - pTbl.getMarginRight());
          } else {
            pTbl.setX2(pTbl.getStartPage().getWidth() - pTbl.getStartPage()
              .getMarginRight() + pTbl.getMarginRight());
          }
          pTbl.setX1(pTbl.getX2() - wd);
        }
      } else if (!pTbl.getIsX1Fixed() && pTbl.getIsX2Fixed()) {
        pTbl.setX1(pTbl.getX2() - wd);
      } else if (pTbl.getIsX1Fixed() && !pTbl.getIsX2Fixed()) {
        pTbl.setX2(pTbl.getX1() + wd);
      }
    } else {
      if (!pTbl.getIsX1Fixed()) {
        if (prnt != null) {
          pTbl.setX1(prnt.getX1() + prnt.getPaddingLeft() + prnt.getBorder()
            + pTbl.getMarginLeft());
        } else {
          pTbl.setX1(pTbl.getStartPage().getMarginLeft()
            + pTbl.getMarginLeft());
        }
      }
      if (!pTbl.getIsX2Fixed()) {
        if (prnt != null) {
          pTbl.setX2(prnt.getX2() - prnt.getPaddingRight() - prnt.getBorder()
            - pTbl.getMarginRight());
        } else {
          pTbl.setX2(pTbl.getStartPage().getWidth() - pTbl.getStartPage()
            .getMarginRight() - pTbl.getMarginRight());
        }
      }
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
