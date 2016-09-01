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
 * Represents project invitation. In order to add a user to a project, they must first be invited.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Invitation extends AbstractBase {

  private String id;

  @Expose
  private String invitee;

  @Expose
  private String message;

  @Expose
  private List<String> roles;

  @SerializedName("created_at")
  private Date createdAt;

  @SerializedName("updated_at")
  private Date updatedAt;

  @SerializedName("invited_by")
  private Link invitedBy;

  private Link project;

  private String href;

  /**
   * Constructor
   */
  public Invitation() {
    // Default Constructor
  }

  /**
   * Constructor
   * 
   * @param invitee user email address or packet user id
   * @param messgae invitation message
   * @param roles list roles for the user
   */
  public Invitation(String invitee, String messgae, List<String> roles) {
    this.invitee = invitee;
    this.message = messgae;
    this.roles = roles;
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
   * @return the invitee
   */
  public String getInvitee() {
    return invitee;
  }

  /**
   * @param invitee the invitee to set
   */
  public void setInvitee(String invitee) {
    this.invitee = invitee;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
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
   * @return the invitedBy
   */
  public Link getInvitedBy() {
    return invitedBy;
  }

  /**
   * @param invitedBy the invitedBy to set
   */
  public void setInvitedBy(Link invitedBy) {
    this.invitedBy = invitedBy;
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
