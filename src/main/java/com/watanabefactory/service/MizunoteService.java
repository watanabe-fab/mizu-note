package com.watanabefactory.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.watanabefactory.repository.UserMapper;
import com.watanabefactory.repository.WaterUsageMapper;
import com.watanabefactory.repository.entity.WaterDailyUsage;

@Service
public class MizunoteService {

	public record User(Integer id, String email, String password, Integer maxWaterUsage) {};
	public record DashBoardDto(Integer dailyWaterUsage, Integer maxWaterUsage, List<WaterDailyUsage> waterDailyUsages) {};
	public record RegisterWaterUsageDto(Integer userId, Integer waterUsage) {};
	
	private UserMapper userMapper;
	private WaterUsageMapper waterUsageMapper;
	
	public MizunoteService(UserMapper userMapper, WaterUsageMapper waterUsageMapper) {
		this.userMapper = userMapper;
		this.waterUsageMapper = waterUsageMapper;
	}
	
	public DashBoardDto getWaterUsage(Integer userId) {
		userMapper.findByPk(userId);
		final var user = userMapper.findByPk(userId);
		final var waterDailyUsages = waterUsageMapper.findByUserId(userId);
		final var dailyWaterUsage = waterDailyUsages.isEmpty() ? 
				Integer.valueOf(0) : waterDailyUsages.stream().map(item->item.amount()).collect(Collectors.summingInt( v -> v ));
		final var maxWaterUsage = user == null ? Integer.valueOf(-100) : user.maxWaterUsage();
		
		return new DashBoardDto(dailyWaterUsage, maxWaterUsage, waterDailyUsages);
	}
	
	public void registerWaterUsage(RegisterWaterUsageDto dto) {
		waterUsageMapper.insertWaterUsage(dto.userId(), dto.waterUsage());
	}
	
	public void updateSetttings(Integer maxWaterUsage) {
		userMapper.updateMaxWaterUsage(maxWaterUsage);
	}
}
