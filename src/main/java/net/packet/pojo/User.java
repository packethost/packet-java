/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * User details of Packet.net
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class User extends AbstractBase {

  private String id;

  @SerializedName("short_id")
  private String shortId;

  @Expose
  @SerializedName("first_name")
  private String firstName;

  @Expose
  @SerializedName("last_name")
  private String lastName;

  @Expose
  @SerializedName("full_name")
  private String fullName;

  @Expose
  private String email;

  @SerializedName("avatar_url")
  private String avatarUrl;

  @SerializedName("two_factor_auth")
  private String twofactorAuth;

  @SerializedName("max_projects")
  private Integer maxProjects;

  @SerializedName("credit_amount")
  private BigDecimal creditAmount;

  @Expose
  @SerializedName("phone_number")
  private String phoneNumber;

  @Expose
  private String timezone;

  @SerializedName("created_at")
  private Date createdAt;

  @SerializedName("updated_at")
  private Date updatedAt;

  @SerializedName("verified_at")
  private Date verifiedAt;

  private String href;

  private List<Link> emails;

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
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the fullName
   */
  public String getFullName() {
    return fullName;
  }

  /**
   * @param fullName the fullName to set
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the avatarUrl
   */
  public String getAvatarUrl() {
    return avatarUrl;
  }

  /**
   * @param avatarUrl the avatarUrl to set
   */
  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  /**
   * @return the twofactorAuth
   */
  public String getTwofactorAuth() {
    return twofactorAuth;
  }

  /**
   * @param twofactorAuth the twofactorAuth to set
   */
  public void setTwofactorAuth(String twofactorAuth) {
    this.twofactorAuth = twofactorAuth;
  }

  /**
   * @return the maxProjects
   */
  public Integer getMaxProjects() {
    return maxProjects;
  }

  /**
   * @param maxProjects the maxProjects to set
   */
  public void setMaxProjects(Integer maxProjects) {
    this.maxProjects = maxProjects;
  }

  /**
   * @return the creditAmount
   */
  public BigDecimal getCreditAmount() {
    return creditAmount;
  }

  /**
   * @param creditAmount the creditAmount to set
   */
  public void setCreditAmount(BigDecimal creditAmount) {
    this.creditAmount = creditAmount;
  }

  /**
   * @return the phoneNumber
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @param phoneNumber the phoneNumber to set
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * @return the timezone
   */
  public String getTimezone() {
    return timezone;
  }

  /**
   * @param timezone the timezone to set
   */
  public void setTimezone(String timezone) {
    this.timezone = timezone;
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
   * @return the verifiedAt
   */
  public Date getVerifiedAt() {
    return verifiedAt;
  }

  /**
   * @param verifiedAt the verifiedAt to set
   */
  public void setVerifiedAt(Date verifiedAt) {
    this.verifiedAt = verifiedAt;
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
   * @return the emails
   */
  public List<Link> getEmails() {
    return emails;
  }

  /**
   * @param emails the emails to set
   */
  public void setEmails(List<Link> emails) {
    this.emails = emails;
  }

}
