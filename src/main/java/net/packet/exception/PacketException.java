/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.exception;

/**
 * Exception will be thrown, while API request had an interruption.
 * 
 * <p>
 * <code>HTTP Status &gt;= 400 &amp;&amp; &lt; 510</code>
 * </p>
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class PacketException extends Exception {

  private static final long serialVersionUID = -5954029883576953193L;

  private String id;

  private int httpStatusCode;

  public PacketException(String msg) {
    super(msg);
  }

  public PacketException(String msg, Throwable t) {
    super(msg, t);
  }

  public PacketException(String msg, String id, int statusCode) {
    super(msg);
    this.id = id;
    this.httpStatusCode = statusCode;
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @return the httpStatusCode
   */
  public int getHttpStatusCode() {
    return httpStatusCode;
  }
}
