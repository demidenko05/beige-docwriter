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


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.beigesoft.doc.model.MetricsString;
import org.beigesoft.doc.model.EUnitOfMeasure;
import org.beigesoft.doc.model.EPageSize;
import org.beigesoft.doc.model.EPageOrientation;
import org.beigesoft.doc.model.Document;
import org.beigesoft.doc.model.DocTable;
import org.beigesoft.doc.model.FontTst;

/**
 * <p>UOM tests.</p>
 *
 * @author Yury Demidenko
 */
public class DocTableTest<WI> {

  UomHelper uomHelper = new UomHelper();

  @Test
  public void test1() throws Exception {
    EvalCharWidthTst evalCharWidth = new EvalCharWidthTst();
    EvalMetricsString evalMetricsString = new EvalMetricsString();
    evalMetricsString.setEvalCharWidth(evalCharWidth);
    FctElement<WI> fctElement = new FctElement<WI>();
    DeriverElTable<WI> deriverElTable = new DeriverElTable<WI>();
    deriverElTable.setEvalMetricsString(evalMetricsString);
    deriverElTable.setElementFactory(fctElement);
    FctDocument<WI> fctDocument = new FctDocument<WI>();
    FctDocTable<WI> fctDocTable = new FctDocTable<WI>();
    fctDocTable.setDeriverElements(deriverElTable);
    DocumentMaker<WI> docMaker = new DocumentMaker<WI>();
    docMaker.setElementFactory(fctElement);
    Document<WI> doc = fctDocument.createDoc(EPageSize.A4, EPageOrientation.PORTRAIT);
    doc.getFonts().add(new FontTst());
    docMaker.setFont(doc, 1, 3.6);
    DocTable<WI> dtbl = fctDocTable.createDocTable(doc, doc.getPages().get(0), 1, 2, 0.3, 0.3);
    dtbl.getItsCells().get(0).setItsContent("cell1 cell1 cell1 cell1 cell1 cell1 cell1 cell1 cell1 cell1 cell1");
    dtbl.getItsCells().get(1).setItsContent("cell2 cell2 cell2 cell2 cell2 cell2 cell2 cell2 cell2 cell2 cell2");
    MetricsString msTst = evalMetricsString.eval("cell1 cell1 cell1 cell1 cell1 cell1 cell1", "any", 3.6, 10000.0, 0.0);
    assertEquals(msTst.getWidth(), 41.0 * 3.6 * 600.0 / 1000.0, 1);
    deriverElTable.evalPosWidForTabMeth1(dtbl);
    assertEquals(dtbl.getY1(), doc.getPages().get(0).getMarginTop() + dtbl.getMarginTop(), 0.0001);
    assertEquals(dtbl.getX1(), doc.getPages().get(0).getMarginLeft() + dtbl.getMarginLeft(), 0.0001);
    assertEquals(dtbl.getX2(), doc.getPages().get(0).getWidth() - doc.getPages().get(0).getMarginRight() - dtbl.getMarginRight(), 0.0001);
    double cl1wd = dtbl.getItsColumns().get(0).getX2() - dtbl.getItsColumns().get(0).getX1();
    double cl2wd = dtbl.getItsColumns().get(1).getX2() - dtbl.getItsColumns().get(1).getX1();
    assertEquals(0.0, cl1wd, 0.0001);
    assertEquals(0.0, cl2wd, 0.0001);
    double row1ht = dtbl.getItsRows().get(0).getHeight();
    assertEquals(0.0, row1ht, 0.0001);
    deriverElTable.evalWrappedContentSize(dtbl);
    cl1wd = dtbl.getItsColumns().get(0).getX2() - dtbl.getItsColumns().get(0).getX1();
    cl2wd = dtbl.getItsColumns().get(1).getX2() - dtbl.getItsColumns().get(1).getX1();
    row1ht = dtbl.getItsRows().get(0).getHeight();
    assertEquals(0.0, cl1wd, 0.0001);
    assertEquals(0.0, cl2wd, 0.0001);
    assertEquals(0.0, row1ht, 0.0001);
    deriverElTable.evalColumnsRowsPosWidths(dtbl);
    cl1wd = dtbl.getItsColumns().get(0).getX2() - dtbl.getItsColumns().get(0).getX1();
    cl2wd = dtbl.getItsColumns().get(1).getX2() - dtbl.getItsColumns().get(1).getX1();
    row1ht = dtbl.getItsRows().get(0).getHeight();
    double colwd50pr = (doc.getPages().get(0).getWidth() - doc.getPages().get(0).getMarginRight()
      - doc.getPages().get(0).getMarginLeft() - (dtbl.getBorder() * 2)) / 2;
    assertEquals(colwd50pr, cl1wd, dtbl.getBorder());
    assertEquals(colwd50pr, cl2wd, dtbl.getBorder());
    assertEquals(0.0, row1ht, 0.0001);
    assertTrue("Content metrics must be NULL!", dtbl.getItsCells().get(0).getMetricsString() == null);
    deriverElTable.evalContentPosHeight(dtbl);
    row1ht = dtbl.getItsRows().get(0).getHeight();
    assertEquals(dtbl.getItsCells().get(0).getMetricsString().getHeight(), dtbl.getItsCells().get(1).getMetricsString().getHeight(), 0.0001);
    assertEquals(row1ht - dtbl.getItsCells().get(0).getMetricsString().getHeight(), dtbl.getPaddingTop()*2 + dtbl.getBorder()*2, 0.1);
    assertEquals(2, dtbl.getItsCells().get(0).getMetricsString().getStrings().size());
    assertEquals(2, dtbl.getItsCells().get(1).getMetricsString().getStrings().size());
    deriverElTable.initAfterChanges(dtbl);
    assertTrue("Content metrics must be emptied!", dtbl.getItsCells().get(0).getMetricsString() == null);
    cl1wd = dtbl.getItsColumns().get(0).getX2() - dtbl.getItsColumns().get(0).getX1();
    cl2wd = dtbl.getItsColumns().get(1).getX2() - dtbl.getItsColumns().get(1).getX1();
    row1ht = dtbl.getItsRows().get(0).getHeight();
    assertEquals(0.0, cl1wd, 0.0001);
    assertEquals(0.0, cl2wd, 0.0001);
    assertEquals(0.0, row1ht, 0.0001);
    docMaker.deriveElements(doc);
    double tcol1Wd = dtbl.getItsColumns().get(0).getX2() - dtbl.getItsColumns().get(0).getX1();
    double tcol2Wd = dtbl.getItsColumns().get(1).getX2() - dtbl.getItsColumns().get(1).getX1();
    double tblWd = dtbl.getX2() - dtbl.getX1();
    System.out.println("tblWd/tcol1Wd/tcol2Wd: " + tblWd + "/" + tcol1Wd + "/" + tcol2Wd + "/");
    System.out.println("col1 cont: " + dtbl.getItsCells().get(0).getItsContent());
    System.out.println("col1 str1: " + dtbl.getItsCells().get(0).getMetricsString().getStrings().get(0));
    System.out.println("col1 str2: " + dtbl.getItsCells().get(0).getMetricsString().getStrings().get(1));
    System.out.println("col2 cont: " + dtbl.getItsCells().get(1).getItsContent());
    System.out.println("col2 str1: " + dtbl.getItsCells().get(1).getMetricsString().getStrings().get(0));
    System.out.println("col2 str2: " + dtbl.getItsCells().get(1).getMetricsString().getStrings().get(1));
    assertEquals(tcol1Wd + tcol2Wd, tblWd, 0.001);
    assertEquals(tcol1Wd, tcol2Wd, 0.001);
    assertEquals(4 + 5, doc.getPages().get(0).getElements().size());
  }
}
