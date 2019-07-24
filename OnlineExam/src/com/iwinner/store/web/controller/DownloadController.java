package com.iwinner.store.web.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iwinner.store.constants.StoreConstants;


@Controller
public class DownloadController {

@RequestMapping("downloadSample.do")
public ModelAndView getDownloadSampleFile(HttpServletRequest request,HttpServletResponse response){
	
	String downloadDirectory=StoreConstants.DOWNLOAD_DIRECTORY;
	
	try {
		PrintWriter out=response.getWriter();
		response.setContentType("APPLICATION/OCTET-STREAM");   
		String fileName="SampleUploadFormat.csv";
    	response.setHeader("Content-Disposition","attachment; filename=\"" + fileName + "\"");   
		FileInputStream fileInputStream = new FileInputStream(downloadDirectory);
		int i;
		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		}
		fileInputStream.close();
		out.close();
	} catch (IOException e) {
	}
			
	return new ModelAndView("bulkupload");
}
}
