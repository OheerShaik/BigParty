package com.eduworld.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.eduworld.entities.Elephant;
import com.eduworld.entities.Employee2;

@Component
public class HomeDaoImpl implements HomeDao {
	
	@Autowired(required=true)
	@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemp;

	@Override
	public Object getHomePage(Object input) {
		
		Elephant elh = new Elephant();//.get(Elephant.class, 1);
		//elh.setId(23);
		elh.setLocation("Delhi");
		elh.setName("Rhama");
		hibernateTemp.save(elh);
		return "This is Test Page";
	}

}
