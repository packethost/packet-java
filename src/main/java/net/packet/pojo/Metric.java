/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

/**
 * Metric For device traffic details
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Metric extends AbstractBase {

  private Integer tag;

  @SerializedName("class_id")
  private String classId;

  @SerializedName("mac_src")
  private String macSource;

  @SerializedName("mac_dst")
  private String macDestination;

  private Integer vlan;

  @SerializedName("as_src")
  private Integer asSource;

  @SerializedName("as_dst")
  private Integer asDestination;

  @SerializedName("ip_src")
  private String ipSource;

  @SerializedName("ip_dst")
  private String ipDestination;

  @SerializedName("port_src")
  private Integer portSource;

  @SerializedName("port_dst")
  private Integer portDestination;

  @SerializedName("tcp_flags")
  private Integer tcpFlags;

  @SerializedName("ip_proto")
  private Integer ipProtocol;

  private Integer tos;

  private Integer packets;

  private Integer bytes;

  private Integer flows;

  @SerializedName("stamp_inserted")
  private Date stampInserted;

  @SerializedName("stamp_updated")
  private Date stampUpdated;

  /**
   * @return the tag
   */
  public Integer getTag() {
    return tag;
  }

  /**
   * @param tag the tag to set
   */
  public void setTag(Integer tag) {
    this.tag = tag;
  }

  /**
   * @return the classId
   */
  public String getClassId() {
    return classId;
  }

  /**
   * @param classId the classId to set
   */
  public void setClassId(String classId) {
    this.classId = classId;
  }

  /**
   * @return the macSource
   */
  public String getMacSource() {
    return macSource;
  }

  /**
   * @param macSource the macSource to set
   */
  public void setMacSource(String macSource) {
    this.macSource = macSource;
  }

  /**
   * @return the macDestination
   */
  public String getMacDestination() {
    return macDestination;
  }

  /**
   * @param macDestination the macDestination to set
   */
  public void setMacDestination(String macDestination) {
    this.macDestination = macDestination;
  }

  /**
   * @return the vlan
   */
  public Integer getVlan() {
    return vlan;
  }

  /**
   * @param vlan the vlan to set
   */
  public void setVlan(Integer vlan) {
    this.vlan = vlan;
  }

  /**
   * @return the asSource
   */
  public Integer getAsSource() {
    return asSource;
  }

  /**
   * @param asSource the asSource to set
   */
  public void setAsSource(Integer asSource) {
    this.asSource = asSource;
  }

  /**
   * @return the asDestination
   */
  public Integer getAsDestination() {
    return asDestination;
  }

  /**
   * @param asDestination the asDestination to set
   */
  public void setAsDestination(Integer asDestination) {
    this.asDestination = asDestination;
  }

  /**
   * @return the ipSource
   */
  public String getIpSource() {
    return ipSource;
  }

  /**
   * @param ipSource the ipSource to set
   */
  public void setIpSource(String ipSource) {
    this.ipSource = ipSource;
  }

  /**
   * @return the ipDestination
   */
  public String getIpDestination() {
    return ipDestination;
  }

  /**
   * @param ipDestination the ipDestination to set
   */
  public void setIpDestination(String ipDestination) {
    this.ipDestination = ipDestination;
  }

  /**
   * @return the portSource
   */
  public Integer getPortSource() {
    return portSource;
  }

  /**
   * @param portSource the portSource to set
   */
  public void setPortSource(Integer portSource) {
    this.portSource = portSource;
  }

  /**
   * @return the portDestination
   */
  public Integer getPortDestination() {
    return portDestination;
  }

  /**
   * @param portDestination the portDestination to set
   */
  public void setPortDestination(Integer portDestination) {
    this.portDestination = portDestination;
  }

  /**
   * @return the tcpFlags
   */
  public Integer getTcpFlags() {
    return tcpFlags;
  }

  /**
   * @param tcpFlags the tcpFlags to set
   */
  public void setTcpFlags(Integer tcpFlags) {
    this.tcpFlags = tcpFlags;
  }

  /**
   * @return the ipProtocol
   */
  public Integer getIpProtocol() {
    return ipProtocol;
  }

  /**
   * @param ipProtocol the ipProtocol to set
   */
  public void setIpProtocol(Integer ipProtocol) {
    this.ipProtocol = ipProtocol;
  }

  /**
   * @return the tos
   */
  public Integer getTos() {
    return tos;
  }

  /**
   * @param tos the tos to set
   */
  public void setTos(Integer tos) {
    this.tos = tos;
  }

  /**
   * @return the packets
   */
  public Integer getPackets() {
    return packets;
  }

  /**
   * @param packets the packets to set
   */
  public void setPackets(Integer packets) {
    this.packets = packets;
  }

  /**
   * @return the bytes
   */
  public Integer getBytes() {
    return bytes;
  }

  /**
   * @param bytes the bytes to set
   */
  public void setBytes(Integer bytes) {
    this.bytes = bytes;
  }

  /**
   * @return the flows
   */
  public Integer getFlows() {
    return flows;
  }

  /**
   * @param flows the flows to set
   */
  public void setFlows(Integer flows) {
    this.flows = flows;
  }

  /**
   * @return the stampInserted
   */
  public Date getStampInserted() {
    return stampInserted;
  }

  /**
   * @param stampInserted the stampInserted to set
   */
  public void setStampInserted(Date stampInserted) {
    this.stampInserted = stampInserted;
  }

  /**
   * @return the stampUpdated
   */
  public Date getStampUpdated() {
    return stampUpdated;
  }

  /**
   * @param stampUpdated the stampUpdated to set
   */
  public void setStampUpdated(Date stampUpdated) {
    this.stampUpdated = stampUpdated;
  }

}
