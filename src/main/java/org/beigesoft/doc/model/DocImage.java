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
   * <p>Rotate on degrees, 0 default no rotation.</p>
   **/
  private double rotateDegrees = 0.0;

  /**
   * <p>Index group for ordering.</p>
   **/
  private int indexGroup = 9999;

  /**
   * <p>Getter for Index group for ordering.</p>
   * @return Index Group
   **/
  @Override
  public final int getIndexGroup() {
    return this.indexGroup;
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

  /**
   * <p>Getter for rotateDegrees.</p>
   * @return double
   **/
  public final double getRotateDegrees() {
    return this.rotateDegrees;
  }

  /**
   * <p>Setter for rotateDegrees.</p>
   * @param pRotateDegrees reference
   **/
  public final void setRotateDegrees(final double pRotateDegrees) {
    this.rotateDegrees = pRotateDegrees;
  }

  /**
   * <p>Setter for indexGroup.</p>
   * @param pIndexGroup reference
   **/
  public final void setIndexGroup(final int pIndexGroup) {
    this.indexGroup = pIndexGroup;
  }
}
