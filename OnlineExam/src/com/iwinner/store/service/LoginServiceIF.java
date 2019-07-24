package com.iwinner.store.service;

import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.User;

public interface LoginServiceIF {
	public Integer loginDao(String username, String password)throws ServiceException ;
	public User getLoginUserInfo(String username)throws ServiceException;
	public String findUser(String username)throws ServiceException;
}
