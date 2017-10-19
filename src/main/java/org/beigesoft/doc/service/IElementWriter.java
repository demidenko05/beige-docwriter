package org.beigesoft.doc.service;

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

import org.beigesoft.doc.model.IElement;

/**
 * <p>Abstraction of service that write document's element.</p>
 *
 * @param <E> element type
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public interface IElementWriter<E extends IElement<WI>, WI> {

  /**
   * <p>Write element to document page in file/screen/printer.</p>
   * @param pElement Element
   * @param pWi writing instrument
   * @throws Exception an Exception
   **/
  void write(E pElement, WI pWi) throws Exception;
}
