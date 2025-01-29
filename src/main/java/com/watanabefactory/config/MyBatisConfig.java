package com.watanabefactory.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	DataSourceProperties dataSourceProperties () {
		return new DataSourceProperties();
	}

	@Bean
    DataSource dataSource(DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
	  
    @Bean
    SqlSessionFactory sqlSessionFactory() throws Exception {
		var bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource(dataSourceProperties()));

		return bean.getObject();
	}
}
