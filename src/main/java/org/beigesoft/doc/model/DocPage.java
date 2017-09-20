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

/**
 * <p>Document page model that contains of atomic document elements.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DocPage<WI> {

  /**
   * <p>Atomic elements list.</p>
   **/
  private List<IElement<WI>> elements;

  /**
   * <p>Width if NULL then like HTML, but during rendering not null.</p>
   **/
  private Double width;

  /**
   * <p>Height if NULL then like HTML.</p>
   **/
  private Double height;

  /**
   * <p>Margin Left if NULL then like HTML.</p>
   **/
  private Double marginLeft;

  /**
   * <p>Margin Right if NULL then like HTML.</p>
   **/
  private Double marginRight;

  /**
   * <p>Margin Top if NULL then like HTML.</p>
   **/
  private Double marginTop;

  /**
   * <p>Margin Bottom if NULL then like HTML.</p>
   **/
  private Double marginBottom;

  /**
   * <p>Font number base (from #1).</p>
   **/
  private Integer fontNumber;

  /**
   * <p>Font size base.</p>
   **/
  private Float fontSize;

  //Simple getters and setters:
  /**
   * <p>Getter for elements.</p>
   * @return List<IElement>
   **/
  public final List<IElement<WI>> getElements() {
    return this.elements;
  }

  /**
   * <p>Setter for elements.</p>
   * @param pElements reference
   **/
  public final void setElements(final List<IElement<WI>> pElements) {
    this.elements = pElements;
  }

  /**
   * <p>Getter for width.</p>
   * @return Double
   **/
  public final Double getWidth() {
    return this.width;
  }

  /**
   * <p>Setter for width.</p>
   * @param pWidth reference
   **/
  public final void setWidth(final Double pWidth) {
    this.width = pWidth;
  }

  /**
   * <p>Getter for height.</p>
   * @return Double
   **/
  public final Double getHeight() {
    return this.height;
  }

  /**
   * <p>Setter for height.</p>
   * @param pHeight reference
   **/
  public final void setHeight(final Double pHeight) {
    this.height = pHeight;
  }

  /**
   * <p>Getter for marginLeft.</p>
   * @return Double
   **/
  public final Double getMarginLeft() {
    return this.marginLeft;
  }

  /**
   * <p>Setter for marginLeft.</p>
   * @param pMarginLeft reference
   **/
  public final void setMarginLeft(final Double pMarginLeft) {
    this.marginLeft = pMarginLeft;
  }

  /**
   * <p>Getter for marginRight.</p>
   * @return Double
   **/
  public final Double getMarginRight() {
    return this.marginRight;
  }

  /**
   * <p>Setter for marginRight.</p>
   * @param pMarginRight reference
   **/
  public final void setMarginRight(final Double pMarginRight) {
    this.marginRight = pMarginRight;
  }

  /**
   * <p>Getter for marginTop.</p>
   * @return Double
   **/
  public final Double getMarginTop() {
    return this.marginTop;
  }

  /**
   * <p>Setter for marginTop.</p>
   * @param pMarginTop reference
   **/
  public final void setMarginTop(final Double pMarginTop) {
    this.marginTop = pMarginTop;
  }

  /**
   * <p>Getter for marginBottom.</p>
   * @return Double
   **/
  public final Double getMarginBottom() {
    return this.marginBottom;
  }

  /**
   * <p>Setter for marginBottom.</p>
   * @param pMarginBottom reference
   **/
  public final void setMarginBottom(final Double pMarginBottom) {
    this.marginBottom = pMarginBottom;
  }

  /**
   * <p>Getter for fontNumber.</p>
   * @return Integer
   **/
  public final Integer getFontNumber() {
    return this.fontNumber;
  }

  /**
   * <p>Setter for fontNumber.</p>
   * @param pFontNumber reference
   **/
  public final void setFontNumber(final Integer pFontNumber) {
    this.fontNumber = pFontNumber;
  }

  /**
   * <p>Getter for fontSize.</p>
   * @return Float
   **/
  public final Float getFontSize() {
    return this.fontSize;
  }

  /**
   * <p>Setter for fontSize.</p>
   * @param pFontSize reference
   **/
  public final void setFontSize(final Float pFontSize) {
    this.fontSize = pFontSize;
  }
}
