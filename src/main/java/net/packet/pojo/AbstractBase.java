/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * Abstract base class for POJOs.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public abstract class AbstractBase {

  @Override
  public String toString() {
    return ReflectionToStringBuilder.toString(this);
  }

}
