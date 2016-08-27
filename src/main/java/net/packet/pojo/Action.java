/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import com.google.gson.annotations.Expose;

import net.packet.ActionType;

/**
 * Device actions type usage
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Action extends AbstractBase {

  @Expose
  private ActionType type;

  /**
   * Constructor
   */
  public Action() {
    // Default Constructor
  }

  /**
   * Constructor
   * 
   * @param type device actions
   */
  public Action(ActionType type) {
    this.type = type;
  }

  /**
   * @return the type
   */
  public ActionType getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(ActionType type) {
    this.type = type;
  }

}
