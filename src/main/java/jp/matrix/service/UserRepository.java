package jp.matrix.service;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public interface UserRepository {
	User save(User user);
	
	int countByUsername(String username);
}
