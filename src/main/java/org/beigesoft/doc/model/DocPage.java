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
 * <p>Document page model that contains of atomic document elements.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DocPage<WI> {

  /**
   * <p>Atomic elements list.</p>
   **/
  private List<IElement<WI>> elements;

  /**
   * <p>Widthdouble, but during rendering not null.</p>
   **/
  private double width;

  /**
   * <p>Heightdouble.</p>
   **/
  private double height;

  /**
   * <p>Margin Leftdouble.</p>
   **/
  private double marginLeft;

  /**
   * <p>Margin Rightdouble.</p>
   **/
  private double marginRight;

  /**
   * <p>Margin Topdouble.</p>
   **/
  private double marginTop;

  /**
   * <p>Margin Bottomdouble.</p>
   **/
  private double marginBottom;

  /**
   * <p>Font number base (from #1).</p>
   **/
  private Integer fontNumber;

  /**
   * <p>Font size base.</p>
   **/
  private Float fontSize;

  //Simple getters and setters:
  /**
   * <p>Getter for elements.</p>
   * @return List<IElement>
   **/
  public final List<IElement<WI>> getElements() {
    return this.elements;
  }

  /**
   * <p>Setter for elements.</p>
   * @param pElements reference
   **/
  public final void setElements(final List<IElement<WI>> pElements) {
    this.elements = pElements;
  }

  /**
   * <p>Getter for width.</p>
   * @return double
   **/
  public final double getWidth() {
    return this.width;
  }

  /**
   * <p>Setter for width.</p>
   * @param pWidth reference
   **/
  public final void setWidth(final double pWidth) {
    this.width = pWidth;
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
   * <p>Getter for marginLeft.</p>
   * @return double
   **/
  public final double getMarginLeft() {
    return this.marginLeft;
  }

  /**
   * <p>Setter for marginLeft.</p>
   * @param pMarginLeft reference
   **/
  public final void setMarginLeft(final double pMarginLeft) {
    this.marginLeft = pMarginLeft;
  }

  /**
   * <p>Getter for marginRight.</p>
   * @return double
   **/
  public final double getMarginRight() {
    return this.marginRight;
  }

  /**
   * <p>Setter for marginRight.</p>
   * @param pMarginRight reference
   **/
  public final void setMarginRight(final double pMarginRight) {
    this.marginRight = pMarginRight;
  }

  /**
   * <p>Getter for marginTop.</p>
   * @return double
   **/
  public final double getMarginTop() {
    return this.marginTop;
  }

  /**
   * <p>Setter for marginTop.</p>
   * @param pMarginTop reference
   **/
  public final void setMarginTop(final double pMarginTop) {
    this.marginTop = pMarginTop;
  }

  /**
   * <p>Getter for marginBottom.</p>
   * @return double
   **/
  public final double getMarginBottom() {
    return this.marginBottom;
  }

  /**
   * <p>Setter for marginBottom.</p>
   * @param pMarginBottom reference
   **/
  public final void setMarginBottom(final double pMarginBottom) {
    this.marginBottom = pMarginBottom;
  }

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
}
