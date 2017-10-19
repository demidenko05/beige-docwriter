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

  /**
   * <p>Current/preferred container margin top.</p>
   **/
  private double containerMarginTop;

  /**
   * <p>Current/preferred container margin bottom.</p>
   **/
  private double containerMarginBottom;

  /**
   * <p>Current/preferred container margin left.</p>
   **/
  private double containerMarginLeft;

  /**
   * <p>Current/preferred container margin right.</p>
   **/
  private double containerMarginRight;

  /**
   * <p>Current/preferred content padding top.</p>
   **/
  private double contentPaddingTop;

  /**
   * <p>Current/preferred content padding bottom.</p>
   **/
  private double contentPaddingBottom;

  /**
   * <p>Current/preferred content padding right.</p>
   **/
  private double contentPaddingRight;

  /**
   * <p>Current/preferred content padding .</p>
   **/
  private double contentPaddingLeft;

  /**
   * <p>Current/preferred border width.</p>
   **/
  private double border;

  /**
   * <p>Current/preferred align Horizontal content.</p>
   **/
  private EAlignHorizontal alignHoriCont = EAlignHorizontal.LEFT;

  /**
   * <p>Current/preferred align Vertical content .</p>
   **/
  private EAlignVertical alignVertCont = EAlignVertical.TOP;

  //Utils:
  /**
   * <p>Setter for all contentPadding.</p>
   * @param pContentPadding reference
   **/
  public final void setContentPadding(final double pContentPadding) {
    this.contentPaddingTop = pContentPadding;
    this.contentPaddingBottom = pContentPadding;
    this.contentPaddingRight = pContentPadding;
    this.contentPaddingLeft = pContentPadding;
  }

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

  /**
   * <p>Getter for containerMarginTop.</p>
   * @return double
   **/
  public final double getContainerMarginTop() {
    return this.containerMarginTop;
  }

  /**
   * <p>Setter for containerMarginTop.</p>
   * @param pContainerMarginTop reference
   **/
  public final void setContainerMarginTop(final double pContainerMarginTop) {
    this.containerMarginTop = pContainerMarginTop;
  }

  /**
   * <p>Getter for containerMarginBottom.</p>
   * @return double
   **/
  public final double getContainerMarginBottom() {
    return this.containerMarginBottom;
  }

  /**
   * <p>Setter for containerMarginBottom.</p>
   * @param pContainerMarginBottom reference
   **/
  public final void setContainerMarginBottom(
    final double pContainerMarginBottom) {
    this.containerMarginBottom = pContainerMarginBottom;
  }

  /**
   * <p>Getter for contentPaddingTop.</p>
   * @return double
   **/
  public final double getContentPaddingTop() {
    return this.contentPaddingTop;
  }

  /**
   * <p>Setter for contentPaddingTop.</p>
   * @param pContentPaddingTop reference
   **/
  public final void setContentPaddingTop(final double pContentPaddingTop) {
    this.contentPaddingTop = pContentPaddingTop;
  }

  /**
   * <p>Getter for contentPaddingBottom.</p>
   * @return double
   **/
  public final double getContentPaddingBottom() {
    return this.contentPaddingBottom;
  }

  /**
   * <p>Setter for contentPaddingBottom.</p>
   * @param pContentPaddingBottom reference
   **/
  public final void setContentPaddingBottom(
    final double pContentPaddingBottom) {
    this.contentPaddingBottom = pContentPaddingBottom;
  }

  /**
   * <p>Getter for contentPaddingRight.</p>
   * @return double
   **/
  public final double getContentPaddingRight() {
    return this.contentPaddingRight;
  }

  /**
   * <p>Setter for contentPaddingRight.</p>
   * @param pContentPaddingRight reference
   **/
  public final void setContentPaddingRight(
    final double pContentPaddingRight) {
    this.contentPaddingRight = pContentPaddingRight;
  }

  /**
   * <p>Getter for contentPaddingLeft.</p>
   * @return double
   **/
  public final double getContentPaddingLeft() {
    return this.contentPaddingLeft;
  }

  /**
   * <p>Setter for contentPaddingLeft.</p>
   * @param pContentPaddingLeft reference
   **/
  public final void setContentPaddingLeft(
    final double pContentPaddingLeft) {
    this.contentPaddingLeft = pContentPaddingLeft;
  }

  /**
   * <p>Getter for containerMarginLeft.</p>
   * @return double
   **/
  public final double getContainerMarginLeft() {
    return this.containerMarginLeft;
  }

  /**
   * <p>Setter for containerMarginLeft.</p>
   * @param pContainerMarginLeft reference
   **/
  public final void setContainerMarginLeft(
    final double pContainerMarginLeft) {
    this.containerMarginLeft = pContainerMarginLeft;
  }

  /**
   * <p>Getter for containerMarginRight.</p>
   * @return double
   **/
  public final double getContainerMarginRight() {
    return this.containerMarginRight;
  }

  /**
   * <p>Setter for containerMarginRight.</p>
   * @param pContainerMarginRight reference
   **/
  public final void setContainerMarginRight(
    final double pContainerMarginRight) {
    this.containerMarginRight = pContainerMarginRight;
  }

  /**
   * <p>Getter for border.</p>
   * @return double
   **/
  public final double getBorder() {
    return this.border;
  }

  /**
   * <p>Setter for border.</p>
   * @param pBorder reference
   **/
  public final void setBorder(final double pBorder) {
    this.border = pBorder;
  }

  /**
   * <p>Getter for alignHoriCont.</p>
   * @return EAlignHorizontal
   **/
  public final EAlignHorizontal getAlignHoriCont() {
    return this.alignHoriCont;
  }

  /**
   * <p>Setter for alignHoriCont.</p>
   * @param pAlignHoriCont reference
   **/
  public final void setAlignHoriCont(final EAlignHorizontal pAlignHoriCont) {
    this.alignHoriCont = pAlignHoriCont;
  }

  /**
   * <p>Getter for alignVertCont.</p>
   * @return EAlignVertical
   **/
  public final EAlignVertical getAlignVertCont() {
    return this.alignVertCont;
  }

  /**
   * <p>Setter for alignVertCont.</p>
   * @param pAlignVertCont reference
   **/
  public final void setAlignVertCont(final EAlignVertical pAlignVertCont) {
    this.alignVertCont = pAlignVertCont;
  }
}
