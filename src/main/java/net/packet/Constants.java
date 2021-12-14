/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet;

/**
 * Equinix Metal API client constants.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public interface Constants {

  String UTF_8 = "utf-8";

  String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX";

  String UTC_TIMEZONE = "UTC";

  String HOSTNAME = "api.packet.net";

  String MEDIA_TYPE_JSON = "application/json";

  String ACCEPT_HDR_FORMAT = "%s; version=%s";

  String URI_SCHEME = "https";

  String USER_AGENT = "Packet API Client - https://github.com/packethost/packet-java";

}
