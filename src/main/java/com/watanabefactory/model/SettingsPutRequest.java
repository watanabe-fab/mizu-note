package com.watanabefactory.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * SettingsPutRequest
 */

@JsonTypeName("_settings_put_request")
public class SettingsPutRequest {

  private Integer maxWaterUsage;

  public SettingsPutRequest maxWaterUsage(Integer maxWaterUsage) {
    this.maxWaterUsage = maxWaterUsage;
    return this;
  }

  /**
   * 新しい取水量の上限
   * @return maxWaterUsage
   */
  @JsonProperty("maxWaterUsage")
  public Integer getMaxWaterUsage() {
    return maxWaterUsage;
  }

  public void setMaxWaterUsage(Integer maxWaterUsage) {
    this.maxWaterUsage = maxWaterUsage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SettingsPutRequest settingsPutRequest = (SettingsPutRequest) o;
    return Objects.equals(this.maxWaterUsage, settingsPutRequest.maxWaterUsage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxWaterUsage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SettingsPutRequest {\n");
    sb.append("    maxWaterUsage: ").append(toIndentedString(maxWaterUsage)).append("\n");
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

