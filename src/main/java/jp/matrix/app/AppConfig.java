package jp.matrix.app;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.Environment;
//import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.pool.OracleDataSource;
import jp.matrix.mapper.poko.BuylistMapper;
import jp.matrix.mapper.poko.GroupinfoMapper;
import jp.matrix.mapper.poko.PartsMapper;
import jp.matrix.mapper.poko.UserinfoMapper;
import jp.matrix.service.UserRepository;
import jp.matrix.service.UserService;
import jp.matrix.service.UserServiceImpl;

@Configuration
@PropertySource("classpath:application.properties")
@MapperScan("jp.matrix.mapper.poko")
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
	
	@Bean
	SqlSessionFactory sqlSessionFactory()
	{
		DataSource dataSource = dataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
		configuration.addMapper(BuylistMapper.class);
		configuration.addMapper(GroupinfoMapper.class);
		configuration.addMapper(PartsMapper.class);
		configuration.addMapper(UserinfoMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

		return sqlSessionFactory;
	
	}
}
