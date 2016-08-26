/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet;

import net.packet.exception.PacketException;
import net.packet.pojo.Facilities;
import net.packet.pojo.OperatingSystems;
import net.packet.pojo.Plans;
import net.packet.pojo.Project;
import net.packet.pojo.Projects;

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

}
