/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.utils.URIBuilder;

import net.packet.http.HttpMethod;
import net.packet.http.QueryParam;

/**
 * Request is used to compose Equinix Metal REST API request values.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Request {

  private Endpoint endpoint;

  private Object body;

  private Object[] pathParams;

  private Map<String, String> queryParams;

  private List<String> includes;

  /**
   * Constructor
   */
  public Request() {
    // Default Constructor
  }

  /**
   * Constructor
   * 
   * @param endpoint a info about api request
   */
  public Request(Endpoint endpoint) {
    this(endpoint, null);
  }

  /**
   * Constructor
   * 
   * @param endpoint a info about api request
   * @param pathParams a api request path variable value(s)
   */
  public Request(Endpoint endpoint, Object[] pathParams) {
    this.endpoint = endpoint;
    this.pathParams = pathParams;
  }

  /**
   * Adds URL query parameter into the request
   * 
   * @param key a String
   * @param value a String
   * @return {@link Request}
   */
  public Request queryParam(String key, String value) {
    if (null == queryParams) {
      this.queryParams = new HashMap<>();
    }

    queryParams.put(key, value);

    return this;
  }

  /**
   * Adds page no into the request
   * 
   * @param page a integer
   * @return {@link Request}
   */
  public Request page(Integer page) {
    return queryParam(QueryParam.KEY_PAGE, String.valueOf(page));
  }

  /**
   * Adds per page count into the request
   * 
   * @param perPage a integer
   * @return {@link Request}
   */
  public Request perPage(Integer perPage) {
    if (null == perPage) {
      return this;
    }

    return queryParam(QueryParam.KEY_PER_PAGE, String.valueOf(perPage));
  }

  /**
   * Adds packet API include options
   * 
   * <p>
   * For e.g.: <code>include=emails,projects,memberships</code>
   * </p>
   * 
   * @param include a string
   * @return {@link Request}
   */
  public Request include(String include) {
    if (null == includes) {
      includes = new ArrayList<>();
    }

    includes.add(include);

    return this;
  }

  /**
   * Adds request body
   * 
   * @param body an object
   * @return {@link Request}
   */
  public Request body(Object body) {
    this.body = body;
    return this;
  }

  public Request addPathParmas(Object[] params) {
    this.pathParams = params;
    return this;
  }

  /**
   * Returns to ture if body exists otherwise false
   * 
   * @return boolean
   */
  public boolean isBodyExists() {
    return null != body;
  }

  /**
   * Returns the composed endpoint URI.
   * 
   * @return {@link URI}
   * @throws URISyntaxException when URI is incorrect
   */
  public URI buildUri() throws URISyntaxException {
    URIBuilder ub = new URIBuilder();
    ub.setScheme(Constants.URI_SCHEME);
    ub.setHost(Constants.HOSTNAME);

    String path = (null == pathParams)
        ? endpoint.getPath() : String.format(endpoint.getPath(), pathParams);
    ub.setPath(path);

    if (null != queryParams) {
      for (Map.Entry<String, String> entry : queryParams.entrySet()) {
        ub.setParameter(entry.getKey(), entry.getValue());
      }
    }

    return ub.build();
  }

  /**
   * @return the path
   */
  public String getPath() {
    return endpoint.getPath();
  }

  /**
   * @return the method
   */
  public HttpMethod getMethod() {
    return endpoint.getMethod();
  }

  /**
   * @return the clazz
   */
  public Class<?> getClazz() {
    return endpoint.getClazz();
  }

  /**
   * @return the endpoint
   */
  public Endpoint getEndpoint() {
    return endpoint;
  }

  /**
   * @return the body
   */
  public Object getBody() {
    return body;
  }

  /**
   * @return the pathParams
   */
  public Object[] getPathParams() {
    return pathParams;
  }

  /**
   * @return the queryParams
   */
  public Map<String, String> getQueryParams() {
    return queryParams;
  }

}
