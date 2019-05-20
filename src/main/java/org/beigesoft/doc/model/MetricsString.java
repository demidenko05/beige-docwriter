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

package org.beigesoft.doc.model;

import java.util.List;
import java.util.ArrayList;

/**
 * <p>String with metrics and multistring data model.</p>
 *
 * @author Yury Demidenko
 */
public class MetricsString {

  /**
   * <p>Width.</p>
   **/
  private double width;

  /**
   * <p>Height.</p>
   **/
  private double height;

  /**
   * <p>Strings.</p>
   **/
  private List<String> strings = new ArrayList<String>();

  /**
   * <p>Strings widths.</p>
   **/
  private List<Double> widths = new ArrayList<Double>();

  //Simple getters and setters:
  /**
   * <p>Getter for width.</p>
   * @return double
   **/
  public final double getWidth() {
    return this.width;
  }

  /**
   * <p>Setter for width.</p>
   * @param pWidth reference
   **/
  public final void setWidth(final double pWidth) {
    this.width = pWidth;
  }

  /**
   * <p>Getter for height.</p>
   * @return double
   **/
  public final double getHeight() {
    return this.height;
  }

  /**
   * <p>Setter for height.</p>
   * @param pHeight reference
   **/
  public final void setHeight(final double pHeight) {
    this.height = pHeight;
  }

  /**
   * <p>Getter for strings.</p>
   * @return List<String>
   **/
  public final List<String> getStrings() {
    return this.strings;
  }

  /**
   * <p>Setter for strings.</p>
   * @param pStrings reference
   **/
  public final void setStrings(final List<String> pStrings) {
    this.strings = pStrings;
  }

  /**
   * <p>Getter for widths.</p>
   * @return List<Double>
   **/
  public final List<Double> getWidths() {
    return this.widths;
  }

  /**
   * <p>Setter for widths.</p>
   * @param pWidths reference
   **/
  public final void setWidths(final List<Double> pWidths) {
    this.widths = pWidths;
  }
}
