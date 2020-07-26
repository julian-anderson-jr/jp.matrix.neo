package jp.matrix.service;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

import jp.matrix.dao.JdbcUserRepository;
import jp.matrix.exception.UserAlreadyRegisteredException;

@Component
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(javax.sql.DataSource dataSource)
	{
		this.userRepository = new JdbcUserRepository(dataSource);
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public UserServiceImpl(UserRepository userRep, BCryptPasswordEncoder passEnc)
	{
		this.userRepository = userRep;
		this.passwordEncoder = passEnc;
	}
	
	public UserRepository getUserRepository()
	{
		return this.userRepository;
	}
	
	@Override
	public void register(User user, String rawPassword) throws Throwable {
		// TODO Auto-generated method stub
		if (this.userRepository.countByUsername(user.getName()) > 0)
		{
			throw new UserAlreadyRegisteredException();
		}
		user.setPassword(this.passwordEncoder.encode(rawPassword));
		this.userRepository.save(user);
	}

	@Override
	public boolean auth(User user) throws Throwable {
		// TODO Auto-generated method stub
		return false;
	}

}
