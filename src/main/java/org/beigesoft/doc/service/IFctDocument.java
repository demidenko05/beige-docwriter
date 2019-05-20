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

import org.beigesoft.doc.model.Document;
import org.beigesoft.doc.model.EPageSize;
import org.beigesoft.doc.model.EPageOrientation;
import org.beigesoft.doc.model.EUnitOfMeasure;

/**
 * <p>Abstraction of service that creates document and its parts.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public interface IFctDocument<WI> {

  /**
   * <p>Create document with page with given size and orientation.
   * EPageSize.LETTER means that unit of measure will be inch,
   * EPageSize.A2..5 - millimeter.</p>
   * @param pPageSize EPageSize
   * @param pPageOrientation EPageOrientation
   * @return Document
   * @throws Exception an Exception
   **/
  Document<WI> createDoc(EPageSize pPageSize,
    EPageOrientation pPageOrientation) throws Exception;

  /**
   * <p>Create document with page with given UOM, width and height.</p>
   * @param pUom doc UOM
   * @param pWidth Width in doc UOM
   * @param pHeight Height in doc UOM
   * @return Document
   * @throws Exception an Exception
   **/
  Document<WI> createDoc(EUnitOfMeasure pUom, double pWidth,
    double pHeight) throws Exception;
}
