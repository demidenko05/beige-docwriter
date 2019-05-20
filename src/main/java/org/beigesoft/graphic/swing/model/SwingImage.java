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

package org.beigesoft.graphic.swing.model;

import java.awt.image.BufferedImage;

import org.beigesoft.graphic.model.IImageRgb;

/**
 * <p>Swing image wrapper.</p>
 *
 * @author Yury Demidenko
 */
public class SwingImage implements IImageRgb {

  /**
   * <p>Wrapped SWING image.</p>
   **/
  private final BufferedImage image;

  /**
   * <p>Setter for image.</p>
   * @param pImage reference
   **/
  public SwingImage(final BufferedImage pImage) {
    this.image = pImage;
  }

  /**
   * <p>Getter for image width.</p>
   * @return int
   **/
  @Override
  public final int getWidth() {
    return this.image.getWidth();
  }

  /**
   * <p>Getter for image height.</p>
   * @return int
   **/
  @Override
  public final int getHeight() {
    return this.image.getHeight();
  }

  /**
   * <p>
   * Get pixel ARGB integer value.
   * </p>
   * @param pX - X
   * @param pY - Y
   * @return int ARGB bytes.
   **/
  @Override
  public final int getRgb(final int pX, final int pY) {
    return this.image.getRGB(pX, pY);
  }

  /**
   * <p>
   * Set pixel ARGB.
   * </p>
   * @param pX - X
   * @param pY - Y
   * @param pRgb ARGB bytes.
   **/
  @Override
  public final void setRgb(final int pX, final int pY,
    final int pRgb) {
    this.image.setRGB(pX, pY, pRgb);
  }

  //SGS:
  /**
   * <p>Getter for image.</p>
   * @return BufferedImage
   **/
  public final BufferedImage getImage() {
    return this.image;
  }
}
