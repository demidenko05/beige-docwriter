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

import java.util.Comparator;

/**
 * <p>Element comparator by index group.</p>
 *
 * @author Yury Demidenko
 */
public class CmpElementIdxGrp implements Comparator<IElement<?>> {

  @Override
  public final int compare(final IElement<?> pVal1,
    final IElement<?> pVal2) {
    return Integer.compare(pVal1.getIndexGroup(), pVal2.getIndexGroup());
  }
}
