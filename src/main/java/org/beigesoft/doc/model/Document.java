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

import java.util.List;

/**
 * <p>Document data model.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class Document<WI> {

  /**
   * <p>Document content.</p>
   **/
  private List<DocPage<WI>> pages;

  /**
   * <p>Document fonts.</p>
   **/
  private List<IFont> fonts;

  /**
   * <p>List of deriving elements.</p>
   **/
  private List<IDerivingElements> derivingElementsList;

  /**
   * <p>User/document unit of measure.</p>
   **/
  private EUnitOfMeasure unitOfMeasure;

  //Document current state during writing:
  /**
   * <p>Resolution dots per inch, 72 default for PDF file.</p>
   **/
  private double resolutionDpi = 72.0;

  //Document current state during creating:
  /**
   * <p>Current page# (from 1).</p>
   **/
  private int pageNumber = 0;

  /**
   * <p>Current font# (from 1).</p>
   **/
  private int fontNumber = 0;

  /**
   * <p>Current font size.</p>
   **/
  private double fontSize;

  //Simple getters and setters:
  /**
   * <p>Getter for resolutionDpi.</p>
   * @return double
   **/
  public final double getResolutionDpi() {
    return this.resolutionDpi;
  }

  /**
   * <p>Setter for resolutionDpi.</p>
   * @param pResolutionDpi reference
   **/
  public final void setResolutionDpi(final double pResolutionDpi) {
    this.resolutionDpi = pResolutionDpi;
  }

  /**
   * <p>Getter for pages.</p>
   * @return List<DocPage>
   **/
  public final List<DocPage<WI>> getPages() {
    return this.pages;
  }

  /**
   * <p>Setter for pages.</p>
   * @param pPages reference
   **/
  public final void setPages(final List<DocPage<WI>> pPages) {
    this.pages = pPages;
  }

  /**
   * <p>Getter for derivingElementsList.</p>
   * @return List<IDerivingElements>
   **/
  public final List<IDerivingElements> getDerivingElementsList() {
    return this.derivingElementsList;
  }

  /**
   * <p>Setter for derivingElementsList.</p>
   * @param pDerivingElementsList reference
   **/
  public final void setDerivingElementsList(
    final List<IDerivingElements> pDerivingElementsList) {
    this.derivingElementsList = pDerivingElementsList;
  }

  /**
   * <p>Getter for pageNumber.</p>
   * @return int
   **/
  public final int getPageNumber() {
    return this.pageNumber;
  }

  /**
   * <p>Setter for pageNumber.</p>
   * @param pPageNumber reference
   **/
  public final void setPageNumber(final int pPageNumber) {
    this.pageNumber = pPageNumber;
  }

  /**
   * <p>Getter for fontNumber.</p>
   * @return int
   **/
  public final int getFontNumber() {
    return this.fontNumber;
  }

  /**
   * <p>Setter for fontNumber.</p>
   * @param pFontNumber reference
   **/
  public final void setFontNumber(final int pFontNumber) {
    this.fontNumber = pFontNumber;
  }

  /**
   * <p>Getter for fontSize.</p>
   * @return double
   **/
  public final double getFontSize() {
    return this.fontSize;
  }

  /**
   * <p>Setter for fontSize.</p>
   * @param pFontSize reference
   **/
  public final void setFontSize(final double pFontSize) {
    this.fontSize = pFontSize;
  }

  /**
   * <p>Getter for unitOfMeasure.</p>
   * @return EUnitOfMeasure
   **/
  public final EUnitOfMeasure getUnitOfMeasure() {
    return this.unitOfMeasure;
  }

  /**
   * <p>Setter for unitOfMeasure.</p>
   * @param pUnitOfMeasure reference
   **/
  public final void setUnitOfMeasure(final EUnitOfMeasure pUnitOfMeasure) {
    this.unitOfMeasure = pUnitOfMeasure;
  }

  /**
   * <p>Getter for fonts.</p>
   * @return List<IFont>
   **/
  public final List<IFont> getFonts() {
    return this.fonts;
  }

  /**
   * <p>Setter for fonts.</p>
   * @param pFonts reference
   **/
  public final void setFonts(final List<IFont> pFonts) {
    this.fonts = pFonts;
  }
}
