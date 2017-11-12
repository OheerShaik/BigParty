








package com.eduworld.authentication;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException autExcep)
			throws IOException, ServletException {
		
		resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "UnAuthorized Access!");
	}

}
