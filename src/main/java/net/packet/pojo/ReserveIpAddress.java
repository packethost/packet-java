/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import com.google.gson.annotations.Expose;

/**
 * ReserveIpAddress is used to reserve an IP address from Packet.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class ReserveIpAddress extends AbstractBase {

  @Expose
  private String type;

  @Expose
  private Integer quantity;

  @Expose
  private String comments;

  /**
   * Constructor
   */
  public ReserveIpAddress() {
    // Default Constructor
  }

  /**
   * Constructor
   * 
   * @param type is <code>public_ipv4</code> or <code>global_ipv4</code>
   * @param quantity how many IPv4 you want to request
   * @param comments message for packet team
   */
  public ReserveIpAddress(String type, Integer quantity, String comments) {
    this.type = type;
    this.quantity = quantity;
    this.comments = comments;
  }

  /**
   * One of the following:
   * 
   * <ul>
   * <li>public_ipv4 or global_ipv4</li>
   * </ul>
   * 
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * One of the following:
   * 
   * <ul>
   * <li>public_ipv4 or global_ipv4</li>
   * </ul>
   * 
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Value might be 1, 2, 4, 8, 16, 32, 64, 128, 256
   * 
   * @return the quantity
   */
  public Integer getQuantity() {
    return quantity;
  }

  /**
   * Value might be 1, 2, 4, 8, 16, 32, 64, 128, 256
   * 
   * @param quantity the quantity to set
   */
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  /**
   * Optional one
   * 
   * @return the comments
   */
  public String getComments() {
    return comments;
  }

  /**
   * Optional one
   * 
   * @param comments the comments to set
   */
  public void setComments(String comments) {
    this.comments = comments;
  }

}
