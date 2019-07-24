package com.iwinner.store.web.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.service.QuestionServiceIF;

@Controller
public class UploadController {
	
	@Autowired
	private QuestionServiceIF questionServiceIF;
	public static String uploadDirectory=StoreConstants.UPLOAD_DIRECTORY;	
@RequestMapping("uploadQuestions.do")
public ModelAndView fileUpload(HttpServletRequest request){

	String examId="OCWCD";
	System.out.println("examId:::>>>>"+examId);
	Integer fileProcessing=StoreConstants.QUESTION_PROCESSING;
	//process only if its multipart content
    if(ServletFileUpload.isMultipartContent(request)){
        try {
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
          
            for(FileItem item : multiparts){
                if(!item.isFormField()){
                    String name = new File(item.getName()).getName();
                    item.write( new File(uploadDirectory + File.separator + name));
                    String fileName=uploadDirectory+name;
                    fileProcessing=questionServiceIF.insertQuestion(examId, fileName);
                }
            }
           //File uploaded successfully
           request.setAttribute("message", "File Uploaded Successfully");
        } catch (Exception ex) {
           request.setAttribute("message", "File Upload Failed due to " + ex);
        }          
     
    }else{
        request.setAttribute("message",
                             "Sorry this Servlet only handles file upload request");
    }

	return new ModelAndView("bulkupload");
}
}
