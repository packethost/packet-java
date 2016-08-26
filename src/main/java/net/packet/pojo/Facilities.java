/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

/**
 * Facilities is used to get all location (aka data center) details
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Facilities extends AbstractBase {

  private List<Facility> facilities;

  private Meta meta;

  /**
   * @return the facilities
   */
  public List<Facility> getFacilities() {
    return facilities;
  }

  /**
   * @param facilities the facilities to set
   */
  public void setFacilities(List<Facility> facilities) {
    this.facilities = facilities;
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
