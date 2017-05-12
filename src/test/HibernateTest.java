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
//		Court court2 = new Court("badminton","badminton is white","badminton is a ball","http://the.url.to.get.image",35.5,20);
//		new CourtApi().addCourt(court2);
//		Court court2 = new CourtApi().getCourt("tennis");
//		System.out.println(court2.getDescription());
//		court2.setFieldNum(10);
//		new CourtApi().updateCourt(court2);
//	}
	
	@Test
	public void testOrder(){
		long userId = 12;
//		Order order = new Order(userId,"tennis",3,new Date(),new Date(),new Date(new Date().getTime()+(long) 60*60*2*1000),"do not forget");
//		Order order3 =  new Order(userId,"badminton",3,new Date(),new Date(),new Date(new Date().getTime()+(long) 60*60*1*1000),"do not forget");
//		new OrderApi().addOrder(order3);
//		new OrderApi().addOrder(order);
//		List<Order> list = new OrderApi().getOrders(userId);
//		for (Order order2 : list) {
//			System.out.println(order2.getCourtTitle()+" count: "+order2.getCountNum());
//		}
//		new OrderApi().deleteOrder(list.get(0).getId());
	}
	
}
