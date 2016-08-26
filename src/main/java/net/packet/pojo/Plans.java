/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

/**
 * Plan is used to get all Service plan details
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Plans extends AbstractBase {

  private List<Plan> plans;

  private Meta meta;

  /**
   * @return the plans
   */
  public List<Plan> getPlans() {
    return plans;
  }

  /**
   * @param plans the plans to set
   */
  public void setPlans(List<Plan> plans) {
    this.plans = plans;
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
