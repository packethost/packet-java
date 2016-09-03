/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.exception;

/**
 * Exception will be thrown if any REST API request is unsuccessful.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class HttpErrorException extends RuntimeException {

  private static final long serialVersionUID = 8893152661817746747L;

  public HttpErrorException() {
    super();
  }

  public HttpErrorException(String msg) {
    super(msg);
  }

  public HttpErrorException(String msg, Throwable t) {
    super(msg, t);
  }

  public HttpErrorException(Throwable t) {
    super(t);
  }

}
