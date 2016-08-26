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

  private Integer total;

  private Link first;

  private Link previous;

  private Link self;

  private Link next;

  private Link last;

  /**
   * @return the total
   */
  public Integer getTotal() {
    return total;
  }

  /**
   * @param total the total to set
   */
  public void setTotal(Integer total) {
    this.total = total;
  }

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
  public Link getPrevious() {
    return previous;
  }

  /**
   * @param previous the previous to set
   */
  public void setPrevious(Link previous) {
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
  public Link getNext() {
    return next;
  }

  /**
   * @param next the next to set
   */
  public void setNext(Link next) {
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
