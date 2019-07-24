package com.iwinner.store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iwinner.store.dao.RoleDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.UserRole;
import com.iwinner.store.service.RoleServiceIF;
@Service
public class RoleServiceImplOperation implements RoleServiceIF{

@Autowired
private RoleDaoIF roleDaoIF;

public List<UserRole> getUserRole() throws ServiceException {
	List<UserRole> userRole=new ArrayList();
try {
	userRole=roleDaoIF.getUserRole();
} catch (DaoException e) {
}
	return userRole;
}
}
