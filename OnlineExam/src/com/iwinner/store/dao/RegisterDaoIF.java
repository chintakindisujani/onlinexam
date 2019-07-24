package com.iwinner.store.dao;

import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.User;

public interface RegisterDaoIF {
	 public int persistNewUser(User user)throws DaoException;
}
