package com.watanabefactory.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.watanabefactory.repository.entity.WaterDailyUsage;

@Mapper
public interface WaterUsageMapper {

	@Select("select id, water_amount, updated_at from water_usages where user_id = #{userId} and updated_at >= CURRENT_DATE and updated_at < (CURRENT_DATE + INTERVAL '1' DAY);")
	List<WaterDailyUsage> findByUserId(Integer userId);

	@Insert("insert into water_usages (user_id, water_amount, created_at, updated_at, deleted_flag) values (#{userId}, #{waterAmount}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 0);")
	void insertWaterUsage(Integer userId, Integer waterAmount);

	@Update("update water_usages set water_amount = #{amount}, updated_at = CURRENT_TIMESTAMP where user_id = #{userId} and id = #{waterUsageId};")
	void updateWaterUsage(Integer userId, Integer waterUsageId, Integer amount);
}
