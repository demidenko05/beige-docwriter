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
 * <p>Document element abstraction model.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public interface IElement<WI> {

  /**
   * <p>Getter for x1 - start - upper left.</p>
   * @return double
   **/
  double getX1();

  /**
   * <p>Setter for x1 - start - upper left.</p>
   * @param pX1 value
   **/
  void setX1(double pX1);

  /**
   * <p>Getter for y1 - start - upper left.</p>
   * @return double
   **/
  double getY1();

  /**
   * <p>Setter for y1 - start - upper left.</p>
   * @param pY1 value
   **/
  void setY1(double pY1);

  /**
   * <p>Getter for x2.
   * X2 - end (lower right). For a string it is used
   * to store its width/height.</p>
   * @return double
   **/
  double getX2();

  /**
   * <p>Setter for x2.
   * X2 - end (lower right). For a string it is used
   * to store its width/height.</p>
   * @param pX2 value
   **/
  void setX2(double pX2);

  /**
   * <p>Getter for y2.
   * Y2 - end ((lower right). For a string it is used
   * to store its width/height.</p>
   * @return double
   **/
  double getY2();

  /**
   * <p>Setter for y2.
   * Y2 - end (lower right). For a string it is used
   * to store its width/height.</p>
   * @param pY2 value
   **/
  void setY2(final double pY2);

  /**
   * <p>Getter for Index Z.</p>
   * @return Index Z
   **/
  int getIndexZ();

  /**
   * <p>Getter for Index group for ordering.</p>
   * @return Index Group
   **/
  int getIndexGroup();

  /**
   * <p>Setter for Index Z.</p>
   * @param pIndexZ value
   **/
  void setIndexZ(int pIndexZ);

  /**
   * <p>Getter for parent.</p>
   * @return IDerivingElements
   **/
  IDerivingElements getParent();

  /**
   * <p>Setter for parent.</p>
   * @param pParent reference
   **/
  void setParent(IDerivingElements pParent);

  /**
   * <p>Write element to document page in file/screen/printer.</p>
   * @param pWi writing instrument
   * @throws Exception an Exception
   **/
  void write(WI pWi) throws Exception;
}
