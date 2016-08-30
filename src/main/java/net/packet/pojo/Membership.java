/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Membership for the project
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Membership extends AbstractBase {

  private String id;

  @Expose
  private List<String> roles;

  @Expose
  private Boolean owner;

  private Link project;

  private Link user;

  @SerializedName("created_at")
  private Date createdAt;

  @SerializedName("updated_at")
  private Date updatedAt;

  private String href;

  /**
   * Constructor
   */
  public Membership() {
    // Default Constructor
  }

  /**
   * Constructor
   * 
   * @param id membership id
   * @param roles
   */
  public Membership(String id, List<String> roles) {
    this.id = id;
    this.roles = roles;
  }

  /**
   * Check give roles is present
   * 
   * @param role
   * @return boolean
   */
  public boolean isRole(String role) {
    return roles.contains(role);
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
   * @return the roles
   */
  public List<String> getRoles() {
    return roles;
  }

  /**
   * @param roles the roles to set
   */
  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  /**
   * @return the owner
   */
  public Boolean isOwner() {
    return owner;
  }

  /**
   * @param owner the owner to set
   */
  public void setOwner(Boolean owner) {
    this.owner = owner;
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
   * @return the user
   */
  public Link getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(Link user) {
    this.user = user;
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
