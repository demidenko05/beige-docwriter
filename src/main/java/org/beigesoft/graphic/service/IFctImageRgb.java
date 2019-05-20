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

package org.beigesoft.graphic.service;

import org.beigesoft.graphic.model.IImageRgb;

/**
 * <p>
 * Abstraction of service that load image from file (file system or resource).
 * If path not exist in resources then try to load from file system.
 * In SWING it do <b>javax.imageio.ImageIO.read(InputStream input)</b> and
 * <b>javax.imageio.ImageIO.read.(File input)</b>, in Android:
 * <b>android.graphics.BitmapFactory.decodeStream(InputStream is)</b> and
 * <b>android.graphics.BitmapFactory.decodeFile(String pathName)</b>
 * </p>
 *
 * @author Yury Demidenko
 */
public interface IFctImageRgb {

  /**
   * <p>It loads image from file (file system or resource).</p>
   * @param pPath path e.g. /img/image1.png or /home/jon/pictures/photo1.jpg
   * @return IImageRgb
   * @throws Exception an Exception
   **/
  IImageRgb loadImage(String pPath) throws Exception;
}
