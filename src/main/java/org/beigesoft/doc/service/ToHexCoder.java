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
