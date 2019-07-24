package com.iwinner.store.dao;

import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.User;

public interface LoginDaoIF {
	public Integer loginDao(String username,String password)throws DaoException;
	public User getLoginUserInfo(String username)throws DaoException;
	public String findUser(String username)throws DaoException;
}
