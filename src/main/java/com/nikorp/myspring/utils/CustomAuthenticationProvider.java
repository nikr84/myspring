package com.nikorp.myspring.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private final static Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		var name = authentication.getName();
		var password = authentication.getCredentials().toString();
        
        logger.debug("USERNAME=" + name);
        
        ArrayList<GrantedAuthority> arrayList = new ArrayList<>();
        arrayList.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        arrayList.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
            		new Principal(name, password, arrayList), authentication.getCredentials(), arrayList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		 return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	class Principal {
		String username;
		String password;
		List<GrantedAuthority> authorities;
		
		public Principal(String username, String password, List<GrantedAuthority> authorities) {
			this.username = username;
			this.password = password;
			this.authorities = authorities;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<GrantedAuthority> getAuthorities() {
			return authorities;
		}

		public void setAuthorities(List<GrantedAuthority> authorities) {
			this.authorities = authorities;
		}
		
	}
}
