/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.packet.BillingCycle;
import net.packet.State;

/**
 * Devices are the heart of the Equinix Metal ecosystem. It represents the cloud system.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Device extends AbstractBase {

  private String id;

  @SerializedName("short_id")
  private String shortId;

  @SerializedName("billing_cycle")
  private BillingCycle billingCycle;

  private String hostname;

  private String description;

  private State state;

  private String user;

  private String iqn;

  private Boolean locked;

  @SerializedName("bonding_mode")
  private Integer bondingMode;

  private String userdata;

  private List<String> tags;

  @SerializedName("operating_system")
  private OperatingSystem operatingSystem;

  private Facility facility;

  @SerializedName("ip_addresses")
  private List<IpAddress> ipAddress;

  private Plan plan;

  private Link project;

  @SerializedName("project_lite")
  private Link projectLite;

  // TODO volumes

  @SerializedName("created_at")
  private Date createdAt;

  @SerializedName("updated_at")
  private Date updatedAt;

  private String href;

  @Expose(serialize = true, deserialize = false)
  private Map<String, String> features;

  @SerializedName("provisioning_percentage")
  private double provisioningPercentage;

  @SerializedName("root_password")
  private String rootPassword;

  // TODO provisioning events

  /**
   * Constructor
   */
  public Device() {
    // Default Constructor
  }

  /**
   * Constructor for initializing mandatory fields for create device
   * 
   * @param hostname name of the host
   * @param plan is service plan
   * @param billingCycle billing mode
   * @param operatingSystem image slug
   * @param facility is data center code
   */
  public Device(String hostname, Plan plan, BillingCycle billingCycle,
      OperatingSystem operatingSystem, Facility facility) {
    this.hostname = hostname;
    this.plan = plan;
    this.billingCycle = billingCycle;
    this.operatingSystem = operatingSystem;
    this.facility = facility;
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
   * @return the shortId
   */
  public String getShortId() {
    return shortId;
  }

  /**
   * @param shortId the shortId to set
   */
  public void setShortId(String shortId) {
    this.shortId = shortId;
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
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
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
   * @return the user
   */
  public String getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(String user) {
    this.user = user;
  }

  /**
   * @return the iqn
   */
  public String getIqn() {
    return iqn;
  }

  /**
   * @param iqn the iqn to set
   */
  public void setIqn(String iqn) {
    this.iqn = iqn;
  }

  /**
   * @return the locked
   */
  public Boolean isLocked() {
    return locked;
  }

  /**
   * @param locked the locked to set
   */
  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  /**
   * @return the bondingMode
   */
  public Integer getBondingMode() {
    return bondingMode;
  }

  /**
   * @param bondingMode the bondingMode to set
   */
  public void setBondingMode(Integer bondingMode) {
    this.bondingMode = bondingMode;
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
   * @return the operatingSystem
   */
  public OperatingSystem getOperatingSystem() {
    return operatingSystem;
  }

  /**
   * @param operatingSystem the operatingSystem to set
   */
  public void setOperatingSystem(OperatingSystem operatingSystem) {
    this.operatingSystem = operatingSystem;
  }

  /**
   * @return the facility
   */
  public Facility getFacility() {
    return facility;
  }

  /**
   * @param facility the facility to set
   */
  public void setFacility(Facility facility) {
    this.facility = facility;
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
   * @return the plan
   */
  public Plan getPlan() {
    return plan;
  }

  /**
   * @param plan the plan to set
   */
  public void setPlan(Plan plan) {
    this.plan = plan;
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
   * @return the projectLite
   */
  public Link getProjectLite() {
    return projectLite;
  }

  /**
   * @param projectLite the projectLite to set
   */
  public void setProjectLite(Link projectLite) {
    this.projectLite = projectLite;
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

  /**
   * @return the features
   */
  public Map<String, String> getFeatures() {
    return features;
  }

  /**
   * @param features the features to set
   */
  public void setFeatures(Map<String, String> features) {
    this.features = features;
  }

  /**
   * @return the provisioningPercentage
   */
  public double getProvisioningPercentage() {
    return provisioningPercentage;
  }

  /**
   * @param provisioningPercentage the provisioningPercentage to set
   */
  public void setProvisioningPercentage(double provisioningPercentage) {
    this.provisioningPercentage = provisioningPercentage;
  }

  /**
   * Equinix Metal provides root password for each server you provision for 24 hours. After 24 hours it
   * will be permanently deleted on packet end, you will not be able to retrieve it.
   * 
   * @return the rootPassword
   */
  public String getRootPassword() {
    return rootPassword;
  }

  /**
   * @param rootPassword the rootPassword to set
   */
  public void setRootPassword(String rootPassword) {
    this.rootPassword = rootPassword;
  }

}
