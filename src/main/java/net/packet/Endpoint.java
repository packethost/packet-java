/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet;

import net.packet.http.HttpMethod;
import net.packet.pojo.Device;
import net.packet.pojo.Devices;
import net.packet.pojo.Email;
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
import net.packet.pojo.SshKey;
import net.packet.pojo.SshKeys;
import net.packet.pojo.Transfer;
import net.packet.pojo.User;
import net.packet.pojo.Users;

/**
 * Enumeration of Equinix Metal REST Endpoint(s) information.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public enum Endpoint {

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /facilities endpoint(s)
  // ___________________________________
  FACILITIES("/facilities", HttpMethod.GET, Facilities.class),

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /operating-systems endpoint(s)
  // ___________________________________
  OPERATING_SYSTEMS("/operating-systems", HttpMethod.GET, OperatingSystems.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /plans endpoint(s)
  // ___________________________________
  PLANS("/plans", HttpMethod.GET, Plans.class),

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /projects endpoint(s)
  // ___________________________________
  PROJECTS("/projects", HttpMethod.GET, Projects.class), 
  GET_PROJECT("/projects/%s", HttpMethod.GET, Project.class), 
  CREATE_PROJECT("/projects", HttpMethod.POST, Project.class), 
  UPDATE_PROJECT("/projects/%s", HttpMethod.PATCH, Project.class), 
  DELETE_PROJECT("/projects/%s", HttpMethod.DELETE, Boolean.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /projects/{id}/transfers endpoint(s)
  // ___________________________________
  TRANSFER("/projects/%s/transfers", HttpMethod.POST, Transfer.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /projects/{id}/devices endpoint(s)
  // ___________________________________
  DEVICES("/projects/%s/devices", HttpMethod.GET, Devices.class),
  CREATE_DEVICE("/projects/%s/devices", HttpMethod.POST, Device.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /transfers endpoint(s)
  // ___________________________________
  GET_TRANSFER("/transfers/%s", HttpMethod.GET, Transfer.class),
  ACCEPT_TRANSFER("/transfers/%s", HttpMethod.PATCH, Boolean.class),
  DECLINE_TRANSFER("/transfers/%s", HttpMethod.DELETE, Boolean.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /devices endpoint(s)
  // ___________________________________
  GET_DEVICE("/devices/%s", HttpMethod.GET, Device.class),  
  UPDATE_DEVICE("/devices/%s", HttpMethod.PATCH, Device.class), 
  DELETE_DEVICE("/devices/%s", HttpMethod.DELETE, Boolean.class),
  DEVICE_TRAFFIC("/devices/%s/traffic", HttpMethod.GET, Metrics.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /devices/{id}/actions endpoint(s)
  // ___________________________________
  DEVICE_ACTIONS("/devices/%s/actions", HttpMethod.POST, Boolean.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /projects/{id}/devices
  // ___________________________________
  IPS("/projects/%s/ips", HttpMethod.GET, IpAddresses.class),
  RESERVE_IPS("/projects/%s/ips", HttpMethod.POST, Boolean.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /ips endpoint(s)
  // ___________________________________
  GET_IP("/ips/%s", HttpMethod.GET, IpAddress.class),
  DELETE_IP("/ips/%s", HttpMethod.DELETE, Boolean.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /users, /user endpoint(s)
  // ___________________________________
  USERS("/users", HttpMethod.GET, Users.class),
  GET_USER("/users/%s", HttpMethod.GET, User.class),
  CURRENT_USER("/user", HttpMethod.GET, User.class),
  UPDATE_USER("/user", HttpMethod.PATCH, User.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /memberships endpoint(s)
  // ___________________________________
  GET_MEMBERSHIP("/memberships/%s", HttpMethod.GET, Membership.class),
  UPDATE_MEMBERSHIP("/memberships/%s", HttpMethod.PATCH, Membership.class),
  DELETE_MEMBERSHIP("/memberships/%s", HttpMethod.DELETE, Boolean.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /ssh-keys endpoint(s)
  // ___________________________________
  SSH_KEYS("/ssh-keys", HttpMethod.GET, SshKeys.class),
  GET_SSH_KEY("/ssh-keys/%s", HttpMethod.GET, SshKey.class),
  CREATE_SSH_KEY("/ssh-keys", HttpMethod.POST, SshKey.class),
  UPDATE_SSH_KEY("/ssh-keys/%s", HttpMethod.PATCH, SshKey.class),
  DELETE_SSH_KEY("/ssh-keys/%s", HttpMethod.DELETE, Boolean.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /invitations, /projects/{id}/invitations endpoint(s)
  // ___________________________________________________________
  INVITE("/projects/%s/invitations", HttpMethod.POST, Invitation.class),
  GET_INVITE("/invitations/%s", HttpMethod.GET, Invitation.class),
  ACCEPT_INVITE("/invitations/%s", HttpMethod.PATCH, Boolean.class),
  DECLINE_INVITE("/invitations/%s", HttpMethod.DELETE, Boolean.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /events, */*/events endpoint(s)
  // ___________________________________
  EVENTS("/events", HttpMethod.GET, Events.class),
  PROJECT_EVENTS("/projects/%s/events", HttpMethod.GET, Events.class),
  DEVICE_EVENTS("/devices/%s/events", HttpMethod.GET, Events.class),
  GET_EVENT("/events/%s", HttpMethod.GET, Event.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /notifications endpoint(s)
  // ___________________________________
  NOTIFICATIONS("/notifications", HttpMethod.GET, Notifications.class),
  GET_NOTIFICATION("/notifications/%s", HttpMethod.GET, Notification.class),
  UPDATE_NOTIFICATION("/notifications/%s", HttpMethod.PATCH, Notification.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /emails endpoint(s)
  // ___________________________________
  ADD_EMAIL("/emails", HttpMethod.POST, Email.class),
  GET_EMAIL("/emails/%s", HttpMethod.GET, Email.class),
  UPDATE_EMAIL("/emails/%s", HttpMethod.PATCH, Email.class),
  DELETE_EMAIL("/emails/%s", HttpMethod.DELETE, Email.class);

  private String path;

  private HttpMethod method;

  private Class<?> clazz;

  Endpoint(String path, HttpMethod method, Class<?> clazz) {
    this.path = path;
    this.method = method;
    this.clazz = clazz;
  }

  /**
   * @return the path
   */
  public String getPath() {
    return path;
  }

  /**
   * @return the method
   */
  public HttpMethod getMethod() {
    return method;
  }

  /**
   * @return the clazz
   */
  public Class<?> getClazz() {
    return clazz;
  }

}
