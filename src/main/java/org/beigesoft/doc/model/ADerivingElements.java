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
