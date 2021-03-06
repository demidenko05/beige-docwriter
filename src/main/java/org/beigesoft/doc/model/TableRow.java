/*
BSD 2-Clause License

Copyright (c) 2019, Beigesoft™
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this
  list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.beigesoft.doc.model;

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

  /**
   * <p>If has cells with custom borders below.
   * This is for implementing the next result rows.</p>
   **/
  private boolean ifHasCustomBordersBelow;

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
    this.setIfHasHorizontalMerged(pRow.getIfHasHorizontalMerged());
    this.setIfHasVerticalMerged(pRow.getIfHasVerticalMerged());
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
   * <p>Getter for ifHasCustomBordersBelow.</p>
   * @return boolean
   **/
  public final boolean getIfHasCustomBordersBelow() {
    return this.ifHasCustomBordersBelow;
  }

  /**
   * <p>Setter for ifHasCustomBordersBelow.</p>
   * @param pIfHasCustomBordersBelow reference
   **/
  public final void setIfHasCustomBordersBelow(
    final boolean pIfHasCustomBordersBelow) {
    this.ifHasCustomBordersBelow = pIfHasCustomBordersBelow;
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
