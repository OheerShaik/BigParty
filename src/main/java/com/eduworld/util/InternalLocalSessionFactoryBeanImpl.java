package com.eduworld.util;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

public class InternalLocalSessionFactoryBeanImpl extends LocalSessionFactoryBean {

	@Override
	public void setMappingResources(String... mappingResources) {
		// TODO Auto-generated method stub
		loadHBMFiles(mappingResources);
		
		super.setMappingResources(mappingResources);
	}
	
	
	public static void loadHBMFiles(String... resources){
		try {
			final List mappingList = new ArrayList();
			CollectionUtils.addAll(mappingList, Thread.currentThread().getContextClassLoader().getResources("hibernate-listing.txt"));
			for (Iterator iterator = mappingList.iterator(); iterator.hasNext();) {
				URL object = (URL) iterator.next();
				
			
			 String theString2 = IOUtils.toString(new FileInputStream(new File(object.getFile())), "UTF-8");
			 resources = theString2.split("\\r\\n");
			 
		        System.out.println(theString2);
			}
			System.out.println("Testing");
		}catch(Exception excep){
			excep.printStackTrace();
		}
		
	}
	
	
	

}
