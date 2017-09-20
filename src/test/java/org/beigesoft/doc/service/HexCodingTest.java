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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * <p>Hex coding tests.
 * </p>
 *
 * @author Yury Demidenko
 */
public class HexCodingTest {

  ToHexCoder toHexCoder = new ToHexCoder();

  @Test
  public void test1() {
    char abcd = (char) 0xABCD;
    assertArrayEquals(new char[] {'A','B','C','D'}, this.toHexCoder.encode(abcd));
    String priv = "Привет G";
    System.out.println("Привет.charAt(0) = " + priv.charAt(0));
    System.out.println("Привет.charAt(0) = " + ((long) priv.charAt(0)));
    System.out.println("Привет.codePointAt(0) = " + priv.codePointAt(0)); //41F
    System.out.println("П toHexCoder.encodeString([str]) hex = " + this.toHexCoder.encodeString("П")); //041F
    System.out.println("П Integer.toHexString([c]).toUpperCase() hex = " + Integer.toHexString('П').toUpperCase());
    char[] cpe = this.toHexCoder.encode((char) priv.codePointAt(0));
    System.out.println("Привет.charAt7) = " + priv.charAt(7));
    System.out.println("Привет.charAt(7) = " + ((long) priv.charAt(7)));
    System.out.println("Привет.codePointAt(7) = " + priv.codePointAt(7));
    System.out.println("Привет G = FEFF" + this.toHexCoder.encodeString(priv));
    System.out.println("codePointAt(0) HEX = " + String.copyValueOf(cpe));
    System.out.println("String.format(%010d, 15); = " +String.format("%010d", 15));
    String abcdStr = new String(new char[] {abcd});
    assertEquals("ABCD", this.toHexCoder.encodeString(abcdStr));
    assertEquals("ABCD", this.toHexCoder.encodeCodePoint(abcdStr.codePointAt(0)));
  }
}
