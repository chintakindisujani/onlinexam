package com.iwinner.store.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iwinner.store.dao.StartUpDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.Vistior;
import com.iwinner.store.service.StartUpServiceIF;

@Service
public class StartUpServiceImpl implements StartUpServiceIF {
	@Autowired
	private StartUpDaoIF startUpDaoIF;
	public static Logger logger = Logger.getLogger(StartUpServiceImpl.class);

	public void saveVistiorInfo(Vistior vistior) throws ServiceException {
		logger.info("Enter Into the saveVistiorInfo()");
		try {
			vistior.setSystemUser(System.getProperty("user.name"));
			startUpDaoIF.peristVistiorInfo(vistior);
		} catch (DaoException e) {
			logger.error("##### Error Into the saveVistiorInfo()"+ e.getMessage());
		}
		logger.info("Exit Into the saveVistiorInfo()");
	}
}
