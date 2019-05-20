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

package org.beigesoft.graphic.model;

/**
 * <p>
 * Abstraction of image to read and modify in RGB standard (three bytes,
 * blue is last, e.g. 0x00AACCDD - red=AA, green=CC, blue=DD).
 * It's usually wrap SWING <b>java.awt.image.BufferedImage</b>
 * or Android image <b>android.graphics.Bitmap</b>. Pure data bean.
 * </p>
 *
 * @author Yury Demidenko
 */
public interface IImageRgb {

  /**
   * <p>Getter for image width.</p>
   * @return int
   **/
  int getWidth();

  /**
   * <p>Getter for image height.</p>
   * @return int
   **/
  int getHeight();

  /**
   * <p>Get pixel RGB integer value.</p>
   * @param pX - X
   * @param pY - Y
   * @return int RGB bytes.
   **/
  int getRgb(int pX, int pY);

  /**
   * <p>Set pixel RGB bytes.</p>
   * @param pX - X
   * @param pY - Y
   * @param pRgb RGB bytes.
   **/
  void setRgb(int pX, int pY, int pRgb);
}
