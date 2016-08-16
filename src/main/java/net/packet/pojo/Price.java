/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.math.BigDecimal;

/**
 * Packet price details of hourly and daily
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Price extends AbstractBase {

  private BigDecimal hourly;

  /**
   * @return the hourly
   */
  public BigDecimal getHourly() {
    return hourly;
  }

  /**
   * @param hourly the hourly to set
   */
  public void setHourly(BigDecimal hourly) {
    this.hourly = hourly;
  }

}


