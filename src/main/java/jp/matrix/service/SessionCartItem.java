package jp.matrix.service;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;

import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(value= "sessionCartItem", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class SessionCartItem implements Serializable {

	private static final long serialVersionUID = 300L;

	private User user;
	
	private int gid;
	
	private CartItem cartItems;
}
