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
    if (pSource == null || pSource.trim().equals("")) {
      result.getStrings().add(" ");
      result.getWidths().add(this.evalCharWidth.eval(' ', pFntNm, pFntSize));
    } else {
      Integer lastWbIdx = null;
      double lstStrLenBefWb = 0.0;
      double lstWbWidth = 0.0;
      double currStrLen = 0.0;
      StringBuffer sb = new StringBuffer();
      int chInStrIdx = 0;
      for (char ch : pSource.toCharArray()) {
        if (ch == '\n') {
          result.getStrings().add(sb.toString());
          result.getWidths().add(currStrLen);
          if (result.getWidth() < currStrLen) {
            result.setWidth(currStrLen);
          }
          sb = sb.delete(0, sb.length());
          chInStrIdx = 0;
          currStrLen = 0.0;
        } else {
          double chWd = this.evalCharWidth.eval(ch, pFntNm, pFntSize);
          if (ch == ' ' || ch == '-') {
            lastWbIdx = chInStrIdx;
            lstStrLenBefWb = currStrLen;
            lstWbWidth = chWd;
          }
          if (currStrLen + chWd <= pWidth) {
            currStrLen += chWd;
            sb.append(ch);
            chInStrIdx++;
          } else {
            if (lastWbIdx == null) {
              result.getStrings().add(sb.toString());
              result.getWidths().add(currStrLen);
              if (result.getWidth() < currStrLen) {
                result.setWidth(currStrLen);
              }
              sb = sb.delete(0, sb.length());
              sb.append(ch);
              chInStrIdx = 1;
              currStrLen = chWd;
            } else if (ch == ' ' || ch == '-') {
              String str = sb.toString();
              result.getStrings().add(str.substring(0, lastWbIdx));
              result.getWidths().add(lstStrLenBefWb);
              if (result.getWidth() < lstStrLenBefWb) {
                result.setWidth(lstStrLenBefWb);
              }
              sb = sb.delete(0, sb.length());
              lastWbIdx = null;
              chInStrIdx = 0;
              currStrLen = 0.0;
            } else {
              sb.append(ch);
              String str = sb.toString();
              result.getStrings().add(str.substring(0, lastWbIdx));
              result.getWidths().add(lstStrLenBefWb);
              if (result.getWidth() < lstStrLenBefWb) {
                result.setWidth(lstStrLenBefWb);
              }
              sb = sb.delete(0, sb.length());
              sb.append(str.substring(lastWbIdx + 1));
              lastWbIdx = null;
              currStrLen = currStrLen - lstStrLenBefWb - lstWbWidth + chWd;
              chInStrIdx = sb.length();
            }
          }
        }
      }
      String str = sb.toString();
      if (str.length() > 0) {
        result.getStrings().add(str);
        result.getWidths().add(currStrLen);
        if (result.getWidth() < currStrLen) {
          result.setWidth(currStrLen);
        }
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
