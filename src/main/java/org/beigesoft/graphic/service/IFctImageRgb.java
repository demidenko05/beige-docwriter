package org.beigesoft.graphic.service;

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
