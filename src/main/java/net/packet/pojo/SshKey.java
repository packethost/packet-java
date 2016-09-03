/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Represents Packet SSH Key values.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class SshKey extends AbstractBase {

  private String id;

  @Expose
  private String label;

  @Expose
  private String key;

  private String fingerprint;

  @SerializedName("created_at")
  private Date createdAt;

  @SerializedName("updated_at")
  private Date updatedAt;

  private String href;

  private Link user;

  /**
   * Constructor
   */
  public SshKey() {
    // Default Constructor
  }

  /**
   * Constructor
   * 
   * @param label SSH key label
   * @param key SSH public key
   */
  public SshKey(String label, String key) {
    this(null, label, key);
  }

  /**
   * Constructor
   * 
   * @param id SSH Key Id
   * @param label SSH key label
   * @param key SSH public key
   */
  public SshKey(String id, String label, String key) {
    this.id = id;
    this.label = label;
    this.key = key;
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
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * @param label the label to set
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * @return the key
   */
  public String getKey() {
    return key;
  }

  /**
   * @param key the key to set
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * @return the fingerprint
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * @param fingerprint the fingerprint to set
   */
  public void setFingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
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

}
