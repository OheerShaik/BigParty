package com.core.security.validator;


import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;

import com.eduworld.vo.UserSignUpDto;

public class UserSignUpDtoValidatorImpl implements UserSignUpDtoValidator {

	@Override
	public boolean supports(Class<?> claaz) {
		// TODO Auto-generated method stub
		return UserSignUpDto.class.equals(claaz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserSignUpDto signUpDto = (UserSignUpDto)target;
		if (signUpDto.getFirstName() == null) {
			errors.reject("firstName","Must Not be null");
		}
		
		
	}

	

}
