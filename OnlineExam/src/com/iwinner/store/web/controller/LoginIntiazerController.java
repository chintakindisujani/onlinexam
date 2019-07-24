package com.iwinner.store.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.helper.PasswordEncoder;
import com.iwinner.store.helper.Role;
import com.iwinner.store.model.User;
import com.iwinner.store.model.UserRole;
import com.iwinner.store.service.LoginServiceIF;
import com.iwinner.store.service.RoleServiceIF;

@Controller
public class LoginIntiazerController {

	@Autowired
	private RoleServiceIF roleSericeIF;
	
	private static Logger logger = Logger.getLogger(LoginIntiazerController.class);
	@Autowired
	private LoginServiceIF loginServiceIF;

	@RequestMapping("loginPage.do")
	public ModelAndView loginPage(HttpServletRequest request) {
		logger.info("Enter Inside the loginPage() " + StoreConstants.START_TIME);
		Integer loginValue = StoreConstants.ZERO;
		String buttonName = request.getParameter("OnlineExam");
		User user = new User();
		if (buttonName.equals(StoreConstants.LOGIN)) {
			logger.debug("Enter Into the Login Page");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (username != StoreConstants.NULL	&& username.trim().length() > StoreConstants.ZERO) {
				if (password != StoreConstants.NULL	&& password.trim().length() > StoreConstants.ZERO) {
					try {
						loginValue = loginServiceIF.loginDao(username,PasswordEncoder.encodePassword(password));
						if (loginValue == StoreConstants.SUCCESS_CODE) {
							user = loginServiceIF.getLoginUserInfo(username);
							}
					} catch (ServiceException e) {
						e.printStackTrace();
					}
					if (loginValue == StoreConstants.SUCCESS_CODE) {
						HttpSession session=request.getSession(true);
						/*session.setMaxInactiveInterval(1800);*/
						session.setAttribute(StoreConstants.LOGIN_USER,	user.getUsername());
						session.setAttribute(StoreConstants.EMAIL_ID, user.emailId);
				
						String userRole=user.getRoleType();
						if(userRole==Role.ADMIN.name()){
							session.setAttribute("ROLE",userRole);
							return new ModelAndView(StoreConstants.HOME_URL);
						}else{
							
					    }
						session.setAttribute("ROLE",userRole);
						return new ModelAndView(StoreConstants.HOME_URL);
					}
				} else {
					// password else
					return new ModelAndView(StoreConstants.LOGIN_REDIRECT_URL);
				}
			} else {

			}
			
		}
		if (buttonName.equals(StoreConstants.REGISTER)) {
			List<UserRole> userRol=new ArrayList();
			try {
				userRol= roleSericeIF.getUserRole();
				System.out.println("Size Of ====>>>>>>>>>."+userRol.size());
				request.getSession().setAttribute("userRolL",userRol);
				
			} catch (ServiceException e) {
			}
			logger.debug("Enter Into the Register Page");
			return new ModelAndView(StoreConstants.REGISTER_REDIRECT_URL);
		}
		if (buttonName.equals(StoreConstants.MANAGER)) {
			logger.debug("Enter Into the Manager Page");
			return new ModelAndView(StoreConstants.ADMIN_REDIRECT_URL);
		}
		logger.info("Exit Into the  loginPage() " + StoreConstants.END_TIME);
		
		return new ModelAndView();
	}
	
@RequestMapping("findUser.do")
public  @ResponseBody  String getFindUser(HttpServletRequest request){
	System.out.println("Processing the files.....");
	String findUserAvaiable=StoreConstants.USER_AVAIABLE_PROCESSING;
	try {
		findUserAvaiable=loginServiceIF.findUser(request.getParameter("username"));
	} catch (ServiceException e) {
	}
	return findUserAvaiable;
}
public static void main(String[] args) {
	System.out.println(Role.ADMIN.name());
}
}
