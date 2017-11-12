package com.eduworld.interceptor;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.eduworld.authentication.CryptoSecurityApp;
import com.eduworld.constants.RequestHeadersConstants;
import com.fis.security.exceptions.ApplicationAuthenticationException;
@Component
public class ApplicationInterceptor implements HandlerInterceptor{
	
	private CryptoSecurityApp encryAndDecrypt;
	private String securFormat;
	private String splitter;
	

	//Map<String, String> userAndPwd = new LinkedHashMap<String, String>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
		boolean isAuth = false;
		final String AUTHORIZATION = RequestHeadersConstants.X_AUTH_TOKEN;
		//Long mills = DateUtil.getTimeNext15MinInMills();
		String encReqAuth = request.getHeader(AUTHORIZATION);
		if (StringUtils.isEmpty(encReqAuth)) {
			throw new ApplicationAuthenticationException("X-Auth-Token does not exist in request header");
		}
		return isAuth = encryAndDecrypt.getAuthenticateion(encReqAuth);
		
		/*if (isAuth ) {
			response.setHeader(AUTHORIZATION, encryAndDecrypt.ecrypt(securFormat+""+splitter+mills));
			return true;
		}*/
		//return false;
		
		}
		catch(Exception authExcep){
			if (authExcep instanceof ApplicationAuthenticationException) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST,authExcep.getMessage());
				return false;
			}
			else {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, authExcep.getMessage());
				return false;
			}
			
		}
		
		
	/*	if (reqAuth == null && ) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Un-Authorized User");
		}*/
		
		/*String username = request.getHeader("username");
		String password = request.getHeader("password");
		if (username.equals(password)) {
			return true;
		}
		else {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User is invalid");
			return false;
		}
		*/
		/*response.setHeader("username", "fdsfds");
		response.setHeader("password", "sfdsfsdf");
		return true;*/
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		response.setHeader("username", request.getHeader("username"));
		response.setHeader("password", request.getHeader("password"));
			System.out.println("Post-Handle Interceptor");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		response.setHeader("username", "fdsfds");
		response.setHeader("password", "sfdsfsdf");
			System.out.println("After-Completion");
	}

	public void setEncryAndDecrypt(CryptoSecurityApp encryAndDecrypt) {
		this.encryAndDecrypt = encryAndDecrypt;
	}


	public void setSecurFormat(String securFormat) {
		this.securFormat = securFormat;
	}
	public void setSplitter(String splitter) {
		this.splitter = splitter;
	}
	
	private void sessionAuth(HttpServletRequest req,HttpServletResponse resp){
		HttpSession sess = req.getSession(false);
		
		System.out.println("Session Test");
	}
	
	
	
	
	

}
