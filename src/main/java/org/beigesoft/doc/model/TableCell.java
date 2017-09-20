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
 * <p>Document's table's cell model.</p>
 *
 * @author Yury Demidenko
 */
public class TableCell extends ADocElement {

  /**
   * <p>Font number, overrides table one (from #1).</p>
   **/
  private Integer fontNumber;

  /**
   * <p>Font size, overrides table one.</p>
   **/
  private Float fontSize;

  /**
   * <p>Align Horizontal, overrides table one, NULL means LEFT.</p>
   **/
  private EAlignHorizontal alignHorizontal;

  /**
   * <p>Align Vertical, overrides table one, NULL means TOP.</p>
   **/
  private EAlignVertical alignVertical;

  /**
   * <p>Content.</p>
   **/
  private String itsContent;

  /**
   * <p>Joined cell.</p>
   **/
  private TableCell joinedCell;

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
   * <p>Getter for joinedCell.</p>
   * @return TableCell
   **/
  public final TableCell getJoinedCell() {
    return this.joinedCell;
  }

  /**
   * <p>Setter for joinedCell.</p>
   * @param pJoinedCell reference
   **/
  public final void setJoinedCell(final TableCell pJoinedCell) {
    this.joinedCell = pJoinedCell;
  }
}
