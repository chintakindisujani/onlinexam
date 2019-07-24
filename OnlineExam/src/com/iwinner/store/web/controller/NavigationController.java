package com.iwinner.store.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.ExamList;
import com.iwinner.store.model.UserRole;
import com.iwinner.store.service.ExamServiceIF;
import com.iwinner.store.service.QuestionServiceIF;
import com.iwinner.store.service.RoleServiceIF;

@Controller
public class NavigationController {
	

@Autowired
private ExamServiceIF examServiceIF;

@Autowired
private RoleServiceIF roleSericeIF;

	@RequestMapping("adminConsole.do")
	public ModelAndView getAdminConsole() {
		return new ModelAndView("adminConsole");
	}

	@RequestMapping("landingPage.do")
	public ModelAndView landingPageURL() {
		return new ModelAndView("home");
	}

	@RequestMapping("addExamNavigation.do")
	public ModelAndView addNewExamNavigation() {
		return new ModelAndView("addNewExam");
	}
    @RequestMapping("userPrivilages.do")
	public ModelAndView userPrivilegesNaviagation() {
		return new ModelAndView("userPrivileges");
	}
	@RequestMapping("bulkUpdateNav.do")
	public ModelAndView getBulkUpdateNav(HttpServletRequest request){
	       List<ExamList> examList=new ArrayList<ExamList>();
	       try {
				examList=examServiceIF.getExamList();
			} catch (ServiceException e) {

			}
	     request.getSession().setAttribute("examList", examList);
		return  new ModelAndView("bulkupload");
	}
	
	@RequestMapping("singleUpdateNav.do")
	public ModelAndView getSingleUpdateNav(HttpServletRequest request){
       List<ExamList> examList=new ArrayList<ExamList>();
       try {
			examList=examServiceIF.getExamList();
		} catch (ServiceException e) {
		}
         request.getSession().setAttribute("examList", examList);
       return  new ModelAndView("singleQuestionUpload");
	}
/*	public static void main(String[] args) {
		BigDecimal bg1=new BigDecimal("6.3");
		BigDecimal bg2=new BigDecimal("3.3");
		BigDecimal bg3=new BigDecimal("3.0");
		System.out.println(bg1.subtract(bg2));
	}
*/
@RequestMapping("logout.do")	
public ModelAndView logOutController(HttpServletRequest request){
	List<UserRole> userRol=new ArrayList();
	try {
		userRol= roleSericeIF.getUserRole();
		System.out.println("Size Of ====>>>>>>>>>."+userRol.size());
		request.getSession().setAttribute("userRol",userRol);
		
	} catch (ServiceException e) {
	}
	return new ModelAndView("login");
}
}
