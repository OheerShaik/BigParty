package com.eduworld.authentication;

import java.util.List;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;




public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		GrantedAuthority authority = null;
		
		String username = auth.getName();
		String password = auth.getCredentials().toString();
		
		
		if (authorizedUser(username, password))
		{
				//List<GrantedAuthority> grantedAuths = new java.util.ArrayList<GrantedAuthority>();
			
			List<GrantedAuthority> grantedAuths = new java.util.ArrayList<GrantedAuthority>();
				grantedAuths.add(new GrantedAuthorityImpl("AUTH_USER"));
				Authentication sucAuth = new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
				System.out.println(auth.getAuthorities());
				return auth;
		}
		else
		{
				throw new AuthenticationCredentialsNotFoundException("Invalid Credentials!");
		}
		
	}
	
	private boolean authorizedUser(String userName, String password)
	{
			System.out.println("username is :" + userName+" and password is "+password );
			if("Chandan".equals(userName) && "Chandan".equals(password))
					return true;
			return false;
	}
	

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
