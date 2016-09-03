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
 * Metric Interval used to get traffic metric into groups.
 * 
 * <p>
 * The interval parameter groups results into sub-timeframes spanning a specified length of time.
 * </p>
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public enum MetricInterval {

  @SerializedName("minute") 
  MINUTE("minute"),

  @SerializedName("hour") 
  HOUR("hour"),

  @SerializedName("day") 
  DAY("day"),

  @SerializedName("week") 
  WEEK("week"),
  
  @SerializedName("month") 
  MONTH("month"),
  
  @SerializedName("year") 
  YEAR("year"),
  
  @SerializedName("hour_of_day") 
  HOUR_OF_DAY("hour_of_day"),
  
  @SerializedName("day_of_week") 
  DAY_OF_WEEK("day_of_week"),
  
  @SerializedName("day_of_month") 
  DAY_OF_MONTH("day_of_month"),
  
  @SerializedName("month_of_year") 
  MONTH_OF_YEAR("month_of_year");

  private String value;

  private MetricInterval(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return this.value;
  }

  public static MetricInterval fromValue(String value) {
    if (StringUtils.isBlank(value)) {
      throw new IllegalArgumentException("Value cannot be null or empty!");
    }

    for (MetricInterval mi : MetricInterval.values()) {
      if (value.equalsIgnoreCase(mi.value)) {
        return mi;
      }
    }

    throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
  }
}
