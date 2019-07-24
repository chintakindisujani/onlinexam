package com.iwinner.store.dao;

import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.Vistior;

public interface StartUpDaoIF {
public void peristVistiorInfo(Vistior vistiorInfo)throws DaoException;
}
