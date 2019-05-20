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

package org.beigesoft.zlib;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * <p>Zlib tests.</p>
 *
 * @author Yury Demidenko
 */
public class ZlibTest {

  ZLibStreamer zLibStreamer = new ZLibStreamer();

  @Test
  public void test1() throws Exception {
    // PDF file has US-ASCII coding:
    Charset chrSet = Charset.forName("US-ASCII");
    String source = "BT *T (Hello) Tj ET";
    ByteArrayInputStream isCm = new ByteArrayInputStream(source.getBytes(chrSet));
    ByteArrayOutputStream osCm = new ByteArrayOutputStream();
    this.zLibStreamer.compress(null, isCm, osCm);
    ByteArrayInputStream isDcm = new ByteArrayInputStream(osCm.toByteArray());
    ByteArrayOutputStream osDcm = new ByteArrayOutputStream();
    this.zLibStreamer.decompress(null, isDcm, osDcm);
    String decoded = new String(osDcm.toByteArray(), chrSet);
    assertEquals(source, decoded);
  }
}
