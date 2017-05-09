package test;


import java.util.Date;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import model.CourtApi;
import model.OrderApi;
import model.UserApi;
import entity.Court;
import entity.Order;
import entity.User;

public class HibernateTest {
//	@Test
//	public void testUser(){
//		User user = new User("zyssky","123456",103.5,50);
//		
//		new UserApi().add(user);
//		User user2 = new UserApi().getUser("zyssky");
//		System.out.println(user2.getPassword());
//		user2.setPassword("654321");
//		new UserApi().updateUser(user2);
//		
//	}
//	
//	@Test
//	public void testCourt(){
//		Court court = new Court("tennis","tennis is green","tennis is a ball","http://the.url.to.get.image",60,5);
//		new CourtApi().addCourt(court);
//		Court court2 = new CourtApi().getCourt("tennis");
//		System.out.println(court2.getDescription());
//		court2.setFieldNum(10);
//		new CourtApi().updateCourt(court2);
//		
//		new CourtApi().deleteCourt("badminton1");
//		
//	}
	
	@Test
	public void testOrder(){
		long userId = 123456789;
		Order order = new Order(userId,"tennis",3,new Date(2017,5,8),new Date(2017,5,8,10,30),new Date(2017,5,8,12,0),"do not forget");
		Order order3 =  new Order(userId,"badminton",3,new Date(2017,5,8),new Date(2017,5,8,10,30),new Date(2017,5,8,12,0),"do not forget");
		new OrderApi().addOrder(order3);
		new OrderApi().addOrder(order);
		List<Order> list = new OrderApi().getOrders(userId);
		for (Order order2 : list) {
			System.out.println(order2.getCourtTitle()+" count: "+order2.getCountNum());
		}
		new OrderApi().deleteOrder(list.get(0).getId());
	}
	
}
