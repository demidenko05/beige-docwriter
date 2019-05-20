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
   * <p>MetricsString from content.</p>
   **/
  private MetricsString metricsString;

  /**
   * <p>If it is merged slave cell form master cell.</p>
   **/
  private boolean isMerged;

  //to implements frequently used "filled by user cells marked underline"
  //logic and others seldom ones:
  /**
   * <p>If show top border.</p>
   **/
  private boolean isShowBorderTop;

  /**
   * <p>If show bottom border.</p>
   **/
  private boolean isShowBorderBottom;

  /**
   * <p>If show left border.</p>
   **/
  private boolean isShowBorderLeft;

  /**
   * <p>If show right border.</p>
   **/
  private boolean isShowBorderRight;

  //for improving performance:
  /**
   * <p>Merged cells list exclude this cell.</p>
   **/
  private List<TableCell> mergedCells;

  /**
   * <p>Merging master cell.</p>
   **/
  private TableCell mergingCell;

  /**
   * <p>If merged cells are vertically (rows),
   * false - horizontally (columns).
   * It means nothing if cell isn't "master-merged cell"
   * i.e. cell.getMergedCell() == null.</p>
   **/
  private boolean isMergedVertically;

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
   * <p>Getter for metricsString.</p>
   * @return MetricsString
   **/
  public final MetricsString getMetricsString() {
    return this.metricsString;
  }

  /**
   * <p>Setter for metricsString.</p>
   * @param pMetricsString reference
   **/
  public final void setMetricsString(final MetricsString pMetricsString) {
    this.metricsString = pMetricsString;
  }

  /**
   * <p>Getter for isShowBorderTop.</p>
   * @return boolean
   **/
  public final boolean getIsShowBorderTop() {
    return this.isShowBorderTop;
  }

  /**
   * <p>Setter for isShowBorderTop.</p>
   * @param pIsShowBorderTop reference
   **/
  public final void setIsShowBorderTop(
    final boolean pIsShowBorderTop) {
    this.isShowBorderTop = pIsShowBorderTop;
  }

  /**
   * <p>Getter for isShowBorderBottom.</p>
   * @return boolean
   **/
  public final boolean getIsShowBorderBottom() {
    return this.isShowBorderBottom;
  }

  /**
   * <p>Setter for isShowBorderBottom.</p>
   * @param pIsShowBorderBottom reference
   **/
  public final void setIsShowBorderBottom(
    final boolean pIsShowBorderBottom) {
    this.isShowBorderBottom = pIsShowBorderBottom;
  }

  /**
   * <p>Getter for isShowBorderLeft.</p>
   * @return boolean
   **/
  public final boolean getIsShowBorderLeft() {
    return this.isShowBorderLeft;
  }

  /**
   * <p>Setter for isShowBorderLeft.</p>
   * @param pIsShowBorderLeft reference
   **/
  public final void setIsShowBorderLeft(
    final boolean pIsShowBorderLeft) {
    this.isShowBorderLeft = pIsShowBorderLeft;
  }

  /**
   * <p>Getter for isShowBorderRight.</p>
   * @return boolean
   **/
  public final boolean getIsShowBorderRight() {
    return this.isShowBorderRight;
  }

  /**
   * <p>Setter for isShowBorderRight.</p>
   * @param pIsShowBorderRight reference
   **/
  public final void setIsShowBorderRight(
    final boolean pIsShowBorderRight) {
    this.isShowBorderRight = pIsShowBorderRight;
  }

  /**
   * <p>Getter for mergingCell.</p>
   * @return TableCell
   **/
  public final TableCell getMergingCell() {
    return this.mergingCell;
  }

  /**
   * <p>Setter for mergingCell.</p>
   * @param pMergingCell reference
   **/
  public final void setMergingCell(final TableCell pMergingCell) {
    this.mergingCell = pMergingCell;
  }

  /**
   * <p>Getter for isMergedVertically.</p>
   * @return boolean
   **/
  public final boolean getIsMergedVertically() {
    return this.isMergedVertically;
  }

  /**
   * <p>Setter for isMergedVertically.</p>
   * @param pIsMergedVertically reference
   **/
  public final void setIsMergedVertically(final boolean pIsMergedVertically) {
    this.isMergedVertically = pIsMergedVertically;
  }
}
