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
 * Enumeration of Packet Device Action types.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public enum ActionType {

  @SerializedName("power_on")
  POWER_ON("power_on"),

  @SerializedName("power_off") 
  POWER_OFF("power_off"),

  @SerializedName("reboot")
  REBOOT("reboot"),

  @SerializedName("rescue")
  RESCUE("rescue");

  private String value;

  private ActionType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.value;
  }

  public static ActionType fromValue(String value) {
    if (StringUtils.isBlank(value)) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }

    for (ActionType at : ActionType.values()) {
      if (value.equalsIgnoreCase(at.value)) {
        return at;
      }
    }

    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}
