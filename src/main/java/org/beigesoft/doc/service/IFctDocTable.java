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

import org.beigesoft.doc.model.DocTable;
import org.beigesoft.doc.model.Document;
import org.beigesoft.doc.model.DocPage;

/**
 * <p>Abstraction of service that creates document's DocTable.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public interface IFctDocTable<WI> {

  /**
   * <p>Create document table.</p>
   * @param pDoc document
   * @param pStartPg page
   * @param pRows total
   * @param pColumns total
   * @param pBorder Border, 0 means NO
   * @param pPadding padding
   * @return DocTable
   * @throws Exception an Exception
   **/
  DocTable<WI> createDocTable(Document<WI> pDoc,
    DocPage<WI> pStartPg, int pRows, int pColumns,
      double pBorder, double pPadding) throws Exception;
}
