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

import org.beigesoft.doc.model.Pagination;
import org.beigesoft.doc.model.DocPage;
import org.beigesoft.doc.model.DocString;
import org.beigesoft.doc.model.MetricsString;
import org.beigesoft.doc.model.EAlignHorizontal;

/**
 * <p>Service that derives atomic elements for paging.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DeriverElPagination<WI>
  implements IDeriverElements<WI, Pagination<WI>> {

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
   * @param pPaging Pagination
   * @throws Exception an Exception
   **/
  @Override
  public final void derive(final Pagination<WI> pPaging) throws Exception {
    Integer totalPg = pPaging.getDocument().getPages().size();
    String fntNm = pPaging.getDocument().getFonts()
      .get(pPaging.getFontNumber() - 1).getItsName();
    Integer numberPg = pPaging.getStart();
    for (Integer pgNum = pPaging.getStart(); pgNum <= totalPg; pgNum++) {
      // String:
      StringBuffer sb = new StringBuffer();
      if (pPaging.getTitle() == null) {
        sb.append(numberPg.toString());
      } else {
        sb.append(pPaging.getTitle() + numberPg);
      }
      if (pPaging.getFrom() != null) {
        sb.append(pPaging.getFrom() + totalPg);
      }
      String str = sb.toString();
      // Positions:
      DocPage<WI> docPg = pPaging.getDocument().getPages().get(pgNum - 1);
      double wd = docPg.getWidth() - docPg.getMarginLeft()
        - docPg.getMarginRight();
      MetricsString ms = this.evalMetricsString.eval(str,
        fntNm, pPaging.getFontSize(), wd, 0.0);
      if (EAlignHorizontal.LEFT.equals(pPaging.getAlignHorizontal())) {
        pPaging.setX1(docPg.getMarginLeft());
      } else if (pPaging.getAlignHorizontal() == null
        || EAlignHorizontal.RIGHT.equals(pPaging.getAlignHorizontal())) {
        pPaging.setX1(docPg.getWidth() - docPg.getMarginRight()
          - ms.getWidth());
      } else if (EAlignHorizontal.CENTER.equals(pPaging.getAlignHorizontal())) {
        pPaging.setX1((docPg.getWidth() - ms.getWidth()) / 2.0);
      }
      pPaging.setX2(pPaging.getX1() + ms.getWidth());
      pPaging.setY1(docPg.getHeight() - docPg.getMarginBottom() / 2.0
        - pPaging.getFontSize() / 2.0);
      pPaging.setY2(pPaging.getY1() + pPaging.getFontSize());
      // Generate:
      DocString<WI> dstr = this.elementFactory.createDocString(pPaging);
      dstr.setX1(pPaging.getX1());
      dstr.setX2(pPaging.getX2());
      dstr.setY1(pPaging.getY1());
      dstr.setY2(pPaging.getY2());
      dstr.setFontNumber(pPaging.getFontNumber());
      dstr.setFontSize(pPaging.getFontSize());
      dstr.setValue(str);
      docPg.getElements().add(dstr);
      numberPg++;
    }
  }


  /**
   * <p>Init data after possible changes.</p>
   * @param pPaging Pagination
   * @throws Exception an Exception
   **/
  @Override
  public final void initAfterChanges(
    final Pagination<WI> pPaging) throws Exception {
    //nothing;
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
