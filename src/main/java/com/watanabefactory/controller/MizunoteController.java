package com.watanabefactory.controller;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.watanabefactory.model.SettingsPut200Response;
import com.watanabefactory.model.SettingsPutRequest;
import com.watanabefactory.model.WaterUsageGetResponse;
import com.watanabefactory.model.WaterUsageGetResponseDailyUsageDetailsInner;
import com.watanabefactory.model.WaterUsagePost201Response;
import com.watanabefactory.model.WaterUsagePostRequest;
import com.watanabefactory.model.WaterUsagePut200Response;
import com.watanabefactory.model.WaterUsagePutRequest;
import com.watanabefactory.service.MizunoteService;
import com.watanabefactory.service.MizunoteService.DashBoardDto;
import com.watanabefactory.service.MizunoteService.RegisterWaterUsageDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
public class MizunoteController {

	private MizunoteService mizunoteService;

	public MizunoteController(MizunoteService mizunoteService) {
		this.mizunoteService = mizunoteService;
	}

	/**
	 * 取水量の取得
	 * 指定したユーザの当日の取水量や関連情報を取得します。
	 * 
	 * @param userId
	 * @return {@see WaterUsageGet200Response} 取水量の取得結果
	 */
	@GetMapping(value = "/water-usage", produces = { "application/json" })
	ResponseEntity<WaterUsageGetResponse> getWaterUsage(
			@NotNull @Valid @RequestParam(value = "userId", required = true) Integer userId) {
		final DashBoardDto dto = mizunoteService.getWaterUsage(userId);

		if (dto.maxWaterUsage() < 0) {
			return ResponseEntity.notFound().build();
		}

		final WaterUsageGetResponse response = new WaterUsageGetResponse();
		response.setDailyWaterUsage(dto.dailyWaterUsage());
		response.setMaxWaterUsage(dto.maxWaterUsage());
		response.setDailyUsageDetails(
				dto.waterDailyUsages().stream()
						.map(item -> {
							final var model = new WaterUsageGetResponseDailyUsageDetailsInner();
							model.id(item.id());
							model.amount(item.amount());
							model.timestamp(item.updatedAt());
							return model;
						})
						.collect(Collectors.toList()));

		return ResponseEntity.ok().body(response);
	}

	/**
	 * 取水量の登録
	 * 新しい取水量を登録します。
	 * 
	 * @param waterUsagePostRequest
	 * @return
	 */
	@PostMapping(value = "/water-usage", produces = { "application/json" }, consumes = { "application/json" })
	ResponseEntity<WaterUsagePost201Response> postWaterUsage(
			@Valid @RequestBody WaterUsagePostRequest waterUsagePostRequest) {
		final var dto = new RegisterWaterUsageDto(
				waterUsagePostRequest.getUserId(),
				waterUsagePostRequest.getAmount());

		mizunoteService.registerWaterUsage(dto);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * 取水量の更新
	 * 登録済みの取水量を更新します。
	 * 
	 * @param waterUsagePutRequest
	 * @return
	 */
	@PutMapping(value = "/water-usage", produces = { "application/json" }, consumes = { "application/json" })
	ResponseEntity<WaterUsagePut200Response> putWaterUsage(
			@Valid @RequestBody WaterUsagePutRequest waterUsagePutRequest) {
		mizunoteService.updateWaterUsage(
				waterUsagePutRequest.getUserId(),
				waterUsagePutRequest.getWaterUsageId(),
				waterUsagePutRequest.getAmount());

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * 設定の更新
	 * ユーザの取水量上限を更新します。
	 * 
	 * @param settingsPutRequest
	 * @return
	 */
	@PutMapping(value = "/settings", produces = { "application/json" }, consumes = { "application/json" })
	ResponseEntity<SettingsPut200Response> putSettings(@Valid @RequestBody SettingsPutRequest settingsPutRequest) {
		mizunoteService.updateSetttings(settingsPutRequest.getMaxWaterUsage());

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
