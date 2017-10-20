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

/**
 * <p>Test service that return monospace width in current UOM.</p>
 *
 * @author Yury Demidenko
 */
public class EvalCharWidthTst implements IEvalCharWidth {

  /**
   * <p>Return just mono-space width 60% of font size.</p>
   * @param pSource char
   * @param pFntNm font name
   * @param pFntSize font size
   * @return char width in current UOM
   * @throws Exception an Exception
   **/
  @Override
  public final double eval(final char pSource,
    final String pFntNm, final double pFntSize) throws Exception {
    return pFntSize * 600.0 / 1000.0;
  }
}
