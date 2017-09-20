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

//import java.util.List;
//import java.util.ArrayList;

import org.beigesoft.doc.model.IDerivingElements;
import org.beigesoft.doc.model.DocTable;
//import org.beigesoft.doc.model.TableCell;

/**
 * <p>Service that derives atomic elements from DocTable.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DeriverElTable<WI> implements IDeriverElements<DocTable> {

  /**
   * <p>Element factory.</p>
   **/
  private IFctElement<WI> elementFactory;

  /**
   * <p>Derives (generates) document atomic elements.</p>
   * @param pTbl table
   * @throws Exception an Exception
   **/
  @Override
  public final void derive(final DocTable pTbl) throws Exception {
    //position:
    if (pTbl.getX1() == null && pTbl.getY1() == null && pTbl.getX2() == null) {
//TODO in container like DIV:
      //previous/page:
      int idxTbl = pTbl.getDocument().getDerivingElementsList().indexOf(pTbl);
      pTbl.setIsX1Calculated(true);
      pTbl.setIsX2Calculated(true);
      pTbl.setIsY1Calculated(true);
      if (idxTbl > 0) { //previous:
        IDerivingElements prev = pTbl.getDocument().getDerivingElementsList()
          .get(idxTbl - 1);
        pTbl.setY1(prev.getY2() + prev.getMarginBottom() + pTbl.getMarginTop());
      } else {
        //page:
        pTbl.setY1(pTbl.getStartPage().getMarginBottom() + pTbl.getMarginTop());
      }
      //page:
      pTbl.setX1(pTbl.getStartPage().getMarginLeft() + pTbl.getMarginLeft());
      pTbl.setX2(pTbl.getStartPage().getWidth() - pTbl.getStartPage()
        .getMarginRight() - pTbl.getMarginRight());
    }
    /*int currRow = 0; //from 0
    int currCell = 0;
    for (TableCell tc : pTbl.getItsCells()) {
      if (tc.getJoinedCell() != null) {
        List<TableCell> lstCells = new ArrayList<TableCell>();
        lstCells.add(tc);
        TableCell jc = tc;
        while ((jc = jc.getJoinedCell()) != null) {
          lstCells.add(jc);
        }
      }
      if (tc.getX2() != null) {
        // float right side:
      } else if (tc.getX1() != null) {
        // float left side:
      }
    }*/
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
}
