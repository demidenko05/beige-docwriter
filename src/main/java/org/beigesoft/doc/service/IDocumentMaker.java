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
import org.beigesoft.doc.model.DocTable;
import org.beigesoft.doc.model.EPageSize;
import org.beigesoft.doc.model.EPageOrientation;
import org.beigesoft.doc.model.Pagination;

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
    double pFontSize) throws Exception;

  /**
   * <p>Set current font size.</p>
   * @param pDoc Document
   * @param pFontSize size
   * @throws Exception an Exception
   **/
  void setFontSize(Document<WI> pDoc, double pFontSize) throws Exception;

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
   * <p>Add pagination from current page.</p>
   * @param pDoc Document
   * @return Pagination Pagination
   * @throws Exception an Exception
   **/
  Pagination<WI> addPagination(Document<WI> pDoc) throws Exception;

  /**
   * <p>Add simple document table with preferred padding/border
   * to current page.</p>
   * @param pDoc document
   * @param pColumns total
   * @param pRows total
   * @return DocTable
   * @throws Exception an Exception
   **/
  DocTable<WI> addDocTable(Document<WI> pDoc,
    int pColumns, int pRows) throws Exception;


  /**
   * <p>Add simple document table with preferred padding and custom border
   * to current page. User himself will decide which/how cell show border.</p>
   * @param pDoc document
   * @param pColumns total
   * @param pRows total
   * @return DocTable
   * @throws Exception an Exception
   **/
  DocTable<WI> addDocTableCustomBorder(Document<WI> pDoc,
    int pColumns, int pRows) throws Exception;

  /**
   * <p>Add simple document table with preferred padding and no border
   * to current page.</p>
   * @param pDoc document
   * @param pColumns total
   * @param pRows total
   * @return DocTable
   * @throws Exception an Exception
   **/
  DocTable<WI> addDocTableNoBorder(Document<WI> pDoc,
    int pColumns, int pRows) throws Exception;

  /**
   * <p>Make DocTable wrapping content.</p>
   * @param pTbl document table
   * @throws Exception an Exception
   **/
  void makeDocTableWrapping(DocTable<WI> pTbl) throws Exception;

  /**
   * <p>Derives elements.</p>
   * @param pDoc Document
   * @throws Exception an Exception
   **/
  void deriveElements(Document<WI> pDoc) throws Exception;
}
