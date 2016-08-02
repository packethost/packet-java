/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.http;

/**
 * Packet API client HTTP Header Names.
 * 
 * <p>
 * It has only header(s) used by Packet API client.
 * </p>
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public interface HttpHeader {

  String ACCEPT = "Accept";

  String CONTENT_TYPE = "Content-Type";

  String USER_AGENT = "User-Agent";

  String AUTHORIZATION = "X-Auth-Token";

}
