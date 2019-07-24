package com.iwinner.store.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.ExamList;
import com.iwinner.store.model.ExamResult;
import com.iwinner.store.service.ExamServiceIF;
import com.iwinner.store.service.QuestionServiceIF;

@Controller
public class ExamController {

	public static Logger logger=Logger.getLogger(ExamController.class);
	@Autowired
	private ExamServiceIF examServiceIF;
	@Autowired
	private QuestionServiceIF questionServiceIF;
	
	@RequestMapping("addNewExam.do")
	public  ModelAndView   addExam(HttpServletRequest request,	HttpServletResponse response) {
		Integer examCode = StoreConstants.START_DEFAULT_CODE;
		String examIdInsertedMessage=StoreConstants.EXAM_ID_PROCESSING;
		ExamList examList=new ExamList();
		examList.setExamId(request.getParameter("ExamId"));
		examList.setExamName(request.getParameter("ExamName"));
		examList.setExamDescription(request.getParameter("txtexamdescription"));
		try {
			examCode=examServiceIF.insertExamId(examList);
			if(examCode==StoreConstants.EXAM_INSERTED){
				examIdInsertedMessage=StoreConstants.EXAM_INSERTED_;
			}else if(examCode==StoreConstants.EXAM_ALREDY_EXISTS){
				examIdInsertedMessage=StoreConstants.EXAM_ALREDY_EXISTS_;
			}else if(examCode==StoreConstants.EXAM_INSERTED_FAILED){
				examIdInsertedMessage=StoreConstants.EXAM_INSERTED_FAILED_;
			}
		} catch (ServiceException e) {
		}
		return new ModelAndView("addNewExam","examIdInsertedMessage",examIdInsertedMessage);
	}

	@RequestMapping("removeExam.do")
	public ModelAndView removeExam(HttpServletRequest request,	HttpServletResponse response) {
        List<ExamList> examList=new ArrayList<ExamList>();
        try {
			examList=examServiceIF.getExamList();
		} catch (ServiceException e) {
		}
		return new ModelAndView("removeExam","examList",examList);
	}

	@RequestMapping("removeUser.do")
	public ModelAndView removeUser(HttpServletRequest request,	HttpServletResponse response) {
		List<ExamList> listOfUsers=new ArrayList<ExamList>();
		try {
			listOfUsers=examServiceIF.getUserList();
		} catch (ServiceException e) {
		}
		return new ModelAndView("removeUser","listOfUsers",listOfUsers);
	}

	@RequestMapping("userPrivilagesNa.do")
	public ModelAndView userPrivilages(HttpServletRequest request,HttpServletResponse response) {
		List<ExamList> listOfUsers=new ArrayList<ExamList>();
		try {
			listOfUsers=examServiceIF.getUserList();
		} catch (ServiceException e) {
		}
		return new ModelAndView("userPrivileges","listOfUsers",listOfUsers);
	}

	@RequestMapping("checkExamId.do")
	public  @ResponseBody String  checkExamID(HttpServletRequest request,	HttpServletResponse response) {
		String examId=request.getParameter("examId");
		String checkExamId=StoreConstants.USER_AVAIABLE_PROCESSING;
		try {
			checkExamId=examServiceIF.checkExamId(examId);
		} catch (ServiceException e) {
		}
       return checkExamId;
	}
	
	@RequestMapping("removeExamId.do")
	public ModelAndView removeExamID(HttpServletRequest request){
		String deleteExamId=StoreConstants.EXAMID_DELETE_PROCESS;		
		String examId=request.getParameter("ExamIdToRemoveRadio");
		List<ExamList> examList=new ArrayList<ExamList>();
		try {
			examList=examServiceIF.getExamList();
		} catch (ServiceException e) {
		}
		if(examId!=null){
		try {
			deleteExamId=examServiceIF.deleteExamId(examId);
			request.setAttribute("deleteExamId", deleteExamId);
			return new ModelAndView("removeExam","examList",examList);
		} catch (ServiceException e) {
		}
	}
		request.setAttribute("removeExamSelect", "Please Select Delete Exam");
		return new ModelAndView("removeExam","examList",examList);
	}
	
	@RequestMapping("avaiableExams.do")
	public ModelAndView viewAvaiableExams(HttpServletRequest request,	HttpServletResponse response) {
		 Integer questionInsertion=StoreConstants.QUESTION_PROCESSING;
        List<ExamList> examList=new ArrayList<ExamList>();
        try {
			examList=examServiceIF.getExamList();
		} catch (ServiceException e) {
			
		}
        
		return new ModelAndView("aviableExams","examList",examList);
	}
	
	@RequestMapping("startExamID.do") 
	public ModelAndView getExamIdInforamtion(HttpServletRequest request){
		logger.info("Enter Into the getExamIdInforamtion()  ");
  		String examIdProcessing=StoreConstants.EXAM_ID;
  		ExamResult examResult=new ExamResult();
		String examId=request.getParameter("examIdSelection");
		if(examId!=null&&examId.trim().length()!=0){
			try {
				examResult=examServiceIF.getExamIDDetails(examId);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}else{
			examIdProcessing=StoreConstants.EXAM_ID_REQUIRED;
			return new ModelAndView("aviableExams");
		}
		request.getSession().setAttribute("examResult", examResult);
		request.getSession().setAttribute("exmIdI", examResult.getExamId());
		return new ModelAndView("beginExam");
	}
}
