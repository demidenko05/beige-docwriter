package org.beigesoft.doc.service;

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

import org.beigesoft.graphic.service.IFctImageRgb;
import org.beigesoft.doc.model.DocString;
import org.beigesoft.doc.model.DocLine;
import org.beigesoft.doc.model.DocRectangle;
import org.beigesoft.doc.model.DocImage;
import org.beigesoft.doc.model.IDerivingElements;

/**
 * <p>Service that creates document's element.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class FctElement<WI> implements IFctElement<WI> {

  /**
   * <p>String Writer service.</p>
   **/
  private IElementWriter<DocString<WI>, WI> writerString;

  /**
   * <p>Line Writer service.</p>
   **/
  private IElementWriter<DocLine<WI>, WI> writerLine;

  /**
   * <p>Rectangle Writer service.</p>
   **/
  private IElementWriter<DocRectangle<WI>, WI> writerRectangle;

  /**
   * <p>Image Writer service.</p>
   **/
  private IElementWriter<DocImage<WI>, WI> writerImage;

  /**
   * <p>Image loader from file.</p>
   **/
  private IFctImageRgb fctImageRgb;

  /**
   * <p>Create document string.</p>
   * @param pParent parent
   * @return DocString
   * @throws Exception an Exception
   **/
  @Override
  public final DocString<WI> createDocString(
    final IDerivingElements pParent) throws Exception {
    DocString<WI> res = new DocString<WI>();
    res.setWriter(this.writerString);
    res.setParent(pParent);
    return res;
  }

  /**
   * <p>Create document line.</p>
   * @param pParent parent
   * @return DocLine
   * @throws Exception an Exception
   **/
  @Override
  public final DocLine<WI> createDocLine(
    final IDerivingElements pParent) throws Exception {
    DocLine<WI> res = new DocLine<WI>();
    res.setWriter(this.writerLine);
    res.setParent(pParent);
    return res;
  }

  /**
   * <p>Create document rectangle.</p>
   * @param pParent parent
   * @return DocRectangle
   * @throws Exception an Exception
   **/
  @Override
  public final DocRectangle<WI> createDocRectangle(
    final IDerivingElements pParent) throws Exception {
    DocRectangle<WI> res = new DocRectangle<WI>();
    res.setWriter(this.writerRectangle);
    res.setParent(pParent);
    return res;
  }

  /**
   * <p>Create document image from file (file system or resource).</p>
   * @param pParent parent
   * @param pPath path e.g. /img/image1.png or /home/jon/pictures/photo1.jpg
   * @return DocImage
   * @throws Exception an Exception
   **/
  @Override
  public final DocImage<WI> createDocImage(final IDerivingElements pParent,
    final String pPath) throws Exception {
    DocImage<WI> res = new DocImage<WI>();
    res.setImage(this.fctImageRgb.loadImage(pPath));
    res.setWriter(this.writerImage);
    res.setParent(pParent);
    return res;
  }

  //Simple getters and setters:
  /**
   * <p>Getter for writerString.</p>
   * @return IElementWriter<DocString>
   **/
  public final IElementWriter<DocString<WI>, WI> getWriterString() {
    return this.writerString;
  }

  /**
   * <p>Setter for writerString.</p>
   * @param pWriterString reference
   **/
  public final void setWriterString(
    final IElementWriter<DocString<WI>, WI> pWriterString) {
    this.writerString = pWriterString;
  }

  /**
   * <p>Getter for writerLine.</p>
   * @return IElementWriter<DocLine>
   **/
  public final IElementWriter<DocLine<WI>, WI> getWriterLine() {
    return this.writerLine;
  }

  /**
   * <p>Setter for writerLine.</p>
   * @param pWriterLine reference
   **/
  public final void setWriterLine(
    final IElementWriter<DocLine<WI>, WI> pWriterLine) {
    this.writerLine = pWriterLine;
  }

  /**
   * <p>Getter for writerRectangle.</p>
   * @return IElementWriter<DocRectangle>
   **/
  public final IElementWriter<DocRectangle<WI>, WI> getWriterRectangle() {
    return this.writerRectangle;
  }

  /**
   * <p>Setter for writerRectangle.</p>
   * @param pWriterRectangle reference
   **/
  public final void setWriterRectangle(
    final IElementWriter<DocRectangle<WI>, WI> pWriterRectangle) {
    this.writerRectangle = pWriterRectangle;
  }

  /**
   * <p>Getter for writerImage.</p>
   * @return IElementWriter<DocImage>
   **/
  public final IElementWriter<DocImage<WI>, WI> getWriterImage() {
    return this.writerImage;
  }

  /**
   * <p>Setter for writerImage.</p>
   * @param pWriterImage reference
   **/
  public final void setWriterImage(
    final IElementWriter<DocImage<WI>, WI> pWriterImage) {
    this.writerImage = pWriterImage;
  }

  /**
   * <p>Getter for fctImageRgb.</p>
   * @return IFctImageRgb
   **/
  public final IFctImageRgb getFctImageRgb() {
    return this.fctImageRgb;
  }

  /**
   * <p>Setter for fctImageRgb.</p>
   * @param pFctImageRgb reference
   **/
  public final void setFctImageRgb(final IFctImageRgb pFctImageRgb) {
    this.fctImageRgb = pFctImageRgb;
  }
}
