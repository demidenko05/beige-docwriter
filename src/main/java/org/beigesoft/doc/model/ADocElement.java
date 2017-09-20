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
 * <p>Document complex element model that contains/derives
 * atomic/complex document elements.</p>
 *
 * @author Yury Demidenko
 */
public abstract class ADocElement implements IDocElement {

  /**
   * <p>Upper left x, if NULL then depends of content or parent.</p>
   **/
  private Double x1;

  /**
   * <p>Upper left y, if NULL then depends of content or parent.</p>
   **/
  private Double y1;

  /**
   * <p>Lower right x, if NULL then depends of content or parent.</p>
   **/
  private Double x2;

  /**
   * <p>Lower right y, if NULL then depends of content or parent.</p>
   **/
  private Double y2;

  /**
   * <p>If X1 calculated (not fixed).</p>
   **/
  private boolean isX1Calculated;

  /**
   * <p>If X2 calculated (not fixed).</p>
   **/
  private boolean isX2Calculated;

  /**
   * <p>If Y2 calculated (not fixed).</p>
   **/
  private boolean isY1Calculated;

  /**
   * <p>If Y2 calculated (not fixed).</p>
   **/
  private boolean isY2Calculated;

  /**
   * <p>Padding Left .</p>
   **/
  private double paddingLeft;

  /**
   * <p>Padding Right .</p>
   **/
  private double paddingRight;

  /**
   * <p>Padding Top .</p>
   **/
  private double paddingTop;

  /**
   * <p>Padding Bottom .</p>
   **/
  private double paddingBottom;

  /**
   * <p>Margin Left .</p>
   **/
  private double marginLeft;

  /**
   * <p>Margin Right .</p>
   **/
  private double marginRight;

  /**
   * <p>Margin Top .</p>
   **/
  private double marginTop;

  /**
   * <p>Margin Bottom .</p>
   **/
  private double marginBottom;

  /**
   * <p>Getter for x1 Upper left.</p>
   * @return Double
   **/
  @Override
  public final Double getX1() {
    return this.x1;
  }

  /**
   * <p>Setter for x1 Upper left.</p>
   * @param pX1 reference
   **/
  @Override
  public final void setX1(final Double pX1) {
    this.x1 = pX1;
  }

  /**
   * <p>Getter for y1 Upper left.</p>
   * @return Double
   **/
  @Override
  public final Double getY1() {
    return this.y1;
  }

  /**
   * <p>Setter for y1 Upper left.</p>
   * @param pY1 reference
   **/
  @Override
  public final void setY1(final Double pY1) {
    this.y1 = pY1;
  }

  /**
   * <p>Getter for x2 Lower right.</p>
   * @return Double
   **/
  @Override
  public final Double getX2() {
    return this.x2;
  }

  /**
   * <p>Setter for x2 Lower right.</p>
   * @param pX2 reference
   **/
  @Override
  public final void setX2(final Double pX2) {
    this.x2 = pX2;
  }

  /**
   * <p>Getter for y2 Lower right.</p>
   * @return Double
   **/
  @Override
  public final Double getY2() {
    return this.y2;
  }

  /**
   * <p>Setter for y2 Lower right.</p>
   * @param pY2 reference
   **/
  @Override
  public final void setY2(final Double pY2) {
    this.y2 = pY2;
  }

  /**
   * <p>Getter for isX1Calculated.</p>
   * @return boolean
   **/
  @Override
  public final boolean getIsX1Calculated() {
    return this.isX1Calculated;
  }

  /**
   * <p>Setter for isX1Calculated.</p>
   * @param pIsX1Calculated reference
   **/
  @Override
  public final void setIsX1Calculated(final boolean pIsX1Calculated) {
    this.isX1Calculated = pIsX1Calculated;
  }

  /**
   * <p>Getter for isX2Calculated.</p>
   * @return boolean
   **/
  @Override
  public final boolean getIsX2Calculated() {
    return this.isX2Calculated;
  }

  /**
   * <p>Setter for isX2Calculated.</p>
   * @param pIsX2Calculated reference
   **/
  @Override
  public final void setIsX2Calculated(final boolean pIsX2Calculated) {
    this.isX2Calculated = pIsX2Calculated;
  }

