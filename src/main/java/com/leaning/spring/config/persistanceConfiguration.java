package com.leaning.spring.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class persistanceConfiguration {
	@Bean
	public DataSource dataSource() {
		
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("Sasi@5451");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/conference_demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	//	System.out.println("Coustome database set up");
		return dataSourceBuilder.build();
		
	}

}
