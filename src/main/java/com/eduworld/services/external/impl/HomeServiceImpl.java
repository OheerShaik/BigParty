package com.eduworld.services.external.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.eduworld.services.internal.impl.HomeCoreService;



@Service
public class HomeServiceImpl implements HomeService{
	
	
	@Autowired(required=true)
	private HomeCoreService homeCoreService;
	
	
	
	
	@Override
	public Object getHomePage(Object input) {
		// TODO Auto-generated method stub
		return homeCoreService.getHomePage(input);
	}




	/*public HomeCoreService getHomeCoreService() {
		return homeCoreService;
	}




	public void setHomeCoreService(HomeCoreService homeCoreService) {
		this.homeCoreService = homeCoreService;
	}*/

	
	
	



	
	
	
	

}
