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

import java.util.Map;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>Utility that compress/decompress stream data with ZLIB.
 * It uses by default compression parameters and doesn't
 * handle closing streams and exceptions.</p>
 *
 * @author Yury Demidenko
 */
public class ZLibStreamer implements IZLibStreamer {

  /**
   * <p>Buffer size.</p>
   **/
  private int bufferSize = 1024;

  /**
   * <p>Compress input stream data.
   * Use java.io.ByteArrayInputStream to wrap source string.
   * Client must close streams itself.</p>
   * @param pAddParam additional params
   * @param pToCompress stream
   * @param pCompressed stream
   * @throws Exception - an exception
   **/
  @Override
  public final void compress(final Map<String, Object> pAddParam,
    final InputStream pToCompress,
      final OutputStream pCompressed) throws Exception {
    int mayRead = pToCompress.available();
    if (mayRead > 0) {
      byte[] buf = new byte[Math.min(mayRead, this.bufferSize)];
      DeflaterOutputStream dfos = new DeflaterOutputStream(pCompressed);
      int amountRead = pToCompress.read(buf);
      while (amountRead != -1) {
        dfos.write(buf, 0, amountRead);
        amountRead = pToCompress.read(buf);
      }
      dfos.flush();
      dfos.finish();
    }
  }

  /**
   * <p>Decompress output stream data.
   * Use java.io.ByteArrayInputStream to wrap source string.
   * Client must close streams itself.</p>
   * @param pAddParam additional params
   * @param pToDecompress stream
   * @param pDecompressed stream
   * @throws Exception - an exception
   **/
  @Override
  public final void decompress(final Map<String, Object> pAddParam,
    final InputStream pToDecompress,
      final OutputStream pDecompressed) throws Exception {
    int mayRead = pToDecompress.available();
    if (mayRead > 0) {
      byte[] buf = new byte[Math.min(mayRead, this.bufferSize)];
      InflaterOutputStream ifos = new InflaterOutputStream(pDecompressed);
      int amountRead = pToDecompress.read(buf);
      while (amountRead != -1) {
        ifos.write(buf, 0, amountRead);
        amountRead = pToDecompress.read(buf);
      }
      ifos.flush();
      ifos.finish();
    }
  }

  //Simple getters and setters:
  /**
   * <p>Getter for bufferSize.</p>
   * @return int
   **/
  public final int getBufferSize() {
    return this.bufferSize;
  }

  /**
   * <p>Setter for bufferSize.</p>
   * @param pBufferSize reference
   **/
  public final void setBufferSize(final int pBufferSize) {
    this.bufferSize = pBufferSize;
  }
}
