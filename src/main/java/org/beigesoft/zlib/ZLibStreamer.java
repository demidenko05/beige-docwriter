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
