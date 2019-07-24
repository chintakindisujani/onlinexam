package com.iwinner.store.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.dao.ExamDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.ExamList;
import com.iwinner.store.model.ExamResult;
import com.iwinner.store.model.QuestionsBank;
import com.iwinner.store.service.ExamServiceIF;

@Service
public class ExamServiceImplOperation implements ExamServiceIF{

@Autowired
private ExamDaoIF examDaoIF;

public Integer insertExamId(ExamList eList) throws ServiceException {
	Integer examCode = StoreConstants.START_DEFAULT_CODE;
	try {
		examCode=examDaoIF.insertExamId(eList);
	} catch (DaoException e) {
	}
	return examCode;
}
	public String checkExamId(String examId) throws ServiceException {
		String checkExamId=StoreConstants.USER_AVAIABLE_PROCESSING;
		try {
			
			checkExamId= examDaoIF.checkExamId(examId);
			
		} catch (DaoException e) {
			
		}
		return checkExamId;
	}
	public List<ExamList>  getExamList()throws ServiceException{
		List<ExamList> listOfExam=new ArrayList<ExamList>();
		try {
			listOfExam=examDaoIF.getExamList();
		} catch (DaoException e) {
		}
		return listOfExam;
	}
	public String deleteExamId(String examId)throws ServiceException{
		String deleteExamId=StoreConstants.EXAMID_DELETE_PROCESS;
		try {
			deleteExamId=examDaoIF.deleteExamId(examId);
		} catch (DaoException e) {
		}
		return deleteExamId;
	}
	public List<ExamList> getUserList()throws ServiceException{
		List<ExamList> listOfUsers=new ArrayList<ExamList>();
		try {
			listOfUsers=examDaoIF.getUserList();
		} catch (DaoException e) {
		}
		return listOfUsers;
	}
		public ExamResult getExamIDDetails(String examID) throws ServiceException {
            ExamResult examResult=new ExamResult();
            try {
				examResult=examDaoIF.getExamIDDetails(examID);
			} catch (DaoException e) {
			}
			return examResult;
		}	
	
/*	public static void main(String[] args) {
		ExamServiceImplOperation eService=new ExamServiceImplOperation();
		try {
			eService.insertQuestions();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
