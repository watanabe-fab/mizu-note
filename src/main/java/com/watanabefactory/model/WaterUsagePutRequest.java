package com.watanabefactory.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * WaterUsagePutRequest
 */
@JsonTypeName("_water_usage_put_request")
public class WaterUsagePutRequest {

  private Integer userId;
  private Integer waterUsageId;
  private Integer amount;

  public WaterUsagePutRequest amount(Integer userId, Integer waterUsageId, Integer amount) {
    this.userId = userId;
    this.waterUsageId = waterUsageId;
    this.amount = amount;
    return this;
  }

  /**
   * 更新するユーザID
   * 
   * @return userId
   */
  @JsonProperty("userId")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * 更新する取水量ID
   * 
   * @return waterUsageId
   */
  @JsonProperty("waterUsageId")
  public Integer getWaterUsageId() {
    return waterUsageId;
  }

  public void setWaterUsageId(Integer waterUsageId) {
    this.waterUsageId = waterUsageId;
  }

  /**
   * 更新する取水量
   * 
   * @return amount
   */
  @JsonProperty("amount")
  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WaterUsagePutRequest waterUsagePutRequest = (WaterUsagePutRequest) o;
    return Objects.equals(this.userId, waterUsagePutRequest.userId) &&
        Objects.equals(this.waterUsageId, waterUsagePutRequest.waterUsageId) &&
        Objects.equals(this.amount, waterUsagePutRequest.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, waterUsageId, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WaterUsagePostRequest {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    waterUsageId: ").append(toIndentedString(waterUsageId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
