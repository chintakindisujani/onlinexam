package com.iwinner.store.service;

import java.util.List;

import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.ExamList;
import com.iwinner.store.model.ExamResult;

public interface ExamServiceIF {
	public Integer insertExamId(ExamList eList) throws ServiceException;
	public String  checkExamId(String examId) throws ServiceException;
	public List<ExamList>  getExamList()throws ServiceException;
	public String deleteExamId(String examId)throws ServiceException;
	public List<ExamList> getUserList()throws ServiceException;
	public ExamResult getExamIDDetails(String examID)throws ServiceException;
}
