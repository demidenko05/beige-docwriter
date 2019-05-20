/*
BSD 2-Clause License

Copyright (c) 2019, Beigesoft™
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this
  list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.beigesoft.doc.service;

import java.util.ArrayList;

import org.beigesoft.doc.model.DocTable;
import org.beigesoft.doc.model.Document;
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
   * @param pColumns total
   * @param pRows total
   * @return DocTable
   * @throws Exception an Exception
   **/
  @Override
  public final DocTable<WI> createDocTable(final Document<WI> pDoc,
    final int pColumns, final int pRows) throws Exception {
    DocTable<WI> res = new DocTable<WI>();
    res.setDocument(pDoc);
    res.setStartPage(pDoc.getPages().get(pDoc.getPageNumber() - 1));
    res.setDeriverElements(this.deriverElements);
    res.setItsRows(new ArrayList<TableRow>());
    res.setBorder(pDoc.getBorder());
    res.setPaddingTop(pDoc.getContentPaddingTop());
    res.setPaddingBottom(pDoc.getContentPaddingBottom());
    res.setPaddingLeft(pDoc.getContentPaddingLeft());
    res.setPaddingRight(pDoc.getContentPaddingRight());
    res.setMarginTop(pDoc.getContainerMarginTop());
    res.setMarginBottom(pDoc.getContainerMarginBottom());
    res.setMarginLeft(pDoc.getContainerMarginLeft());
    res.setMarginRight(pDoc.getContainerMarginRight());
    for (int i = 0; i < pRows; i++) {
      TableRow trow = new TableRow();
      trow.setBorder(pDoc.getBorder());
      trow.setPaddingTop(pDoc.getContentPaddingTop());
      trow.setPaddingBottom(pDoc.getContentPaddingBottom());
      trow.setPaddingLeft(pDoc.getContentPaddingLeft());
      trow.setPaddingRight(pDoc.getContentPaddingRight());
      res.getItsRows().add(trow);
    }
    res.setItsColumns(new ArrayList<TableColumn>());
    for (int i = 0; i < pColumns; i++) {
      TableColumn tcol = new TableColumn();
      tcol.setBorder(pDoc.getBorder());
      tcol.setPaddingTop(pDoc.getContentPaddingTop());
      tcol.setPaddingBottom(pDoc.getContentPaddingBottom());
      tcol.setPaddingLeft(pDoc.getContentPaddingLeft());
      tcol.setPaddingRight(pDoc.getContentPaddingRight());
      res.getItsColumns().add(tcol);
    }
    res.setItsCells(new ArrayList<TableCell>());
    for (int i = 0; i < pRows * pColumns; i++) {
      TableCell tcel = new TableCell();
      tcel.setFontNumber(pDoc.getFontNumber());
      tcel.setFontSize(pDoc.getFontSize());
      tcel.setAlignHorizontal(pDoc.getAlignHoriCont());
      tcel.setAlignVertical(pDoc.getAlignVertCont());
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
