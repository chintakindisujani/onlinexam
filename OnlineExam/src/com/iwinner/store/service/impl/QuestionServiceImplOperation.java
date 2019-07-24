package com.iwinner.store.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.dao.QuestionDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.QuestionsBank;
import com.iwinner.store.service.QuestionServiceIF;
@Service
public class QuestionServiceImplOperation implements QuestionServiceIF {
	@Autowired
	private QuestionDaoIF questionDaoIF;

	public Integer insertQuestion(String examId,String uploadFileName) throws ServiceException{
	     Integer questionInsertion=StoreConstants.QUESTION_PROCESSING;
		File file=new File(uploadFileName);
		List<String> addFileData=new ArrayList<String>();
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			String line;
			int len=0;
           try {
			while((line=br.readLine())!=null){
				if(len>0)
				addFileData.add(line);
                len++;
			}
			QuestionsBank qBank=new QuestionsBank();
			for(String lineData:addFileData){
				String questionNoSp[]=lineData.split("@@");
				qBank.setQuestionno(Integer.parseInt(questionNoSp[0]));
				String questionNameSp[]=questionNoSp[1].split("::");
				qBank.setQuestion(questionNameSp[0]);
				String optionNameSp[]=questionNameSp[1].split("##");
				qBank.setOptionA(optionNameSp[0]);
				qBank.setOptionB(optionNameSp[1]);
				qBank.setOptionC(optionNameSp[2]);
				String ansNameSp[]=optionNameSp[3].split("@#");
				qBank.setOptionD(ansNameSp[0]);
				qBank.setAnswer(ansNameSp[1]);
				qBank.setExamid(examId);
				try {
					questionInsertion=questionDaoIF.insertQuestion(qBank);
				} catch (DaoException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
		}
		} catch (FileNotFoundException e) {
		}
		
		return questionInsertion;
	}
		
	public Integer singleInsertionQuestion(QuestionsBank qBank)throws ServiceException{
	     Integer questionInsertion=StoreConstants.QUESTION_PROCESSING;
	 	try {
			questionInsertion=questionDaoIF.insertQuestion(qBank);
		} catch (DaoException e) {
		}
	     return questionInsertion;
	}
	public List<QuestionsBank> getAllQuestionInfo(Integer questionNumber,String examId)throws ServiceException{
		List<QuestionsBank> listOfQuestion=new ArrayList<QuestionsBank>();
		try {
			listOfQuestion=questionDaoIF.getAllQuestionInfo(questionNumber, examId);
		} catch (DaoException e) {
			
		}
		return listOfQuestion;
	}
}
