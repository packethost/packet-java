/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.serializer;

import java.lang.reflect.Type;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import net.packet.pojo.Device;

/**
 * Serializer for {@link Device}
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class DeviceSerializer implements JsonSerializer<Device> {

  @Override
  public JsonElement serialize(Device src, Type typeOfSrc, JsonSerializationContext context) {
    final JsonObject jsonObject = new JsonObject();

    if (StringUtils.isNotBlank(src.getHostname())) {
      jsonObject.addProperty("hostname", src.getHostname());
    }

    if (null != src.getPlan() && StringUtils.isNotBlank(src.getPlan().getSlug())) {
      jsonObject.addProperty("plan", src.getPlan().getSlug());
    }

    if (null != src.getBillingCycle()) {
      jsonObject.addProperty("billing_cycle", src.getBillingCycle().getValue());
    }

    if (null != src.getOperatingSystem()
        && StringUtils.isNotBlank(src.getOperatingSystem().getSlug())) {
      jsonObject.addProperty("operating_system", src.getOperatingSystem().getSlug());
    }

    if (null != src.getFacility() && StringUtils.isNotBlank(src.getFacility().getCode())) {
      jsonObject.addProperty("facility", src.getFacility().getCode());
    }

    if (StringUtils.isNotBlank(src.getUserdata())) {
      jsonObject.addProperty("userdata", src.getUserdata());
    }

    if (null != src.isLocked()) {
      jsonObject.addProperty("locked", src.isLocked().booleanValue());
    }

    if (null != src.getFeatures()) {
      final JsonObject features = new JsonObject();
      for (Map.Entry<String, String> entry : src.getFeatures().entrySet()) {
        features.addProperty(entry.getKey(), entry.getValue());
      }
      jsonObject.add("features", features);
    }

    if (null != src.getTags()) {
      final JsonArray tags = new JsonArray();
      for (String tag : src.getTags()) {
        tags.add(context.serialize(tag));
      }
      jsonObject.add("tags", tags);
    }

    return jsonObject;
  }

}
