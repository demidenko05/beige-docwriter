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
 * <p>Document complex container element model that contains/derives
 * atomic/complex document elements.</p>
 *
 * @author Yury Demidenko
 */
public abstract class ADocElement implements IDocElement {

  /**
   * <p>Align Horizontal.</p>
   **/
  private EAlignHorizontal alignHorizontal = EAlignHorizontal.LEFT;

  /**
   * <p>Getter for alignHorizontal.</p>
   * @return EAlignHorizontal
   **/
  @Override
  public final EAlignHorizontal getAlignHorizontal() {
    return this.alignHorizontal;
  }

  /**
   * <p>Setter for alignHorizontal.</p>
   * @param pAlignHorizontal reference
   **/
  @Override
  public final void setAlignHorizontal(
    final EAlignHorizontal pAlignHorizontal) {
    this.alignHorizontal = pAlignHorizontal;
  }
}
