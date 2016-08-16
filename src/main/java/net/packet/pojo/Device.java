/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.lang.Thread.State;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import net.packet.BillingCycle;

/**
 * Devices are the heart of the Packet ecosystem. It represents the cloud system.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Device extends AbstractBase {

  private String id;

  private Link plan;

  @SerializedName("billing_cycle")
  private BillingCycle billingCycle;

  private String hostname;

  private State state;

  private boolean locked;

  private String userdata;

  private List<String> tags;

  @SerializedName("operating_system")
  private OperatingSystem OS;

  @SerializedName("ip_addresses")
  private List<IpAddress> ipAddress;

  private Link project;

  @SerializedName("created_at")
  private Date createdAt;

  @SerializedName("updated_at")
  private Date updatedAt;

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
   * @return the plan
   */
  public Link getPlan() {
    return plan;
  }

  /**
   * @param plan the plan to set
   */
  public void setPlan(Link plan) {
    this.plan = plan;
  }

  /**
   * @return the billingCycle
   */
  public BillingCycle getBillingCycle() {
    return billingCycle;
  }

  /**
   * @param billingCycle the billingCycle to set
   */
  public void setBillingCycle(BillingCycle billingCycle) {
    this.billingCycle = billingCycle;
  }

  /**
   * @return the hostname
   */
  public String getHostname() {
    return hostname;
  }

  /**
   * @param hostname the hostname to set
   */
  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  /**
   * @return the state
   */
  public State getState() {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState(State state) {
    this.state = state;
  }

  /**
   * @return the locked
   */
  public boolean isLocked() {
    return locked;
  }

  /**
   * @param locked the locked to set
   */
  public void setLocked(boolean locked) {
    this.locked = locked;
  }

  /**
   * @return the userdata
   */
  public String getUserdata() {
    return userdata;
  }

  /**
   * @param userdata the userdata to set
   */
  public void setUserdata(String userdata) {
    this.userdata = userdata;
  }

  /**
   * @return the tags
   */
  public List<String> getTags() {
    return tags;
  }

  /**
   * @param tags the tags to set
   */
  public void setTags(List<String> tags) {
    this.tags = tags;
  }

  /**
   * @return the oS
   */
  public OperatingSystem getOS() {
    return OS;
  }

  /**
   * @param oS the oS to set
   */
  public void setOS(OperatingSystem oS) {
    OS = oS;
  }

  /**
   * @return the ipAddress
   */
  public List<IpAddress> getIpAddress() {
    return ipAddress;
  }

  /**
   * @param ipAddress the ipAddress to set
   */
  public void setIpAddress(List<IpAddress> ipAddress) {
    this.ipAddress = ipAddress;
  }

  /**
   * @return the project
   */
  public Link getProject() {
    return project;
  }

  /**
   * @param project the project to set
   */
  public void setProject(Link project) {
    this.project = project;
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
