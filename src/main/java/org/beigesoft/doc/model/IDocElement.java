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
 * <p>Document complex element model that contains/derives
 * atomic/complex document elements.</p>
 *
 * @author Yury Demidenko
 */
public interface IDocElement {

  /**
   * <p>Getter for x1 Upper left.</p>
   * @return Double
   **/
  Double getX1();

  /**
   * <p>Setter for x1 Upper left.</p>
   * @param pX1 reference
   **/
  void setX1(Double pX1);

  /**
   * <p>Getter for y1 Upper left.</p>
   * @return Double
   **/
  Double getY1();

  /**
   * <p>Setter for y1 Upper left.</p>
   * @param pY1 reference
   **/
  void setY1(Double pY1);

  /**
   * <p>Getter for x2 Lower right.</p>
   * @return Double
   **/
  Double getX2();

  /**
   * <p>Setter for x2 Lower right.</p>
   * @param pX2 reference
   **/
  void setX2(Double pX2);

  /**
   * <p>Getter for y2 Lower right.</p>
   * @return Double
   **/
  Double getY2();

  /**
   * <p>Setter for y2 Lower right.</p>
   * @param pY2 reference
   **/
  void setY2(Double pY2);

  /**
   * <p>Getter for isX1Calculated.</p>
   * @return boolean
   **/
  boolean getIsX1Calculated();

  /**
   * <p>Setter for isX1Calculated.</p>
   * @param pIsX1Calculated reference
   **/
  void setIsX1Calculated(boolean pIsX1Calculated);

  /**
   * <p>Getter for isX2Calculated.</p>
   * @return boolean
   **/
  boolean getIsX2Calculated();

  /**
   * <p>Setter for isX2Calculated.</p>
   * @param pIsX2Calculated reference
   **/
  void setIsX2Calculated(boolean pIsX2Calculated);

  /**
   * <p>Getter for isY1Calculated.</p>
   * @return boolean
   **/
  boolean getIsY1Calculated();

  /**
   * <p>Setter for isY1Calculated.</p>
   * @param pIsY1Calculated reference
   **/
  void setIsY1Calculated(boolean pIsY1Calculated);

  /**
   * <p>Getter for isY2Calculated.</p>
   * @return boolean
   **/
  boolean getIsY2Calculated();

  /**
   * <p>Setter for isY2Calculated.</p>
   * @param pIsY2Calculated reference
   **/
  void setIsY2Calculated(boolean pIsY2Calculated);

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
}
