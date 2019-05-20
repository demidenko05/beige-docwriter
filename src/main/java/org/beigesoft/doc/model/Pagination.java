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
