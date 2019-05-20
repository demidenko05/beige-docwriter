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
