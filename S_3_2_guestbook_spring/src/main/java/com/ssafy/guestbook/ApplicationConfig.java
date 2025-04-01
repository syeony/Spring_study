package com.ssafy.guestbook;


import java.sql.Driver;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class ApplicationConfig {
    
    @SuppressWarnings("unchecked")
	@Bean
    public DataSource dataSource() {
        SimpleDriverDataSource ds = new SimpleDriverDataSource();
        try {
			ds.setDriverClass((Class<Driver>) Class.forName("com.mysql.cj.jdbc.Driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8");
        ds.setUsername("ssafy");
        ds.setPassword("ssafy");
        return ds;
    }

}
