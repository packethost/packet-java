/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Represents Email details
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Email extends AbstractBase {

  private String id;

  @Expose
  private String address;

  @Expose
  @SerializedName("default")
  private Boolean defaultAddress;

  private String href;

  /**
   * Constructor
   */
  public Email() {
    // Default Constructor
  }

  /**
   * Constructor
   * 
   * @param address user email address
   * @param isDefaultAddress is it a default address
   */
  public Email(String address, Boolean isDefaultAddress) {
    this(null, address, isDefaultAddress);
  }

  /**
   * Constructor
   * 
   * @param id email record id
   * @param address user email address
   * @param isDefaultAddress is it a default address
   */
  public Email(String id, String address, Boolean isDefaultAddress) {
    this.id = id;
    this.address = address;
    this.defaultAddress = isDefaultAddress;
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * @param address the address to set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * @return the defaultAddress
   */
  public Boolean isDefault() {
    return defaultAddress;
  }

  /**
   * @param defaultAddress the defaultAddress to set
   */
  public void setDefault(Boolean defaultAddress) {
    this.defaultAddress = defaultAddress;
  }

  /**
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * @param href the href to set
   */
  public void setHref(String href) {
    this.href = href;
  }

}
