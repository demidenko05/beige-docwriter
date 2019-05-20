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

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.beigesoft.doc.exception.ExceptionBdw;
import org.beigesoft.doc.model.EPageSize;
import org.beigesoft.doc.model.EPageOrientation;
import org.beigesoft.doc.model.EAlignHorizontal;
import org.beigesoft.doc.model.EWraping;
import org.beigesoft.doc.model.Document;
import org.beigesoft.doc.model.DocTable;
import org.beigesoft.doc.model.TableCell;
import org.beigesoft.doc.model.TableRow;
import org.beigesoft.doc.model.TableColumn;
import org.beigesoft.doc.model.IElement;
import org.beigesoft.doc.model.DocPage;
import org.beigesoft.doc.model.DocString;
import org.beigesoft.doc.model.DocImage;
import org.beigesoft.doc.model.Pagination;
import org.beigesoft.doc.model.IDerivingElements;

/**
 * <p>Service that makes document.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DocumentMaker<WI> implements IDocumentMaker<WI> {

  /**
   * <p>Element factory.</p>
   **/
  private IFctElement<WI> elementFactory;

  /**
   * <p>DocTable factory.</p>
   **/
  private IFctDocTable<WI> docTableFactory;

  /**
   * <p>Standard Charset Encoder.</p>
   **/
  private final CharsetEncoder charsetEncoder =
    Charset.forName("ISO-8859-1").newEncoder();

  /**
   * <p>Deriver pagination elements.</p>
   **/
  private IDeriverElements<WI, Pagination<WI>> deriverElPagination;

  /**
   * <p>Add a page into document like the last page
   * and set it current.</p>
   * @param pDoc Document
   * @throws Exception an Exception
   **/
  @Override
  public final void addPage(final Document<WI> pDoc) throws Exception {
    DocPage<WI> lpg = pDoc.getPages().get(pDoc.getPages().size() - 1);
    DocPage<WI> pg = new DocPage<WI>();
    pg.setElements(new ArrayList<IElement<WI>>());
    pg.setWidth(lpg.getWidth());
    pg.setHeight(lpg.getHeight());
    pg.setMarginBottom(lpg.getMarginBottom());
    pg.setMarginTop(lpg.getMarginTop());
    pg.setMarginLeft(lpg.getMarginLeft());
    pg.setMarginRight(lpg.getMarginRight());
    pDoc.getPages().add(pg);
    pDoc.setPageNumber(pDoc.getPages().size());
  }

  /**
   * <p>Add a page into document with given size and orientation
   * and set it current.</p>
   * @param pDoc Document
   * @param pPageSize EPageSize
   * @param pPageOrientation EPageOrientation
   * @throws Exception an Exception
   **/
  @Override
  public final void addPage(final Document<WI> pDoc, final EPageSize pPageSize,
    final EPageOrientation pPageOrientation) throws Exception {
    if (pPageSize.equals(EPageSize.LETTER)) {
      if (pPageOrientation.equals(EPageOrientation.PORTRAIT)) {
        addPage(pDoc, 8.5, 11.0);
      } else {
        addPage(pDoc, 11.0, 8.5);
      }
    } else if (pPageSize.equals(EPageSize.A5)) {
      if (pPageOrientation.equals(EPageOrientation.PORTRAIT)) {
        addPage(pDoc, 148.0, 210.0);
      } else {
        addPage(pDoc, 210.0, 148.0);
      }
    } else if (pPageSize.equals(EPageSize.A4)) {
      if (pPageOrientation.equals(EPageOrientation.PORTRAIT)) {
        addPage(pDoc, 210.0, 297.0);
      } else {
        addPage(pDoc, 297.0, 210.0);
      }
    } else if (pPageSize.equals(EPageSize.A3)) {
      if (pPageOrientation.equals(EPageOrientation.PORTRAIT)) {
        addPage(pDoc, 297.0, 420.0);
      } else {
        addPage(pDoc, 420.0, 297.0);
      }
    } else {
      if (pPageOrientation.equals(EPageOrientation.PORTRAIT)) {
        addPage(pDoc, 420.0, 594.0);
      } else {
        addPage(pDoc, 594.0, 420.0);
      }
    }
  }

  /**
   * <p>Add a page into document with given width and height
   * and set it current.</p>
   * @param pDoc Document
   * @param pWidth Width in doc UOM
   * @param pHeight Height in doc UOM
   * @throws Exception an Exception
   **/
  @Override
  public final void addPage(final Document<WI> pDoc, final double pWidth,
    final double pHeight) throws Exception {
    DocPage<WI> pg = new DocPage<WI>();
    pg.setElements(new ArrayList<IElement<WI>>());
    pg.setWidth(pWidth);
    pg.setHeight(pHeight);
    pDoc.getPages().add(pg);
    pDoc.setPageNumber(pDoc.getPages().size());
  }

  /**
   * <p>Set current page (the first is #1).</p>
   * @param pDoc Document
   * @param pPageNum number
   * @throws Exception an Exception
   **/
  @Override
  public final void setPage(final Document<WI> pDoc,
    final int pPageNum) throws Exception {
    if (pDoc.getPages().size() < pPageNum) {
       throw new ExceptionBdw("Add page first!");
    }
    pDoc.setPageNumber(pPageNum);
  }

  /**
   * <p>Set current font (the first is #1).</p>
   * @param pDoc Document
   * @param pFontNum number
   * @param pFontSize size
   * @throws Exception an Exception
   **/
  @Override
  public final void setFont(final Document<WI> pDoc, final int pFontNum,
    final double pFontSize) throws Exception {
    if (pDoc.getFonts().size() < pFontNum) {
       throw new ExceptionBdw("Add font first!");
    }
    pDoc.setFontNumber(pFontNum);
    pDoc.setFontSize(pFontSize);
  }

  /**
   * <p>Set current font size.</p>
   * @param pDoc Document
   * @param pFontSize size
   * @throws Exception an Exception
   **/
  @Override
  public final void setFontSize(final Document<WI> pDoc,
    final double pFontSize) throws Exception {
    if (pFontSize <= 0.0f || pFontSize > pDoc.getPages()
      .get(pDoc.getPageNumber() - 1).getWidth() * 0.8) {
       throw new ExceptionBdw("Wrong font size!");
    }
    pDoc.setFontSize(pFontSize);
  }

  /**
   * <p>Add non-multiline text into current page with
   * X Y coordinates in current units.</p>
   * @param pDoc Document
   * @param pString string
   * @param pX x
   * @param pY y
   * @throws Exception an Exception
   **/
  @Override
  public final void addString(final Document<WI> pDoc, final String pString,
    final double pX, final double pY) throws Exception {
    if (pDoc.getFonts().size() == 0) {
       throw new ExceptionBdw("Add font first!");
    }
    if (!pDoc.getFonts().get(pDoc.getFontNumber() - 1).getIsUnicoded()
        && !this.charsetEncoder.canEncode(pString)) {
      throw new ExceptionBdw("This string required unicode font!");
    }
    DocString<WI> dstr = this.elementFactory.createDocString(null);
    dstr.setValue(pString);
    dstr.setFontSize(pDoc.getFontSize());
    dstr.setX1(pX);
    dstr.setY1(pY - dstr.getFontSize());
    dstr.setY2(pY);
    dstr.setFontNumber(pDoc.getFontNumber());
    pDoc.getPages().get(pDoc.getPageNumber() - 1).getElements().add(dstr);
  }

  /**
   * <p>Add simple document table with preferred padding/border
   * to current page.</p>
   * @param pDoc document
   * @param pColumns total
   * @param pRows total
   * @return DocTable
   * @throws Exception an Exception
   **/
  @Override
  public final DocTable<WI> addDocTable(final Document<WI> pDoc,
    final int pColumns, final int pRows) throws Exception {
    if (pDoc.getFonts().size() == 0) {
       throw new ExceptionBdw("Add font first!");
    }
    return this.docTableFactory.createDocTable(pDoc, pColumns, pRows);
  }

  /**
   * <p>Add simple document table with preferred padding and custom border
   * to current page. User himself will decide which/how cell show border.</p>
   * @param pDoc document
   * @param pColumns total
   * @param pRows total
   * @return DocTable
   * @throws Exception an Exception
   **/
  @Override
  public final DocTable<WI> addDocTableCustomBorder(final Document<WI> pDoc,
    final int pColumns, final int pRows) throws Exception {
    if (pDoc.getFonts().size() == 0) {
       throw new ExceptionBdw("Add font first!");
    }
    DocTable<WI> res = this.docTableFactory
      .createDocTable(pDoc, pColumns, pRows);
    res.setIsThereCellWithCustomBorder(true);
    return res;
  }

  /**
   * <p>Add pagination from current page.</p>
   * @param pDoc Document
   * @return Pagination Pagination
   * @throws Exception an Exception
   **/
  @Override
  public final Pagination<WI> addPagination(
    final Document<WI> pDoc) throws Exception {
    Pagination<WI> paging = new Pagination<WI>();
    paging.setDocument(pDoc);
    paging.setStartPage(pDoc.getPages().get(pDoc.getPageNumber() - 1));
    paging.setDeriverElements(this.deriverElPagination);
    paging.setAlignHorizontal(EAlignHorizontal.RIGHT);
    paging.setFontNumber(pDoc.getFontNumber());
    paging.setFontSize(pDoc.getFontSize());
    pDoc.getDerivingElementsList().add(paging);
    return paging;
  }

  /**
   * <p>Add simple document table with preferred padding and no border
   * to current page.</p>
   * @param pDoc document
   * @param pColumns total
   * @param pRows total
   * @return DocTable
   * @throws Exception an Exception
   **/
  @Override
  public final DocTable<WI> addDocTableNoBorder(final Document<WI> pDoc,
    final int pColumns, final int pRows) throws Exception {
    if (pDoc.getFonts().size() == 0) {
       throw new ExceptionBdw("Add font first!");
    }
    double bordWas = pDoc.getBorder();
    pDoc.setBorder(0.0);
    DocTable<WI> rez = this.docTableFactory
      .createDocTable(pDoc, pColumns, pRows);
    pDoc.setBorder(bordWas);
    return rez;
  }

  /**
   * <p>Make DocTable wrapping content.</p>
   * @param pTbl document table
   * @throws Exception an Exception
   **/
  @Override
  public final void makeDocTableWrapping(
    final DocTable<WI> pTbl) throws Exception {
    pTbl.setWraping(EWraping.WRAP_CONTENT);
    for (TableColumn col : pTbl.getItsColumns()) {
      col.setWraping(EWraping.WRAP_CONTENT);
    }
  }

  /**
   * <p>Add row to the end of DocTable.</p>
   * @param pTbl document table
   * @throws Exception an Exception
   **/
  @Override
  public final void addRowToDocTable(
    final DocTable<WI> pTbl) throws Exception {
    TableRow rowEnd = pTbl.getItsRows().get(pTbl.getItsRows().size() - 1);
    pTbl.getItsRows().add(new TableRow(rowEnd));
    for (int i = 0; i < pTbl.getItsColumns().size(); i++) {
      TableCell tcel = new TableCell();
      tcel.setFontNumber(pTbl.getDocument().getFontNumber());
      tcel.setFontSize(pTbl.getDocument().getFontSize());
      tcel.setAlignHorizontal(pTbl.getDocument().getAlignHoriCont());
      tcel.setAlignVertical(pTbl.getDocument().getAlignVertCont());
      pTbl.getItsCells().add(tcel);
    }
  }

  /**
   * <p>Derives elements.</p>
   * @param pDoc Document
   * @throws Exception an Exception
   **/
  @Override
  public final void deriveElements(final Document<WI> pDoc) throws Exception {
    for (DocPage<WI> pg : pDoc.getPages()) {
      Set<IElement<WI>> dsToDelSet = new HashSet<IElement<WI>>();
      for (IElement<WI> el: pg.getElements()) {
        if (el.getParent() != null) {
          dsToDelSet.add(el);
        }
      }
      for (IElement<WI> el: dsToDelSet) {
        pg.getElements().remove(el);
      }
    }
    for (IDerivingElements de : pDoc.getDerivingElementsList()) {
      de.derive();
    }
  }

  /**
   * <p>Add image into current page from file (file system or resource) with
   * X Y coordinates in current units.</p>
   * @param pDoc Document
   * @param pPath path e.g. /img/image1.png or /home/jon/pictures/photo1.jpg
   * @param pX x
   * @param pY y
   * @return DocImage<WI>
   * @throws Exception an Exception
   **/
  @Override
  public final DocImage<WI> addImage(final Document<WI> pDoc,
    final String pPath, final double pX, final double pY) throws Exception {
    DocImage<WI> dimg = this.elementFactory.createDocImage(null, pPath);
    dimg.setX1(pX);
    dimg.setY1(pY);
    pDoc.getPages().get(pDoc.getPageNumber() - 1).getElements().add(dimg);
    return dimg;
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
  public final void setElementFactory(
    final IFctElement<WI> pElementFactory) {
    this.elementFactory = pElementFactory;
  }

  /**
   * <p>Getter for docTableFactory.</p>
   * @return IFctDocTable<WI>
   **/
  public final IFctDocTable<WI> getDocTableFactory() {
    return this.docTableFactory;
  }

  /**
   * <p>Setter for docTableFactory.</p>
   * @param pDocTableFactory reference
   **/
  public final void setDocTableFactory(
    final IFctDocTable<WI> pDocTableFactory) {
    this.docTableFactory = pDocTableFactory;
  }

  /**
   * <p>Getter for charsetEncoder.</p>
   * @return CharsetEncoder
   **/
  public final CharsetEncoder getCharsetEncoder() {
    return this.charsetEncoder;
  }

  /**
   * <p>Getter for deriverElPagination.</p>
   * @return IDeriverElements<WI, Pagination<WI>>
   **/
  public final IDeriverElements<WI, Pagination<WI>> getDeriverElPagination() {
    return this.deriverElPagination;
  }

  /**
   * <p>Setter for deriverElPagination.</p>
   * @param pDeriverElPagination reference
   **/
  public final void setDeriverElPagination(
    final IDeriverElements<WI, Pagination<WI>> pDeriverElPagination) {
    this.deriverElPagination = pDeriverElPagination;
  }
}
