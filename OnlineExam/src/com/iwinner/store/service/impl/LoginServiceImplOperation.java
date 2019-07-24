package com.iwinner.store.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.dao.LoginDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.User;
import com.iwinner.store.service.LoginServiceIF;

@Service
public class LoginServiceImplOperation implements LoginServiceIF {
	private static Logger logger = Logger
			.getLogger(LoginServiceImplOperation.class);
	@Autowired
	private LoginDaoIF loginDaoIF;

	public Integer loginDao(String username, String password)throws ServiceException {
		logger.info("Enter Into the loginDao()");
		Integer loginValue = StoreConstants.ZERO;
		try {
			loginValue = loginDaoIF.loginDao(username, password);
			logger.debug("Inside the loginDao() loginValue=[" + loginValue
					+ "]");
		} catch (DaoException e) {
			loginValue = StoreConstants.SYSTEM_ERROR;
			logger.error("###### Error Into the loginDao() " + e.getMessage());
		}
		logger.info("Exit Into the loginDao()  loginValue=[" + loginValue + "]");
		return loginValue;
	}
	public User getLoginUserInfo(String username)throws ServiceException{
		User user=new User();
		try {
			user=loginDaoIF.getLoginUserInfo(username);
		} catch (DaoException e) {
		}
		return user;
	}
	public String findUser(String username)throws ServiceException{
		String findUserAvaiable=StoreConstants.USER_AVAIABLE_PROCESSING;
		try {
			findUserAvaiable= loginDaoIF.findUser(username);
		} catch (DaoException e) {
			throw new ServiceException("Error inside the fidnUser()",e);
		}
		return findUserAvaiable;
	}
}
