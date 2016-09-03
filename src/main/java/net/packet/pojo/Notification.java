/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.Date;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Represents Notification details from Packet.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Notification extends AbstractBase {

  private String id;

  private String type;

  private String body;

  private String severity;

  @Expose
  private Boolean read;

  private Map<String, String> context;

  private Link user;

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
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the body
   */
  public String getBody() {
    return body;
  }

  /**
   * @param body the body to set
   */
  public void setBody(String body) {
    this.body = body;
  }

  /**
   * @return the severity
   */
  public String getSeverity() {
    return severity;
  }

  /**
   * @param severity the severity to set
   */
  public void setSeverity(String severity) {
    this.severity = severity;
  }

  /**
   * @return the read
   */
  public Boolean isRead() {
    return read;
  }

  /**
   * @param read the read to set
   */
  public void setRead(Boolean read) {
    this.read = read;
  }

  /**
   * @return the context
   */
  public Map<String, String> getContext() {
    return context;
  }

  /**
   * @param context the context to set
   */
  public void setContext(Map<String, String> context) {
    this.context = context;
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
