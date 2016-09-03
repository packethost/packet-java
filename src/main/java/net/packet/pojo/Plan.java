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
 * Packet service plan details.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Plan extends AbstractBase {

  private String id;

  private String slug;

  private String name;

  private String description;

  private Price pricing;

  private String line;

  private Spec specs;

  @SerializedName("available_in")
  private List<Link> availableIn;

  /**
   * Constructor
   */
  public Plan() {
    // Default Constructor
  }

  /**
   * Constructor
   * 
   * @param slug name of the slug
   */
  public Plan(String slug) {
    this.slug = slug;
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
   * @return the pricing
   */
  public Price getPricing() {
    return pricing;
  }

  /**
   * @param pricing the pricing to set
   */
  public void setPricing(Price pricing) {
    this.pricing = pricing;
  }

  /**
   * @return the line
   */
  public String getLine() {
    return line;
  }

  /**
   * @param line the line to set
   */
  public void setLine(String line) {
    this.line = line;
  }

  /**
   * @return the specs
   */
  public Spec getSpecs() {
    return specs;
  }

  /**
   * @param specs the specs to set
   */
  public void setSpecs(Spec specs) {
    this.specs = specs;
  }

}
