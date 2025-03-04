package com.watanabefactory.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * WaterUsagePut200Response
 */
@JsonTypeName("_water_usage_put_200_response")
public class WaterUsagePut200Response {

  private Boolean success;

  private String message;

  public WaterUsagePut200Response success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * 更新結果
   * 
   * @return success
   */
  @JsonProperty("success")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public WaterUsagePut200Response message(String message) {
    this.message = message;
    return this;
  }

  /**
   * 更新メッセージ
   * 
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
    WaterUsagePut200Response waterUsagePut200Response = (WaterUsagePut200Response) o;
    return Objects.equals(this.success, waterUsagePut200Response.success) &&
        Objects.equals(this.message, waterUsagePut200Response.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(success, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WaterUsagePut200Response {\n");
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
