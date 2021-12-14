/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Response holds Equinix Metal REST API response values.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Response {

  private final Endpoint endpoint;

  private final Object data;

  private final Boolean requestSuccess;

  /**
   * Constructor
   * 
   * @param endpoint of response belongs to
   * @param data is response object
   * @param requestSuccess result of the executed API request
   */
  public Response(Endpoint endpoint, Object data, boolean requestSuccess) {
    this.endpoint = endpoint;
    this.data = data;
    this.requestSuccess = requestSuccess;
  }

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

  /**
   * To check response has body or not
   * 
   * @return boolean
   */
  public boolean isDataExists() {
    return (null == data);
  }

  /**
   * @return the endpoint
   */
  public Endpoint getEndpoint() {
    return endpoint;
  }

  /**
   * @return the data
   */
  public Object getData() {
    return data;
  }

  /**
   * @return the requestSuccess
   */
  public Boolean isRequestSuccess() {
    return requestSuccess;
  }

}
