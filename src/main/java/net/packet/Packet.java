/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet;

import java.util.Date;

import net.packet.exception.PacketException;
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
import net.packet.pojo.ReserveIpAddress;
import net.packet.pojo.SshKey;
import net.packet.pojo.SshKeys;
import net.packet.pojo.Transfer;
import net.packet.pojo.User;
import net.packet.pojo.Users;

/**
 * Packet API client interface of REST APIs.
 * 
 * <p>
 * Lightweight API client library for accessing Packet REST APIs with project based (JVM hosted
 * languages) on Java, Groovy, Scala, Clojure, etc.
 * </p>
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public interface Packet {

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Facility methods
  // ___________________________________

  /**
   * Provides a listing of available datacenters where you can provision Packet devices.
   * 
   * @param pageNo for pagination
   * @param perPage no. of items per page (optional, can pass null)
   * @return {@link Facilities}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Facilities getFacilites(Integer pageNo, Integer perPage) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Operating systems methods
  // ___________________________________

  /**
   * Provides a listing of available operating systems to provision your new device with.
   * 
   * @param pageNo for pagination
   * @param perPage no. of items per page (optional, can pass null)
   * @return {@link OperatingSystems}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  OperatingSystems getOperatingSystems(Integer pageNo, Integer perPage) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Plans methods
  // ___________________________________

  /**
   * Provides a listing of available services plans available to provision your device on.
   * 
   * @param pageNo for pagination
   * @param perPage no. of items per page (optional, can pass null)
   * @return {@link Plans}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Plans getPlans(Integer pageNo, Integer perPage) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Projects methods
  // ___________________________________

  /**
   * Projects are a way to group devices and grant users access to them. A collection of projects
   * that the current user is a member of.
   * 
   * @param pageNo for pagination
   * @param perPage no. of items per page (optional, can pass null)
   * @return {@link Projects}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Projects getProjects(Integer pageNo, Integer perPage) throws PacketException;

  /**
   * Provides single project object.
   * 
   * @param projectId a packet project id
   * @return {@link Project}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Project getProject(String projectId) throws PacketException;

  /**
   * Create a project on your packet account.
   * 
   * @param project a {@link Project} instance
   * @return {@link Project}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Project createProject(Project project) throws PacketException;

  /**
   * Updates a project information. Like name, payment methods.
   * 
   * @param project a {@link Project} instance
   * @return {@link Project}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Project updateProject(Project project) throws PacketException;

  /**
   * Deletes a device and de-provisions it in our datacenter.
   * 
   * @param projectId a packet project id
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean deleteProject(String projectId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Project Transfer methods
  // ___________________________________

  /**
   * Project owners can transfer ownership of their projects to other members.
   * 
   * @param projectId a packet project id
   * @param membershipId a packet membership id
   * @return {@link Transfer}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Transfer transferProject(String projectId, String membershipId) throws PacketException;

  /**
   * Get the project transfer information.
   * 
   * @param transferId project transfer id
   * @return {@link Transfer}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Transfer getTransferInfo(String transferId) throws PacketException;

  /**
   * To accept project ownership transfer.
   * 
   * @param transferId project transfer id
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean acceptTransfer(String transferId) throws PacketException;

  /**
   * To decline project ownership transfer.
   * 
   * @param transferId project transfer id
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean declineTransfer(String transferId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Devices methods
  // ___________________________________

  /**
   * To get all available devices from your packet account on particular project.
   * 
   * @param projectId a packet project id
   * @param pageNo for pagination
   * @param perPage no. of items per page (optional, can pass null)
   * @return {@link Devices}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Devices getDevices(String projectId, Integer pageNo, Integer perPage) throws PacketException;

  /**
   * To get single device information.
   * 
   * @param deviceId a packet device id
   * @return {@link Device}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Device getDevice(String deviceId) throws PacketException;

  /**
   * Creating new device on packet project.
   * 
   * @param projectId a packet project id
   * @param device a {@link Device} instance
   * @return {@link Device}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Device createDevice(String projectId, Device device) throws PacketException;

  /**
   * To update device details on packet project.
   * 
   * @param device a {@link Device} instance
   * @return {@link Device}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Device updateDevice(Device device) throws PacketException;

  /**
   * To delete a device from Packet project and deprovisions it in packet datacenter.
   * 
   * @param deviceId a packet device id
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean deleteDevice(String deviceId) throws PacketException;

  /**
   * To power on your device.
   * 
   * @param deviceId a packet device id
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean powerOnDevice(String deviceId) throws PacketException;

  /**
   * To turn-off power on your device.
   * 
   * @param deviceId a packet device id
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean powerOffDevice(String deviceId) throws PacketException;

  /**
   * To reboot device normally.
   * 
   * @param deviceId a packet device id
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean rebootDevice(String deviceId) throws PacketException;

  /**
   * To reboot the device into rescue OS.
   * 
   * @param deviceId a packet device id
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean rescueDevice(String deviceId) throws PacketException;

  /**
   * To get traffic information for device.
   * 
   * @param deviceId a packet device id
   * @param direction a value of {@link TrafficDirection}
   * @param timeframeStart a starting date time
   * @param timeframeEnd a end date time
   * @return {@link Metrics}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Metrics deviceTraffic(String deviceId, TrafficDirection direction, Date timeframeStart,
      Date timeframeEnd) throws PacketException;

  /**
   * To get traffic information for device.
   * 
   * @param deviceId a packet device id
   * @param direction a value of {@link TrafficDirection}
   * @param timeframeStart a starting date time
   * @param timeframeEnd a end date time
   * @param interval a value of {@link MetricInterval}
   * @param bucket a value of {@link TrafficBucket}
   * @return {@link Metrics}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Metrics deviceTraffic(String deviceId, TrafficDirection direction, Date timeframeStart,
      Date timeframeEnd, MetricInterval interval, TrafficBucket bucket) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // IP Address methods
  // ___________________________________

  /**
   * To get all available IP Addresses form packet project.
   * 
   * @param projectId a packet project id
   * @return {@link IpAddresses}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  IpAddresses getIpAddresses(String projectId) throws PacketException;

  /**
   * Reserve/Request more IP address for a project.
   * 
   * @param projectId a packet project id
   * @param reserveIpAddress a instance of {@link ReserveIpAddress}
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean reserveIpAddress(String projectId, ReserveIpAddress reserveIpAddress)
      throws PacketException;

  /**
   * To get particular IP Address details.
   * 
   * @param ipAddressId id of the IP address
   * @return {@link IpAddress}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  IpAddress getIpAddress(String ipAddressId) throws PacketException;

  /**
   * To remove an IP reservation from the project.
   * 
   * @param ipAddressId id of the IP address
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean deleteIpAddress(String ipAddressId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Users methods
  // ___________________________________

  /**
   * To get all the available users information.
   * 
   * @param pageNo for pagination
   * @param perPage no. of items per page (optional, can pass null)
   * @return {@link Users}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Users getUsers(Integer pageNo, Integer perPage) throws PacketException;

  /**
   * To get single user information.
   * 
   * @param userId packet user id
   * @return {@link User}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  User getUser(String userId) throws PacketException;

  /**
   * To get current user information.
   * 
   * @return {@link User}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  User getCurrentUser() throws PacketException;

  /**
   * To update current user information.
   * 
   * @param user a instance of {@link User}
   * @return {@link User}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  User updateCurrentUser(User user) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Memberships methods
  // ___________________________________

  /**
   * To get project membership details.
   * 
   * @param membershipId project membership id
   * @return {@link Membership}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Membership getMembership(String membershipId) throws PacketException;

  /**
   * To update membership details.
   * 
   * @param membership a instance of {@link Membership}
   * @return {@link Membership}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Membership updateMembership(Membership membership) throws PacketException;

  /**
   * To deletes a membership record and also it will remove the user from the project.
   * 
   * @param membershipId project membership id
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean deleteMembership(String membershipId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // SSH keys methods
  // ___________________________________

  /**
   * To get all the available SSH keys from packet account.
   * 
   * @param pageNo for pagination
   * @param perPage no. of items per page (optional, can pass null)
   * @return {@link SshKeys}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  SshKeys getSshKeys(Integer pageNo, Integer perPage) throws PacketException;

  /**
   * To get single SSH key details.
   * 
   * @param sshKeyId id of the SSH key
   * @return {@link SshKey}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  SshKey getSshKey(String sshKeyId) throws PacketException;

  /**
   * To create a new SSH key on packet account.
   * 
   * @param sshKey a instance of {@link SshKey}
   * @return {@link SshKey}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  SshKey createSshKey(SshKey sshKey) throws PacketException;

  /**
   * To update existing SSH key on packet account.
   * 
   * @param sshKey a instance of {@link SshKey}
   * @return {@link SshKey}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  SshKey updateSshKey(SshKey sshKey) throws PacketException;

  /**
   * To delete SSH key from packet account.
   * 
   * @param sshKeyId a instance of {@link SshKey}
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean deleteSshKey(String sshKeyId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Invitations methods
  // ___________________________________

  /**
   * Inviting a user to the project or adding user to the project.
   * 
   * @param projectId a packet project id
   * @param invitation a instance of {@link Invitation}
   * @return {@link Invitation}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Invitation invite(String projectId, Invitation invitation) throws PacketException;

  /**
   * To get particular invite details.
   * 
   * @param invitationId a user invitation id
   * @return {@link Invitation}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Invitation getInvite(String invitationId) throws PacketException;

  /**
   * To accept user invitation.
   * 
   * @param invitationId a user invitation id
   * @return {@link Invitation}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean acceptInvite(String invitationId) throws PacketException;

  /**
   * To decline user invitation.
   * 
   * @param invitationId a user invitation id
   * @return {@link Invitation}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean declineInvite(String invitationId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Events methods
  // ___________________________________

  /**
   * Provides all the events from since date. This method returns event details regardless of
   * projects, devices.
   * 
   * @param since date time of events to fetch
   * @param pageNo for pagination
   * @param perPage no. of items per page (optional, can pass null)
   * @return {@link Events}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Events getEvents(Date since, Integer pageNo, Integer perPage) throws PacketException;

  /**
   * To fetch all the events belongs to particular project.
   * 
   * @param projectId packet project id
   * @param pageNo for pagination
   * @param perPage no. of items per page (optional, can pass null)
   * @return {@link Events}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Events getProjectEvents(String projectId, Integer pageNo, Integer perPage) throws PacketException;

  /**
   * To fetch all the events belongs to particular device.
   * 
   * @param deviceId packet device id
   * @param pageNo for pagination
   * @param perPage no. of items per page (optional, can pass null)
   * @return {@link Events}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Events getDeviceEvents(String deviceId, Integer pageNo, Integer perPage) throws PacketException;

  /**
   * To get single event details.
   * 
   * @param eventId id of project or device event id
   * @return {@link Event}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Event getEvent(String eventId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Notifications methods
  // ___________________________________

  /**
   * To fetch all the notification from packet account.
   * 
   * @param since date time of notifications to fetch
   * @param all to include read notification too
   * @param pageNo for pagination
   * @param perPage no. of items per page (optional, can pass null)
   * @return {@link Notifications}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Notifications getNotifications(Date since, Boolean all, Integer pageNo, Integer perPage)
      throws PacketException;

  /**
   * To get single notification details.
   * 
   * @param notificationId id of the packet notifications
   * @return {@link Notification}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Notification getNotification(String notificationId) throws PacketException;

  /**
   * To update single notification. Currently you can only mark as read.
   * 
   * @param notification a instance of the {@link Notification}
   * @return {@link Notification}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Notification updateNotification(Notification notification) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Email methods
  // ___________________________________

  /**
   * Add email address to current user profile.
   * 
   * @param email a valid email address
   * @return {@link Email}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Email addEmailAddress(Email email) throws PacketException;

  /**
   * To fetch one email address information.
   * 
   * @param emailId id of the email address record
   * @return {@link Email}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Email getEmailAddress(String emailId) throws PacketException;

  /**
   * To update email address to default address or non-default.
   * 
   * @param email a instance of {@link Email}
   * @return {@link Email}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Email updateEmailAddress(Email email) throws PacketException;

  /**
   * To delete email address from current user profile.
   * 
   * @param emailId id of the email address record
   * @return {@link Boolean}
   * @throws PacketException for <code>HTTP status code &gt;= 400 &amp;&amp; &lt; 510</code>
   */
  Boolean deleteEmailAddress(String emailId) throws PacketException;

}
