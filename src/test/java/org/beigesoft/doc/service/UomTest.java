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
