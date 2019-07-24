package com.iwinner.store.dao.impl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;


@Repository
public class ExamProcedureDaoImpl {

	private static DataSource l_ds = null;
	private Logger logger = Logger.getLogger(LoginDaoImpl.class);

	public void setDataSource(DataSource ds) {
		this.l_ds = ds;
	}
}
