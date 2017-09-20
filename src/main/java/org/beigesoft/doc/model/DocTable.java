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
 * <p>Document table model.</p>
 *
 * @author Yury Demidenko
 */
public class DocTable extends ADerivingElements<DocTable> {

  /**
   * <p>Font number overrides base (from #1).</p>
   **/
  private Integer fontNumber;

  /**
   * <p>Font size overrides base.</p>
   **/
  private Float fontSize;

  /**
   * <p>Columns count.</p>
   **/
  private int columnsCount;

  /**
   * <p>Rows count.</p>
   **/
  private int rowsCount;

  /**
   * <p>Cells.</p>
   **/
  private List<TableCell> itsCells;

  /**
   * <p>Align Horizontal base, NULL means LEFT.</p>
   **/
  private EAlignHorizontal alignHorizontal;

  /**
   * <p>Align Vertical base, NULL means TOP.</p>
   **/
  private EAlignVertical alignVertical;

  /**
   * <p>Border width, usually equivalent to 1 dot,
   * 0 means no border.</p>
   **/
  private double border;

  //Simple getters and setters:
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

  /**
   * <p>Getter for columnsCount.</p>
   * @return int
   **/
  public final int getColumnsCount() {
    return this.columnsCount;
  }

  /**
   * <p>Setter for columnsCount.</p>
   * @param pColumnsCount reference
   **/
  public final void setColumnsCount(final int pColumnsCount) {
    this.columnsCount = pColumnsCount;
  }

  /**
   * <p>Getter for rowsCount.</p>
   * @return int
   **/
  public final int getRowsCount() {
    return this.rowsCount;
  }

  /**
   * <p>Setter for rowsCount.</p>
   * @param pRowsCount reference
   **/
  public final void setRowsCount(final int pRowsCount) {
    this.rowsCount = pRowsCount;
  }

  /**
   * <p>Getter for itsCells.</p>
   * @return List<TableCell>
   **/
  public final List<TableCell> getItsCells() {
    return this.itsCells;
  }

  /**
   * <p>Setter for itsCells.</p>
   * @param pItsCells reference
   **/
  public final void setItsCells(final List<TableCell> pItsCells) {
    this.itsCells = pItsCells;
  }

  /**
   * <p>Getter for alignHorizontal.</p>
   * @return EAlignHorizontal
   **/
  public final EAlignHorizontal getAlignHorizontal() {
    return this.alignHorizontal;
  }

  /**
   * <p>Setter for alignHorizontal.</p>
   * @param pAlignHorizontal reference
   **/
  public final void setAlignHorizontal(
    final EAlignHorizontal pAlignHorizontal) {
    this.alignHorizontal = pAlignHorizontal;
  }

  /**
   * <p>Getter for alignVertical.</p>
   * @return EAlignVertical
   **/
  public final EAlignVertical getAlignVertical() {
    return this.alignVertical;
  }

  /**
   * <p>Setter for alignVertical.</p>
   * @param pAlignVertical reference
   **/
  public final void setAlignVertical(final EAlignVertical pAlignVertical) {
    this.alignVertical = pAlignVertical;
  }

  /**
   * <p>Getter for border.</p>
   * @return double
   **/
  public final double getBorder() {
    return this.border;
  }

  /**
   * <p>Setter for border.</p>
   * @param pBorder reference
   **/
  public final void setBorder(final double pBorder) {
    this.border = pBorder;
  }
}
