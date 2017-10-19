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

import org.beigesoft.doc.model.IDerivingElements;

/**
 * <p>Abstraction of service that derives atomic elements.</p>
 *
 * @param <WI> writing instrument type
 * @param <E> deriving elements type
 * @author Yury Demidenko
 */
public interface IDeriverElements<WI, E extends IDerivingElements<WI>> {

  /**
   * <p>Derives (generates) document atomic elements.</p>
   * @param pDerivingEl IDerivingElements
   * @throws Exception an Exception
   **/
  void derive(E pDerivingEl) throws Exception;


  /**
   * <p>Init data after possible changes.</p>
   * @param pDerivingEl IDerivingElements
   * @throws Exception an Exception
   **/
  void initAfterChanges(E pDerivingEl) throws Exception;
}
