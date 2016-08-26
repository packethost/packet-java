/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import net.packet.Constants;
import net.packet.Endpoint;
import net.packet.Packet;
import net.packet.Request;
import net.packet.Response;
import net.packet.exception.HttpErrorException;
import net.packet.exception.PacketException;
import net.packet.http.HttpHeader;
import net.packet.http.methods.HttpDelete;
import net.packet.pojo.Error;
import net.packet.pojo.Facilities;
import net.packet.pojo.OperatingSystems;
import net.packet.pojo.Plans;
import net.packet.pojo.Project;
import net.packet.pojo.Projects;
import net.packet.serializer.ProjectSerializer;

/**
 * Packet API client implementation.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public final class PacketClient implements Packet, Constants {

  private static final Logger log = LoggerFactory.getLogger(PacketClient.class);

  /**
   * Packet API version
   */
  private String version;

  /**
   * Packet <code>X-Auth-Token</code> value you get from
   * <code>https://app.packet.net/portal#/api-keys</code>
   */
  private String authToken;

  /**
   * Gson instance for deserialize
   */
  private Gson deserializer;

  /**
   * Gson instance for serialize
   */
  private Gson serializer;

  /**
   * Packet API common headers
   */
  private Header[] commonHeaders;

  /**
   * Content-Type header JSON
   */
  private Header contentTypeHeader;

  /**
   * Apache httpcomponents Http client, v4.5.2
   */
  private CloseableHttpClient httpClient;

  public PacketClient(String authToken, String version) {
    this(authToken, version, null);
  }

  public PacketClient(String authToken, String version, CloseableHttpClient httpClient) {
    if (!"1".equalsIgnoreCase(version)) {
      throw new IllegalArgumentException("Incorrect Packet API version number");
    }

    this.authToken = authToken;
    this.version = version;
    this.httpClient = httpClient;

    // call our init
    init();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Facility methods
  // ___________________________________

  @Override
  public Facilities getFacilites(Integer pageNo, Integer perPage) throws PacketException {
    checkNullAndThrowError(pageNo, "Page no is required");

    Request request = new Request(Endpoint.FACILITIES)
        .page(pageNo)
        .perPage(perPage);

    return (Facilities) executeRequest(request).getData();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Operating systems methods
  // ___________________________________

  @Override
  public OperatingSystems getOperatingSystems(Integer pageNo, Integer perPage)
      throws PacketException {
    checkNullAndThrowError(pageNo, "Page no is required");

    Request request = new Request(Endpoint.OPERATING_SYSTEMS)
        .page(pageNo)
        .perPage(perPage);

    return (OperatingSystems) executeRequest(request).getData();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Plans methods
  // ___________________________________

  @Override
  public Plans getPlans(Integer pageNo, Integer perPage) throws PacketException {
    checkNullAndThrowError(pageNo, "Page no is required");

    Request request = new Request(Endpoint.PLANS)
        .page(pageNo)
        .perPage(perPage);

    return (Plans) executeRequest(request).getData();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Projects methods
  // ___________________________________

  @Override
  public Projects getProjects(Integer pageNo, Integer perPage)
      throws PacketException, HttpErrorException {
    checkNullAndThrowError(pageNo, "Page no is required");

    Request request = new Request(Endpoint.PROJECTS)
        .page(pageNo)
        .perPage(perPage);

    return (Projects) executeRequest(request).getData();
  }

  @Override
  public Project getProject(String projectId) throws PacketException {
    checkEmptyAndThrowError(projectId, "projectId is required");

    Request request = new Request(Endpoint.GET_PROJECT)
        .addPathParmas(new Object[] {projectId});

    return (Project) executeRequest(request).getData();
  }

  @Override
  public Project createProject(Project project) throws PacketException {
    if (null == project || StringUtils.isBlank(project.getName())) {
      throw new IllegalArgumentException("Missing required parameters [Name] for create project.");
    }

    Request request = new Request(Endpoint.CREATE_PROJECT).body(project);

    return (Project) executeRequest(request).getData();
  }

  @Override
  public Project updateProject(Project project) throws PacketException {
    if (null == project
        || StringUtils.isBlank(project.getId())
        || StringUtils.isBlank(project.getName())) {
      throw new IllegalArgumentException(
          "Missing required parameters [Id, Name] for update project.");
    }

    Request request = new Request(Endpoint.UPDATE_PROJECT)
        .addPathParmas(new Object[] {project.getId()})
        .body(project);

    return (Project) executeRequest(request).getData();
  }

  @Override
  public Boolean deleteProject(String projectId) throws PacketException {
    checkEmptyAndThrowError(projectId, "projectId is required");

    Request request = new Request(Endpoint.DELET_PROJECT)
        .addPathParmas(new Object[] {projectId});

    return executeRequest(request).isRequestSuccess();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Private methods
  // ___________________________________

  private void checkNullAndThrowError(Integer integer, String errorMsg) {
    if (null == integer) {
      log.error(errorMsg);
      throw new IllegalArgumentException(errorMsg);
    }
  }

  private void checkEmptyAndThrowError(String str, String errorMsg) {
    if (StringUtils.isBlank(str)) {
      log.error(errorMsg);
      throw new IllegalArgumentException(errorMsg);
    }
  }

  private Response executeRequest(Request req) throws PacketException {
    Response response = null;
    CloseableHttpResponse httpResponse = null;

    try {
      httpResponse = httpClient.execute(createHttpRequest(req));
      log.debug("HTTP Response Object: {}", httpResponse);

      String responseString = parseHttpResponse(httpResponse);
      log.debug("Response Body: {}", responseString);

      if (StringUtils.isBlank(responseString)) {
        response = new Response(req.getEndpoint(), null, true);
      } else {
        Object data = deserializer.fromJson(responseString, req.getClazz());
        response = new Response(req.getEndpoint(), data, true);
      }

      log.debug("Packet Response: {}", response);
    } catch (IOException e) {
      throw new HttpErrorException(e.getMessage(), e);
    } finally {
      try {
        if (null != httpResponse) {
          httpResponse.close();
        }
      } catch (IOException ignore) {
        // Ignoring close exception, really no impact
      }
    }

    return response;
  }

  private HttpUriRequest createHttpRequest(Request req) {
    try {
      switch (req.getMethod()) {
        case GET:
          HttpGet httpGet = new HttpGet(req.buildUri());
          httpGet.setHeaders(commonHeaders);
          return httpGet;
        case POST:
          HttpPost httpPost = new HttpPost(req.buildUri());
          httpPost.setHeaders(commonHeaders);

          if (req.isBodyExists()) {
            httpPost.addHeader(contentTypeHeader);
            httpPost.setEntity(createHttpEntity(req));
          }

          return httpPost;
        case PUT:
          break;
        case PATCH:
          HttpPatch httpPatch = new HttpPatch(req.buildUri());
          httpPatch.setHeaders(commonHeaders);

          if (req.isBodyExists()) {
            httpPatch.addHeader(contentTypeHeader);
            httpPatch.setEntity(createHttpEntity(req));
          }

          return httpPatch;
        case DELETE:
          HttpDelete httpDelete = new HttpDelete(req.buildUri());
          httpDelete.setHeaders(commonHeaders);

          if (req.isBodyExists()) {
            httpDelete.addHeader(contentTypeHeader);
            httpDelete.setEntity(createHttpEntity(req));
          }

          return httpDelete;
      }
    } catch (URISyntaxException ue) {
      throw new HttpErrorException(ue);
    }

    return null;
  }

  private HttpEntity createHttpEntity(Request req) {
    StringEntity data = null;

    if (req.isBodyExists()) {
      String inputData = serializer.toJson(req.getBody());

      try {
        data = new StringEntity(inputData);
      } catch (UnsupportedEncodingException e) {
        log.error(e.getMessage(), e);
      }
    }

    return data;
  }

  private String httpResponseToString(HttpResponse httpResponse) {
    String response = StringUtils.EMPTY;

    if (null != httpResponse.getEntity()) {
      try {
        response = EntityUtils.toString(httpResponse.getEntity(), UTF_8);
      } catch (ParseException | IOException e) {
        log.error(e.getMessage(), e);
        throw new HttpErrorException("Unable to read http response", e);
      }
    }

    return response;
  }

  private String parseHttpResponse(CloseableHttpResponse httpResponse) throws PacketException {
    String responseString = StringUtils.EMPTY;

    int statusCode = httpResponse.getStatusLine().getStatusCode();
    if (HttpStatus.SC_OK == statusCode
        || HttpStatus.SC_CREATED == statusCode
        || HttpStatus.SC_ACCEPTED == statusCode) {
      responseString = httpResponseToString(httpResponse);
    } else if (HttpStatus.SC_NO_CONTENT == statusCode) {
      log.info("here no content");
    }

    if (statusCode >= 400 && statusCode < 510) {
      responseString = httpResponseToString(httpResponse);
      String errorMsg = StringUtils.EMPTY;
      try {
        Error error = deserializer.fromJson(responseString, Error.class);
        errorMsg = error.getAllErrors();
      } catch (JsonSyntaxException e) {
        errorMsg = "Packet server are on maintenance. Wait for official messages from Packet";
      }
      log.debug(String.format("\nHTTP Status Code: %s\nError Message: %s", statusCode, errorMsg));
      throw new PacketException(errorMsg, null, statusCode);
    }

    return responseString;
  }

  private void init() {
    this.serializer = new GsonBuilder()
        .setDateFormat(DATE_FORMAT)
        .registerTypeAdapter(Project.class, new ProjectSerializer())
        .excludeFieldsWithoutExposeAnnotation()
        .create();

    this.deserializer = new GsonBuilder()
        .setDateFormat(DATE_FORMAT)
        .create();

    this.commonHeaders = new Header[] {
        new BasicHeader(HttpHeader.USER_AGENT, USER_AGENT),
        new BasicHeader(HttpHeader.ACCEPT,
            String.format("%s; version=%s", MEDIA_TYPE_JSON, version)),
        new BasicHeader(HttpHeader.AUTHORIZATION, authToken)
    };

    this.contentTypeHeader = new BasicHeader(HttpHeader.CONTENT_TYPE, MEDIA_TYPE_JSON);

    if (null == this.httpClient) {
      this.httpClient = HttpClients.createDefault();
    }

    log.info("Packet API client have been initialized [version: {}, host: {}]", version, HOSTNAME);
  }

}
