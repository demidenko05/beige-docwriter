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
public abstract class ADocContainer extends ADocElement
  implements IDocContainer {

  /**
   * <p>Parent container if exist.</p>
   **/
  private IDocContainer parent;

  /**
   * <p>Container wraping type.</p>
   **/
  private EWraping wraping = EWraping.FILL_PARENT;

  /**
   * <p>Upper left x.</p>
   **/
  private double x1;

  /**
   * <p>Upper left y.</p>
   **/
  private double y1;

  /**
   * <p>Lower right x.</p>
   **/
  private double x2;

  /**
   * <p>Lower right y.</p>
   **/
  private double y2;

  /**
   * <p>If X1 fixed (not calculated).</p>
   **/
  private boolean isX1Fixed;

  /**
   * <p>If X2 fixed (not calculated).</p>
   **/
  private boolean isX2Fixed;

  /**
   * <p>If Y2 fixed (not calculated).</p>
   **/
  private boolean isY1Fixed;

  /**
   * <p>If Y2 fixed (not calculated).</p>
   **/
  private boolean isY2Fixed;

  /**
   * <p>Border width, usually equivalent to 1 dot,
   * 0 means no border.</p>
   **/
  private double border;

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

  // calculated or desired width:
  /**
   * <p>Width in UOM.</p>
   **/
  private double width;

  /**
   * <p>If width fixed (not calculated).</p>
   **/
  private boolean isWidthFixed;

  /**
   * <p>Width in percentage of FILLED parent.</p>
   **/
  private double widthInPercentage;

  /**
   * <p>Getter for width.</p>
   * @return double
   **/
  @Override
  public final double getWidth() {
    return this.width;
  }

  /**
   * <p>Setter for width.</p>
   * @param pWidth value
   **/
  @Override
  public final void setWidth(final double pWidth) {
    this.width = pWidth;
  }

  /**
   * <p>Getter for isWidthFixed.</p>
   * @return boolean
   **/
  @Override
  public final boolean getIsWidthFixed() {
    return this.isWidthFixed;
  }

  /**
   * <p>Setter for isWidthFixed.</p>
   * @param pIsWidthFixed value
   **/
  @Override
  public final void setIsWidthFixed(final boolean pIsWidthFixed) {
    this.isWidthFixed = pIsWidthFixed;
  }

  /**
   * <p>Getter for widthInPercentage.</p>
   * @return boolean
   **/
  @Override
  public final double getWidthInPercentage() {
    return this.widthInPercentage;
  }

  /**
   * <p>Setter for widthInPercentage.</p>
   * @param pWidthInPercentage value
   **/
  @Override
  public final void setWidthInPercentage(final double pWidthInPercentage) {
    this.widthInPercentage = pWidthInPercentage;
  }

  /**
   * <p>Getter for parent.</p>
   * @return IDocContainer
   **/
  @Override
  public final IDocContainer getParent() {
    return this.parent;
  }

  /**
   * <p>Setter for parent.</p>
   * @param pParent value
   **/
  @Override
  public final void setParent(final IDocContainer pParent) {
    this.parent = pParent;
  }

  /**
   * <p>Getter for wraping.</p>
   * @return EWraping
   **/
  @Override
  public final EWraping getWraping() {
    return this.wraping;
  }

  /**
   * <p>Setter for wraping.</p>
   * @param pWraping value
   **/
  @Override
  public final void setWraping(
    final EWraping pWraping) {
    this.wraping = pWraping;
  }


  /**
   * <p>Getter for x1 Upper left.</p>
   * @return double
   **/
  @Override
  public final double getX1() {
    return this.x1;
  }

  /**
   * <p>Setter for x1 Upper left.</p>
   * @param pX1 value
   **/
  @Override
  public final void setX1(final double pX1) {
    this.x1 = pX1;
  }

  /**
   * <p>Getter for y1 Upper left.</p>
   * @return double
   **/
  @Override
  public final double getY1() {
    return this.y1;
  }

  /**
   * <p>Setter for y1 Upper left.</p>
   * @param pY1 value
   **/
  @Override
  public final void setY1(final double pY1) {
    this.y1 = pY1;
  }

  /**
   * <p>Getter for x2 Lower right.</p>
   * @return double
   **/
  @Override
  public final double getX2() {
    return this.x2;
  }

  /**
   * <p>Setter for x2 Lower right.</p>
   * @param pX2 value
   **/
  @Override
  public final void setX2(final double pX2) {
    this.x2 = pX2;
  }

  /**
   * <p>Getter for y2 Lower right.</p>
   * @return double
   **/
  @Override
  public final double getY2() {
    return this.y2;
  }

  /**
   * <p>Setter for y2 Lower right.</p>
   * @param pY2 value
   **/
  @Override
  public final void setY2(final double pY2) {
    this.y2 = pY2;
  }

  /**
   * <p>Getter for isX1Fixed.</p>
   * @return boolean
   **/
  @Override
  public final boolean getIsX1Fixed() {
    return this.isX1Fixed;
  }

  /**
   * <p>Setter for isX1Fixed.</p>
   * @param pIsX1Fixed value
   **/
  @Override
  public final void setIsX1Fixed(final boolean pIsX1Fixed) {
    this.isX1Fixed = pIsX1Fixed;
  }

  /**
   * <p>Getter for isX2Fixed.</p>
   * @return boolean
   **/
  @Override
  public final boolean getIsX2Fixed() {
    return this.isX2Fixed;
  }

  /**
   * <p>Setter for isX2Fixed.</p>
   * @param pIsX2Fixed value
   **/
  @Override
  public final void setIsX2Fixed(final boolean pIsX2Fixed) {
    this.isX2Fixed = pIsX2Fixed;
  }

  /**
   * <p>Getter for isY1Fixed.</p>
   * @return boolean
   **/
  @Override
  public final boolean getIsY1Fixed() {
    return this.isY1Fixed;
  }

  /**
   * <p>Setter for isY1Fixed.</p>
   * @param pIsY1Fixed value
   **/
  @Override
  public final void setIsY1Fixed(final boolean pIsY1Fixed) {
    this.isY1Fixed = pIsY1Fixed;
  }

  /**
   * <p>Getter for isY2Fixed.</p>
   * @return boolean
   **/
  @Override
  public final boolean getIsY2Fixed() {
    return this.isY2Fixed;
  }

  /**
   * <p>Setter for isY2Fixed.</p>
   * @param pIsY2Fixed value
   **/
  @Override
  public final void setIsY2Fixed(final boolean pIsY2Fixed) {
    this.isY2Fixed = pIsY2Fixed;
  }

  /**
   * <p>Getter for border.</p>
   * @return double
   **/
  @Override
  public final double getBorder() {
    return this.border;
  }

  /**
   * <p>Setter for border.</p>
   * @param pBorder value
   **/
  @Override
  public final void setBorder(final double pBorder) {
    this.border = pBorder;
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
   * @param pPaddingLeft value
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
   * @param pPaddingRight value
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
   * @param pPaddingTop value
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
   * @param pPaddingBottom value
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
   * @param pMarginLeft value
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
   * @param pMarginRight value
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
   * @param pMarginTop value
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
   * @param pMarginBottom value
   **/
  @Override
  public final void setMarginBottom(final double pMarginBottom) {
    this.marginBottom = pMarginBottom;
  }
}
