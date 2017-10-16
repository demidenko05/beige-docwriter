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
 * <p>Document's table's column model.</p>
 *
 * @author Yury Demidenko
 */
public class TableColumn extends ADocContainer {

  // to improve performance:
  /**
   * <p>If has horizontally merged cells.</p>
   **/
  private boolean ifHasHorizontalMerged;

  //SGS:
  /**
   * <p>Getter for ifHasHorizontalMerged.</p>
   * @return boolean
   **/
  public final boolean getIfHasHorizontalMerged() {
    return this.ifHasHorizontalMerged;
  }

  /**
   * <p>Setter for ifHasHorizontalMerged.</p>
   * @param pIfHasHorizontalMerged reference
   **/
  public final void setIfHasHorizontalMerged(
    final boolean pIfHasHorizontalMerged) {
    this.ifHasHorizontalMerged = pIfHasHorizontalMerged;
  }
}
