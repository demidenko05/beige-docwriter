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
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DocTable<WI> extends ADerivingElements<WI, DocTable<WI>> {

  /**
   * <p>Font number base (from #1).</p>
   **/
  private int fontNumber;

  /**
   * <p>Font size base.</p>
   **/
  private double fontSize;

  /**
   * <p>Cells.</p>
   **/
  private List<TableCell> itsCells;

  /**
   * <p>Rows.</p>
   **/
  private List<TableRow> itsRows;

  /**
   * <p>Columns.</p>
   **/
  private List<TableColumn> itsColumns;

  /**
   * <p>Align Horizontal content base.</p>
   **/
  private EAlignHorizontal alignHoriCont = EAlignHorizontal.LEFT;

  /**
   * <p>Align Vertical content base.</p>
   **/
  private EAlignVertical alignVertCont = EAlignVertical.TOP;

  /**
   * <p>If repeat table head on every page.</p>
   **/
  private boolean isRepeatHead;

  /**
   * <p>If there is cell(s) with custom border. For example border shown only
   * at bottom for cells that user enters data.</p>
   **/
  private boolean isThereCellWithCustomBorder;

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
   * @return double
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
   * <p>Getter for itsRows.</p>
   * @return List<TableRow>
   **/
  public final List<TableRow> getItsRows() {
    return this.itsRows;
  }

  /**
   * <p>Setter for itsRows.</p>
   * @param pItsRows reference
   **/
  public final void setItsRows(final List<TableRow> pItsRows) {
    this.itsRows = pItsRows;
  }

  /**
   * <p>Getter for itsColumns.</p>
   * @return List<TableColumn>
   **/
  public final List<TableColumn> getItsColumns() {
    return this.itsColumns;
  }

  /**
   * <p>Setter for itsColumns.</p>
   * @param pItsColumns reference
   **/
  public final void setItsColumns(final List<TableColumn> pItsColumns) {
    this.itsColumns = pItsColumns;
  }

  /**
   * <p>Getter for alignHoriCont.</p>
   * @return EAlignHorizontal
   **/
  public final EAlignHorizontal getAlignHoriCont() {
    return this.alignHoriCont;
  }

  /**
   * <p>Setter for alignHoriCont.</p>
   * @param pAlignHoriCont reference
   **/
  public final void setAlignHoriCont(final EAlignHorizontal pAlignHoriCont) {
    this.alignHoriCont = pAlignHoriCont;
  }

  /**
   * <p>Getter for alignVertCont.</p>
   * @return EAlignVertical
   **/
  public final EAlignVertical getAlignVertCont() {
    return this.alignVertCont;
  }

  /**
   * <p>Setter for alignVertCont.</p>
   * @param pAlignVertCont reference
   **/
  public final void setAlignVertCont(final EAlignVertical pAlignVertCont) {
    this.alignVertCont = pAlignVertCont;
  }

  /**
   * <p>Getter for isRepeatHead.</p>
   * @return boolean
   **/
  public final boolean getIsRepeatHead() {
    return this.isRepeatHead;
  }

  /**
   * <p>Setter for isRepeatHead.</p>
   * @param pIsRepeatHead reference
   **/
  public final void setIsRepeatHead(final boolean pIsRepeatHead) {
    this.isRepeatHead = pIsRepeatHead;
  }

  /**
   * <p>Getter for isThereCellWithCustomBorder.</p>
   * @return boolean
   **/
  public final boolean getIsThereCellWithCustomBorder() {
    return this.isThereCellWithCustomBorder;
  }

  /**
   * <p>Setter for isThereCellWithCustomBorder.</p>
   * @param pIsThereCellWithCustomBorder reference
   **/
  public final void setIsThereCellWithCustomBorder(
    final boolean pIsThereCellWithCustomBorder) {
    this.isThereCellWithCustomBorder = pIsThereCellWithCustomBorder;
  }
}
