/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Project represents group of Servers, Networks and Storages.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Project extends AbstractBase {

  private String id;

  private String name;

  @SerializedName("created_at")
  private Date createdAt;

  @SerializedName("updated_at")
  private Date updatedAt;

  // TODO max_devices - since data type is unclear

  private List<Link> members;

  private List<Link> memberships;

  // TODO invitations

  @SerializedName("payment_method")
  private Link paymentMethod;

  private List<Link> devices;

  @SerializedName("ssh_keys")
  private List<Link> sshKeys;

  // TODO volumes

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
   * @return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * @param createdAt the createdAt to set
   */
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * @param updatedAt the updatedAt to set
   */
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * @return the members
   */
  public List<Link> getMembers() {
    return members;
  }

  /**
   * @param members the members to set
   */
  public void setMembers(List<Link> members) {
    this.members = members;
  }

  /**
   * @return the memberships
   */
  public List<Link> getMemberships() {
    return memberships;
  }

  /**
   * @param memberships the memberships to set
   */
  public void setMemberships(List<Link> memberships) {
    this.memberships = memberships;
  }

  /**
   * @return the paymentMethod
   */
  public Link getPaymentMethod() {
    return paymentMethod;
  }

  /**
   * @param paymentMethod the paymentMethod to set
   */
  public void setPaymentMethod(Link paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  /**
   * @return the devices
   */
  public List<Link> getDevices() {
    return devices;
  }

  /**
   * @param devices the devices to set
   */
  public void setDevices(List<Link> devices) {
    this.devices = devices;
  }

  /**
   * @return the sshKeys
   */
  public List<Link> getSshKeys() {
    return sshKeys;
  }

  /**
   * @param sshKeys the sshKeys to set
   */
  public void setSshKeys(List<Link> sshKeys) {
    this.sshKeys = sshKeys;
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


