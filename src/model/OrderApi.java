package model;

import java.util.List;

import org.hibernate.Session;

import entity.Court;
import entity.Order;

public class OrderApi {
	private Session session;
	
	public OrderApi(){
		session = HibernateUtil.getCurrentSession();
		session.getTransaction().begin();
	}
	
	public List<Order>getOrders(long id){
		List<Order> result = null;
		try {
			String hql = "from Order where userId = ?";
			result = session.createQuery(hql).setParameter(0, id).list();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return result;
	}
	
	public Order getOrder(long id) {
		Order order = null;
		try {
			
			String hql = "FROM Order WHERE id = ?";
			List<Order> list = session.createQuery(hql,Order.class).setParameter(0, id).getResultList();
			if(!list.isEmpty())
				order = list.get(0);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return order;
	}
	
	public void deleteOrder (long id){
		try {
			String hql = "delete from Order where id =?";
			int row = session.createQuery(hql).setParameter(0, id).executeUpdate();
			session.getTransaction().commit();
			System.out.println(row+" row affected");
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	
	public void addOrder(Order order){
		try {
			session.save(order);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
