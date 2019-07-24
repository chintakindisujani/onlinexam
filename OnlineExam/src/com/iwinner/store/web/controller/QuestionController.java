package com.iwinner.store.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.Question;
import com.iwinner.store.model.QuestionsBank;
import com.iwinner.store.service.QuestionServiceIF;

@Controller
public class QuestionController {
	@Autowired
	private QuestionServiceIF questionServiceIF;

	@RequestMapping("singleUpdate.do")
	public ModelAndView singleUpdate(HttpServletRequest request) {
		Integer questionInsertion = StoreConstants.QUESTION_PROCESSING;
		QuestionsBank qBank = new QuestionsBank();
		qBank.setExamid(request.getParameter("userRole"));
		qBank.setAnswer(request.getParameter("answer"));
		qBank.setOptionA(request.getParameter("optionA"));
		qBank.setOptionB(request.getParameter("optionB"));
		qBank.setOptionC(request.getParameter("optionC"));
		qBank.setOptionD(request.getParameter("optionD"));
		qBank.setQuestion(request.getParameter("questionName"));
		try {
			questionInsertion = questionServiceIF
					.singleInsertionQuestion(qBank);
		} catch (ServiceException e) {
		}
		return new ModelAndView("singleQuestionUpload");
	}
}