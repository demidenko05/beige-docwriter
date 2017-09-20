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


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.beigesoft.doc.model.EUnitOfMeasure;

/**
 * <p>UOM tests.</p>
 *
 * @author Yury Demidenko
 */
public class UomTest {

  UomHelper uomHelper = new UomHelper();

  @Test
  public void test1() throws Exception {
    assertEquals(1.0, this.uomHelper.toPoints(1.0, 72.0, EUnitOfMeasure.POINT), 0);
    assertEquals(72.0, this.uomHelper.toPoints(1.0, 72.0, EUnitOfMeasure.INCH), 0);
    assertEquals(72.0, this.uomHelper.toPoints(2.54, 72.0, EUnitOfMeasure.CENTIMETRE), 0);
    assertEquals(72.0, this.uomHelper.toPoints(25.4, 72.0, EUnitOfMeasure.MILLIMETRE), 0);
  }
}
