package com.iwinner.store.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.dao.StartUpDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.Vistior;

@Repository
public class StartUpDaoImpl  implements StartUpDaoIF    {
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void peristVistiorInfo(Vistior vistiorInfo) throws DaoException {
		Session session =sessionFactory.openSession();
	    Transaction transaction=session.beginTransaction();
	    vistiorInfo.setId(getMaxId()+StoreConstants.ADD_ONE);
	    transaction.begin();
	    session.save(vistiorInfo);
	    transaction.commit();

	}
	
	public  Integer getMaxId()throws DaoException{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("select Max(id) from  Vistior");
		List<Integer> listOfMax=query.list();
		Integer maxValue=listOfMax.get(0);
		return maxValue;
	}
}
