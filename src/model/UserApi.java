package model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Token;
import entity.User;

public class UserApi {
	
	private Session session;
	
	private static final int SUCCESS = 1;
	private static final int FAIL = 0;
	
	public UserApi(){
		session = HibernateUtil.getCurrentSession();
		session.getTransaction().begin();
	}
	
	public List<User> getUsers() {
		try {
			String hql = "from User";
			List<User> list = session.createQuery(hql,User.class).getResultList();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	
	
	public String add(User user) {
		try {
			session.save(user);
			String hql = "from User where username = ?";
			user = session.createQuery(hql,User.class).setParameter(0, user.getUsername()).list().get(0);
			String token = createOrUpdateToken(user.getId());
			session.getTransaction().commit();
			return token;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	
	public User getUser(String userName) {
		User user = null;
		try {
			String hql  = "from User where username = ?";
			user = session.createQuery(hql,User.class).setParameter(0, userName).list().get(0);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return user;
	}
	
	public User getUser(Long userId) {
		User user = null;
		try {
			String hql  = "from User where id = ?";
			user = session.createQuery(hql,User.class).setParameter(0, userId).list().get(0);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return user;
	}
	
	public long getUserIdFromToken(String token){
		String hql = "from Token where tokenString = ?";
		try {
			List<Token> list = session.createQuery(hql,Token.class).setParameter(0, token).getResultList();
			if(list.isEmpty()){
				return -1;
			}
			Token tokenEntity = list.get(0);
			tokenEntity.setAvailDate(new Date(new Date().getTime()+(long)60*60*24*30*1000));
			session.update(tokenEntity);
			session.getTransaction().commit();
			return tokenEntity.getUserId();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}
	
	public String login(String username , String password) {
			String tokenString = null;
			try {
				String hql = "from User where username = ? and password = ?";
				List<User> list = session.createQuery(hql,User.class).setParameter(0, username).setParameter(1, password).getResultList();
				if(!list.isEmpty()){
					User user = list.get(0);
					tokenString = createOrUpdateToken(user.getId());
				}
				session.getTransaction().commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		
		return tokenString;
	}
	
	private String createOrUpdateToken(long userId) throws Exception{
		Token token = new Token();
		token.setUserId(userId);
		token.setTokenString(UUID.randomUUID().toString());
		token.setAvailDate(new Date(new Date().getTime()+(long)60*60*24*30*1000));
		
		String hql = "delete from Token where userId = ?";
		session.createQuery(hql).setParameter(0, userId).executeUpdate();
		
		session.save(token);
		
		return token.getTokenString();
	}
	
//	public int updateCredit(int value) {
//		try {
//			String hql = "update User set "
//			session.
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	public int updateUser(User user) {
		try {
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			return FAIL;
		}
		return SUCCESS;
	}
}
