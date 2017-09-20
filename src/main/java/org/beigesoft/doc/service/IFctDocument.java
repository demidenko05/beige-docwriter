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
