package com.iwinner.store.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.ExamResult;
import com.iwinner.store.model.QuestionsBank;
import com.iwinner.store.service.ExamServiceIF;
import com.iwinner.store.service.QuestionServiceIF;

@Controller
public class StartExamProcessing {

	private static Logger logger = Logger.getLogger(StartExamProcessing.class);

	@Autowired
	private ExamServiceIF examServiceIF;

	@Autowired
	private QuestionServiceIF questionServiceIF;
	
	private static final int EXAMDURATION = 3601;

	@RequestMapping("startNewExam.do")
	public ModelAndView startExam(HttpServletRequest request) {
		Date date = new Date();
		long milliseconds = date.getTime();
		long StartTime = milliseconds / 1000;

		String examId = request.getParameter("ExamCodeID");
		System.out.println("ExamID  is ......." + examId);
		logger.info("Enter Into the getExamIdInforamtion()  ");
		String examIdProcessing = StoreConstants.EXAM_ID;
		ExamResult examResult = new ExamResult();
		if (examId != null && examId.trim().length() != 0) {
			try {
				examResult = examServiceIF.getExamIDDetails(examId);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		} else {
			examIdProcessing = StoreConstants.EXAM_ID_REQUIRED;
			return new ModelAndView("aviableExams");
		}

		HttpSession session = request.getSession();
		session.setAttribute("UserName_",
				request.getSession().getAttribute(StoreConstants.LOGIN_USER)
						.toString());
		session.setAttribute("EXAMID", examResult.getExamId());
		session.setAttribute("USERID", examResult.getUserId());
		session.setAttribute("UEID", examResult.getUeid());
		session.setAttribute("STARTTIME", StartTime);
		session.setAttribute("DURATION", EXAMDURATION);
        Integer firstQuestion=StoreConstants.FIRST_QUESTION;
		try {
			List<QuestionsBank> listOfQuestionBank=questionServiceIF.getAllQuestionInfo(firstQuestion,  examResult.getExamId());
			for(QuestionsBank qsBank:listOfQuestionBank){
				session.setAttribute("CurrentQuestion", qsBank.getQuestion());
				session.setAttribute("OptionA", qsBank.getOptionA());
				session.setAttribute("OptionB",qsBank.getOptionB());
				session.setAttribute("OptionC", qsBank.getOptionC());
				session.setAttribute("OptionD",qsBank.getOptionD());
				session.setAttribute("QuestionNo", firstQuestion);
			}
		} catch (ServiceException e) {
		}
		
		
		return new ModelAndView("examination");
	}

	@RequestMapping("examInstructionsPage.do")
	public ModelAndView examInstructionsPage(HttpServletRequest request) {
		String examID = request.getParameter("ExamCodeID");

		System.out.println("ExamID:::====>>>>>" + examID);
		return new ModelAndView("examInstructions");

	}

}
