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
import net.packet.pojo.Facilities;
import net.packet.pojo.IpAddress;
import net.packet.pojo.IpAddresses;
import net.packet.pojo.OperatingSystems;
import net.packet.pojo.Plans;
import net.packet.pojo.Project;
import net.packet.pojo.Projects;

/**
 * Enumeration of Packet REST endpoints information.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public enum Endpoint {

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Facility methods
  // ___________________________________
  FACILITIES("/facilities", "", HttpMethod.GET, Facilities.class),

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Operating systems methods
  // ___________________________________
  OPERATING_SYSTEMS("/operating-systems", "", HttpMethod.GET, OperatingSystems.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // Plans methods
  // ___________________________________
  PLANS("/plans", "", HttpMethod.GET, Plans.class),

  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /projects endpoint(s)
  // ___________________________________
  PROJECTS("/projects", "", HttpMethod.GET, Projects.class), 
  GET_PROJECT("/projects/%s", "", HttpMethod.GET, Project.class), 
  CREATE_PROJECT("/projects", "", HttpMethod.POST, Project.class), 
  UPDATE_PROJECT("/projects/%s", "", HttpMethod.PATCH, Project.class), 
  DELETE_PROJECT("/projects/%s", "", HttpMethod.DELETE, Boolean.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /projects/{id}/devices
  // ___________________________________
  DEVICES("/projects/%s/devices", "", HttpMethod.GET, Devices.class),
  CREATE_DEVICE("/projects/%s/devices", "", HttpMethod.POST, Device.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /devices endpoint(s)
  // ___________________________________
  GET_DEVICE("/devices/%s", "", HttpMethod.GET, Device.class),  
  UPDATE_DEVICE("/devices/%s", "", HttpMethod.PATCH, Device.class), 
  DELETE_DEVICE("/devices/%s", "", HttpMethod.DELETE, Boolean.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /devices/{id}/actions endpoint(s)
  // ___________________________________
  DEVICE_ACTIONS("/devices/%s/actions", "", HttpMethod.POST, Boolean.class),
  
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /projects/{id}/devices
  // ___________________________________
  IPS("/projects/%s/ips", "", HttpMethod.GET, IpAddresses.class),
  RESERVE_IPS("/projects/%s/ips", "", HttpMethod.POST, Boolean.class),
  
  // ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾
  // /ips endpoint(s)
  // ___________________________________
  GET_IP("/ips/%s", "", HttpMethod.GET, IpAddress.class),
  DELETE_IP("/ips/%s", "", HttpMethod.DELETE, Boolean.class);

  private String path;

  private String elementName;

  private HttpMethod method;

  private Class<?> clazz;

  Endpoint(String path, String elementName, HttpMethod method, Class<?> clazz) {
    this.path = path;
    this.elementName = elementName;
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
   * @return the elementName
   */
  public String getElementName() {
    return elementName;
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
