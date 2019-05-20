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

/**
 * <p>Document atomic string model.</p>
 *
 * @param <WI> writing instrument type
 * @author Yury Demidenko
 */
public class DocString<WI> extends AElement<DocString<WI>, WI> {

  /**
   * <p>Font number from #1.</p>
   **/
  private int fontNumber;

  /**
   * <p>Font size.</p>
   **/
  private double fontSize;

  /**
   * <p>Value.</p>
   **/
  private String value;

  /**
   * <p>Getter for Index group for ordering.</p>
   * @return Index Group
   **/
  @Override
  public final int getIndexGroup() {
    return 1;
  }

  //Simple getters and setters:
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
   * @return int
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
   * <p>Getter for value.</p>
   * @return String
   **/
  public final String getValue() {
    return this.value;
  }

  /**
   * <p>Setter for value.</p>
   * @param pValue reference
   **/
  public final void setValue(final String pValue) {
    this.value = pValue;
  }
}
