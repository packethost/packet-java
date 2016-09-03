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
 * Enumeration of Traffic Bucket classifications (internal &amp; external).
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public enum TrafficBucket {

  @SerializedName("internal") 
  INTERNAL("internal"),

  @SerializedName("external") 
  EXTERNAL("external");

  private String value;

  private TrafficBucket(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.value;
  }

  public static TrafficBucket fromValue(String value) {
    if (StringUtils.isBlank(value)) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }

    for (TrafficBucket tb : TrafficBucket.values()) {
      if (value.equalsIgnoreCase(tb.value)) {
        return tb;
      }
    }

    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}
