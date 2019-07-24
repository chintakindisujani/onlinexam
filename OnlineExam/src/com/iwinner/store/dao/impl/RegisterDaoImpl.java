package com.iwinner.store.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.dao.RegisterDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.User;

@Repository
public class RegisterDaoImpl implements RegisterDaoIF {
	@Autowired
	private SessionFactory sessionFactory;
	
	private static Logger logger=Logger.getLogger(RegisterDaoImpl.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
   @Transactional	
   public int persistNewUser(User user)throws DaoException{
	   Integer startCode=StoreConstants.START_DEFAULT_CODE;
	  logger.info("Enter Into the persistNewUser() "+user);  
	  Session session=sessionFactory.openSession();
	  Transaction tx=session.beginTransaction();
	  tx.begin();
	  try{
	  User userChecking=(User)session.get(User.class, user.getUsername());
	  if(userChecking!=null){
		  startCode=StoreConstants.USER_EXISTS;
	  }else{
		  session.save(user);
		  startCode=StoreConstants.USER_CREATED;
	  }
	  }catch(DataAccessException dae){
		  tx.rollback();
		   startCode=StoreConstants.SYSTEM_ERROR;
	  }
	  finally{
		  tx.commit();
	  }
	  logger.info("Exit Into the persistNewUser() ");
	return startCode;
}
	
}
