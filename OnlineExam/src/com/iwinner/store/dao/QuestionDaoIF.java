package com.iwinner.store.dao;

import java.util.List;

import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.QuestionsBank;


public interface QuestionDaoIF {
	public Integer insertQuestion(QuestionsBank quesBank) throws DaoException;
	public List<QuestionsBank> getAllQuestionInfo(Integer questionNumber,String examId)throws DaoException;	
}
