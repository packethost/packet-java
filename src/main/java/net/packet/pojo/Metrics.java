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
 * Collection of metrics
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Metrics extends AbstractBase {

  @SerializedName(value = "metrics", alternate = {"result"})
  private List<Metric> metrics;

  private Meta meta;

  /**
   * @return the metrics
   */
  public List<Metric> getMetrics() {
    return metrics;
  }

  /**
   * @param metrics the metrics to set
   */
  public void setMetrics(List<Metric> metrics) {
    this.metrics = metrics;
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
