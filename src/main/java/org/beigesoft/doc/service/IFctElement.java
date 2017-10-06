package org.beigesoft.doc.service;

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

import org.beigesoft.doc.model.DocString;
import org.beigesoft.doc.model.DocLine;
import org.beigesoft.doc.model.DocRectangle;
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
}
