/**
 * Copyright (c) The packet-java Authors, All rights reserved.
 * 
 * packet-java source code and usage is governed by a MIT style license that can be found in the
 * LICENSE file
 */

package net.packet.pojo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Error response.
 * 
 * @author Jeevanandam M. (https://github.com/jeevatkm)
 * @since v1.0.0
 */
public class Error extends AbstractBase {

  private String error;

  private List<String> errors;

  public String getAllErrors() {
    String allErrors = StringUtils.join(errors, ",\n");
    if (StringUtils.isNotBlank(error)) {
      allErrors = error + ",\n" + allErrors;
    }
    return allErrors;
  }

  /**
   * @return the error
   */
  public String getError() {
    return error;
  }

  /**
   * @param error the error to set
   */
  public void setError(String error) {
    this.error = error;
  }

  /**
   * @return the errors
   */
  public List<String> getErrors() {
    return errors;
  }

  /**
   * @param errors the errors to set
   */
  public void setErrors(List<String> errors) {
    this.errors = errors;
  }

}
