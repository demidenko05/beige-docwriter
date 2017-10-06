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
   * @param pColumns total
   * @param pRows total
   * @return DocTable
   * @throws Exception an Exception
   **/
  DocTable<WI> createDocTable(Document<WI> pDoc,
    int pColumns, int pRows) throws Exception;
}
