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
