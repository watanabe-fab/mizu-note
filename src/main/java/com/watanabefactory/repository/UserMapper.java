package com.watanabefactory.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.watanabefactory.repository.entity.User;

@Mapper
public interface UserMapper {

	@Select("select id, email, password, max_water_usage from user where id = #{userId}")
	User findByPk(Integer userId);

	@Update("update user set max_water_usage = #{maxWaterUsage}")
	void updateMaxWaterUsage(Integer maxWaterUsage);
}
