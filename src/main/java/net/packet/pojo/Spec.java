/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

/**
 * Spec represents values of NICs, Drives, Features, CPUs, Memory, etc.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Spec extends AbstractBase {

  private List<SpecDetail> nics;

  private List<SpecDetail> drives;

  private SpecDetail features;

  private List<SpecDetail> cpus;

  private SpecDetail memory;

  /**
   * @return the nics
   */
  public List<SpecDetail> getNics() {
    return nics;
  }

  /**
   * @param nics the nics to set
   */
  public void setNics(List<SpecDetail> nics) {
    this.nics = nics;
  }

  /**
   * @return the drives
   */
  public List<SpecDetail> getDrives() {
    return drives;
  }

  /**
   * @param drives the drives to set
   */
  public void setDrives(List<SpecDetail> drives) {
    this.drives = drives;
  }

  /**
   * @return the features
   */
  public SpecDetail getFeatures() {
    return features;
  }

  /**
   * @param features the features to set
   */
  public void setFeatures(SpecDetail features) {
    this.features = features;
  }

  /**
   * @return the cpus
   */
  public List<SpecDetail> getCpus() {
    return cpus;
  }

  /**
   * @param cpus the cpus to set
   */
  public void setCpus(List<SpecDetail> cpus) {
    this.cpus = cpus;
  }

  /**
   * @return the memory
   */
  public SpecDetail getMemory() {
    return memory;
  }

  /**
   * @param memory the memory to set
   */
  public void setMemory(SpecDetail memory) {
    this.memory = memory;
  }

}


