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
 * Traffic direction enum inbound & outbound
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public enum TrafficDirection {

  @SerializedName("inbound") 
  INBOUND("inbound"),

  @SerializedName("outbound") 
  OUTBOUND("outbound");

  private String value;

  private TrafficDirection(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.value;
  }

  public static TrafficDirection fromValue(String value) {
    if (StringUtils.isBlank(value)) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }

    for (TrafficDirection td : TrafficDirection.values()) {
      if (value.equalsIgnoreCase(td.value)) {
        return td;
      }
    }

    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}
