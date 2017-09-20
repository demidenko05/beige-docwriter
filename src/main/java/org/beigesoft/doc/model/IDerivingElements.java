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

/**
 * <p>Abstraction of document's complex object that derive atomic elements,
 * e.g. Table derives many DocString, DocLine.</p>
 *
 * @author Yury Demidenko
 */
public interface IDerivingElements extends IDocElement {

  /**
   * <p>Derives (generates) document atomic elements.</p>
   * @throws Exception an Exception
   **/
  void derive() throws Exception;

  // current context:
  /**
   * <p>Getter for start page.</p>
   * @return DocPage<?>
   **/
  DocPage<?> getStartPage();

  /**
   * <p>Setter for start page.</p>
   * @param pPage reference
   **/
  void setStartPage(DocPage<?> pPage);

  /**
   * <p>Getter for document.</p>
   * @return Document
   **/
  Document<?> getDocument();

  /**
   * <p>Setter for document.</p>
   * @param pDocument reference
   **/
  void setDocument(Document<?> pDocument);
}
