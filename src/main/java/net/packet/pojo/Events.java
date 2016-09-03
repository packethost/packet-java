/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

/**
 * Events represents the collections of event belongs to projects, devices, etc.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Events extends AbstractBase {

  private List<Event> events;

  private Meta meta;

  /**
   * @return the events
   */
  public List<Event> getEvents() {
    return events;
  }

  /**
   * @param events the events to set
   */
  public void setEvents(List<Event> events) {
    this.events = events;
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
