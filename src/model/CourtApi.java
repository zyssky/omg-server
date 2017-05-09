package model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.junit.FixMethodOrder;

import entity.Court;

public class CourtApi {
	private Session session;
	
	public CourtApi() {
		session = HibernateUtil.getCurrentSession();
		session.getTransaction().begin();
	}
	
	
	public List<Court> getCourts() {
		List<Court> result = null;
		try {
			String hql = "from Court";
			result = session.createQuery(hql).list();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return result;
	}
	
	public Court getCourt(String title) {
		Court court = null;
		try {
			
			String hql = "FROM Court WHERE title = ?";
			List<Court> list = session.createQuery(hql,Court.class).setParameter(0, title).getResultList();
			if(!list.isEmpty())
				court = list.get(0);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return court;
	}
	
	
	public void deleteCourt(String title){
		try {
			String hql = "delete from Court where title = ?";
			int row = session.createQuery(hql).setParameter(0, title).executeUpdate();
			session.getTransaction().commit();
			System.out.println(row+" row affected");
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	
	public void updateCourt(Court court){
		try {
			session.update(court);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	
	public void addCourt(Court court){
		try {
			session.save(court);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
