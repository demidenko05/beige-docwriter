package org.beigesoft.zlib;

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
