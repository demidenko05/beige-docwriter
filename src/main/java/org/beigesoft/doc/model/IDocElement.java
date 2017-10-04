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
 * <p>Document complex element base model that contains/derives
 * atomic/complex document elements.</p>
 *
 * @author Yury Demidenko
 */
public interface IDocElement {

  /**
   * <p>Getter for alignHorizontal.</p>
   * @return EAlignHorizontal
   **/
  EAlignHorizontal getAlignHorizontal();

  /**
   * <p>Setter for alignHorizontal.</p>
   * @param pAlignHorizontal reference
   **/
  void setAlignHorizontal(EAlignHorizontal pAlignHorizontal);
}
