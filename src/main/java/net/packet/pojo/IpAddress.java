/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import net.packet.IpFamily;

/**
 * Describes packet IP address, family and private or public network
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class IpAddress extends AbstractBase {

  private String id;

  private String address;

  private String network;

  private String gateway;

  @SerializedName("address_family")
  private IpFamily family;

  private String netmask;

  @SerializedName("public")
  private boolean availablePublic;

  private int cidr;

  private Boolean management;

  private Boolean manageable;

  @SerializedName("assigned_to")
  private Link assignedTo;

  private List<Link> assignments;

  private String href;

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
   * @return the network
   */
  public String getNetwork() {
    return network;
  }

  /**
   * @param network the network to set
   */
  public void setNetwork(String network) {
    this.network = network;
  }

  /**
   * @return the gateway
   */
  public String getGateway() {
    return gateway;
  }

  /**
   * @param gateway the gateway to set
   */
  public void setGateway(String gateway) {
    this.gateway = gateway;
  }

  /**
   * @return the family
   */
  public IpFamily getFamily() {
    return family;
  }

  /**
   * @param family the family to set
   */
  public void setFamily(IpFamily family) {
    this.family = family;
  }

  /**
   * @return the netmask
   */
  public String getNetmask() {
    return netmask;
  }

  /**
   * @param netmask the netmask to set
   */
  public void setNetmask(String netmask) {
    this.netmask = netmask;
  }

  /**
   * @return the public
   */
  public boolean isPublic() {
    return availablePublic;
  }

  /**
   * @param isPublic the isPublic to set
   */
  public void setPublic(boolean isPublic) {
    this.availablePublic = isPublic;
  }

  /**
   * @return the cidr
   */
  public int getCidr() {
    return cidr;
  }

  /**
   * @param cidr the cidr to set
   */
  public void setCidr(int cidr) {
    this.cidr = cidr;
  }

  /**
   * @return the management
   */
  public Boolean isManagement() {
    return management;
  }

  /**
   * @param management the management to set
   */
  public void setManagement(Boolean management) {
    this.management = management;
  }

  /**
   * @return the manageable
   */
  public Boolean isManageable() {
    return manageable;
  }

  /**
   * @param manageable the manageable to set
   */
  public void setManageable(Boolean manageable) {
    this.manageable = manageable;
  }

  /**
   * @return the assignedTo
   */
  public Link getAssignedTo() {
    return assignedTo;
  }

  /**
   * @param assignedTo the assignedTo to set
   */
  public void setAssignedTo(Link assignedTo) {
    this.assignedTo = assignedTo;
  }

  /**
   * @return the assignments
   */
  public List<Link> getAssignments() {
    return assignments;
  }

  /**
   * @param assignments the assignments to set
   */
  public void setAssignments(List<Link> assignments) {
    this.assignments = assignments;
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
