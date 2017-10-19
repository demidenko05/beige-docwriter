package org.beigesoft.doc.service;

/*
 * Copyright (c) 2017 Beigesoft ™
 *
 * Licensed under the GNU General Public License (GPL), Version 2.0
 * (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html
 */

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
    for (Integer pgNum = pPaging.getDocument().getPages()
      .indexOf(pPaging.getStartPage()) + 1; pgNum <= totalPg; pgNum++) {
      // String:
      String str;
      if (pPaging.getTitle() == null) {
        str = numberPg.toString() + pPaging.getFrom() + totalPg;
      } else {
        str = pPaging.getTitle() + numberPg + pPaging.getFrom() + totalPg;
      }
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
