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

  /**
   * <p>Strings widths.</p>
   **/
  private List<Double> widths = new ArrayList<Double>();

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

  /**
   * <p>Getter for widths.</p>
   * @return List<Double>
   **/
  public final List<Double> getWidths() {
    return this.widths;
  }

  /**
   * <p>Setter for widths.</p>
   * @param pWidths reference
   **/
  public final void setWidths(final List<Double> pWidths) {
    this.widths = pWidths;
  }
}
