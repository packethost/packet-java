/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.serializer;

import java.lang.reflect.Type;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import net.packet.pojo.Project;

/**
 * Serializer for {@link Project}.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class ProjectSerializer implements JsonSerializer<Project> {

  @Override
  public JsonElement serialize(Project src, Type typeOfSrc, JsonSerializationContext context) {
    final JsonObject jsonObject = new JsonObject();

    if (StringUtils.isNotBlank(src.getName())) {
      jsonObject.addProperty("name", src.getName());
    }

    if (StringUtils.isNotBlank(src.getPaymentMethodId())) {
      jsonObject.addProperty("payment_method", src.getPaymentMethodId());
    }

    return jsonObject;
  }

}
