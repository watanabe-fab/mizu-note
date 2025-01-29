package com.watanabefactory.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.watanabefactory.repository.entity.WaterDailyUsage;

@Mapper
public interface WaterUsageMapper {

	@Select("select water_amount, updated_at from water_usages where user_id = #{userId}")
	List<WaterDailyUsage> findByUserId(Integer userId);
	
	@Insert("insert into water_usages (user_id, water_amount, created_at, updated_at, deleted_flag) values (#{userId}, #{waterAmount}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);")
	void insertWaterUsage(Integer userId, Integer waterAmount);
}
