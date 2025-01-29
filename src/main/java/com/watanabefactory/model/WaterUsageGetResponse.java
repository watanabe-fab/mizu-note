package com.watanabefactory.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.validation.Valid;

/**
 * WaterUsageGet200Response
 */

@JsonTypeName("_water_usage_get_200_response")
public class WaterUsageGetResponse {

  private Integer dailyWaterUsage;

  private Integer maxWaterUsage;

  @Valid
  private List<@Valid WaterUsageGetResponseDailyUsageDetailsInner> waterDailyUsages = new ArrayList<>();

  public WaterUsageGetResponse dailyWaterUsage(Integer dailyWaterUsage) {
    this.dailyWaterUsage = dailyWaterUsage;
    return this;
  }

  /**
   * その日の取水量
   * @return dailyWaterUsage
   */
  
  @JsonProperty("dailyWaterUsage")
  public Integer getDailyWaterUsage() {
    return dailyWaterUsage;
  }

  public void setDailyWaterUsage(Integer dailyWaterUsage) {
    this.dailyWaterUsage = dailyWaterUsage;
  }

  public WaterUsageGetResponse maxWaterUsage(Integer maxWaterUsage) {
    this.maxWaterUsage = maxWaterUsage;
    return this;
  }

  /**
   * 取水量の上限
   * @return maxWaterUsage
   */
  
  @JsonProperty("maxWaterUsage")
  public Integer getMaxWaterUsage() {
    return maxWaterUsage;
  }

  public void setMaxWaterUsage(Integer maxWaterUsage) {
    this.maxWaterUsage = maxWaterUsage;
  }

  public WaterUsageGetResponse waterDailyUsages(List<@Valid WaterUsageGetResponseDailyUsageDetailsInner> waterDailyUsages) {
    this.waterDailyUsages = waterDailyUsages;
    return this;
  }

  public WaterUsageGetResponse addDailyUsageDetailsItem(WaterUsageGetResponseDailyUsageDetailsInner dailyUsageDetailsItem) {
    if (this.waterDailyUsages == null) {
      this.waterDailyUsages = new ArrayList<>();
    }
    this.waterDailyUsages.add(dailyUsageDetailsItem);
    return this;
  }

  /**
   * 登録した当日の取水量の一覧
   * @return waterDailyUsages
   */
  @Valid 
  @JsonProperty("waterDailyUsages")
  public List<@Valid WaterUsageGetResponseDailyUsageDetailsInner> getDailyUsageDetails() {
    return waterDailyUsages;
  }

  public void setDailyUsageDetails(List<@Valid WaterUsageGetResponseDailyUsageDetailsInner> waterDailyUsages) {
    this.waterDailyUsages = waterDailyUsages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WaterUsageGetResponse waterUsageGet200Response = (WaterUsageGetResponse) o;
    return Objects.equals(this.dailyWaterUsage, waterUsageGet200Response.dailyWaterUsage) &&
        Objects.equals(this.maxWaterUsage, waterUsageGet200Response.maxWaterUsage) &&
        Objects.equals(this.waterDailyUsages, waterUsageGet200Response.waterDailyUsages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dailyWaterUsage, maxWaterUsage, waterDailyUsages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WaterUsageGet200Response {\n");
    sb.append("    dailyWaterUsage: ").append(toIndentedString(dailyWaterUsage)).append("\n");
    sb.append("    maxWaterUsage: ").append(toIndentedString(maxWaterUsage)).append("\n");
    sb.append("    waterDailyUsages: ").append(toIndentedString(waterDailyUsages)).append("\n");
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

