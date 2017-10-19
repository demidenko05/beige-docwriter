package org.beigesoft.doc.model;

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
 * <p>Document image model, full-colored (RGB).</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DocImage<WI> extends AElement<DocImage<WI>, WI> {

  /**
   * <p>Image.</p>
   **/
  private IImageRgb image;

  /**
   * <p>Scale 1.0 (100%) default.</p>
   **/
  private double scale = 1.0;

  /**
   * <p>Getter for Index group for ordering.</p>
   * @return Index Group
   **/
  @Override
  public final int getIndexGroup() {
    return 9999;
  }

  //Simple getters and setters:
  /**
   * <p>Getter for image.</p>
   * @return IImageRgb
   **/
  public final IImageRgb getImage() {
    return this.image;
  }

  /**
   * <p>Setter for image.</p>
   * @param pImage reference
   **/
  public final void setImage(final IImageRgb pImage) {
    this.image = pImage;
  }

  /**
   * <p>Getter for scale.</p>
   * @return double
   **/
  public final double getScale() {
    return this.scale;
  }

  /**
   * <p>Setter for scale.</p>
   * @param pScale reference
   **/
  public final void setScale(final double pScale) {
    this.scale = pScale;
  }
}
