/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * OperatingSystems is used to get all OS details
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class OperatingSystems extends AbstractBase {

  @SerializedName("operating_systems")
  private List<OperatingSystem> operatingSystems;

  private Meta meta;

  /**
   * @return the operatingSystems
   */
  public List<OperatingSystem> getOperatingSystems() {
    return operatingSystems;
  }

  /**
   * @param operatingSystems the operatingSystems to set
   */
  public void setOperatingSystems(List<OperatingSystem> operatingSystems) {
    this.operatingSystems = operatingSystems;
  }

  /**
   * @return the meta
   */
  public Meta getMeta() {
    return meta;
  }

  /**
   * @param meta the meta to set
   */
  public void setMeta(Meta meta) {
    this.meta = meta;
  }

}
