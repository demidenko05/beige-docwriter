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
}
