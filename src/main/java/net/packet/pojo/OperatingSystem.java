/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Describes packet device opertaing system details.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class OperatingSystem extends AbstractBase {

  private String slug;

  private String name;

  private String distro;

  private String version;

  @SerializedName("provisionable_on")
  private List<String> provisionableOn;

  /**
   * Constructor
   */
  public OperatingSystem() {
    // Default Constructor
  }

  /**
   * Constructor
   */
  public OperatingSystem(String slug) {
    this.slug = slug;
  }

  /**
   * @return the slug
   */
  public String getSlug() {
    return slug;
  }

  /**
   * @param slug the slug to set
   */
  public void setSlug(String slug) {
    this.slug = slug;
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
   * @return the distro
   */
  public String getDistro() {
    return distro;
  }

  /**
   * @param distro the distro to set
   */
  public void setDistro(String distro) {
    this.distro = distro;
  }

  /**
   * @return the version
   */
  public String getVersion() {
    return version;
  }

  /**
   * @param version the version to set
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * @return the provisionableOn
   */
  public List<String> getProvisionableOn() {
    return provisionableOn;
  }

  /**
   * @param provisionableOn the provisionableOn to set
   */
  public void setProvisionableOn(List<String> provisionableOn) {
    this.provisionableOn = provisionableOn;
  }

}
