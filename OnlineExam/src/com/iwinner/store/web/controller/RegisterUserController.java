package com.iwinner.store.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.helper.PasswordEncoder;
import com.iwinner.store.model.User;
import com.iwinner.store.service.RegisterServiceIF;
import com.iwinner.store.utils.DateUtils;

@Controller
public class RegisterUserController {
	private static Logger logger = Logger.getLogger(RegisterUserController.class);
	@Autowired
	private RegisterServiceIF registerServiceIF;
	
	@RequestMapping("newUserOp.do")
   public ModelAndView createNewUser(HttpServletRequest request){
		logger.info("Enter Into the createNewUser() "+StoreConstants.START_TIME);
	   String buttonName=request.getParameter("RegisterForm");
	   if(!StoreConstants.BACK_BUTTON.equals(buttonName)){
		   User user=new User();
		   user.setUsername(request.getParameter("username"));
		   user.setPassword(PasswordEncoder.encodePassword(request.getParameter("password")));
		   user.setFirstName(request.getParameter("username"));
		   user.setLastName(request.getParameter("username"));
		   user.setPastPassword(PasswordEncoder.encodePassword(request.getParameter("password")));
		   user.setUpdateTime(DateUtils.getTimestamp());
		   user.setEmailId(request.getParameter("email"));
		   user.setPhone(request.getParameter("phone"));
		   try {
			int userValue=registerServiceIF.persistNewUser(user);
			logger.debug("Inside the createNewUser(); userValue [="+userValue+"]");
		} catch (ServiceException e) {
			logger.error("###### Error Into the createNewUser() "+e.getMessage());
		}
		   return new ModelAndView("login");
	   }else{
		   
	   }
	   logger.info("Enter Into the createNewUser() "+StoreConstants.END_TIME);
	   return new ModelAndView("login");
   }
}
