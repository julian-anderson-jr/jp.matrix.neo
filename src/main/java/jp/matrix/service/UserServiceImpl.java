package jp.matrix.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import jp.matrix.dao.JdbcUserRepository;
import jp.matrix.dao.poko.Userinfo;
import jp.matrix.dao.poko.UserinfoExample;
import jp.matrix.exception.UserAlreadyRegisteredException;
import jp.matrix.mapper.poko.UserinfoMapper;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserinfoMapper userMapper;
	
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
	public int auth(User user) throws Throwable {
		// TODO Auto-generated method stub
		UserinfoExample ex = new UserinfoExample();
		UserinfoExample.Criteria cr = ex.createCriteria();
		cr.andSIDEqualTo(user.getName());
		//cr.andPWDEqualTo(user.getPassword());
		Userinfo usr = userMapper.selectByPrimaryKey(user.getName());
		if (!(usr == null))
		{
			if (usr.getLOCKING() == 1)
			{
				log.error(user.getName() + " is lockout now!");
				return -2; // lockout
			}
			if (!usr.getPWD().equals(user.getPassword()))
			{
				log.error(user.getName() + " is mistake id or password!");
				return -3; // password
			}
			List<String> role = new ArrayList<String>();
			switch(usr.getGPID())
			{
			case 1:
				role.add("USER");
				user.setRoles(role);
				break;
			case 2:
				role.add("USER");
				user.setRoles(role);
				break;
			case 99:
				role.add("ADMIN");
				user.setRoles(role);
				break;
			default:
				role.add("USER");
				user.setRoles(role);
				break;
			}
		}
		else 
		{
			UserinfoExample ex2 = new UserinfoExample();
			UserinfoExample.Criteria cr2 = ex.createCriteria();
			cr2.andSIDEqualTo(user.getName());
			Userinfo usr2 = userMapper.selectByPrimaryKey(user.getName());
			if (usr2 != null)
			{
				usr2.setLOCKING((short)1);
				userMapper.updateByPrimaryKey(usr2);
				log.error(user.getName() + " is lockout!");
			}
			
			return -1; // password or id error
		}
		return 0;
	}

}
