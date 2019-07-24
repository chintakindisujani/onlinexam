package com.iwinner.store.service.impl;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.dao.RegisterDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.helper.AccountStatus;
import com.iwinner.store.helper.Role;
import com.iwinner.store.model.User;
import com.iwinner.store.service.RegisterServiceIF;
import com.iwinner.store.utils.DateUtils;

@Service
public class RegisterServiceImplOperation implements RegisterServiceIF {
	@Autowired
	private RegisterDaoIF registerDaoIF;
	
	private static Logger logger = Logger.getLogger(RegisterServiceImplOperation.class);

	@Transactional
	public int persistNewUser(User user) throws ServiceException {
		logger.info("Enter Into the persistNewUser()");
		user.setAccountStatus(AccountStatus.ACTIVE.toString());
		user.setPasswordExpirtationDate(DateUtils.getPasswordDate());
		user.setLastUpdateTime(DateUtils.getTimestamp());
		user.setUpdateTime(DateUtils.getTimestamp());
		user.setRoleType(Role.EMPLOYEE.toString());
		Integer startCode = StoreConstants.START_DEFAULT_CODE;
		try {
			startCode = registerDaoIF.persistNewUser(user);
		logger.debug("startCode Info = ["+startCode+"]");	
		} catch (DaoException e) {
		logger.error("###### Error Into the persistNewUser() "+e.getMessage());	
		}
		logger.info("Exit Into the persistNewUser()");
		return startCode;
	 }
	}
