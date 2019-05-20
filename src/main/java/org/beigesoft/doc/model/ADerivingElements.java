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

import org.beigesoft.doc.service.IDeriverElements;

/**
 * <p>Deriving Elements base model.</p>
 *
 * @param <WI> writing instrument type
 * @param <E> deriving elements type
 * @author Yury Demidenko
 */
public abstract class ADerivingElements<WI, E extends IDerivingElements<WI>>
  extends ADocContainer implements IDerivingElements<WI> {

  /**
   * <p>Deriver Elements service.</p>
   **/
  private IDeriverElements<WI, E> deriverElements;

  //context:
  /**
   * <p>Page where element has started.</p>
   **/
  private DocPage<WI> startPage;

  /**
   * <p>PDF document.</p>
   **/
  private Document<WI> document;

  /**
   * <p>Derives (generates) document atomic elements.</p>
   * @throws Exception an Exception
   **/
  @Override
  public final void derive() throws Exception {
    @SuppressWarnings("unchecked")
    E de = (E) this;
    this.deriverElements.derive(de);
  }

  /**
   * <p>Derives (generates) document atomic elements.</p>
   * @throws Exception an Exception
   **/
  @Override
  public final void initAfterChanges() throws Exception {
    @SuppressWarnings("unchecked")
    E de = (E) this;
    this.deriverElements.initAfterChanges(de);
  }

  /**
   * <p>Getter for start page.</p>
   * @return DocPage<WI>
   **/
  @Override
  public final DocPage<WI> getStartPage() {
    return this.startPage;
  }

  /**
   * <p>Setter for start page.</p>
   * @param pPage reference
   **/
  @Override
  public final void setStartPage(final DocPage<WI> pPage) {
    this.startPage = pPage;
  }

  /**
   * <p>Getter for document.</p>
   * @return Document
   **/
  @Override
  public final Document<WI> getDocument() {
    return this.document;
  }

  /**
   * <p>Setter for document.</p>
   * @param pDocument reference
   **/
  @Override
  public final void setDocument(
    final Document<WI> pDocument) {
    this.document = pDocument;
  }

  //Simple getters and setters:
  /**
   * <p>Getter for deriverElements.</p>
   * @return IDeriverElements<E>
   **/
  public final IDeriverElements<WI, E> getDeriverElements() {
    return this.deriverElements;
  }

  /**
   * <p>Setter for deriverElements.</p>
   * @param pDeriverElements reference
   **/
  public final void setDeriverElements(
    final IDeriverElements<WI, E> pDeriverElements) {
    this.deriverElements = pDeriverElements;
  }
}
