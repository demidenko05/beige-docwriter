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
 * <p>Abstraction of document's complex object that derive atomic elements,
 * e.g. Table derives many DocString, DocLine.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public interface IDerivingElements<WI> extends IDocContainer {

  /**
   * <p>If affected on other's positions, e.g. pagination, background isn't.</p>
   * @return is affected on other's positions
   * @throws Exception an Exception
   **/
  boolean getIsAffectedOnOtherPositions() throws Exception;

  /**
   * <p>Derives (generates) document atomic elements.</p>
   * @throws Exception an Exception
   **/
  void derive() throws Exception;

  /**
   * <p>Init data after possible changes.</p>
   * @throws Exception an Exception
   **/
  void initAfterChanges() throws Exception;

  // current context:
  /**
   * <p>Getter for start page.</p>
   * @return DocPage<WI>
   **/
  DocPage<WI> getStartPage();

  /**
   * <p>Setter for start page.</p>
   * @param pPage reference
   **/
  void setStartPage(DocPage<WI> pPage);

  /**
   * <p>Getter for document.</p>
   * @return Document
   **/
  Document<WI> getDocument();

  /**
   * <p>Setter for document.</p>
   * @param pDocument reference
   **/
  void setDocument(Document<WI> pDocument);
}
