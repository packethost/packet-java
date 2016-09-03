/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of IP family to represent IP V4 and V6 classification.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public enum IpFamily {

  @SerializedName("4") 
  V4(4),

  @SerializedName("6") 
  V6(6);

  private int value;

  private IpFamily(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }

  public static IpFamily fromValue(int value) {
    for (IpFamily ip : IpFamily.values()) {
      if (ip.value == value) {
        return ip;
      }
    }

    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }

}
