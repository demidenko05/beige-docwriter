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
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>Utility that compress/decompress stream data with ZLIB.</p>
 *
 * @author Yury Demidenko
 */
public interface IZLibStreamer {

  /**
   * <p>Compress input stream data.
   * Use java.io.ByteArrayInputStream to wrap source string.
   * Either Client or this method will handle
   * closing streams and exceptions.</p>
   * @param pAddParam additional params
   * @param pToCompress stream
   * @param pCompressed stream
   * @throws Exception - an exception
   **/
  void compress(Map<String, Object> pAddParam,
    InputStream pToCompress,
      OutputStream pCompressed) throws Exception;

  /**
   * <p>Decompress output stream data.
   * Use java.io.ByteArrayInputStream to wrap source string.
   * Either Client or this method will handle
   * closing streams and exceptions.</p>
   * @param pAddParam additional params
   * @param pToDecompress stream
   * @param pDecompressed stream
   * @throws Exception - an exception
   **/
  void decompress(Map<String, Object> pAddParam,
    InputStream pToDecompress,
      OutputStream pDecompressed) throws Exception;
}
