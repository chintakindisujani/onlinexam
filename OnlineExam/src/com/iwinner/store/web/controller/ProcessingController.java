package com.iwinner.store.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.Question;
import com.iwinner.store.service.QuestionServiceIF;

@Controller
public class ProcessingController {
@Autowired
private QuestionServiceIF questionServiceIF;

@RequestMapping("processingOPeration.do")
public ModelAndView processingOpearationForm(HttpServletRequest request){
	/*String username=(String)request.getSession().getAttribute(StoreConstants.LOGIN_USER);
	Question question=new Question();
	try {
		question=questionServiceIF.getFirstQuestionInfo();
	} catch (ServiceException e) {
		e.printStackTrace();
	}
	return new ModelAndView(StoreConstants.QUESTION_REDIRECT_URL,"question",question);*/
	return new ModelAndView();
}
}
