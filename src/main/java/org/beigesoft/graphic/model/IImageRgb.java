package org.beigesoft.graphic.model;

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
