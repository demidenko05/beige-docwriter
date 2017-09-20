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

import org.beigesoft.doc.model.Document;
import org.beigesoft.doc.model.EPageSize;
import org.beigesoft.doc.model.EPageOrientation;

/**
 * <p>Abstraction of service that makes document.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public interface IDocumentMaker<WI> {

  /**
   * <p>Add a page into document like the last page
   * and set it current.</p>
   * @param pDoc Document
   * @throws Exception an Exception
   **/
  void addPage(Document<WI> pDoc) throws Exception;

  /**
   * <p>Add a page into document with given size and orientation
   * and set it current.</p>
   * @param pDoc Document
   * @param pPageSize EPageSize
   * @param pPageOrientation EPageOrientation
   * @throws Exception an Exception
   **/
  void addPage(Document<WI> pDoc, EPageSize pPageSize,
    EPageOrientation pPageOrientation) throws Exception;

  /**
   * <p>Add a page into document with given width and height
   * and set it current.</p>
   * @param pDoc Document
   * @param pWidth Width in doc UOM
   * @param pHeight Height in doc UOM
   * @throws Exception an Exception
   **/
  void addPage(Document<WI> pDoc, double pWidth,
    double pHeight) throws Exception;

  /**
   * <p>Set current page (the first is #1).</p>
   * @param pDoc Document
   * @param pPageNum number
   * @throws Exception an Exception
   **/
  void setPage(Document<WI> pDoc,
    int pPageNum) throws Exception;

  /**
   * <p>Set current font (the first is #1).</p>
   * @param pDoc Document
   * @param pFontNum number
   * @param pFontSize size
   * @throws Exception an Exception
   **/
  void setFont(Document<WI> pDoc, int pFontNum,
    float pFontSize) throws Exception;

  /**
   * <p>Set current font size.</p>
   * @param pDoc Document
   * @param pFontSize size
   * @throws Exception an Exception
   **/
  void setFontSize(Document<WI> pDoc, float pFontSize) throws Exception;

  /**
   * <p>Add non-multiline text into current page with
   * X Y coordinates in current units.</p>
   * @param pDoc Document
   * @param pString string
   * @param pX x
   * @param pY y
   * @throws Exception an Exception
   **/
  void addString(Document<WI> pDoc, String pString,
    double pX, double pY) throws Exception;

  /**
   * <p>Derives elements.</p>
   * @param pDoc Document
   * @throws Exception an Exception
   **/
  void deriveElements(Document<WI> pDoc) throws Exception;
}