  /**
   * <p>Getter for isY1Calculated.</p>
   * @return boolean
   **/
  @Override
  public final boolean getIsY1Calculated() {
    return this.isY1Calculated;
  }

  /**
   * <p>Setter for isY1Calculated.</p>
   * @param pIsY1Calculated reference
   **/
  @Override
  public final void setIsY1Calculated(final boolean pIsY1Calculated) {
    this.isY1Calculated = pIsY1Calculated;
  }

  /**
   * <p>Getter for isY2Calculated.</p>
   * @return boolean
   **/
  @Override
  public final boolean getIsY2Calculated() {
    return this.isY2Calculated;
  }

  /**
   * <p>Setter for isY2Calculated.</p>
   * @param pIsY2Calculated reference
   **/
  @Override
  public final void setIsY2Calculated(final boolean pIsY2Calculated) {
    this.isY2Calculated = pIsY2Calculated;
  }

  /**
   * <p>Getter for paddingLeft.</p>
   * @return double
   **/
  @Override
  public final double getPaddingLeft() {
    return this.paddingLeft;
  }

  /**
   * <p>Setter for paddingLeft.</p>
   * @param pPaddingLeft reference
   **/
  @Override
  public final void setPaddingLeft(final double pPaddingLeft) {
    this.paddingLeft = pPaddingLeft;
  }

  /**
   * <p>Getter for paddingRight.</p>
   * @return double
   **/
  @Override
  public final double getPaddingRight() {
    return this.paddingRight;
  }

  /**
   * <p>Setter for paddingRight.</p>
   * @param pPaddingRight reference
   **/
  @Override
  public final void setPaddingRight(final double pPaddingRight) {
    this.paddingRight = pPaddingRight;
  }

  /**
   * <p>Getter for paddingTop.</p>
   * @return double
   **/
  @Override
  public final double getPaddingTop() {
    return this.paddingTop;
  }

  /**
   * <p>Setter for paddingTop.</p>
   * @param pPaddingTop reference
   **/
  @Override
  public final void setPaddingTop(final double pPaddingTop) {
    this.paddingTop = pPaddingTop;
  }

  /**
   * <p>Getter for paddingBottom.</p>
   * @return double
   **/
  @Override
  public final double getPaddingBottom() {
    return this.paddingBottom;
  }

  /**
   * <p>Setter for paddingBottom.</p>
   * @param pPaddingBottom reference
   **/
  @Override
  public final void setPaddingBottom(final double pPaddingBottom) {
    this.paddingBottom = pPaddingBottom;
  }

  /**
   * <p>Getter for marginLeft.</p>
   * @return double
   **/
  @Override
  public final double getMarginLeft() {
    return this.marginLeft;
  }

  /**
   * <p>Setter for marginLeft.</p>
   * @param pMarginLeft reference
   **/
  @Override
  public final void setMarginLeft(final double pMarginLeft) {
    this.marginLeft = pMarginLeft;
  }

  /**
   * <p>Getter for marginRight.</p>
   * @return double
   **/
  @Override
  public final double getMarginRight() {
    return this.marginRight;
  }

  /**
   * <p>Setter for marginRight.</p>
   * @param pMarginRight reference
   **/
  @Override
  public final void setMarginRight(final double pMarginRight) {
    this.marginRight = pMarginRight;
  }

  /**
   * <p>Getter for marginTop.</p>
   * @return double
   **/
  @Override
  public final double getMarginTop() {
    return this.marginTop;
  }

  /**
   * <p>Setter for marginTop.</p>
   * @param pMarginTop reference
   **/
  @Override
  public final void setMarginTop(final double pMarginTop) {
    this.marginTop = pMarginTop;
  }

  /**
   * <p>Getter for marginBottom.</p>
   * @return double
   **/
  @Override
  public final double getMarginBottom() {
    return this.marginBottom;
  }

  /**
   * <p>Setter for marginBottom.</p>
   * @param pMarginBottom reference
   **/
  @Override
  public final void setMarginBottom(final double pMarginBottom) {
    this.marginBottom = pMarginBottom;
  }
}
