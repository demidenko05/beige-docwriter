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

import org.beigesoft.doc.service.IElementWriter;

/**
 * <p>Document element base model.</p>
 *
 * @param <E> element type
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public abstract class AElement<E extends IElement<WI>, WI>
  implements IElement<WI> {

  /**
   * <p>X1 - start - upper left.</p>
   **/
  private double x1;

  /**
   * <p>Y1 - start - upper left.</p>
   **/
  private double y1;

  /**
   * <p>X2 - end (lower right). For a string it is used
   * to store its width/height.</p>
   **/
  private double x2;

  /**
   * <p>Y2 - end (lower right). For a string it is used
   * to store its width/height.</p>
   **/
  private double y2;

  /**
   * <p>Index Z, i.e. writing order.</p>
   **/
  private int indexZ = 0;

  /**
   * <p>Parent if exist.</p>
   **/
  private IDerivingElements parent;

  /**
   * <p>Element Writer delegate.</p>
   **/
  private IElementWriter<E, WI> writer;

  /**
   * <p>Getter for Index Z.</p>
   * @return Index Z
   **/
  @Override
  public final int getIndexZ() {
    return this.indexZ;
  }

  /**
   * <p>Setter for Index Z.</p>
   * @param pIndexZ value
   **/
  @Override
  public final void setIndexZ(final int pIndexZ) {
    this.indexZ = pIndexZ;
  }

  /**
   * <p>Getter for x2 (lower right).</p>
   * @return double
   **/
  @Override
  public final double getX2() {
    return this.x2;
  }

  /**
   * <p>Setter for x2 (lower right).</p>
   * @param pX2 reference
   **/
  @Override
  public final void setX2(final double pX2) {
    this.x2 = pX2;
  }

  /**
   * <p>Getter for y2 (lower right).</p>
   * @return double
   **/
  @Override
  public final double getY2() {
    return this.y2;
  }

  /**
   * <p>Setter for y2 (lower right).</p>
   * @param pY2 reference
   **/
  @Override
  public final void setY2(final double pY2) {
    this.y2 = pY2;
  }

  /**
   * <p>Getter for x1 - upper left.</p>
   * @return double
   **/
  @Override
  public final double getX1() {
    return this.x1;
  }

  /**
   * <p>Setter for x1 - upper left.</p>
   * @param pX1 reference
   **/
  @Override
  public final void setX1(final double pX1) {
    this.x1 = pX1;
  }

  /**
   * <p>Getter for y1 - upper left.</p>
   * @return double
   **/
  @Override
  public final double getY1() {
    return this.y1;
  }

  /**
   * <p>Setter for y1 - upper left.</p>
   * @param pY1 reference
   **/
  @Override
  public final void setY1(final double pY1) {
    this.y1 = pY1;
  }

  /**
   * <p>Getter for parent.</p>
   * @return IDerivingElements
   **/
  @Override
  public final IDerivingElements getParent() {
    return this.parent;
  }

  /**
   * <p>Setter for parent.</p>
   * @param pParent reference
   **/
  @Override
  public final void setParent(final IDerivingElements pParent) {
    this.parent = pParent;
  }

  /**
   * <p>Write element to document page in file/screen/printer.</p>
   * @param pWi writing instrument
   * @throws Exception an Exception
   **/
  @Override
  public final void write(final WI pWi) throws Exception {
    @SuppressWarnings("unchecked")
    E el = (E) this;
    this.writer.write(el, pWi);
  }

  //Simple getters and setters:
  /**
   * <p>Getter for writer.</p>
   * @return IElementWriter<E, WI>
   **/
  public final IElementWriter<E, WI> getWriter() {
    return this.writer;
  }

  /**
   * <p>Setter for writer.</p>
   * @param pWriter reference
   **/
  public final void setWriter(final IElementWriter<E, WI> pWriter) {
    this.writer = pWriter;
  }
}
