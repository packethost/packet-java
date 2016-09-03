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
 * Enumeration of Packet billing cycles.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public enum BillingCycle {

  @SerializedName("hourly") 
  HOURLY("hourly"),

  @SerializedName("daily") 
  DAILY("daily");

  private String value;

  private BillingCycle(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.value;
  }

  public static BillingCycle fromValue(String value) {
    if (StringUtils.isBlank(value)) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }

    for (BillingCycle bc : BillingCycle.values()) {
      if (value.equalsIgnoreCase(bc.value)) {
        return bc;
      }
    }

    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}
