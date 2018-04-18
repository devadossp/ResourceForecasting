package com.cts.commsmedia.forecast.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cts.commsmedia.forecast.utils.RFConstants;
 
@Configuration
@ComponentScan(basePackages = RFConstants.COMMON.COM_CTS_COMMSMEDIA)
@PropertySource(value = { RFConstants.COMMON.CLASSPATH_APP_PROPERTIES })
public class ApplicationConfig {
 
    @Autowired
    private Environment env;
 
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(RFConstants.DATABASE.JDBC_DRIVER_CLASS_NAME));
		dataSource.setUrl(env.getRequiredProperty(RFConstants.DATABASE.JDBC_URL));
		dataSource.setUsername(env.getRequiredProperty(RFConstants.DATABASE.JDBC_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(RFConstants.DATABASE.JDBC_PASSWORD));
		return dataSource;
	}
 
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}
 
}
