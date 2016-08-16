/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * SpecDetail is used in {@link Spec} to represents values of NICs, Drives, Features, CPUs, Memory,
 * etc.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class SpecDetail extends AbstractBase {

  //
  // For nics, drives, cpus, memory
  //
  private String type;

  private int count;

  @SerializedName(value = "size", alternate = {"total"})
  private String size;

  //
  // features
  //
  private boolean txt;

  private boolean raid;

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the count
   */
  public int getCount() {
    return count;
  }

  /**
   * @param count the count to set
   */
  public void setCount(int count) {
    this.count = count;
  }

  /**
   * @return the size
   */
  public String getSize() {
    return size;
  }

  /**
   * @param size the size to set
   */
  public void setSize(String size) {
    this.size = size;
  }

  /**
   * @return the txt
   */
  public boolean isTxt() {
    return txt;
  }

  /**
   * @param txt the txt to set
   */
  public void setTxt(boolean txt) {
    this.txt = txt;
  }

  /**
   * @return the raid
   */
  public boolean isRaid() {
    return raid;
  }

  /**
   * @param raid the raid to set
   */
  public void setRaid(boolean raid) {
    this.raid = raid;
  }

}


