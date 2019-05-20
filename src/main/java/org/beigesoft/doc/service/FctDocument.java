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
      doc.setContainerMarginBottom(3.5);
      doc.setContentPadding(1);
      doc.setBorder(0.33);
      doc.setFontSize(3.5);
    }
    doc.getPages().add(pg1);
    doc.setPageNumber(1);
    return doc;
  }
}
