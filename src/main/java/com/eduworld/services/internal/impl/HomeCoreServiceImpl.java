package com.eduworld.services.internal.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduworld.dao.HomeDao;

@Service
public class HomeCoreServiceImpl implements HomeCoreService{
	
	@Autowired(required=true)
	private HomeDao homeDao;
	
	
	
	
	
	@Override
	public Object getHomePage(Object input) {
		// TODO Auto-generated method stub
		if(true)
		return "Home.html";
		
		return homeDao.getHomePage(input);
	}


	public HomeDao getHomeDao() {
		return homeDao;
	}

	public void setHomeDao(HomeDao homeDao) {
		this.homeDao = homeDao;
	}

	
}
