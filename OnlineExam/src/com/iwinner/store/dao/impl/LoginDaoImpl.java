package com.iwinner.store.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.dao.LoginDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.User;

@Repository
public class LoginDaoImpl implements LoginDaoIF {
	@Autowired
	private SessionFactory sessionFactory;

	private static Logger logger = Logger.getLogger(RegisterDaoImpl.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Integer loginDao(String username, String password)
			throws DaoException {
		Integer loginValue = StoreConstants.ZERO;
		logger.info("Enter Into the loginDao() ");
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery(StoreConstants.LOGIN_QUERY);
			query.setString("username", username);
			query.setString("password", password);
			List<Integer> listUser = query.list();
			if (listUser.size() > StoreConstants.ZERO) {
				loginValue = StoreConstants.SUCCESS_CODE;
			} else {
				loginValue = StoreConstants.USER_NOT_AVAIABLE;
			}
		} catch (DataAccessException dae) {
			loginValue = StoreConstants.SYSTEM_ERROR;
		}
		logger.info("Exit Into the loginDao()");
		return loginValue;
	}

	public User getLoginUserInfo(String username) throws DaoException {
		User user = new User();
		Session session = sessionFactory.openSession();
		if (session != null) {
			user = (User) session.load(User.class, username);
		}
		return user;
	}

public String findUser(String username)throws DaoException{
	logger.info("Enter Into the findUser Processing method "+username);
	String findUserAvaiable=StoreConstants.USER_AVAIABLE_PROCESSING;
	try{
	Session session=sessionFactory.openSession();
	User user=(User)session.get(User.class, username);
	if(user!=null){
		findUserAvaiable=StoreConstants.USER_AVAIABLE;
		logger.debug("Inside the  findUser Processing method "+findUserAvaiable);
	}else{
		logger.debug("Inside the  findUser Processing method "+findUserAvaiable);
		findUserAvaiable=StoreConstants.USER_NOT_AVAIABLE_;
	}
	}catch(DataAccessException dae){
		findUserAvaiable=StoreConstants.USER_AVAIABLE_ERROR;
		logger.error("Error Into the findUser()"+dae.getMessage());
	}
	return findUserAvaiable;
}
	public Map getRole() {
		Map getRole = new HashMap();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select * from User");

		return getRole;

	}

}
