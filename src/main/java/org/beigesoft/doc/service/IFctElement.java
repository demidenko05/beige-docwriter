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

import org.beigesoft.doc.model.DocString;
import org.beigesoft.doc.model.DocLine;
import org.beigesoft.doc.model.DocRectangle;
import org.beigesoft.doc.model.DocImage;
import org.beigesoft.doc.model.IDerivingElements;

/**
 * <p>Abstraction of service that creates document's element.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public interface IFctElement<WI> {

  /**
   * <p>Create document string.</p>
   * @param pParent parent
   * @return DocString
   * @throws Exception an Exception
   **/
  DocString<WI> createDocString(IDerivingElements pParent) throws Exception;

  /**
   * <p>Create document line.</p>
   * @param pParent parent
   * @return DocLine
   * @throws Exception an Exception
   **/
  DocLine<WI> createDocLine(IDerivingElements pParent) throws Exception;

  /**
   * <p>Create document rectangle.</p>
   * @param pParent parent
   * @return DocRectangle
   * @throws Exception an Exception
   **/
  DocRectangle<WI> createDocRectangle(
    IDerivingElements pParent) throws Exception;

  /**
   * <p>Create document image from file (file system or resource).</p>
   * @param pParent parent
   * @param pPath path e.g. /img/image1.png or /home/jon/pictures/photo1.jpg
   * @return DocImage
   * @throws Exception an Exception
   **/
  DocImage<WI> createDocImage(IDerivingElements pParent,
    String pPath) throws Exception;
}
