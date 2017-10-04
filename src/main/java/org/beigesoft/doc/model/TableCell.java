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
 * <p>Document's table's cell model.</p>
 *
 * @author Yury Demidenko
 */
public class TableCell extends ADocElement {

  /**
   * <p>Font number, overrides table one (from #1).</p>
   **/
  private int fontNumber;

  /**
   * <p>Font size, overrides table one.</p>
   **/
  private double fontSize;

  /**
   * <p>Align Vertical, overrides table one.</p>
   **/
  private EAlignVertical alignVertical;

  /**
   * <p>Content.</p>
   **/
  private String itsContent;

  /**
   * <p>Merged cell.</p>
   **/
  private TableCell mergedCell;

  /**
   * <p>Merged cells list exclude this cell.</p>
   **/
  private List<TableCell> mergedCells;

  /**
   * <p>MetricsString from content.</p>
   **/
  private MetricsString multistring;

  /**
   * <p>If it is merged slave cell form master cell.</p>
   **/
  private boolean isMerged;

  //to implements frequently used "filled by user cells marked underline"
  //logic and others seldom ones:
  /**
   * <p>If show top border.</p>
   **/
  private boolean isNotShowBorderTop;

  /**
   * <p>If show bottom border.</p>
   **/
  private boolean isNotShowBorderBottom;

  /**
   * <p>If show left border.</p>
   **/
  private boolean isNotShowBorderLeft;

  /**
   * <p>If show right border.</p>
   **/
  private boolean isNotShowBorderRight;

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
   * <p>Getter for itsContent.</p>
   * @return String
   **/
  public final String getItsContent() {
    return this.itsContent;
  }

  /**
   * <p>Setter for itsContent.</p>
   * @param pItsContent reference
   **/
  public final void setItsContent(final String pItsContent) {
    this.itsContent = pItsContent;
  }

  /**
   * <p>Getter for mergedCell.</p>
   * @return TableCell
   **/
  public final TableCell getMergedCell() {
    return this.mergedCell;
  }

  /**
   * <p>Setter for mergedCell.</p>
   * @param pMergedCell reference
   **/
  public final void setMergedCell(final TableCell pMergedCell) {
    this.mergedCell = pMergedCell;
  }


  /**
   * <p>Getter for mergedCells.</p>
   * @return List<TableCell>
   **/
  public final List<TableCell> getMergedCells() {
    return this.mergedCells;
  }

  /**
   * <p>Setter for mergedCells.</p>
   * @param pMergedCells reference
   **/
  public final void setMergedCells(final List<TableCell> pMergedCells) {
    this.mergedCells = pMergedCells;
  }

  /**
   * <p>Getter for isMerged.</p>
   * @return boolean
   **/
  public final boolean getIsMerged() {
    return this.isMerged;
  }

  /**
   * <p>Setter for isMerged.</p>
   * @param pIsMerged reference
   **/
  public final void setIsMerged(final boolean pIsMerged) {
    this.isMerged = pIsMerged;
  }

  /**
   * <p>Getter for multistring.</p>
   * @return MetricsString
   **/
  public final MetricsString getMetricsString() {
    return this.multistring;
  }

  /**
   * <p>Setter for multistring.</p>
   * @param pMetricsString reference
   **/
  public final void setMetricsString(final MetricsString pMetricsString) {
    this.multistring = pMetricsString;
  }

  /**
   * <p>Getter for isNotShowBorderTop.</p>
   * @return boolean
   **/
  public final boolean getIsNotShowBorderTop() {
    return this.isNotShowBorderTop;
  }

  /**
   * <p>Setter for isNotShowBorderTop.</p>
   * @param pIsNotShowBorderTop reference
   **/
  public final void setIsNotShowBorderTop(
    final boolean pIsNotShowBorderTop) {
    this.isNotShowBorderTop = pIsNotShowBorderTop;
  }

  /**
   * <p>Getter for isNotShowBorderBottom.</p>
   * @return boolean
   **/
  public final boolean getIsNotShowBorderBottom() {
    return this.isNotShowBorderBottom;
  }

  /**
   * <p>Setter for isNotShowBorderBottom.</p>
   * @param pIsNotShowBorderBottom reference
   **/
  public final void setIsNotShowBorderBottom(
    final boolean pIsNotShowBorderBottom) {
    this.isNotShowBorderBottom = pIsNotShowBorderBottom;
  }

  /**
   * <p>Getter for isNotShowBorderLeft.</p>
   * @return boolean
   **/
  public final boolean getIsNotShowBorderLeft() {
    return this.isNotShowBorderLeft;
  }

  /**
   * <p>Setter for isNotShowBorderLeft.</p>
   * @param pIsNotShowBorderLeft reference
   **/
  public final void setIsNotShowBorderLeft(
    final boolean pIsNotShowBorderLeft) {
    this.isNotShowBorderLeft = pIsNotShowBorderLeft;
  }

  /**
   * <p>Getter for isNotShowBorderRight.</p>
   * @return boolean
   **/
  public final boolean getIsNotShowBorderRight() {
    return this.isNotShowBorderRight;
  }

  /**
   * <p>Setter for isNotShowBorderRight.</p>
   * @param pIsNotShowBorderRight reference
   **/
  public final void setIsNotShowBorderRight(
    final boolean pIsNotShowBorderRight) {
    this.isNotShowBorderRight = pIsNotShowBorderRight;
  }
}
