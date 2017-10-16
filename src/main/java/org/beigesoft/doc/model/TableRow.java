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
 * <p>Document's table's row model.</p>
 *
 * @author Yury Demidenko
 */
public class TableRow extends ADocContainer {

  /**
   * <p>Page number.</p>
   **/
  private Integer pageNumber;

  /**
   * <p>If head row.</p>
   **/
  private boolean isHead;

  /**
   * <p>Height.</p>
   **/
  private double height;

  /**
   * <p>If height fixed (not calculated).</p>
   **/
  private boolean isHeightFixed;

  // to improve performance:
  /**
   * <p>If has vertically merged cells.</p>
   **/
  private boolean ifHasVerticalMerged;

  /**
   * <p>If has horizontally merged cells.</p>
   **/
  private boolean ifHasHorizontalMerged;

  /**
   * <p>Constructor default.</p>
   **/
  public TableRow() {
  }

  /**
   * <p>Constructor for cloning row.</p>
   * @param pRow reference
   **/
  public TableRow(final TableRow pRow) {
    this.setPaddingBottom(pRow.getPaddingBottom());
    this.setPaddingLeft(pRow.getPaddingLeft());
    this.setPaddingRight(pRow.getPaddingRight());
    this.setPaddingTop(pRow.getPaddingTop());
    this.setMarginBottom(pRow.getMarginBottom());
    this.setMarginLeft(pRow.getMarginLeft());
    this.setMarginRight(pRow.getMarginRight());
    this.setMarginTop(pRow.getMarginTop());
    this.setBorder(pRow.getBorder());
    this.setWraping(pRow.getWraping());
    this.setParent(pRow.getParent());
    this.setAlignHorizontal(pRow.getAlignHorizontal());
    this.height = pRow.getHeight();
    this.setIsHeightFixed(pRow.getIsHeightFixed());
    this.setWidth(pRow.getWidth());
    this.setIsWidthFixed(pRow.getIsWidthFixed());
    this.setWidthInPercentage(pRow.getWidthInPercentage());
    this.setIsX1Fixed(pRow.getIsX1Fixed());
    this.setIsX2Fixed(pRow.getIsX2Fixed());
    this.setIsY1Fixed(pRow.getIsY1Fixed());
    this.setIsY2Fixed(pRow.getIsY2Fixed());
    this.setX1(pRow.getX1());
    this.setX2(pRow.getX2());
    this.setY1(pRow.getY1());
    this.setY2(pRow.getY2());
  }

  //Simple getters and setters:
  /**
   * <p>Getter for pageNumber.</p>
   * @return Integer
   **/
  public final Integer getPageNumber() {
    return this.pageNumber;
  }

  /**
   * <p>Setter for pageNumber.</p>
   * @param pPageNumber reference
   **/
  public final void setPageNumber(final Integer pPageNumber) {
    this.pageNumber = pPageNumber;
  }

  /**
   * <p>Getter for isHead.</p>
   * @return boolean
   **/
  public final boolean getIsHead() {
    return this.isHead;
  }

  /**
   * <p>Setter for isHead.</p>
   * @param pIsHead reference
   **/
  public final void setIsHead(final boolean pIsHead) {
    this.isHead = pIsHead;
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
   * <p>Getter for isHeightFixed.</p>
   * @return boolean
   **/
  public final boolean getIsHeightFixed() {
    return this.isHeightFixed;
  }

  /**
   * <p>Setter for isHeightFixed.</p>
   * @param pIsHeightFixed reference
   **/
  public final void setIsHeightFixed(final boolean pIsHeightFixed) {
    this.isHeightFixed = pIsHeightFixed;
  }

  /**
   * <p>Getter for ifHasVerticalMerged.</p>
   * @return boolean
   **/
  public final boolean getIfHasVerticalMerged() {
    return this.ifHasVerticalMerged;
  }

  /**
   * <p>Setter for ifHasVerticalMerged.</p>
   * @param pIfHasVerticalMerged reference
   **/
  public final void setIfHasVerticalMerged(
    final boolean pIfHasVerticalMerged) {
    this.ifHasVerticalMerged = pIfHasVerticalMerged;
  }

  /**
   * <p>Getter for ifHasHorizontalMerged.</p>
   * @return boolean
   **/
  public final boolean getIfHasHorizontalMerged() {
    return this.ifHasHorizontalMerged;
  }

  /**
   * <p>Setter for ifHasHorizontalMerged.</p>
   * @param pIfHasHorizontalMerged reference
   **/
  public final void setIfHasHorizontalMerged(
    final boolean pIfHasHorizontalMerged) {
    this.ifHasHorizontalMerged = pIfHasHorizontalMerged;
  }
}
