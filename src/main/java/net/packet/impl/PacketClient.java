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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

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

import net.packet.ActionType;
import net.packet.Constants;
import net.packet.Endpoint;
import net.packet.MetricInterval;
import net.packet.Packet;
import net.packet.Request;
import net.packet.Response;
import net.packet.TrafficBucket;
import net.packet.TrafficDirection;
import net.packet.exception.HttpErrorException;
import net.packet.exception.PacketException;
import net.packet.http.HttpHeader;
import net.packet.http.methods.HttpDelete;
import net.packet.pojo.Action;
import net.packet.pojo.Device;
import net.packet.pojo.Devices;
import net.packet.pojo.Email;
import net.packet.pojo.Error;
import net.packet.pojo.Event;
import net.packet.pojo.Events;
import net.packet.pojo.Facilities;
import net.packet.pojo.Invitation;
import net.packet.pojo.IpAddress;
import net.packet.pojo.IpAddresses;
import net.packet.pojo.Membership;
import net.packet.pojo.Metrics;
import net.packet.pojo.Notification;
import net.packet.pojo.Notifications;
import net.packet.pojo.OperatingSystems;
import net.packet.pojo.Plans;
import net.packet.pojo.Project;
import net.packet.pojo.Projects;
import net.packet.pojo.ReserveIpAddress;
import net.packet.pojo.SshKey;
import net.packet.pojo.SshKeys;
import net.packet.pojo.Transfer;
import net.packet.pojo.User;
import net.packet.pojo.Users;
import net.packet.serializer.DeviceSerializer;
import net.packet.serializer.ProjectSerializer;

