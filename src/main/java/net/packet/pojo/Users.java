/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

/**
 * Users represents the collection User information.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Users extends AbstractBase {

  private List<User> users;

  private Meta meta;

  /**
   * @return the users
   */
  public List<User> getUsers() {
    return users;
  }

  /**
   * @param users the users to set
   */
  public void setUsers(List<User> users) {
    this.users = users;
  }

  /**
   * @return the meta
   */
  public Meta getMeta() {
    return meta;
  }

  /**
   * @param meta the meta to set
   */
  public void setMeta(Meta meta) {
    this.meta = meta;
  }

}
