package com.iwinner.store.service;

import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.Vistior;

public interface StartUpServiceIF {
public void saveVistiorInfo(Vistior vistor)throws ServiceException;
}
