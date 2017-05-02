package model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.User;

public final class UserApi {
	public static void add(User user) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
	}
}
