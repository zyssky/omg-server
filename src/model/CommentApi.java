package model;

import java.util.List;

import org.hibernate.Session;

import entity.Comment;
import entity.Order;

public class CommentApi {
	private Session session;
	
	public CommentApi(){
		session = HibernateUtil.getCurrentSession();
		session.getTransaction().begin();
	}
	
	public List<Comment> getComments(String title){
		List<Comment> result = null;
		try {
			String hql = "from Comment where courtTitle = ? order by date desc";
			result = session.createQuery(hql).setParameter(0, title).list();
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return result;
	}
	
	public int addComment(Comment comment){
		try {
			session.save(comment);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return 0;
	}
}
