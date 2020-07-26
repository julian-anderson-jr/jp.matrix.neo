package jp.matrix.service;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

public interface UserService {
	boolean auth(User user) throws Throwable;
	void register(User user, String rawPassword) throws Throwable;
}
