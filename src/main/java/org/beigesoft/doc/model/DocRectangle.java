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

/**
 * <p>Document atomic rectangle model.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DocRectangle<WI> extends AElement<DocRectangle<WI>, WI> {

  /**
   * <p>Line width.</p>
   **/
  private double width;

  /**
   * <p>If fill.</p>
   **/
  private boolean isFill;

  /**
   * <p>Getter for Index group for ordering.</p>
   * @return Index Group
   **/
  @Override
  public final int getIndexGroup() {
    return 2;
  }

  //Simple getters and setters:
  /**
   * <p>Getter for width.</p>
   * @return double
   **/
  public final double getWidth() {
    return this.width;
  }

  /**
   * <p>Setter for width.</p>
   * @param pWidth reference
   **/
  public final void setWidth(final double pWidth) {
    this.width = pWidth;
  }

  /**
   * <p>Getter for isFill.</p>
   * @return boolean
   **/
  public final boolean getIsFill() {
    return this.isFill;
  }

  /**
   * <p>Setter for isFill.</p>
   * @param pIsFill reference
   **/
  public final void setIsFill(final boolean pIsFill) {
    this.isFill = pIsFill;
  }
}
