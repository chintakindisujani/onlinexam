package com.iwinner.store.web.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.helper.IdGenerator;
import com.iwinner.store.model.UserRole;
import com.iwinner.store.model.Vistior;
import com.iwinner.store.service.RoleServiceIF;
import com.iwinner.store.service.StartUpServiceIF;

/**
 * Servlet implementation class StartUpServlet
 */
@Controller
public class StartUpController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private StartUpServiceIF startUpServiceIF;
	
	@Autowired
	private RoleServiceIF roleSericeIF;
	
	private static Logger logger = Logger.getLogger(StartUpController.class);

	public StartUpController() {
	}

	@RequestMapping("startUp.do")
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response){
		logger.info("Enter Into the StartUpServlet() # execute()");
		String savedVistorInfo = "";
		Hashtable<String, String> headerInfo = new Hashtable<String, String>();
		Enumeration<String> headEnum = (Enumeration<String>) request.getHeaderNames();
		while (headEnum.hasMoreElements()) {
			String keyName = headEnum.nextElement();
			String valueName = request.getHeader(keyName);
			headerInfo.put(keyName, valueName);
		}
		InetAddress inetAdd = null;
		try {
			inetAdd = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			
		}
		String hostAndIpAddress[] = inetAdd.toString().split("/");
		String hostName = hostAndIpAddress[0];
		String ipAddress = hostAndIpAddress[1];
		String userAgent = headerInfo.get("user-agent");
		String browserName = "";
		if (userAgent != null && userAgent.contains("Chrome")) {
			browserName = browserName + "Chrome";
		} else if (userAgent != null && userAgent.contains("MSIE")) {
			browserName = browserName + "MSIE";
		} else if (userAgent != null && userAgent.contains("Firefox")) {
			browserName = browserName + "Firefox";
		} else if (userAgent != null) {
			browserName = browserName + "Not Chrome/MSIE/FireFox";
		}
		String osName=System.getProperty("os.name");
		java.util.Date date = new java.util.Date();
		java.sql.Timestamp viewTime = new java.sql.Timestamp(date.getTime());
		
		Vistior vForm = new Vistior();
		vForm.setHostname(hostName);
		vForm.setIpAddress(ipAddress);
		vForm.setBrowser(browserName);
		vForm.setUserAgent(userAgent);
		vForm.setViewDate(date);
		vForm.setVistorranId(IdGenerator.getId());
		vForm.setViewDateAndTime(viewTime);
		vForm.setOsName(osName);
		try {
			startUpServiceIF.saveVistiorInfo(vForm);
		} catch (ServiceException e) {
			logger.error("##### Error Into the execute() "+e.getMessage());
		}
		List<UserRole> userRol=new ArrayList();
		try {
			userRol= roleSericeIF.getUserRole();
			System.out.println("Size Of ====>>>>>>>>>."+userRol.size());
			request.getSession().setAttribute("userRol",userRol);
			
		} catch (ServiceException e) {
		}
		
//		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,	response);
		return new ModelAndView("login");
	}
}
