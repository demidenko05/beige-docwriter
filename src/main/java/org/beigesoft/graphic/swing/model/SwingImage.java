package org.beigesoft.graphic.swing.model;

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
