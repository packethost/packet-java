# Java Client Library - Changelog

* **Released in v1.0.0**
  * Facilities
  <pre>
  Facilities getFacilites(Integer pageNo, Integer perPage)
  </pre>
  * Plans
  <pre>
  Plans getPlans(Integer pageNo, Integer perPage)
  </pre>
  * Operating Systems
  <pre>
  OperatingSystems getOperatingSystems(Integer pageNo, Integer perPage)
  </pre>
  * Projects
  <pre>
  Projects getProjects(Integer pageNo, Integer perPage)
  Project getProject(String projectId)
  Project createProject(Project project)
  Project updateProject(Project project)
  Boolean deleteProject(String projectId)
  </pre>
  * Devices and Device Actions
  <pre>
  Devices getDevices(String projectId, Integer pageNo, Integer perPage)
  Device getDevice(String deviceId)
  Device createDevice(String projectId, Device device)
  Device updateDevice(Device device)
  Boolean deleteDevice(String deviceId)
  Boolean powerOnDevice(String deviceId)
  Boolean powerOffDevice(String deviceId)
  Boolean rebootDevice(String deviceId)
  Boolean rescueDevice(String deviceId)
  </pre>
  * IP Address
  <pre>
  IpAddresses getIpAddresses(String projectId)
  Boolean reserveIpAddress(String projectId, ReserveIpAddress reserveIpAddress)
  IpAddress getIpAddress(String ipAddressId)
  Boolean deleteIpAddress(String ipAddressId)
  </pre>
  * Users
  <pre>
  Users getUsers(Integer pageNo, Integer perPage)
  User getUser(String userId)
  User getCurrentUser()
  User updateCurrentUser(User user)
  </pre>
  * Memberships
  <pre>
  Membership getMembership(String membershipId)
  Membership updateMembership(Membership membership)
  Boolean deleteMembership(String membershipId)
  </pre>
  * SSH Keys
  <pre>
  SshKeys getSshKeys(Integer pageNo, Integer perPage)
  SshKey getSshKey(String sshKeyId)
  SshKey createSshKey(SshKey sshKey)
  SshKey updateSshKey(SshKey sshKey)
  Boolean deleteSshKey(String sshKeyId)
  </pre>
  * Events
  <pre>
  Events getEvents(Date since, Integer pageNo, Integer perPage)
  Events getProjectEvents(String projectId, Integer pageNo, Integer perPage)
  Events getDeviceEvents(String deviceId, Integer pageNo, Integer perPage)
  Event getEvent(String eventId)
  </pre>
  * Invitations
  <pre>
  Invitation invite(String projectId, Invitation invitation)
  Invitation getInvite(String invitationId)
  Boolean acceptInvite(String invitationId)
  Boolean declineInvite(String invitationId)
  </pre>
  * Email
  <pre>
  Email addEmailAddress(Email email)
  Email getEmailAddress(String emailId)
  Email updateEmailAddress(Email email)
  Boolean deleteEmailAddress(String emailId)
  </pre>
  * Notifications
  <pre>
  Notifications getNotifications(Date since, Boolean all, Integer pageNo, Integer perPage)
  Notification getNotification(String notificationId)
  Notification updateNotification(Notification notification)
  </pre>
  * Project Transfer
  <pre>
  Transfer transferProject(String projectId, String membershipId)
  Transfer getTransferInfo(String transferId)
  Boolean acceptTransfer(String transferId)
  Boolean declineTransfer(String transferId)
  </pre>
  * Device Traffic
  <pre>
  Metrics deviceTraffic(String deviceId, TrafficDirection direction, Date timeframeStart,Date timeframeEnd)
  Metrics deviceTraffic(String deviceId, TrafficDirection direction, Date timeframeStart, Date timeframeEnd, MetricInterval interval, TrafficBucket bucket)
  </pre>
