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
 * <p>Document table model.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DocTable<WI> extends ADerivingElements<WI, DocTable<WI>> {

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
   * <p>If repeat table head on every page.</p>
   **/
  private boolean isRepeatHead;

  /**
   * <p>If there is cell(s) with custom border. For example border shown only
   * at bottom for cells that user enters data.</p>
   **/
  private boolean isThereCellWithCustomBorder;

  // automatically evaluated:
  /**
   * <p>Header rows that's repeated on every new page.</p>
   **/
  private List<TableRow> repHeadRows;

  /**
   * <p>Header cells that's repeated on every new page.</p>
   **/
  private List<TableCell> repHeadCells;

  /**
   * <p>If affected on other's positions, e.g. pagination, background isn't.</p>
   * @return is affected on other's positions
   * @throws Exception an Exception
   **/
  @Override
  public final boolean getIsAffectedOnOtherPositions() throws Exception {
    return true;
  }

  //Simple getters and setters:
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

  /**
   * <p>Getter for repHeadCells.</p>
   * @return List<TableCell>
   **/
  public final List<TableCell> getRepHeadCells() {
    return this.repHeadCells;
  }

  /**
   * <p>Setter for repHeadCells.</p>
   * @param pRepHeadCells reference
   **/
  public final void setRepHeadCells(final List<TableCell> pRepHeadCells) {
    this.repHeadCells = pRepHeadCells;
  }

  /**
   * <p>Getter for repHeadRows.</p>
   * @return List<TableRow>
   **/
  public final List<TableRow> getRepHeadRows() {
    return this.repHeadRows;
  }

  /**
   * <p>Setter for repHeadRows.</p>
   * @param pRepHeadRows reference
   **/
  public final void setRepHeadRows(final List<TableRow> pRepHeadRows) {
    this.repHeadRows = pRepHeadRows;
  }
}
