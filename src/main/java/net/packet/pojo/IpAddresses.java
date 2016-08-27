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
 * IP Addresses is used to get all IP Address belongs to the {@link Project}
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class IpAddresses extends AbstractBase {

  @SerializedName("ip_addresses")
  private List<IpAddress> ipAddresses;

  private Meta meta;

  /**
   * @return the ipAddresses
   */
  public List<IpAddress> getIpAddresses() {
    return ipAddresses;
  }

  /**
   * @param ipAddresses the ipAddresses to set
   */
  public void setIpAddresses(List<IpAddress> ipAddresses) {
    this.ipAddresses = ipAddresses;
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
