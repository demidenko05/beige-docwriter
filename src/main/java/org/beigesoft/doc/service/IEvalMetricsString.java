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

import org.beigesoft.doc.model.MetricsString;

/**
 * <p>Abstraction of service that evaluate metrics in current UOM
 * and multistring from string.</p>
 *
 * @author Yury Demidenko
 */
public interface IEvalMetricsString {

  /**
   * <p>Evaluate metrics in current UOM and multistring from string.</p>
   * @param pSource string
   * @param pFntNm font name
   * @param pFntSize font size
   * @param pWidth maximum
   * @param pLineSpace 0 means no space between lines
   * @return MetricsString
   * @throws Exception an Exception
   **/
  MetricsString eval(String pSource, String pFntNm, double pFntSize,
    double pWidth, double pLineSpace) throws Exception;
}
