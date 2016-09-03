/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

/**
 * Represents collection of Notifications.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Notifications extends AbstractBase {

  private List<Notification> notifications;

  private Meta meta;

  /**
   * @return the notifications
   */
  public List<Notification> getNotifications() {
    return notifications;
  }

  /**
   * @param notifications the notifications to set
   */
  public void setNotifications(List<Notification> notifications) {
    this.notifications = notifications;
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
