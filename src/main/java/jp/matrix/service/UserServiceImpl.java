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
		cr.andPWDEqualTo(user.getPassword());
		List<Userinfo> usr = userMapper.selectByExample(ex);
		if (usr.size() == 1)
		{
			if (usr.get(0).getLOCKING() == 1)
			{
				log.error(user.getName() + " is lockout now!");
				return -2; // lockout
			}
			List<String> role = new ArrayList<String>();
			switch(usr.get(0).getGPID())
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
		else if(usr.size() == 0) 
		{
			UserinfoExample ex2 = new UserinfoExample();
			UserinfoExample.Criteria cr2 = ex.createCriteria();
			cr2.andSIDEqualTo(user.getName());
			List<Userinfo> usr2 = userMapper.selectByExample(ex2);
			if (usr2.size() == 1)
			{
				usr2.get(0).setLOCKING((short)1);
				userMapper.updateByPrimaryKey(usr2.get(0));
				log.error(user.getName() + " is lockout!");
			}
			
			return -1; // password or id error
		}
		return 0;
	}

}
