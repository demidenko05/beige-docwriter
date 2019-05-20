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

import java.math.RoundingMode;
import java.math.BigDecimal;

import org.beigesoft.doc.model.EUnitOfMeasure;

/**
 * <p>Unit of measure helper.</p>
 *
 * @author Yury Demidenko
 */
public class UomHelper {

  /**
   * <p>Convert value from user UOM to document points.
   * PDF UOM = 1/72 inch by default, so 1 inch = 72 points.</p>
   * @param pDocDpi document dots per inch resolution
   * @param pValue in user UOM
   * @param pUom user UOM
   * @return in document points value
   **/
  public final double toPoints(final double pValue, final double pDocDpi,
    final EUnitOfMeasure pUom) {
    double result;
    switch (pUom) {
      case POINT:
      result = pValue;
      break;
      case INCH:
      result = pValue * pDocDpi;
      break;
      case CENTIMETRE:
      result = pValue / 2.54 * pDocDpi;
      break;
      // millimetre:
      default:
      result = pValue / 25.4 * pDocDpi;
    }
    return BigDecimal.valueOf(result)
      .setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  /**
   * <p>Convert value from points to user UOM,
   * e.g. convert boder in 1 point to current UOM.</p>
   * @param pDocDpi document dots per inch resolution
   * @param pValue in user UOM
   * @param pUom user UOM
   * @return in document points value
   **/
  public final double fromPoints(final double pValue, final double pDocDpi,
    final EUnitOfMeasure pUom) {
    double result;
    switch (pUom) {
      case POINT:
      result = pValue;
      break;
      case INCH:
      result = pValue / pDocDpi;
      break;
      case CENTIMETRE:
      result = pValue * 2.54 / pDocDpi;
      break;
      // millimetre:
      default:
      result = pValue * 25.4 / pDocDpi;
    }
    return result;
  }
}
