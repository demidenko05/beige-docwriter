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
import org.beigesoft.doc.model.EAlignHorizontal;
import org.beigesoft.doc.model.EAlignVertical;
import org.beigesoft.doc.model.Document;
import org.beigesoft.doc.model.DocTable;
import org.beigesoft.doc.model.TableRow;
import org.beigesoft.doc.model.TableCell;
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
    docMaker.setDocTableFactory(fctDocTable);
    Document<WI> doc = fctDocument.createDoc(EPageSize.A4, EPageOrientation.PORTRAIT);
    doc.getFonts().add(new FontTst());
    docMaker.setFont(doc, 1, 3.6);
    doc.setBorder(0.3);
    doc.setContentPadding(0.3);
    DocTable<WI> dtbl = fctDocTable.createDocTable(doc, 2, 1);
    dtbl.getItsCells().get(0).setItsContent("Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1");
    dtbl.getItsCells().get(1).setItsContent("Cell2 Cell2 Cell2 Cell2 Cell2 Cell2 Cell2 Cell2 Cell2 Cell2 Cell2");
    MetricsString msTst = evalMetricsString.eval("Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1", "any", 3.6, 10000.0, 0.0);
    assertEquals(msTst.getWidth(), 41.0 * 3.6 * 600.0 / 1000.0, 1);
    deriverElTable.evalWidthPosForTableAndRows(dtbl);
    assertEquals(dtbl.getY1(), doc.getPages().get(0).getMarginTop() + dtbl.getMarginTop(), 0.0001);
    assertEquals(dtbl.getX1(), doc.getPages().get(0).getMarginLeft() + dtbl.getMarginLeft(), 0.0001);
    assertEquals(dtbl.getX2(), doc.getPages().get(0).getWidth() - doc.getPages().get(0).getMarginRight() - dtbl.getMarginRight(), 0.0001);
    double cl1wd = dtbl.getItsColumns().get(0).getX2() - dtbl.getItsColumns().get(0).getX1();
    double cl2wd = dtbl.getItsColumns().get(1).getX2() - dtbl.getItsColumns().get(1).getX1();
    assertEquals(0.0, cl1wd, 0.0001);
    assertEquals(0.0, cl2wd, 0.0001);
    double row1ht = dtbl.getItsRows().get(0).getHeight();
    assertEquals(0.0, row1ht, 0.0001);
    deriverElTable.evalWrappedContentSize(dtbl, dtbl.getWidth());
    cl1wd = dtbl.getItsColumns().get(0).getX2() - dtbl.getItsColumns().get(0).getX1();
    cl2wd = dtbl.getItsColumns().get(1).getX2() - dtbl.getItsColumns().get(1).getX1();
    row1ht = dtbl.getItsRows().get(0).getHeight();
    assertEquals(0.0, cl1wd, 0.0001);
    assertEquals(0.0, cl2wd, 0.0001);
    assertEquals(0.0, row1ht, 0.0001);
    deriverElTable.evalFloatColumnWidths(dtbl);
    deriverElTable.evalColumnPosX(dtbl);
    cl1wd = dtbl.getItsColumns().get(0).getX2() - dtbl.getItsColumns().get(0).getX1();
    cl2wd = dtbl.getItsColumns().get(1).getX2() - dtbl.getItsColumns().get(1).getX1();
    row1ht = dtbl.getItsRows().get(0).getHeight();
    double colwd50pr = (doc.getPages().get(0).getWidth() - doc.getPages().get(0).getMarginRight()
      - doc.getPages().get(0).getMarginLeft() - (dtbl.getBorder() * 2)) / 2;
    assertEquals(colwd50pr, cl1wd, dtbl.getBorder());
    assertEquals(colwd50pr, cl2wd, dtbl.getBorder());
    assertEquals(0.0, row1ht, 0.0001);
    assertTrue("Content metrics must be NULL!", dtbl.getItsCells().get(0).getMetricsString() == null);
    deriverElTable.evalContentHeightsAndPosY(dtbl);
    row1ht = dtbl.getItsRows().get(0).getHeight();
    assertEquals(2, dtbl.getItsCells().get(0).getMetricsString().getStrings().size());
    assertEquals("Cell1 Cell1 Cell1 Cell1 Cell1 Cell1", dtbl.getItsCells().get(0).getMetricsString().getStrings().get(0));
    assertEquals("Cell1 Cell1 Cell1 Cell1 Cell1", dtbl.getItsCells().get(0).getMetricsString().getStrings().get(1));
    assertEquals(2, dtbl.getItsCells().get(0).getMetricsString().getWidths().size());
    assertEquals(35.0 * 3.6 * 600.0 / 1000.0, dtbl.getItsCells().get(0).getMetricsString().getWidths().get(0), 1);
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
    doc.setBorder(0.3);
    doc.setContentPadding(0.3);
    DocTable<WI> dtbl1 = docMaker.addDocTable(doc, 3, 2);
    dtbl1.getItsCells().get(0).setItsContent("Cell0 Cell0 Cell0 Cell0 Cell0 Cell0 Cell0 Cell0 Cell0 Cell0 Cell0 Cell0");
    dtbl1.getItsCells().get(1).setItsContent("Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1 Cell1");
    dtbl1.getItsCells().get(2).setItsContent("Cell2 Cell2 Cell2 Cell2 Cell2 Cell2 Cell2 Cell2 Cell2 Cell2 Cell2 Cell2");
    dtbl1.getItsCells().get(3).setItsContent("Cell3 Cell3 Cell3 Cell3 Cell3 Cell3 Cell3 Cell3 Cell3 Cell3 Cell3 Cell3");
    dtbl1.getItsCells().get(4).setItsContent("Cell4 Cell4 Cell4 Cell4 Cell4 Cell4 Cell4 Cell4 Cell4 Cell4 Cell4 Cell4");
    dtbl1.getItsCells().get(5).setItsContent("Cell5 Cell5 Cell5 Cell5 Cell5 Cell5 Cell5 Cell5 Cell5 Cell5 Cell5 Cell5");
    dtbl1.getItsCells().get(1).setAlignHorizontal(EAlignHorizontal.CENTER);
    dtbl1.getItsCells().get(2).setAlignHorizontal(EAlignHorizontal.RIGHT);
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
    System.out.println("tbl2Wd/tcol1Wd/tcol2Wd/tcol3Wd: " + (dtbl1.getX2() - dtbl1.getX2()) + "/"
      + dtbl1.getItsColumns().get(0).getWidth() + "/"
       + dtbl1.getItsColumns().get(1).getWidth() + "/" + dtbl1.getItsColumns().get(2).getWidth());
    System.out.println("col1 cont: " + dtbl1.getItsCells().get(0).getItsContent());
    System.out.println("col1 str1: " + dtbl1.getItsCells().get(0).getMetricsString().getStrings().get(0));
    System.out.println("col1 str2: " + dtbl1.getItsCells().get(0).getMetricsString().getStrings().get(1));
    System.out.println("col1 str3: " + dtbl1.getItsCells().get(0).getMetricsString().getStrings().get(2));
    assertEquals(dtbl1.getItsCells().get(0).getMetricsString().getWidths().get(0), dtbl1.getItsCells().get(0).getMetricsString().getWidths().get(1), 1.0);
    assertEquals(dtbl1.getItsCells().get(0).getMetricsString().getStrings().get(0), dtbl1.getItsCells().get(0).getMetricsString().getStrings().get(1));
    assertTrue(dtbl.getY2() - dtbl.getY1() > 3.0);
    assertTrue(dtbl1.getY1() > dtbl.getY2());
    assertEquals(dtbl.getY1(), 20.0, 0.001);
    TableRow rowPrev = dtbl1.getItsRows().get(0);
    System.out.println("row 0 x1/x2/y1/y2/height: " + rowPrev.getX1() + "/" + rowPrev.getX2() + "/" + rowPrev.getY1() + "/" + rowPrev.getY2() + "/" + rowPrev.getHeight());
    assertTrue(rowPrev.getY2() > rowPrev.getY1());
    assertTrue(rowPrev.getX1() > 0.0);
    assertTrue(rowPrev.getX2() > rowPrev.getX1());
    for (int i = 1; i < dtbl1.getItsRows().size(); i++) {
      TableRow row = dtbl1.getItsRows().get(i);
      System.out.println("row i x1/x2/y1/y2/height: " + i + " " + row.getX1() + "/" + row.getX2() + "/" + row.getY1() + "/" + row.getY2() + "/" + row.getHeight());
      assertTrue(row.getY2() > row.getY1());
      assertTrue(row.getX1() > 0.0);
      assertTrue(row.getX2() > row.getX1());
      assertEquals(row.getY1(), rowPrev.getY2(), 0.1);
      rowPrev = row;
    }
    for (TableCell cel : dtbl1.getItsCells()) {
      assertEquals(3, cel.getMetricsString().getStrings().size());
      assertEquals(3, cel.getMetricsString().getWidths().size());
    }
    assertEquals(tcol1Wd + tcol2Wd, tblWd, 0.001);
    assertEquals(tcol1Wd, tcol2Wd, 0.001);
    assertEquals(4 + 5 + 3*6 + 11, doc.getPages().get(0).getElements().size());
  }
}
