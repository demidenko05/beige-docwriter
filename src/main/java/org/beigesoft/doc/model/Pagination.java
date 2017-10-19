package org.beigesoft.doc.model;

/*
 * Copyright (c) 2017 Beigesoft ™
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
 * <p>Document pagination model.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class Pagination<WI> extends ADerivingElements<WI, Pagination<WI>> {

  /**
   * <p>Start from.</p>
   **/
  private int start = 1;

  /**
   * <p>Title e.g. "27 Jul 17, Page #", empty default.</p>
   **/
  private String title;

  /**
   * <p>From, e.g. " from ".</p>
   **/
  private String from = "/";

  /**
   * <p>Font number, overrides table one (from #1).</p>
   **/
  private int fontNumber;

  /**
   * <p>Font size, overrides table one.</p>
   **/
  private double fontSize;

  /**
   * <p>If affected on other's positions, e.g. pagination, background isn't.</p>
   * @return is affected on other's positions
   * @throws Exception an Exception
   **/
  @Override
  public final boolean getIsAffectedOnOtherPositions() throws Exception {
    return false;
  }

  //Simple getters and setters:
  /**
   * <p>Getter for start.</p>
   * @return int
   **/
  public final int getStart() {
    return this.start;
  }

  /**
   * <p>Setter for start.</p>
   * @param pStart reference
   **/
  public final void setStart(final int pStart) {
    this.start = pStart;
  }

  /**
   * <p>Getter for title.</p>
   * @return String
   **/
  public final String getTitle() {
    return this.title;
  }

  /**
   * <p>Setter for title.</p>
   * @param pTitle reference
   **/
  public final void setTitle(final String pTitle) {
    this.title = pTitle;
  }

  /**
   * <p>Getter for from.</p>
   * @return String
   **/
  public final String getFrom() {
    return this.from;
  }

  /**
   * <p>Setter for from.</p>
   * @param pFrom reference
   **/
  public final void setFrom(final String pFrom) {
    this.from = pFrom;
  }

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
}
