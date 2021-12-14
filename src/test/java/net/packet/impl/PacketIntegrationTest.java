/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.packet.BillingCycle;
import net.packet.Constants;
import net.packet.MetricInterval;
import net.packet.Packet;
import net.packet.TrafficBucket;
import net.packet.TrafficDirection;
import net.packet.exception.PacketException;
import net.packet.pojo.Device;
import net.packet.pojo.Devices;
import net.packet.pojo.Email;
import net.packet.pojo.Event;
import net.packet.pojo.Events;
import net.packet.pojo.Facilities;
import net.packet.pojo.Facility;
import net.packet.pojo.Invitation;
import net.packet.pojo.IpAddress;
import net.packet.pojo.IpAddresses;
import net.packet.pojo.Membership;
import net.packet.pojo.Metrics;
import net.packet.pojo.Notification;
import net.packet.pojo.Notifications;
import net.packet.pojo.OperatingSystem;
import net.packet.pojo.OperatingSystems;
import net.packet.pojo.Plan;
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
 * Equinix Metal API client Integration test.
 * 
 * <p>
 * <strong>Note:</strong> <i>Please update private variable values before using executing
 * integration test since it's uses actual values. And the comment out @Ignore.</i>
 * </p>
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
@Ignore
public class PacketIntegrationTest {

  private static final Logger log = LoggerFactory.getLogger(PacketIntegrationTest.class);

  private String authToken = "";
  private String version = "1";
  private Packet apiClient;

