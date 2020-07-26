package jp.matrix.app;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import oracle.jdbc.pool.OracleDataSource;

import jp.matrix.service.UserRepository;
import jp.matrix.service.UserService;
import jp.matrix.service.UserServiceImpl;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
	private @Value("${datasource.driver-class-name}") String driverClassName;
	private @Value("${datasource.url}") String url;
	private @Value("${datasource.username}") String username;
	private @Value("${datasource.password}") String password;

	@Bean(destroyMethod = "close")
	DataSource dataSource()
	{
		OracleDataSource ds = null;
		try
		{
			ds = new OracleDataSource();
			ds.setDriverType(this.driverClassName);
			ds.setURL(this.url);
			ds.setUser(this.username);
			ds.setPassword(this.password);
			return (DataSource)ds;	
		}
		catch (SQLException ex)
		{
			return null;
		}
	}
	
	@Bean
	UserRepository userRespository()
	{
		UserServiceImpl imp = new UserServiceImpl(this.dataSource());
		return imp.getUserRepository();
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserService userService()
	{
		return new UserServiceImpl(userRespository(), passwordEncoder());
	}
}
