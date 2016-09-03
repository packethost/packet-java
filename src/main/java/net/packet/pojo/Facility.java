/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

/**
 * Packet data center information, where you can provision Packet devices.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Facility extends AbstractBase {

  private String id;

  private String name;

  private String code;

  private String address;

  private List<String> features;

  /**
   * Constructor
   */
  public Facility() {
    // Default Constructor
  }

  /**
   * Constructor
   * 
   * @param code a facility code
   */
  public Facility(String code) {
    this.code = code;
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
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the code
   */
  public String getCode() {
    return code;
  }

  /**
   * @param code the code to set
   */
  public void setCode(String code) {
    this.code = code;
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
   * @return the features
   */
  public List<String> getFeatures() {
    return features;
  }

  /**
   * @param features the features to set
   */
  public void setFeatures(List<String> features) {
    this.features = features;
  }

}
