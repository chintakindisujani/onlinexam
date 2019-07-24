package com.iwinner.store.service;

import java.util.List;

import com.iwinner.store.expections.ServiceException;
import com.iwinner.store.model.QuestionsBank;

public interface QuestionServiceIF {
	public Integer insertQuestion(String examId,String fileName) throws ServiceException; 
	public Integer singleInsertionQuestion(QuestionsBank qBank)throws ServiceException;
	public List<QuestionsBank> getAllQuestionInfo(Integer questionNumber,String examId)throws ServiceException;
}
