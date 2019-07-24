package com.iwinner.store.service;

import java.util.List;

import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.UserRole;

public interface RoleServiceIF {
	public List<UserRole> getUserRole()throws ServiceException;
}
