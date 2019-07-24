package com.iwinner.store.service;

import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.User;

public interface RegisterServiceIF {
	 public int persistNewUser(User user)throws ServiceException;
}