/**
 * Equinix Metal API client implementation.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public final class PacketClient implements Packet, Constants {

  private static final Logger log = LoggerFactory.getLogger(PacketClient.class);

  /**
   * Equinix Metal API version
   */
  private String version;

  /**
   * Equinix Metal <code>X-Auth-Token</code> value you get from
   * <code>https://console.equinix.com/users/me/api-keys</code>
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
   * Equinix Metal API common headers
   */
  private Header[] commonHeaders;

  /**
   * Content-Type header JSON
   */
  private Header contentTypeHeader;

  /**
   * ISO 8601 date format
   */
  private SimpleDateFormat isoDateFormatter;

  /**
   * Apache httpcomponents Http client, v4.5.2
   */
  private CloseableHttpClient httpClient;

  /**
   * Constructor for creating Equinix Metal API Client Instance.
   * 
   * @param authToken authentication tokens from
   *        <a href="https://console.equinix.com/users/me/api-keys">Equinix Metal Console</a>
   * @param version API version number
   */
  public PacketClient(String authToken, String version) {
    this(authToken, version, null);
  }

  /**
   * Constructor for creating Equinix Metal API Client Instance with HTTP Client.
   * 
   * @param authToken authentication tokens from
   *        <a href="https://console.equinix.com/users/me/api-keys">Equinix Metal Console</a>
   * @param version API version number
   * @param httpClient Apache HTTP Client instance
   */
  public PacketClient(String authToken, String version, CloseableHttpClient httpClient) {
    if (!"1".equalsIgnoreCase(version)) {
      throw new IllegalArgumentException("Incorrect Equinix Metal API version number");
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

    Request request = new Request(Endpoint.DELETE_PROJECT)
        .addPathParmas(new Object[] {projectId});

    return executeRequest(request).isRequestSuccess();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Project Transfer methods
  // ___________________________________

  @Override
  public Transfer transferProject(String projectId, String membershipId) throws PacketException {
    checkEmptyAndThrowError(projectId, "projectId is required");
    checkEmptyAndThrowError(membershipId, "membershipId is required");

    Map<String, String> requestBody = new HashMap<>();
    requestBody.put("membership", membershipId);

    Request request = new Request(Endpoint.TRANSFER)
        .addPathParmas(new Object[] {projectId})
        .body(requestBody);

    return (Transfer) executeRequest(request).getData();
  }

  @Override
  public Transfer getTransferInfo(String transferId) throws PacketException {
    checkEmptyAndThrowError(transferId, "transferId is required");

    Request request = new Request(Endpoint.GET_TRANSFER)
        .addPathParmas(new Object[] {transferId});

    return (Transfer) executeRequest(request).getData();
  }

  @Override
  public Boolean acceptTransfer(String transferId) throws PacketException {
    checkEmptyAndThrowError(transferId, "transferId is required");

    Request request = new Request(Endpoint.ACCEPT_TRANSFER)
        .addPathParmas(new Object[] {transferId});

    return executeRequest(request).isRequestSuccess();
  }

  @Override
  public Boolean declineTransfer(String transferId) throws PacketException {
    checkEmptyAndThrowError(transferId, "transferId is required");

    Request request = new Request(Endpoint.DECLINE_TRANSFER)
        .addPathParmas(new Object[] {transferId});

    return executeRequest(request).isRequestSuccess();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Devices methods
  // ___________________________________

  @Override
  public Devices getDevices(String projectId, Integer pageNo, Integer perPage)
      throws PacketException {
    checkEmptyAndThrowError(projectId, "projectId is required");
    checkNullAndThrowError(pageNo, "Page no is required");

    Request request = new Request(Endpoint.DEVICES)
        .addPathParmas(new Object[] {projectId})
        .page(pageNo)
        .perPage(perPage);

    return (Devices) executeRequest(request).getData();
  }

  @Override
  public Device getDevice(String deviceId) throws PacketException {
    checkEmptyAndThrowError(deviceId, "deviceId is required");

    Request request = new Request(Endpoint.GET_DEVICE)
        .addPathParmas(new Object[] {deviceId});

    return (Device) executeRequest(request).getData();
  }

  @Override
  public Device createDevice(String projectId, Device device) throws PacketException {
    checkEmptyAndThrowError(projectId, "projectId is required");
    if (null == device
        || null == device.getPlan()
        || null == device.getBillingCycle()
        || null == device.getFacility()
        || null == device.getOperatingSystem()
        || StringUtils.isBlank(device.getHostname())
        || StringUtils.isBlank(device.getPlan().getSlug())
        || StringUtils.isBlank(device.getFacility().getCode())
        || StringUtils.isBlank(device.getOperatingSystem().getSlug())) {
      throw new IllegalArgumentException(
          "Missing required parameters [Hostname, Plan, BillingCycle, Facility, OperatingSystem] for create device.");
    }

    Request request = new Request(Endpoint.CREATE_DEVICE)
        .addPathParmas(new Object[] {projectId})
        .body(device);

    return (Device) executeRequest(request).getData();
  }

  @Override
  public Device updateDevice(Device device) throws PacketException {
    if (null == device || StringUtils.isBlank(device.getId())) {
      throw new IllegalArgumentException("Missing required parameters [Id] for update device.");
    }

    Request request = new Request(Endpoint.UPDATE_DEVICE)
        .addPathParmas(new Object[] {device.getId()})
        .body(device);

    return (Device) executeRequest(request).getData();
  }

  @Override
  public Boolean deleteDevice(String deviceId) throws PacketException {
    checkEmptyAndThrowError(deviceId, "deviceId is required");

    Request request = new Request(Endpoint.DELETE_DEVICE)
        .addPathParmas(new Object[] {deviceId});

    return executeRequest(request).isRequestSuccess();
  }

  @Override
  public Boolean powerOnDevice(String deviceId) throws PacketException {
    checkEmptyAndThrowError(deviceId, "deviceId is required");

    Request request = new Request(Endpoint.DEVICE_ACTIONS)
        .addPathParmas(new Object[] {deviceId})
        .body(new Action(ActionType.POWER_ON));

    return executeRequest(request).isRequestSuccess();
  }

  @Override
  public Boolean powerOffDevice(String deviceId) throws PacketException {
    checkEmptyAndThrowError(deviceId, "deviceId is required");

    Request request = new Request(Endpoint.DEVICE_ACTIONS)
        .addPathParmas(new Object[] {deviceId})
        .body(new Action(ActionType.POWER_OFF));

    return executeRequest(request).isRequestSuccess();
  }

  @Override
  public Boolean rebootDevice(String deviceId) throws PacketException {
    checkEmptyAndThrowError(deviceId, "deviceId is required");

    Request request = new Request(Endpoint.DEVICE_ACTIONS)
        .addPathParmas(new Object[] {deviceId})
        .body(new Action(ActionType.REBOOT));

    return executeRequest(request).isRequestSuccess();
  }

  @Override
  public Boolean rescueDevice(String deviceId) throws PacketException {
    checkEmptyAndThrowError(deviceId, "deviceId is required");

    Request request = new Request(Endpoint.DEVICE_ACTIONS)
        .addPathParmas(new Object[] {deviceId})
        .body(new Action(ActionType.RESCUE));

    return executeRequest(request).isRequestSuccess();
  }

  @Override
  public Metrics deviceTraffic(String deviceId, TrafficDirection direction, Date timeframeStart,
      Date timeframeEnd) throws PacketException {
    return deviceTraffic(deviceId, direction, timeframeStart, timeframeEnd, null, null);
  }

  @Override
  public Metrics deviceTraffic(String deviceId, TrafficDirection direction, Date timeframeStart,
      Date timeframeEnd, MetricInterval interval, TrafficBucket bucket) throws PacketException {
    checkEmptyAndThrowError(deviceId, "deviceId is required");
    if (null == direction || null == timeframeStart || null == timeframeEnd) {
      throw new IllegalArgumentException(
          "Missing required parameters [Traffic direction, Timeframe start date, Timeframe end date] for device traffic info.");
    }

    Request request = new Request(Endpoint.DEVICE_TRAFFIC)
        .addPathParmas(new Object[] {deviceId})
        .queryParam("direction", direction.getValue())
        .queryParam("timeframe['started_at']", isoDateFormatter.format(timeframeStart))
        .queryParam("timeframe['ended_at']", isoDateFormatter.format(timeframeEnd));

    if (null != interval) {
      request.queryParam("interval", interval.getValue());
    }

    if (null != bucket) {
      request.queryParam("bucket", bucket.getValue());
    }

    return (Metrics) executeRequest(request).getData();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // IP Address methods
  // ___________________________________

  @Override
  public IpAddresses getIpAddresses(String projectId) throws PacketException {
    checkEmptyAndThrowError(projectId, "projectId is required");

    Request request = new Request(Endpoint.IPS)
        .addPathParmas(new Object[] {projectId});

    return (IpAddresses) executeRequest(request).getData();
  }

  @Override
  public Boolean reserveIpAddress(String projectId, ReserveIpAddress reserveIpAddress)
      throws PacketException {
    checkEmptyAndThrowError(projectId, "projectId is required");
    if (null == reserveIpAddress
        || StringUtils.isBlank(reserveIpAddress.getType())
        || null == reserveIpAddress.getQuantity()) {
      throw new IllegalArgumentException(
          "Missing required parameters [IP Address type, Quantity] for IP address reservation.");
    }

    Request request = new Request(Endpoint.RESERVE_IPS)
        .addPathParmas(new Object[] {projectId})
        .body(reserveIpAddress);

    return executeRequest(request).isRequestSuccess();
  }

  @Override
  public IpAddress getIpAddress(String ipAddressId) throws PacketException {
    checkEmptyAndThrowError(ipAddressId, "ipAddressId is required");

    Request request = new Request(Endpoint.GET_IP)
        .addPathParmas(new Object[] {ipAddressId});

    return (IpAddress) executeRequest(request).getData();
  }

  @Override
  public Boolean deleteIpAddress(String ipAddressId) throws PacketException {
    checkEmptyAndThrowError(ipAddressId, "ipAddressId is required");

    Request request = new Request(Endpoint.DELETE_IP)
        .addPathParmas(new Object[] {ipAddressId});

    return executeRequest(request).isRequestSuccess();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Users methods
  // ___________________________________

  @Override
  public Users getUsers(Integer pageNo, Integer perPage) throws PacketException {
    checkNullAndThrowError(pageNo, "Page no is required");

    Request request = new Request(Endpoint.USERS)
        .page(pageNo)
        .perPage(perPage);

    return (Users) executeRequest(request).getData();
  }

  @Override
  public User getUser(String userId) throws PacketException {
    checkEmptyAndThrowError(userId, "userId is required");

    Request request = new Request(Endpoint.GET_USER)
        .addPathParmas(new Object[] {userId});

    return (User) executeRequest(request).getData();
  }

  @Override
  public User getCurrentUser() throws PacketException {
    Request request = new Request(Endpoint.CURRENT_USER);
    return (User) executeRequest(request).getData();
  }

  @Override
  public User updateCurrentUser(User user) throws PacketException {
    if (null == user) {
      throw new IllegalArgumentException(
          "Missing required parameters [user] for update current user.");
    }

    Request request = new Request(Endpoint.UPDATE_USER)
        .body(user);

    return (User) executeRequest(request).getData();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Memberships methods
  // ___________________________________

  @Override
  public Membership getMembership(String membershipId) throws PacketException {
    checkEmptyAndThrowError(membershipId, "membershipId is required");

    Request request = new Request(Endpoint.GET_MEMBERSHIP)
        .addPathParmas(new Object[] {membershipId});

    return (Membership) executeRequest(request).getData();
  }

  @Override
  public Membership updateMembership(Membership membership) throws PacketException {
    if (null == membership
        || StringUtils.isBlank(membership.getId())
        || null == membership.getRoles()
        || membership.getRoles().isEmpty()) {
      throw new IllegalArgumentException(
          "Missing required parameters [Id, Roles] for update membership.");
    }

    Request request = new Request(Endpoint.UPDATE_MEMBERSHIP)
        .addPathParmas(new Object[] {membership.getId()})
        .body(membership);

    return (Membership) executeRequest(request).getData();
  }

  @Override
  public Boolean deleteMembership(String membershipId) throws PacketException {
    checkEmptyAndThrowError(membershipId, "membershipId is required");

    Request request = new Request(Endpoint.DELETE_MEMBERSHIP)
        .addPathParmas(new Object[] {membershipId});

    return executeRequest(request).isRequestSuccess();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // SSH keys methods
  // ___________________________________

  @Override
  public SshKeys getSshKeys(Integer pageNo, Integer perPage) throws PacketException {
    checkNullAndThrowError(pageNo, "Page no is required");

    Request request = new Request(Endpoint.SSH_KEYS)
        .page(pageNo)
        .perPage(perPage);

    return (SshKeys) executeRequest(request).getData();
  }

  @Override
  public SshKey getSshKey(String sshKeyId) throws PacketException {
    checkEmptyAndThrowError(sshKeyId, "sshKeyId is required");

    Request request = new Request(Endpoint.GET_SSH_KEY)
        .addPathParmas(new Object[] {sshKeyId});

    return (SshKey) executeRequest(request).getData();
  }

  @Override
  public SshKey createSshKey(SshKey sshKey) throws PacketException {
    if (null == sshKey
        || StringUtils.isBlank(sshKey.getLabel())
        || StringUtils.isBlank(sshKey.getKey())) {
      throw new IllegalArgumentException(
          "Missing required parameters [Label, Key] for create SSH key.");
    }

    Request request = new Request(Endpoint.CREATE_SSH_KEY)
        .body(sshKey);

    return (SshKey) executeRequest(request).getData();
  }

  @Override
  public SshKey updateSshKey(SshKey sshKey) throws PacketException {
    if (null == sshKey
        || StringUtils.isBlank(sshKey.getId())
        || (StringUtils.isBlank(sshKey.getLabel()) && StringUtils.isBlank(sshKey.getKey()))) {
      throw new IllegalArgumentException(
          "Missing required parameters [Id, Label, Key] for update SSH key.");
    }

    Request request = new Request(Endpoint.UPDATE_SSH_KEY)
        .addPathParmas(new Object[] {sshKey.getId()})
        .body(sshKey);

    return (SshKey) executeRequest(request).getData();
  }

  @Override
  public Boolean deleteSshKey(String sshKeyId) throws PacketException {
    checkEmptyAndThrowError(sshKeyId, "sshKeyId is required");

    Request request = new Request(Endpoint.DELETE_SSH_KEY)
        .addPathParmas(new Object[] {sshKeyId});

    return executeRequest(request).isRequestSuccess();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Invitations methods
  // ___________________________________

  @Override
  public Invitation invite(String projectId, Invitation invitation) throws PacketException {
    checkEmptyAndThrowError(projectId, "projectId is required");
    if (null == invitation
        || StringUtils.isBlank(invitation.getInvitee())
        || StringUtils.isBlank(invitation.getMessage())
        || null == invitation.getRoles()
        || invitation.getRoles().isEmpty()) {
      throw new IllegalArgumentException(
          "Missing required parameters [Invitee, Message, Roles] for sending invite.");
    }

    Request request = new Request(Endpoint.INVITE)
        .addPathParmas(new Object[] {projectId})
        .body(invitation);

    return (Invitation) executeRequest(request).getData();
  }

  @Override
  public Invitation getInvite(String invitationId) throws PacketException {
    checkEmptyAndThrowError(invitationId, "invitationId is required");

    Request request = new Request(Endpoint.GET_INVITE)
        .addPathParmas(new Object[] {invitationId});

    return (Invitation) executeRequest(request).getData();
  }

  @Override
  public Boolean acceptInvite(String invitationId) throws PacketException {
    checkEmptyAndThrowError(invitationId, "invitationId is required");

    Request request = new Request(Endpoint.ACCEPT_INVITE)
        .addPathParmas(new Object[] {invitationId});

    return executeRequest(request).isRequestSuccess();
  }

  @Override
  public Boolean declineInvite(String invitationId) throws PacketException {
    checkEmptyAndThrowError(invitationId, "invitationId is required");

    Request request = new Request(Endpoint.DECLINE_INVITE)
        .addPathParmas(new Object[] {invitationId});

    return executeRequest(request).isRequestSuccess();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Events methods
  // ___________________________________

  @Override
  public Events getEvents(Date since, Integer pageNo, Integer perPage) throws PacketException {
    checkNullAndThrowError(pageNo, "Page no is required");

    Request request = new Request(Endpoint.EVENTS)
        .page(pageNo)
        .perPage(perPage);

    if (null != since) {
      request.queryParam("since", isoDateFormatter.format(since));
    }

    return (Events) executeRequest(request).getData();
  }

  @Override
  public Events getProjectEvents(String projectId, Integer pageNo, Integer perPage)
      throws PacketException {
    checkEmptyAndThrowError(projectId, "projectId is required");
    checkNullAndThrowError(pageNo, "Page no is required");

    Request request = new Request(Endpoint.PROJECT_EVENTS)
        .addPathParmas(new Object[] {projectId})
        .page(pageNo)
        .perPage(perPage);

    return (Events) executeRequest(request).getData();
  }

  @Override
  public Events getDeviceEvents(String deviceId, Integer pageNo, Integer perPage)
      throws PacketException {
    checkEmptyAndThrowError(deviceId, "deviceId is required");
    checkNullAndThrowError(pageNo, "Page no is required");

    Request request = new Request(Endpoint.DEVICE_EVENTS)
        .addPathParmas(new Object[] {deviceId})
        .page(pageNo)
        .perPage(perPage);

    return (Events) executeRequest(request).getData();
  }

  @Override
  public Event getEvent(String eventId) throws PacketException {
    checkEmptyAndThrowError(eventId, "eventId is required");

    Request request = new Request(Endpoint.GET_EVENT)
        .addPathParmas(new Object[] {eventId});

    return (Event) executeRequest(request).getData();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Notifications methods
  // ___________________________________

  @Override
  public Notifications getNotifications(Date since, Boolean all, Integer pageNo, Integer perPage)
      throws PacketException {
    checkNullAndThrowError(pageNo, "Page no is required");

    Request request = new Request(Endpoint.NOTIFICATIONS)
        .page(pageNo)
        .perPage(perPage);

    if (null != since) {
      request.queryParam("since", isoDateFormatter.format(since));
    }

    if (null != all) {
      request.queryParam("all", all.toString());
    }

    return (Notifications) executeRequest(request).getData();
  }

  @Override
  public Notification getNotification(String notificationId) throws PacketException {
    checkEmptyAndThrowError(notificationId, "notificationId is required");

    Request request = new Request(Endpoint.GET_NOTIFICATION)
        .addPathParmas(new Object[] {notificationId});

    return (Notification) executeRequest(request).getData();
  }

  @Override
  public Notification updateNotification(Notification notification) throws PacketException {
    if (null == notification
        || StringUtils.isBlank(notification.getId())
        || null == notification.isRead()) {
      throw new IllegalArgumentException(
          "Missing required parameters [Id, Read] for update notification.");
    }

    Request request = new Request(Endpoint.UPDATE_NOTIFICATION)
        .addPathParmas(new Object[] {notification.getId()})
        .body(notification);

    return (Notification) executeRequest(request).getData();
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Email methods
  // ___________________________________

  @Override
  public Email addEmailAddress(Email email) throws PacketException {
    if (null == email || StringUtils.isBlank(email.getAddress())) {
      throw new IllegalArgumentException(
          "Missing required parameters [Address] for adding email address.");
    }

    Request request = new Request(Endpoint.ADD_EMAIL).body(email);

    return (Email) executeRequest(request).getData();
  }

  @Override
  public Email getEmailAddress(String emailId) throws PacketException {
    checkEmptyAndThrowError(emailId, "emailId is required");

    Request request = new Request(Endpoint.GET_EMAIL)
        .addPathParmas(new Object[] {emailId});

    return (Email) executeRequest(request).getData();
  }

  @Override
  public Email updateEmailAddress(Email email) throws PacketException {
    if (null == email
        || StringUtils.isBlank(email.getId())
        || null == email.isDefault()) {
      throw new IllegalArgumentException(
          "Missing required parameters [Id, IsDefault] for updating email address.");
    }

    Request request = new Request(Endpoint.UPDATE_EMAIL)
        .addPathParmas(new Object[] {email.getId()})
        .body(email);

    return (Email) executeRequest(request).getData();
  }

  @Override
  public Boolean deleteEmailAddress(String emailId) throws PacketException {
    checkEmptyAndThrowError(emailId, "emailId is required");

    Request request = new Request(Endpoint.DELETE_EMAIL)
        .addPathParmas(new Object[] {emailId});

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

      log.debug("Equinix Metal Response: {}", response);
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
    if (HttpStatus.SC_OK == statusCode || HttpStatus.SC_CREATED == statusCode) {
      responseString = httpResponseToString(httpResponse);
    } else if (HttpStatus.SC_ACCEPTED == statusCode || HttpStatus.SC_NO_CONTENT == statusCode) {
      log.debug("202 Accepted or 204 No content");
    }

    if (statusCode >= 400 && statusCode < 510) {
      responseString = httpResponseToString(httpResponse);
      String errorMsg = StringUtils.EMPTY;
      try {
        Error error = deserializer.fromJson(responseString, Error.class);
        errorMsg = error.getAllErrors();
      } catch (JsonSyntaxException e) {
        errorMsg = "Equinix Metal server are on maintenance. Wait for official messages from Packet";
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
        .registerTypeAdapter(Device.class, new DeviceSerializer())
        .excludeFieldsWithoutExposeAnnotation()
        .create();

    this.deserializer = new GsonBuilder()
        .setDateFormat(DATE_FORMAT)
        .create();

    this.commonHeaders = new Header[] {
        new BasicHeader(HttpHeader.USER_AGENT, USER_AGENT),
        new BasicHeader(HttpHeader.ACCEPT,
            String.format(ACCEPT_HDR_FORMAT, MEDIA_TYPE_JSON, version)),
        new BasicHeader(HttpHeader.AUTHORIZATION, authToken)
    };

    this.contentTypeHeader = new BasicHeader(HttpHeader.CONTENT_TYPE, MEDIA_TYPE_JSON);

    this.isoDateFormatter = new SimpleDateFormat(DATE_FORMAT);
    this.isoDateFormatter.setTimeZone(TimeZone.getTimeZone(UTC_TIMEZONE));

    if (null == this.httpClient) {
      this.httpClient = HttpClients.createDefault();
    }

    log.info("Equinix Metal API client have been initialized [version: {}, host: {}]", version, HOSTNAME);
  }

}
