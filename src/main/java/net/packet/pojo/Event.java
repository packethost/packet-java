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
 * Represents Events details from Packet
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Event extends AbstractBase {

  private String id;

  private String type;

  private String body;

  private List<Link> relationships;

  private String interpolated;

  @SerializedName("created_at")
  private Date createdAt;

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
   * @return the relationships
   */
  public List<Link> getRelationships() {
    return relationships;
  }

  /**
   * @param relationships the relationships to set
   */
  public void setRelationships(List<Link> relationships) {
    this.relationships = relationships;
  }

  /**
   * @return the interpolated
   */
  public String getInterpolated() {
    return interpolated;
  }

  /**
   * @param interpolated the interpolated to set
   */
  public void setInterpolated(String interpolated) {
    this.interpolated = interpolated;
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
