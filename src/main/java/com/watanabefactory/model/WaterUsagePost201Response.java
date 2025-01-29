package com.watanabefactory.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * WaterUsagePost201Response
 */

@JsonTypeName("_water_usage_post_201_response")
public class WaterUsagePost201Response {

  private Boolean success;

  private String message;

  public WaterUsagePost201Response success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * 登録結果
   * @return success
   */
  @JsonProperty("success")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public WaterUsagePost201Response message(String message) {
    this.message = message;
    return this;
  }

  /**
   * 登録メッセージ
   * @return message
   */
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WaterUsagePost201Response waterUsagePost201Response = (WaterUsagePost201Response) o;
    return Objects.equals(this.success, waterUsagePost201Response.success) &&
        Objects.equals(this.message, waterUsagePost201Response.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WaterUsagePost201Response {\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

