/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet;


import org.apache.commons.lang3.StringUtils;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of Packet Resource Status.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public enum State {

  @SerializedName("active")
  ACTIVE("active"),
  
  @SerializedName("inactive")
  INACTIVE("inactive"),
  
  @SerializedName("queued")
  QUEUED("queued"),
  
  @SerializedName("provisioning")
  PROVISIONING("provisioning");

  private String value;

  private State(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.value;
  }

  public static State fromValue(String value) {
    if (StringUtils.isBlank(value)) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }

    for (State s : State.values()) {
      if (value.equalsIgnoreCase(s.value)) {
        return s;
      }
    }

    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}
