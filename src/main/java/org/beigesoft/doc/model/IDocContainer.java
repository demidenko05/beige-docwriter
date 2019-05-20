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
 * <p>Document complex element container model that contains/derives
 * atomic/complex document elements.</p>
 *
 * @author Yury Demidenko
 */
public interface IDocContainer extends IDocElement {

  /**
   * <p>Getter for parent.</p>
   * @return IDocContainer
   **/
  IDocContainer getParent();

  /**
   * <p>Setter for parent.</p>
   * @param pParent reference
   **/
  void setParent(IDocContainer pParent);

  /**
   * <p>Getter for wraping.</p>
   * @return EWraping
   **/
  EWraping getWraping();

  /**
   * <p>Setter for wraping.</p>
   * @param pWraping reference
   **/
  void setWraping(EWraping pWraping);


  /**
   * <p>Getter for x1 Upper left.</p>
   * @return double
   **/
  double getX1();

  /**
   * <p>Setter for x1 Upper left.</p>
   * @param pX1 reference
   **/
  void setX1(double pX1);

  /**
   * <p>Getter for y1 Upper left.</p>
   * @return double
   **/
  double getY1();

  /**
   * <p>Setter for y1 Upper left.</p>
   * @param pY1 reference
   **/
  void setY1(double pY1);

  /**
   * <p>Getter for x2 Lower right.</p>
   * @return double
   **/
  double getX2();

  /**
   * <p>Setter for x2 Lower right.</p>
   * @param pX2 reference
   **/
  void setX2(double pX2);

  /**
   * <p>Getter for y2 Lower right.</p>
   * @return double
   **/
  double getY2();

  /**
   * <p>Setter for y2 Lower right.</p>
   * @param pY2 reference
   **/
  void setY2(double pY2);

  /**
   * <p>Getter for isX1Fixed.</p>
   * @return boolean
   **/
  boolean getIsX1Fixed();

  /**
   * <p>Setter for isX1Fixed.</p>
   * @param pIsX1Fixed reference
   **/
  void setIsX1Fixed(boolean pIsX1Fixed);

  /**
   * <p>Getter for isX2Fixed.</p>
   * @return boolean
   **/
  boolean getIsX2Fixed();

  /**
   * <p>Setter for isX2Fixed.</p>
   * @param pIsX2Fixed reference
   **/
  void setIsX2Fixed(boolean pIsX2Fixed);

  /**
   * <p>Getter for isY1Fixed.</p>
   * @return boolean
   **/
  boolean getIsY1Fixed();

  /**
   * <p>Setter for isY1Fixed.</p>
   * @param pIsY1Fixed reference
   **/
  void setIsY1Fixed(boolean pIsY1Fixed);

  /**
   * <p>Getter for isY2Fixed.</p>
   * @return boolean
   **/
  boolean getIsY2Fixed();

  /**
   * <p>Setter for isY2Fixed.</p>
   * @param pIsY2Fixed reference
   **/
  void setIsY2Fixed(boolean pIsY2Fixed);

  /**
   * <p>Getter for border.</p>
   * @return double
   **/
  double getBorder();

  /**
   * <p>Setter for border.</p>
   * @param pBorder reference
   **/
  void setBorder(double pBorder);

  /**
   * <p>Getter for paddingLeft.</p>
   * @return double
   **/
  double getPaddingLeft();

  /**
   * <p>Setter for paddingLeft.</p>
   * @param pPaddingLeft reference
   **/
  void setPaddingLeft(double pPaddingLeft);

  /**
   * <p>Getter for paddingRight.</p>
   * @return double
   **/
  double getPaddingRight();

  /**
   * <p>Setter for paddingRight.</p>
   * @param pPaddingRight reference
   **/
  void setPaddingRight(double pPaddingRight);

  /**
   * <p>Getter for paddingTop.</p>
   * @return double
   **/
  double getPaddingTop();

  /**
   * <p>Setter for paddingTop.</p>
   * @param pPaddingTop reference
   **/
  void setPaddingTop(double pPaddingTop);

  /**
   * <p>Getter for paddingBottom.</p>
   * @return double
   **/
  double getPaddingBottom();

  /**
   * <p>Setter for paddingBottom.</p>
   * @param pPaddingBottom reference
   **/
  void setPaddingBottom(double pPaddingBottom);

  /**
   * <p>Getter for marginLeft.</p>
   * @return double
   **/
  double getMarginLeft();

  /**
   * <p>Setter for marginLeft.</p>
   * @param pMarginLeft reference
   **/
  void setMarginLeft(double pMarginLeft);

  /**
   * <p>Getter for marginRight.</p>
   * @return double
   **/
  double getMarginRight();

  /**
   * <p>Setter for marginRight.</p>
   * @param pMarginRight reference
   **/
  void setMarginRight(double pMarginRight);

  /**
   * <p>Getter for marginTop.</p>
   * @return double
   **/
  double getMarginTop();

  /**
   * <p>Setter for marginTop.</p>
   * @param pMarginTop reference
   **/
  void setMarginTop(double pMarginTop);

  /**
   * <p>Getter for marginBottom.</p>
   * @return double
   **/
  double getMarginBottom();

  /**
   * <p>Setter for marginBottom.</p>
   * @param pMarginBottom reference
   **/
  void setMarginBottom(double pMarginBottom);

  // intermediate or desired width:
  /**
   * <p>Getter for width.</p>
   * @return double
   **/
  double getWidth();

  /**
   * <p>Setter for width.</p>
   * @param pWidth reference
   **/
  void setWidth(double pWidth);

  /**
   * <p>Getter for isWidthFixed.</p>
   * @return boolean
   **/
  boolean getIsWidthFixed();

  /**
   * <p>Setter for isWidthFixed.</p>
   * @param pIsWidthFixed reference
   **/
  void setIsWidthFixed(boolean pIsWidthFixed);

  /**
   * <p>Getter for widthInPercentage.</p>
   * @return boolean
   **/
  double getWidthInPercentage();

  /**
   * <p>Setter for widthInPercentage.</p>
   * @param pWidthInPercentage reference
   **/
  void setWidthInPercentage(double pWidthInPercentage);
}
