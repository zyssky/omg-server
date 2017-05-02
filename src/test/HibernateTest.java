package test;


import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import model.UserApi;
import entity.User;

public class HibernateTest {
	@Test
	public void testUser(){
		User user = new User();
		user.setUsername("hello2");
		UserApi.add(user);
	}
	
	
}
