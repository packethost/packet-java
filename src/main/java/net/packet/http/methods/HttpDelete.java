/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.http.methods;

import java.net.URI;

import org.apache.http.client.methods.HttpPost;

/**
 * Custom delete HTTP client method with Payload support.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class HttpDelete extends HttpPost {

  public HttpDelete(URI uri) {
    super(uri);
  }

  public HttpDelete(String url) {
    super(url);
  }

  @Override
  public String getMethod() {
    return "DELETE";
  }

}
