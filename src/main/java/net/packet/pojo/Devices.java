/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

/**
 * Devices is used to get all devices from packet project
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Devices extends AbstractBase {

  private List<Device> devices;

  private Meta meta;

  /**
   * @return the devices
   */
  public List<Device> getDevices() {
    return devices;
  }

  /**
   * @param devices the devices to set
   */
  public void setDevices(List<Device> devices) {
    this.devices = devices;
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
