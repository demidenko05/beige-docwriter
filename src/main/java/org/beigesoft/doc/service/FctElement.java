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

package org.beigesoft.doc.service;

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
