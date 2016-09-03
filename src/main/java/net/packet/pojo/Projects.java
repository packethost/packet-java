/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

/**
 * Projects represents the collection project details.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Projects extends AbstractBase {

  private List<Project> projects;

  private Meta meta;

  /**
   * @return the projects
   */
  public List<Project> getProjects() {
    return projects;
  }

  /**
   * @param projects the projects to set
   */
  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  /**
   * @return the meta
   */
  public Meta getMeta() {
    return meta;
  }

  /**
   * @param meta the meta to set
   */
  public void setMeta(Meta meta) {
    this.meta = meta;
  }

}


