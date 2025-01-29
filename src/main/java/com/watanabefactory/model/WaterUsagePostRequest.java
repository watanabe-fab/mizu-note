package com.watanabefactory.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * WaterUsagePostRequest
 */
@JsonTypeName("_water_usage_post_request")
public class WaterUsagePostRequest {

  private Integer userId;
  private Integer amount;

  public WaterUsagePostRequest amount(Integer userId, Integer amount) {
    this.userId = userId;
    this.amount = amount;
    return this;
  }

  /**
   * 登録するユーザID
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
   * 登録する取水量
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
    WaterUsagePostRequest waterUsagePostRequest = (WaterUsagePostRequest) o;
    return Objects.equals(this.userId, waterUsagePostRequest.userId) &&
    	   Objects.equals(this.amount, waterUsagePostRequest.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WaterUsagePostRequest {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

