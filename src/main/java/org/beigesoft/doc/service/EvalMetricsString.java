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

import org.beigesoft.doc.model.MetricsString;

/**
 * <p>Service that evaluate metrics in current UOM
 * and multistring from string.</p>
 *
 * @author Yury Demidenko
 */
public class EvalMetricsString implements IEvalMetricsString {

  /**
   * <p>Character width evaluator.</p>
   **/
  private IEvalCharWidth evalCharWidth;

  /**
   * <p>Evaluate sizes in current UOM and multistring from string.</p>
   * @param pSource string
   * @param pFntNm font name
   * @param pFntSize font size
   * @param pWidth maximum
   * @param pLineSpace 0 means no space between lines
   * @return MetricsString
   * @throws Exception an Exception
   **/
  @Override
  public final MetricsString eval(final String pSource,
    final String pFntNm, final double pFntSize,
      final double pWidth, final double pLineSpace) throws Exception {
    MetricsString result = new MetricsString();
    Integer lastWbIdx = null;
    double lstStrLenBefWb = 0.0;
    double currStrLen = 0.0;
    double spaceWd = this.evalCharWidth.eval(' ', pFntNm, pFntSize);
    StringBuffer sb = new StringBuffer();
    int chInStrIdx = 0;
    for (char ch : pSource.toCharArray()) {
      if (ch == '\n') {
        result.getStrings().add(sb.toString());
        sb = sb.delete(0, sb.length());
        if (result.getWidth() < currStrLen) {
          result.setWidth(currStrLen);
        }
        chInStrIdx = 0;
        currStrLen = 0.0;
      } else {
        if (ch == ' ' || ch == '-') {
          lastWbIdx = chInStrIdx;
          lstStrLenBefWb = currStrLen;
        }
        double chWd = this.evalCharWidth.eval(ch, pFntNm, pFntSize);
        if (currStrLen + chWd <= pWidth) {
          currStrLen += chWd;
          sb.append(ch);
          chInStrIdx++;
        } else {
          if (lastWbIdx == null) {
            result.getStrings().add(sb.toString());
            sb = sb.delete(0, sb.length());
            if (result.getWidth() < currStrLen) {
              result.setWidth(currStrLen);
            }
            sb.append(ch);
            chInStrIdx = 1;
            currStrLen = chWd;
          } else {
            currStrLen += chWd;
            sb.append(ch);
            String str = sb.toString();
            result.getStrings().add(str.substring(0, lastWbIdx));
            sb = sb.delete(0, sb.length());
            if (result.getWidth() < currStrLen) {
              result.setWidth(currStrLen);
            }
            currStrLen -= lstStrLenBefWb + spaceWd;
            sb.append(str.substring(lastWbIdx + 1));
            lastWbIdx = null;
            chInStrIdx = sb.length() - 1;
          }
        }
      }
    }
    String str = sb.toString();
    if (str.length() > 0) {
      result.getStrings().add(str);
      if (result.getWidth() < currStrLen) {
        result.setWidth(currStrLen);
      }
    }
    result.setHeight(result.getStrings().size() * pFntSize);
    return result;
  }

  //Simple getters and setters:
  /**
   * <p>Getter for evalCharWidth.</p>
   * @return IEvalCharWidth
   **/
  public final IEvalCharWidth getEvalCharWidth() {
    return this.evalCharWidth;
  }

  /**
   * <p>Setter for evalCharWidth.</p>
   * @param pEvalCharWidth reference
   **/
  public final void setEvalCharWidth(final IEvalCharWidth pEvalCharWidth) {
    this.evalCharWidth = pEvalCharWidth;
  }
}
