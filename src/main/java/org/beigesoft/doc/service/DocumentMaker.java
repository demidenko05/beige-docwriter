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

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.beigesoft.doc.exception.ExceptionBdw;
import org.beigesoft.doc.model.EPageSize;
import org.beigesoft.doc.model.EPageOrientation;
import org.beigesoft.doc.model.Document;
import org.beigesoft.doc.model.IElement;
import org.beigesoft.doc.model.DocPage;
import org.beigesoft.doc.model.DocString;
import org.beigesoft.doc.model.IDerivingElements;

/**
 * <p>Utility that invoke deriving elements for document.</p>
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
   * <p>Standard Charset Encoder.</p>
   **/
  private final CharsetEncoder charsetEncoder =
    Charset.forName("ISO-8859-1").newEncoder();

  /**
   * <p>Add a page into document like the last page
   * and set it current.</p>
   * @param pDoc Document
   * @throws Exception an Exception
   **/
  @Override
  public final void addPage(final Document<WI> pDoc) throws Exception {
    DocPage<WI> lpg = pDoc.getPages().get(pDoc.getPages().size() - 1);
    addPage(pDoc, lpg.getWidth(), lpg.getHeight());
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
    final float pFontSize) throws Exception {
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
    final float pFontSize) throws Exception {
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
    DocString<WI> dstr = this.elementFactory.createDocString();
    dstr.setValue(pString);
    dstr.setX1(pX);
    dstr.setY1(pY);
    dstr.setFontSize(pDoc.getFontSize());
    dstr.setFontNumber(pDoc.getFontNumber());
    pDoc.getPages().get(pDoc.getPageNumber() - 1).getElements().add(dstr);
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
   * <p>Getter for charsetEncoder.</p>
   * @return CharsetEncoder
   **/
  public final CharsetEncoder getCharsetEncoder() {
    return this.charsetEncoder;
  }
}
