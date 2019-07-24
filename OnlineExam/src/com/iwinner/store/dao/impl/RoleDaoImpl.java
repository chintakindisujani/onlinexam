package com.iwinner.store.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iwinner.store.dao.RoleDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.UserRole;
import com.iwinner.store.utils.HibernateUtils;

@Repository
public class RoleDaoImpl implements RoleDaoIF{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static Logger logger=Logger.getLogger(RegisterDaoImpl.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public List<UserRole> getUserRole()throws DaoException{
		
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select * from USER_ROLE");
		query.addEntity(UserRole.class);
		List<UserRole> list=query.list();
		return list;
	}
	public static void main(String[] args)throws Exception {
		RoleDaoImpl rd=new RoleDaoImpl();
		rd.getUserRole();
	}
}
