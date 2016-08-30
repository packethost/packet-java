/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * SshKeys to get all the SSH Keys from an account.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class SshKeys extends AbstractBase {

  @SerializedName("ssh_keys")
  private List<SshKey> sshKeys;

  private Meta meta;

  /**
   * @return the sshKeys
   */
  public List<SshKey> getSshKeys() {
    return sshKeys;
  }

  /**
   * @param sshKeys the sshKeys to set
   */
  public void setSshKeys(List<SshKey> sshKeys) {
    this.sshKeys = sshKeys;
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
