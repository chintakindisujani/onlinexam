package com.iwinner.store.dao;

import java.util.List;

import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.UserRole;

public interface RoleDaoIF {

	public List<UserRole> getUserRole()throws DaoException;
}
