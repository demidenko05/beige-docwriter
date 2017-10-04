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

import org.beigesoft.doc.model.EPageSize;
import org.beigesoft.doc.model.EPageOrientation;
import org.beigesoft.doc.model.EUnitOfMeasure;
import org.beigesoft.doc.model.Document;
import org.beigesoft.doc.model.DocPage;
import org.beigesoft.doc.model.IFont;
import org.beigesoft.doc.model.IDerivingElements;
import org.beigesoft.doc.model.IElement;

/**
 * <p>Service that creates document and its parts.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class FctDocument<WI> implements IFctDocument<WI> {

  /**
   * <p>Create document with page with given EPageSize and orientation.
   * EPageSize.LETTER means that unit of measure will be inch,
   * EPageSize.A2..5 - millimeter.</p>
   * @param pPageSize EPageSize
   * @param pPageOrientation EPageOrientation
   * @return Document
   * @throws Exception an Exception
   **/
  @Override
  public final Document<WI> createDoc(final EPageSize pPageSize,
    final EPageOrientation pPageOrientation) throws Exception {
    if (pPageSize.equals(EPageSize.LETTER)) {
      if (pPageOrientation.equals(EPageOrientation.PORTRAIT)) {
        return createDoc(EUnitOfMeasure.INCH, 8.5, 11.0);
      } else {
        return createDoc(EUnitOfMeasure.INCH, 11.0, 8.5);
      }
    } else if (pPageSize.equals(EPageSize.A5)) {
      if (pPageOrientation.equals(EPageOrientation.PORTRAIT)) {
        return createDoc(EUnitOfMeasure.MILLIMETRE, 148.0, 210.0);
      } else {
        return createDoc(EUnitOfMeasure.MILLIMETRE, 210.0, 148.0);
      }
    } else if (pPageSize.equals(EPageSize.A4)) {
      if (pPageOrientation.equals(EPageOrientation.PORTRAIT)) {
        return createDoc(EUnitOfMeasure.MILLIMETRE, 210.0, 297.0);
      } else {
        return createDoc(EUnitOfMeasure.MILLIMETRE, 297.0, 210.0);
      }
    } else if (pPageSize.equals(EPageSize.A3)) {
      if (pPageOrientation.equals(EPageOrientation.PORTRAIT)) {
        return createDoc(EUnitOfMeasure.MILLIMETRE, 297.0, 420.0);
      } else {
        return createDoc(EUnitOfMeasure.MILLIMETRE, 420.0, 297.0);
      }
    } else {
      if (pPageOrientation.equals(EPageOrientation.PORTRAIT)) {
        return createDoc(EUnitOfMeasure.MILLIMETRE, 420.0, 594.0);
      } else {
        return createDoc(EUnitOfMeasure.MILLIMETRE, 594.0, 420.0);
      }
    }
  }

  /**
   * <p>Create document with page with given UOM, width and height.</p>
   * @param pUom UOM
   * @param pWidth Width in UOM
   * @param pHeight Height in UOM
   * @return Document
   * @throws Exception an Exception
   **/
  @Override
  public final Document<WI> createDoc(final EUnitOfMeasure pUom,
    final double pWidth, final double pHeight) throws Exception {
    Document<WI> doc = new Document<WI>();
    doc.setUnitOfMeasure(pUom);
    doc.setPages(new ArrayList<DocPage<WI>>());
    doc.setFonts(new ArrayList<IFont>());
    doc.setDerivingElementsList(new ArrayList<IDerivingElements>());
    DocPage<WI> pg1 = new DocPage<WI>();
    pg1.setElements(new ArrayList<IElement<WI>>());
    pg1.setWidth(pWidth);
    pg1.setHeight(pHeight);
    if (EUnitOfMeasure.INCH.equals(pUom)) {
      pg1.setMarginBottom(0.79);
      pg1.setMarginTop(0.79);
      pg1.setMarginLeft(0.79);
      pg1.setMarginRight(0.79);
    } else if (EUnitOfMeasure.MILLIMETRE.equals(pUom)) {
      pg1.setMarginBottom(20.0);
      pg1.setMarginTop(20.0);
      pg1.setMarginLeft(30.0);
      pg1.setMarginRight(15.0);
    }
    doc.getPages().add(pg1);
    doc.setPageNumber(1);
    return doc;
  }
}
