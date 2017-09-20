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
 * <p>Document atomic line model.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DocLine<WI> extends AElement<DocLine<WI>, WI> {

  /**
   * <p>Getter for Index group for ordering.</p>
   * @return Index Group
   **/
  @Override
  public final int getIndexGroup() {
    return 2;
  }
}
