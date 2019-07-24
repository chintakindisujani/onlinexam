package com.iwinner.store.dao;

import java.util.List;

import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.ExamList;
import com.iwinner.store.model.ExamResult;

public interface ExamDaoIF {
	public Integer insertExamId(ExamList eList) throws DaoException;
	public String  checkExamId(String examId) throws DaoException ;
	public List<ExamList>  getExamList()throws DaoException;
	public String deleteExamId(String examId)throws DaoException;
	public List<ExamList> getUserList()throws DaoException;
	public ExamResult getExamIDDetails(String examID)throws DaoException;
}