  @Before
  public void before() {
    this.apiClient = new PacketClient(authToken, version);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Facility methods
  // ___________________________________

  @Test
  public void testGetFacilities() throws PacketException {
    Facilities facilities = apiClient.getFacilites(1, null);
    assertNotNull(facilities);

    log.info("{}", facilities);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Operating systems methods
  // ___________________________________

  @Test
  public void testGetOperatingSystems() throws PacketException {
    OperatingSystems operatingSystems = apiClient.getOperatingSystems(1, 15);
    assertNotNull(operatingSystems);

    log.info("{}", operatingSystems);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Plans methods
  // ___________________________________

  @Test
  public void testGetPlans() throws PacketException {
    Plans plans = apiClient.getPlans(1, 15);
    assertNotNull(plans);

    log.info("{}", plans);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Projects methods
  // ___________________________________

  @Test
  public void testGetProjects() throws PacketException {
    Projects projects = apiClient.getProjects(1, null);
    assertNotNull(projects);

    log.info("{}", projects);
  }

  @Test
  public void testGetProject() throws PacketException {
    Project project = apiClient.getProject("478a943f-9134-4c45-a664-6a8e7f2ff17c");
    assertNotNull(project);

    log.info("{}", project);
  }

  @Test
  public void testCreateProject() throws PacketException {
    Project newProject = new Project("Test api client 1", "b2bb4ee0-506b-4c01-b17d-ba41d5c430c5");

    Project result = apiClient.createProject(newProject);
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testUpdateProject() throws PacketException {
    Project updateProject =
        new Project("478a943f-9134-4c45-a664-6a8e7f2ff17c", "Test api client 1", null);

    Project result = apiClient.updateProject(updateProject);
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testDeleteProject() throws PacketException {
    Boolean result = apiClient.deleteProject("478a943f-9134-4c45-a664-6a8e7f2ff17c");
    assertTrue(result);

    log.info("{}", result);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Project Transfer methods
  // ___________________________________

  @Test
  public void testTransferProject() throws PacketException {
    Transfer transfer = apiClient.transferProject("478a943f-9134-4c45-a664-6a8e7f2ff17c",
        "1140617d-262d-4502-a3d6-771d83c930da");
    assertNotNull(transfer);

    log.info("{}", transfer);
  }

  @Test
  public void testGetTransferInfo() throws PacketException {
    Transfer transfer = apiClient.getTransferInfo("df900305-bf65-4820-9e74-22cd4a8fafe5");
    assertNotNull(transfer);

    log.info("{}", transfer);
  }

  @Test
  public void testAcceptTransfer() throws PacketException {
    Boolean result = apiClient.acceptTransfer("df900305-bf65-4820-9e74-22cd4a8fafe5");
    assertTrue(result);

    log.info("{}", result);
  }

  @Test
  public void testDeclineTransfer() throws PacketException {
    Boolean result = apiClient.declineTransfer("df900305-bf65-4820-9e74-22cd4a8fafe5");
    assertTrue(result);

    log.info("{}", result);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Devices methods
  // ___________________________________

  @Test
  public void testGetDevices() throws PacketException {
    Devices devices = apiClient.getDevices("478a943f-9134-4c45-a664-6a8e7f2ff17c", 1, null);
    assertNotNull(devices);

    log.info("{}", devices);
  }

  @Test
  public void testGetDevice() throws PacketException {
    Device device = apiClient.getDevice("9661be52-d386-4dc2-86fe-0434e0b81bb7");
    assertNotNull(device);

    log.info("{}", device);
  }

  @Test
  public void testCreateDevice() throws PacketException {
    Device device = new Device(
        "web1.sample.com",
        new Plan("baremetal_0"),
        BillingCycle.fromValue("hourly"),
        new OperatingSystem("debian_8"),
        new Facility("ewr1"));

    device.setTags(Arrays.asList("api client create"));

    Device result = apiClient.createDevice("478a943f-9134-4c45-a664-6a8e7f2ff17c", device);
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testUpdateDevice() throws PacketException {
    Device device = new Device();
    device.setId("b454c6d9-29e5-4d20-a2f5-6cf4e217b51b");
    device.setHostname("web2.sample.com");
    device.setLocked(false);

    Device result = apiClient.updateDevice(device);
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testDeleteDevice() throws PacketException {
    Boolean result = apiClient.deleteDevice("9661be52-d386-4dc2-86fe-0434e0b81bb7");
    assertTrue(result);

    log.info("{}", result);
  }

  @Test
  public void testPowerOnDevice() throws PacketException {
    Boolean result = apiClient.powerOnDevice("b454c6d9-29e5-4d20-a2f5-6cf4e217b51b");
    assertTrue(result);

    log.info("{}", result);
  }

  @Test
  public void testPowerOffDevice() throws PacketException {
    Boolean result = apiClient.powerOffDevice("b454c6d9-29e5-4d20-a2f5-6cf4e217b51b");
    assertTrue(result);

    log.info("{}", result);
  }

  @Test
  public void testRebootDevice() throws PacketException {
    Boolean result = apiClient.rebootDevice("b454c6d9-29e5-4d20-a2f5-6cf4e217b51b");
    assertTrue(result);

    log.info("{}", result);
  }

  @Test
  public void testRescueDevice() throws PacketException {
    Boolean result = apiClient.rescueDevice("b454c6d9-29e5-4d20-a2f5-6cf4e217b51b");
    assertTrue(result);

    log.info("{}", result);
  }

  @Test
  public void testDeviceTraffic() throws PacketException, ParseException {
    DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);

    Metrics metrics = apiClient.deviceTraffic(
        "b454c6d9-29e5-4d20-a2f5-6cf4e217b51b",
        TrafficDirection.OUTBOUND,
        df.parse("2016-08-27T00:00:00Z"),
        df.parse("2016-09-01T23:59:59Z"),
        MetricInterval.DAY,
        TrafficBucket.EXTERNAL);

    assertNotNull(metrics);

    log.info("{}", metrics);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // IP Address methods
  // ___________________________________

  @Test
  public void testGetIpAddresses() throws PacketException {
    IpAddresses ipAddresses = apiClient.getIpAddresses("478a943f-9134-4c45-a664-6a8e7f2ff17c");
    assertNotNull(ipAddresses);

    log.info("{}", ipAddresses);
  }

  @Test
  public void testReserveIpAddress() throws PacketException {
    ReserveIpAddress reserveIpAddress =
        new ReserveIpAddress("public_ipv4", 4, "java api client testing");

    Boolean result =
        apiClient.reserveIpAddress("478a943f-9134-4c45-a664-6a8e7f2ff17c", reserveIpAddress);
    assertTrue(result);

    log.info("{}", result);
  }

  @Test
  public void testGetIpAddress() throws PacketException {
    IpAddress ipAddress = apiClient.getIpAddress("c851ffe1-d5d3-4fbd-bd97-706b482a0414");
    assertNotNull(ipAddress);

    log.info("{}", ipAddress);
  }

  @Test
  public void testDeleteIpAddress() throws PacketException {
    Boolean result = apiClient.deleteIpAddress("16c978d9-b224-499c-8146-3925ed7fcedc");
    assertTrue(result);

    log.info("{}", result);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Users methods
  // ___________________________________

  @Test
  public void testGetUsers() throws PacketException {
    Users users = apiClient.getUsers(1, null);
    assertNotNull(users);

    log.info("{}", users);
  }

  @Test
  public void testGetUser() throws PacketException {
    User user = apiClient.getUser("1140617d-262d-4502-a3d6-771d83c930da");
    assertNotNull(user);

    log.info("{}", user);
  }

  @Test
  public void testGetCurrentUser() throws PacketException {
    User user = apiClient.getCurrentUser();
    assertNotNull(user);

    log.info("{}", user); // america/los_angeles
  }

  @Test
  public void testUpdateCurrentUser() throws PacketException {
    User user = new User();
    user.setTimezone("America/Los_Angeles");

    User result = apiClient.updateCurrentUser(user);
    assertNotNull(result);

    log.info("{}", result);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Memberships methods
  // ___________________________________

  @Test
  public void testGetMembership() throws PacketException {
    Membership membership = apiClient.getMembership("e8b8c684-6de1-455b-87af-301b36df8da7");
    assertNotNull(membership);

    log.info("{}", membership);
  }

  @Test
  public void testUpdateMembership() throws PacketException {
    Membership membership = new Membership(
        "e8b8c684-6de1-455b-87af-301b36df8da7",
        Arrays.asList("billing", "collaborator"));

    Membership result = apiClient.updateMembership(membership);
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testDeleteMembership() throws PacketException {
    Boolean result = apiClient.deleteMembership("membership-id");
    assertTrue(result);

    log.info("{}", result);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // SSH keys methods
  // ___________________________________

  @Test
  public void testGetSshKeys() throws PacketException {
    SshKeys sshKeys = apiClient.getSshKeys(1, null);
    assertNotNull(sshKeys);

    log.info("{}", sshKeys);
  }

  @Test
  public void testGetSshKey() throws PacketException {
    SshKey sshKey = apiClient.getSshKey("8008273d-1444-40f0-955e-b223cbcf406c");
    assertNotNull(sshKey);

    log.info("{}", sshKey);
  }

  @Test
  public void testCreateSshKey() throws PacketException {
    SshKey sshKey = new SshKey("test api key 1",
        "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQDcdZVJxgZ2Z0X3FKfI8K+XPmcZ6EHckoCWwDe4iS5Cntrn71mtF92IjUPUpMF6P7cxAgvXZglr/G8Dt7LWucppt7YziXlye2+aQR+aR7/TKaN6KyhZPMgpTBn9/y9tNOx/c2ntzXaqLT7dEmHKdQdZxe2V11V0p2KSlzJfXD908PI9POS2Ick2OMKLcifREl60TUjTIcol27XB5+vjVIdNw7gGbyoicZNkUVmCKVbH9XeL7VmUSEyekLGAEAs2CCnxcCv2v4JueDubaqiLS1xGhgMBNuPRIBpOhSKRbSEQpRSD4569f3W8A+mqWWle9yw3yaolv/NBe+X0l0MCRw9t jeeva@myjeeva.com");

    SshKey result = apiClient.createSshKey(sshKey);
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testUpdateSshKey() throws PacketException {
    SshKey sshKey = new SshKey("9d6f7c06-1a69-46a9-a13c-93ba395797aa", "test api ssh key 1", null);

    SshKey result = apiClient.updateSshKey(sshKey);
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testDeleteSshKey() throws PacketException {
    Boolean result = apiClient.deleteSshKey("8008273d-1444-40f0-955e-b223cbcf406c");
    assertNotNull(result);

    log.info("{}", result);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Invitations methods
  // ___________________________________

  @Test
  public void testInvite() throws PacketException {
    Invitation invitation = new Invitation("sample@exampl.com", "Invitation test message",
        Arrays.asList("collaborator"));

    Invitation result = apiClient.invite("478a943f-9134-4c45-a664-6a8e7f2ff17c", invitation);
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testGetInvite() throws PacketException {
    Invitation invitation = apiClient.getInvite("4c234b1c-3c1c-4ce1-9054-c9de97f1a0a7");
    assertNotNull(invitation);

    log.info("{}", invitation);
  }

  @Test
  public void testAcceptInvite() throws PacketException {
    Boolean result = apiClient.acceptInvite("4c234b1c-3c1c-4ce1-9054-c9de97f1a0a7");
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testDeclineInvite() throws PacketException {
    Boolean result = apiClient.declineInvite("4c234b1c-3c1c-4ce1-9054-c9de97f1a0a7");
    assertNotNull(result);

    log.info("{}", result);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Events methods
  // ___________________________________

  @Test
  public void testGetEvents() throws PacketException {
    Events events = apiClient.getEvents(null, 1, 5);
    assertNotNull(events);

    log.info("{}", events);
  }

  @Test
  public void testGetProjectEvents() throws PacketException {
    Events events = apiClient.getProjectEvents("478a943f-9134-4c45-a664-6a8e7f2ff17c", 1, 5);
    assertNotNull(events);

    log.info("{}", events);
  }

  @Test
  public void testGetDeviceEvents() throws PacketException {
    Events events = apiClient.getDeviceEvents("b454c6d9-29e5-4d20-a2f5-6cf4e217b51b", 1, 5);
    assertNotNull(events);

    log.info("{}", events);
  }

  @Test
  public void testGetEvent() throws PacketException {
    Event event = apiClient.getEvent("73430cc4-91d8-4d90-ac49-fab19f2c8683");
    assertNotNull(event);

    log.info("{}", event);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Notifications methods
  // ___________________________________

  @Test
  public void testGetNotifications() throws PacketException {
    Notifications notifications = apiClient.getNotifications(null, true, 1, 5);
    assertNotNull(notifications);

    log.info("{}", notifications);
  }

  @Test
  public void testGetNotification() throws PacketException {
    Notification notification = apiClient.getNotification("a2d0f2ea-668c-4ed0-af6e-8b023003b3e3");
    assertNotNull(notification);

    log.info("{}", notification);
  }

  @Test
  public void testUpdateNotification() throws PacketException {
    Notification notification = new Notification();
    notification.setId("61731738-36b2-40c6-ba3e-47990333d01f");
    notification.setRead(true);

    Notification result = apiClient.updateNotification(notification);
    assertNotNull(result);

    log.info("{}", result);
  }

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Email methods
  // ___________________________________

  @Test
  public void testAddEmail() throws PacketException {
    Email email = new Email("foobar@packet.net", null);

    Email result = apiClient.addEmailAddress(email);
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testGetEmail() throws PacketException {
    Email result = apiClient.getEmailAddress("70b88c76-4434-40cb-a491-57786578dec6");
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testUpdateEmail() throws PacketException {
    Email email = new Email("70b88c76-4434-40cb-a491-57786578dec6", "foobar1@packet.net", false);

    Email result = apiClient.updateEmailAddress(email);
    assertNotNull(result);

    log.info("{}", result);
  }

  @Test
  public void testDeleteEmail() throws PacketException {
    Boolean result = apiClient.deleteEmailAddress("70b88c76-4434-40cb-a491-57786578dec6");
    assertNotNull(result);

    log.info("{}", result);
  }

}
