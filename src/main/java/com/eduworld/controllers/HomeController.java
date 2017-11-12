package com.eduworld.controllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.security.validator.UserSignUpDtoValidator;
import com.core.security.validator.UserSignUpDtoValidatorImpl;
import com.eduworld.services.external.impl.HomeService;
import com.eduworld.services.internal.impl.HomeCoreService;
import com.eduworld.vo.UserSignUpDto;

@Controller("HomeController")
@RequestMapping("/hmCntrl")
public class HomeController {
	
	

	@Autowired(required = true)
	private HomeService homeService;

	@Autowired(required = true)
	private HomeCoreService homeCoreService;

	@RequestMapping(value = "/getHomePAGE", method = RequestMethod.GET)
	@ResponseBody
	public Object geHomePage(Object input) {

		return homeService.getHomePage(input);
	}

	@RequestMapping(value = "/getHomePAGE", method = RequestMethod.POST)
	@ResponseBody
	public Object geHomePage(String input) {

		return homeService.getHomePage(input);
	}

	// @ResponseStatus(HttpStatus.OK)
	// @ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	@RequestMapping(value = "/userSignUp", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Object userSignUp(@Valid @RequestBody UserSignUpDto userSingUpDto, BindingResult result, HttpServletRequest request,
			HttpServletResponse resp) {
			UserSignUpDtoValidator validator = new UserSignUpDtoValidatorImpl();
			validator.validate(userSingUpDto, result);
		
		if (result.hasErrors()) {
			return result;
		}
		else {
			return userSingUpDto;
		}

		//return "This is Json Data";
	}

}
