/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

/**
 * Meta is used for pagination details.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Meta extends AbstractBase {

  private Link first;

  private String previous;

  private Link self;

  private String next;

  private Link last;

  /**
   * @return the first
   */
  public Link getFirst() {
    return first;
  }

  /**
   * @param first the first to set
   */
  public void setFirst(Link first) {
    this.first = first;
  }

  /**
   * @return the previous
   */
  public String getPrevious() {
    return previous;
  }

  /**
   * @param previous the previous to set
   */
  public void setPrevious(String previous) {
    this.previous = previous;
  }

  /**
   * @return the self
   */
  public Link getSelf() {
    return self;
  }

  /**
   * @param self the self to set
   */
  public void setSelf(Link self) {
    this.self = self;
  }

  /**
   * @return the next
   */
  public String getNext() {
    return next;
  }

  /**
   * @param next the next to set
   */
  public void setNext(String next) {
    this.next = next;
  }

  /**
   * @return the last
   */
  public Link getLast() {
    return last;
  }

  /**
   * @param last the last to set
   */
  public void setLast(Link last) {
    this.last = last;
  }

}


