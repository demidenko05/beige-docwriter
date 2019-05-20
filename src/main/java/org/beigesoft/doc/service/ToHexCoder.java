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

import java.util.Set;

/**
 * <p>Utility that convert chars/strings into hex-string,
 * e.g. "0x0012" will be [0,0,1,2] or "0012", it's like UTF-16BE encoding
 * for 16bit chars. It's used to create PDF "hexadecimal" strings,
 * see Document management - Portable document format - Part1: PDF 1.7.
 * 7.3.4.3 and 9.10.3</p>
 *
 * @author Yury Demidenko
 */
public class ToHexCoder {

  /**
   * <p>HEX chars for encoding.<p>
   **/
  private final char[] ecncodingChars = {'0', '1', '2', '3', '4', '5', '6',
    '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

  /**
   * <p>HEX letters for encoding.<p>
   **/
  private final String[] ecncodingLetters = {"0", "1", "2", "3", "4", "5",
      "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

  /**
   * <p>Encoding char.</p>
   * @param pChar source char
   * @return encoded array of hex chars
   **/
  public final char[] encode(final char pChar) {
    char[] result = new char[4];
    result[0] = ecncodingChars[(pChar >> 12) & 0x0F];
    result[1] = ecncodingChars[(pChar >> 8) & 0x0F];
    result[2] = ecncodingChars[(pChar >> 4) & 0x0F];
    result[3] = ecncodingChars[pChar & 0x0F];
    return result;
  }

  /**
   * <p>Encoding char's code point to hex string.</p>
   * @param pCode source char's code
   * @return encoded string
   **/
  public final String encodeCodePoint(final int pCode) {
    char chr = (char) pCode;
    return encodeCodePoint(chr);
  }

  /**
   * <p>Encoding char's code point to hex string.</p>
   * @param pCode source char's UInt16 code
   * @return encoded string
   **/
  public final String encodeCodePoint(final char pCode) {
    return ecncodingLetters[(pCode >> 12) & 0x0F]
      + ecncodingLetters[(pCode >> 8) & 0x0F]
        + ecncodingLetters[(pCode >> 4) & 0x0F]
          + ecncodingLetters[pCode & 0x0F];
  }

  /**
   * <p>Encoding string to hex string.</p>
   * @param pSource source
   * @return encoded string
   **/
  public final String encodeString(final String pSource) {
    StringBuffer result = new StringBuffer();
    for (int i = 0; i < pSource.length(); i++) {
      char chr = pSource.charAt(i);
      result.append(ecncodingChars[(chr >> 12) & 0x0F]);
      result.append(ecncodingChars[(chr >> 8) & 0x0F]);
      result.append(ecncodingChars[(chr >> 4) & 0x0F]);
      result.append(ecncodingChars[chr & 0x0F]);
    }
    return result.toString();
  }

  /**
   * <p>Encoding string to hex string and register used unicode car.</p>
   * @param pSource source
   * @param pUsedUnicodes used unicodes
   * @return encoded string
   **/
  public final String encodeString(final String pSource,
    final Set<Integer> pUsedUnicodes) {
    StringBuffer result = new StringBuffer();
    for (int i = 0; i < pSource.length(); i++) {
      char chr = pSource.charAt(i);
      pUsedUnicodes.add(pSource.codePointAt(i));
      result.append(ecncodingChars[(chr >> 12) & 0x0F]);
      result.append(ecncodingChars[(chr >> 8) & 0x0F]);
      result.append(ecncodingChars[(chr >> 4) & 0x0F]);
      result.append(ecncodingChars[chr & 0x0F]);
    }
    return result.toString();
  }
}
