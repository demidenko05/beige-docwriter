/*
BSD 2-Clause License

Copyright (c) 2019, Beigesoft™
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this
  list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.beigesoft.doc.service;

import org.beigesoft.doc.model.Document;
import org.beigesoft.doc.model.DocTable;
import org.beigesoft.doc.model.DocImage;
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
   * <p>Add row to the end of DocTable.</p>
   * @param pTbl document table
   * @throws Exception an Exception
   **/
  void addRowToDocTable(DocTable<WI> pTbl) throws Exception;

  /**
   * <p>Derives elements.</p>
   * @param pDoc Document
   * @throws Exception an Exception
   **/
  void deriveElements(Document<WI> pDoc) throws Exception;

  /**
   * <p>Add image into current page from file (file system or resource) with
   * X Y coordinates in current units.</p>
   * @param pDoc Document
   * @param pPath path e.g. /img/image1.png or /home/jon/pictures/photo1.jpg
   * @param pX x
   * @param pY y
   * @return DocImage<WI>
   * @throws Exception an Exception
   **/
  DocImage<WI> addImage(Document<WI> pDoc, String pPath,
    double pX, double pY) throws Exception;
}
