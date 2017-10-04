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

import org.beigesoft.doc.model.DocTable;
import org.beigesoft.doc.model.Document;
import org.beigesoft.doc.model.DocPage;
import org.beigesoft.doc.model.TableRow;
import org.beigesoft.doc.model.TableColumn;
import org.beigesoft.doc.model.TableCell;

/**
 * <p>Service that creates document's DocTable.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class FctDocTable<WI> implements IFctDocTable<WI> {

  /**
   * <p>Deriver table elements.</p>
   **/
  private IDeriverElements<WI, DocTable<WI>> deriverElements;

  /**
   * <p>Create simple document table.</p>
   * @param pDoc document
   * @param pStartPg page
   * @param pRows total
   * @param pColumns total
   * @param pBorder Border, 0 means NO
   * @param pPadding padding
   * @return DocTable
   * @throws Exception an Exception
   **/
  @Override
  public final DocTable<WI> createDocTable(final Document<WI> pDoc,
    final DocPage<WI> pStartPg, final int pRows,
      final int pColumns, final double pBorder,
        final double pPadding) throws Exception {
    DocTable<WI> res = new DocTable<WI>();
    res.setFontNumber(pDoc.getFontNumber());
    res.setFontSize(pDoc.getFontSize());
    res.setDocument(pDoc);
    res.setStartPage(pStartPg);
    res.setDeriverElements(this.deriverElements);
    res.setItsRows(new ArrayList<TableRow>());
    res.setBorder(pBorder);
    res.setPaddingTop(pPadding);
    res.setPaddingBottom(pPadding);
    res.setPaddingLeft(pPadding);
    res.setPaddingRight(pPadding);
    for (int i = 0; i < pRows; i++) {
      TableRow trow = new TableRow();
      trow.setBorder(pBorder);
      trow.setPaddingTop(pPadding);
      trow.setPaddingBottom(pPadding);
      trow.setPaddingLeft(pPadding);
      trow.setPaddingRight(pPadding);
      res.getItsRows().add(trow);
    }
    res.setItsColumns(new ArrayList<TableColumn>());
    for (int i = 0; i < pColumns; i++) {
      TableColumn tcol = new TableColumn();
      tcol.setBorder(pBorder);
      tcol.setPaddingTop(pPadding);
      tcol.setPaddingBottom(pPadding);
      tcol.setPaddingLeft(pPadding);
      tcol.setPaddingRight(pPadding);
      res.getItsColumns().add(tcol);
    }
    res.setItsCells(new ArrayList<TableCell>());
    for (int i = 0; i < pRows * pColumns; i++) {
      TableCell tcel = new TableCell();
      tcel.setFontNumber(res.getFontNumber());
      tcel.setFontSize(res.getFontSize());
      tcel.setAlignHorizontal(res.getAlignHoriCont());
      tcel.setAlignVertical(res.getAlignVertCont());
      res.getItsCells().add(tcel);
    }
    pDoc.getDerivingElementsList().add(res);
    return res;
  }

  //Simple getters and setters:

  /**
   * <p>Getter for deriverElements.</p>
   * @return IDeriverElements<WI, DocTable<WI>>
   **/
  public final IDeriverElements<WI, DocTable<WI>> getDeriverElements() {
    return this.deriverElements;
  }

  /**
   * <p>Setter for deriverElements.</p>
   * @param pDeriverElements reference
   **/
  public final void setDeriverElements(
    final IDeriverElements<WI, DocTable<WI>> pDeriverElements) {
    this.deriverElements = pDeriverElements;
  }
}
