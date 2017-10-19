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

/**
 * <p>Font abstraction model.</p>
 *
 * @author Yury Demidenko
 */
public interface IFont {

  /**
   * <p>Get if unicoded.</p>
   * @return if unicoded
   **/
  boolean getIsUnicoded();

  /**
   * <p>Usually it's simple getter that return model name.</p>
   * @return String model name
   **/
  String getItsName();
}
