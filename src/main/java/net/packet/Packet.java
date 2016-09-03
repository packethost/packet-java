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
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public interface Packet {

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Facility methods
  // ___________________________________

  Facilities getFacilites(Integer pageNo, Integer perPage) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Operating systems methods
  // ___________________________________

  OperatingSystems getOperatingSystems(Integer pageNo, Integer perPage) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Plans methods
  // ___________________________________

  Plans getPlans(Integer pageNo, Integer perPage) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Projects methods
  // ___________________________________

  Projects getProjects(Integer pageNo, Integer perPage) throws PacketException;

  Project getProject(String projectId) throws PacketException;

  Project createProject(Project project) throws PacketException;

  Project updateProject(Project project) throws PacketException;

  Boolean deleteProject(String projectId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Project Transfer methods
  // ___________________________________

  Transfer transferProject(String projectId, String membershipId) throws PacketException;

  Transfer getTransferInfo(String transferId) throws PacketException;

  Boolean acceptTransfer(String transferId) throws PacketException;

  Boolean declineTransfer(String transferId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Devices methods
  // ___________________________________

  Devices getDevices(String projectId, Integer pageNo, Integer perPage) throws PacketException;

  Device getDevice(String deviceId) throws PacketException;

  Device createDevice(String projectId, Device device) throws PacketException;

  Device updateDevice(Device device) throws PacketException;

  Boolean deleteDevice(String deviceId) throws PacketException;

  Boolean powerOnDevice(String deviceId) throws PacketException;

  Boolean powerOffDevice(String deviceId) throws PacketException;

  Boolean rebootDevice(String deviceId) throws PacketException;

  Boolean rescueDevice(String deviceId) throws PacketException;

  Metrics deviceTraffic(String deviceId, TrafficDirection direction, Date timeframeStart,
      Date timeframeEnd) throws PacketException;

  Metrics deviceTraffic(String deviceId, TrafficDirection direction, Date timeframeStart,
      Date timeframeEnd, MetricInterval interval, TrafficBucket bucket) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // IP Address methods
  // ___________________________________

  IpAddresses getIpAddresses(String projectId) throws PacketException;

  Boolean reserveIpAddress(String projectId, ReserveIpAddress reserveIpAddress)
      throws PacketException;

  IpAddress getIpAddress(String ipAddressId) throws PacketException;

  Boolean deleteIpAddress(String ipAddressId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Users methods
  // ___________________________________

  Users getUsers(Integer pageNo, Integer perPage) throws PacketException;

  User getUser(String userId) throws PacketException;

  User getCurrentUser() throws PacketException;

  User updateCurrentUser(User user) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Memberships methods
  // ___________________________________

  Membership getMembership(String membershipId) throws PacketException;

  Membership updateMembership(Membership membership) throws PacketException;

  Boolean deleteMembership(String membershipId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // SSH keys methods
  // ___________________________________

  SshKeys getSshKeys(Integer pageNo, Integer perPage) throws PacketException;

  SshKey getSshKey(String sshKeyId) throws PacketException;

  SshKey createSshKey(SshKey sshKey) throws PacketException;

  SshKey updateSshKey(SshKey sshKey) throws PacketException;

  Boolean deleteSshKey(String sshKeyId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Invitations methods
  // ___________________________________

  Invitation invite(String projectId, Invitation invitation) throws PacketException;

  Invitation getInvite(String invitationId) throws PacketException;

  Boolean acceptInvite(String invitationId) throws PacketException;

  Boolean declineInvite(String invitationId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Events methods
  // ___________________________________

  Events getEvents(Date since, Integer pageNo, Integer perPage) throws PacketException;

  Events getProjectEvents(String projectId, Integer pageNo, Integer perPage) throws PacketException;

  Events getDeviceEvents(String deviceId, Integer pageNo, Integer perPage) throws PacketException;

  Event getEvent(String eventId) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Notifications methods
  // ___________________________________

  Notifications getNotifications(Date since, Boolean all, Integer pageNo, Integer perPage)
      throws PacketException;

  Notification getNotification(String notificationId) throws PacketException;

  Notification updateNotification(Notification notification) throws PacketException;

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Email methods
  // ___________________________________

  Email addEmailAddress(Email email) throws PacketException;

  Email getEmailAddress(String emailId) throws PacketException;

  Email updateEmailAddress(Email email) throws PacketException;

  Boolean deleteEmailAddress(String emailId) throws PacketException;

}
