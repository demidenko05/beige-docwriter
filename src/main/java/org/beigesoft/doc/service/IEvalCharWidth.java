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

/**
 * <p>Abstraction of service that evaluate character width in current UOM.</p>
 *
 * @author Yury Demidenko
 */
public interface IEvalCharWidth {

  /**
   * <p>Evaluate char width in current UOM.</p>
   * @param pSource char
   * @param pFntNm font name
   * @param pFntSize font size
   * @return char width in current UOM
   * @throws Exception an Exception
   **/
  double eval(char pSource, String pFntNm, double pFntSize) throws Exception;
}
