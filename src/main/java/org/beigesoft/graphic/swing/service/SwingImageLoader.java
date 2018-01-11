package org.beigesoft.graphic.swing.service;

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

import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;

import org.beigesoft.graphic.swing.model.SwingImage;
import org.beigesoft.graphic.service.IFctImageRgb;

/**
 * <p>Swing image loader.</p>
 *
 * @author Yury Demidenko
 */
public class SwingImageLoader implements IFctImageRgb {

  /**
   * <p>It loads image from file (file system or resource).</p>
   * @param pPath path e.g. resource /img/image1.png
   *  or file C:\pictures\photo1.jpg
   * @return IImageRgb
   * @throws Exception an Exception
   **/
  @Override
  public final SwingImage loadImage(final String pPath) throws Exception {
    URL url = SwingImageLoader.class.getResource(pPath);
    if (url != null) {
      return new SwingImage(ImageIO
        .read(SwingImageLoader.class.getResourceAsStream(pPath)));
    } else {
      File file = new File(pPath);
      if (!file.exists()) {
        throw new Exception("Image file not found: " + pPath);
      }
      return new SwingImage(ImageIO.read(file));
    }
  }
}
