package com.iwinner.store.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.dao.ExamDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.ExamList;
import com.iwinner.store.model.ExamResult;

@Repository
public class ExamDaoImpl implements ExamDaoIF{
	@Autowired
	private SessionFactory sessionFactory;

	private static Logger logger = Logger.getLogger(RegisterDaoImpl.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Integer insertExamId(ExamList eList) throws DaoException {
		Integer examCode = StoreConstants.START_DEFAULT_CODE;
		logger.info("Enter Into the insertExamId() " + eList);
		Session session = sessionFactory.openSession();
		
		try{
		session.beginTransaction().begin();
		ExamList examList = (ExamList) session.get(ExamList.class,eList.getExamId());
		if (examList!= null) {
			examCode=StoreConstants.EXAM_ALREDY_EXISTS;
		} else {
			session.save(eList);
			session.beginTransaction().commit();
			examCode=StoreConstants.EXAM_INSERTED;
    		}
		}catch(DataAccessException dae){
			examCode=StoreConstants.EXAM_INSERTED_FAILED;
			logger.error("Error Into the DataAccessException " + examCode+"  "+dae.getMessage());
		}
		return examCode;
	}
	
	public String  checkExamId(String examId) throws DaoException {
		String checkExamId=StoreConstants.USER_AVAIABLE_PROCESSING;
		logger.info("Enter Into the checkExamId() " + examId);
		Session session = sessionFactory.openSession();
		try{
		session.beginTransaction().begin();
		ExamList examList = (ExamList) session.get(ExamList.class,examId);
		if (examList != null) {
			checkExamId=StoreConstants.EXAM_ID_EXISTS;
			logger.debug("Inside the checkExamId() " + checkExamId);
		} else {
			checkExamId=StoreConstants.EXAM_ID_NOT_FOUND;
			logger.debug("Inside the checkExamId() " + checkExamId);
		}
		}catch(DataAccessException dae){
			checkExamId=StoreConstants.EXAM_ID_PROCESSING_ERROR;
			logger.error("Error into the  checkExamId() "+dae.getMessage());
		}
		return checkExamId;
	}
	
	public List<ExamList>  getExamList()throws DaoException{
		
		List<ExamList> examList=new ArrayList<ExamList>();
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("FROM ExamList AS EL");
		examList=(List<ExamList>)query.list();
		return examList;
	}
	public String deleteExamId(String examId)throws DaoException{
		String deleteExamId=StoreConstants.EXAMID_DELETE_PROCESS;
		logger.info("Enter Into the deleteExamId() " + examId);
		Session session = sessionFactory.openSession();
		session.beginTransaction().begin();
		ExamList examList=(ExamList)session.get(ExamList.class, examId);
		if(examList!=null){
			session.delete(examList);
			session.beginTransaction().commit();
			deleteExamId=StoreConstants.EXAMID_DELETED;
		}else{
			deleteExamId=StoreConstants.EXAMID_DELETED_NOT_FOUND;
		}
		
		return deleteExamId;
	}
	public List<ExamList> getUserList()throws DaoException{
		List<ExamList> listOfUser=new ArrayList<ExamList>();
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("FROM User AS us");
		listOfUser=query.list();
		return listOfUser;
	}
	public ExamResult getExamIDDetails(String examID)throws DaoException{
		ExamResult examResult=new ExamResult();
		Session session =sessionFactory.openSession();
		Query query=session.createQuery("FROM ExamResult where examId=:EXAMID");
		query.setString("EXAMID",examID);
		List<ExamResult> eresult=query.list();
		
		for(ExamResult eResult:eresult){
			examResult.setDuration(eResult.getDuration());
			examResult.setExamId(eResult.getExamId());
			examResult.setTotalMarks(eResult.getTotalMarks());
			examResult.setNoOfQuestions(eResult.getNoOfQuestions());
			examResult.setExamName(eResult.getExamName());
            examResult.setUeid(eResult.getUeid());
            examResult.setUserId(eResult.getUserId());
		}
		return examResult;
	}
	
	
	public static void main(String args[]){
		String str="2@@Who was the first asian to win nobel prize in literature?::mother teresa##gutenburg##rabindranath tagore##mahatma gandhi@#C";
		String sp[]=str.split("@@");
		//System.out.println(sp[0]);
		
		String spQues[]=sp[1].split("::");
		//System.out.println(spQues[0]);
		
		String optionSp[]=spQues[1].split("##");
		/*System.out.println(optionSp[0]);
		System.out.println(optionSp[1]);
		System.out.println(optionSp[2]);
		*/
		System.out.println(optionSp[3]);
		
		String ansSp[]=optionSp[3].split("@#");
		System.out.println(ansSp[1]);
		
		
		
		
	}
}
