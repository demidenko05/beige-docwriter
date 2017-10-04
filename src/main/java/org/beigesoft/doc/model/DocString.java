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

/**
 * <p>Document atomic string model.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DocString<WI> extends AElement<DocString<WI>, WI> {

  /**
   * <p>Font number from #1.</p>
   **/
  private int fontNumber;

  /**
   * <p>Font size.</p>
   **/
  private double fontSize;

  /**
   * <p>Value.</p>
   **/
  private String value;

  /**
   * <p>Getter for Index group for ordering.</p>
   * @return Index Group
   **/
  @Override
  public final int getIndexGroup() {
    return 1;
  }

  //Simple getters and setters:
  /**
   * <p>Getter for fontNumber.</p>
   * @return int
   **/
  public final int getFontNumber() {
    return this.fontNumber;
  }

  /**
   * <p>Setter for fontNumber.</p>
   * @param pFontNumber reference
   **/
  public final void setFontNumber(final int pFontNumber) {
    this.fontNumber = pFontNumber;
  }

  /**
   * <p>Getter for fontSize.</p>
   * @return int
   **/
  public final double getFontSize() {
    return this.fontSize;
  }

  /**
   * <p>Setter for fontSize.</p>
   * @param pFontSize reference
   **/
  public final void setFontSize(final double pFontSize) {
    this.fontSize = pFontSize;
  }

  /**
   * <p>Getter for value.</p>
   * @return String
   **/
  public final String getValue() {
    return this.value;
  }

  /**
   * <p>Setter for value.</p>
   * @param pValue reference
   **/
  public final void setValue(final String pValue) {
    this.value = pValue;
  }
}
