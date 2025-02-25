package com.watanabefactory.model;

import java.time.OffsetDateTime;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.Valid;

/**
 * WaterUsageGet200ResponseDailyUsageDetailsInner
 */

@JsonTypeName("_water_usage_get_200_response_dailyUsageDetails_inner")
public class WaterUsageGetResponseDailyUsageDetailsInner {

  private Integer id;

  private Integer amount;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime timestamp;

  public WaterUsageGetResponseDailyUsageDetailsInner id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * 登録されたID
   * 
   * @return id
   */

  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public WaterUsageGetResponseDailyUsageDetailsInner amount(Integer amount) {
    this.amount = amount;
    return this;
  }

  /**
   * 登録された取水量
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

  public WaterUsageGetResponseDailyUsageDetailsInner timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * 登録日時
   * 
   * @return timestamp
   */
  @Valid
  @JsonProperty("timestamp")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WaterUsageGetResponseDailyUsageDetailsInner waterUsageGetResponseDailyUsageDetailsInner = (WaterUsageGetResponseDailyUsageDetailsInner) o;
    return Objects.equals(this.amount, waterUsageGetResponseDailyUsageDetailsInner.amount) &&
        Objects.equals(this.timestamp, waterUsageGetResponseDailyUsageDetailsInner.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WaterUsageGet200ResponseDailyUsageDetailsInner {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
