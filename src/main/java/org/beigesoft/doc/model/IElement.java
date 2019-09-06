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
  void setY2(double pY2);

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
