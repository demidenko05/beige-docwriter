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
