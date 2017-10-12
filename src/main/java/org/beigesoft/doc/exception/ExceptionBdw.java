package org.beigesoft.doc.exception;

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
 * <p>Main document writer exception.</p>
 *
 * @author Yury Demidenko
 */
public class ExceptionBdw extends Exception {

  /**
   * <p>Constructor default.</p>
   **/
  public ExceptionBdw() {
  }

  /**
   * <p>Constructor useful.</p>
   * @param pCause parent exception
   **/
  public ExceptionBdw(final Throwable pCause) {
    super(pCause);
  }

  /**
   * <p>Constructor useful.</p>
   * @param pMsg message
   **/
  public ExceptionBdw(final String pMsg) {
    super(pMsg);
  }
}