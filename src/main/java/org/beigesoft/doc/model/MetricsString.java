package org.beigesoft.doc.model;

/*
 * Copyright (c) 2015-2017 Beigesoft ™
 *
 * Licensed under the GNU General Public License (GPL), Version 2.0
 * (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.en.html
 */

import java.util.List;
import java.util.ArrayList;

/**
 * <p>String with metrics and multistring data model.</p>
 *
 * @author Yury Demidenko
 */
public class MetricsString {

  /**
   * <p>Width.</p>
   **/
  private double width;

  /**
   * <p>Height.</p>
   **/
  private double height;

  /**
   * <p>Strings.</p>
   **/
  private List<String> strings = new ArrayList<String>();

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
   * <p>Getter for height.</p>
   * @return double
   **/
  public final double getHeight() {
    return this.height;
  }

  /**
   * <p>Setter for height.</p>
   * @param pHeight reference
   **/
  public final void setHeight(final double pHeight) {
    this.height = pHeight;
  }

  /**
   * <p>Getter for strings.</p>
   * @return List<String>
   **/
  public final List<String> getStrings() {
    return this.strings;
  }

  /**
   * <p>Setter for strings.</p>
   * @param pStrings reference
   **/
  public final void setStrings(final List<String> pStrings) {
    this.strings = pStrings;
  }
}
