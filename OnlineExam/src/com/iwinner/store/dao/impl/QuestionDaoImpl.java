package com.iwinner.store.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iwinner.store.constants.StoreConstants;
import com.iwinner.store.dao.QuestionDaoIF;
import com.iwinner.store.expections.DaoException;
import com.iwinner.store.model.QuestionsBank;

@Repository
public class QuestionDaoImpl implements QuestionDaoIF {
	@Autowired
	private SessionFactory sessionFactory;

	private static Logger logger = Logger.getLogger(RegisterDaoImpl.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Integer insertQuestion(QuestionsBank quesBank) throws DaoException {

		Integer questionInsertion = StoreConstants.QUESTION_PROCESSING;
		Session session = sessionFactory.openSession();
		session.beginTransaction().begin();
		Integer questionNumber = getMaxQuestionNumber(quesBank.getExamid());
		Integer updateQuestionNumber = getUpdateQuestion(quesBank.getExamid());

		if (questionNumber != null
				&& questionNumber.intValue() < StoreConstants.MAX_QUESTIONS) {

			quesBank.setQuestionnos(getMaxQuestionAllsNumber()
					+ StoreConstants.ADD_ONE);
			quesBank.setQuestionno(questionNumber + StoreConstants.ADD_ONE);
			quesBank.setInsertQuestionTime(new Timestamp(new Date().getTime()));
			session.save(quesBank);
			session.beginTransaction().commit();

		} else {
			// update Min Question Number inside the specify Exam ID
			// Here ExamID 101OCJP exam Total question now 20 ,now i want added
			// new question but it is not possiable so, i need to update
			// min(timestatmpinsertionquestion)
			Integer mainQuestionNumber = getMainQuestionNumber(
					quesBank.getExamid(), updateQuestionNumber);
			QuestionsBank queBank = (QuestionsBank) session.get(
					QuestionsBank.class, mainQuestionNumber);
			if (queBank != null) {
				queBank.setInsertQuestionTime(new Timestamp(new Date()
						.getTime()));
				queBank.setQuestionno(updateQuestionNumber);
				queBank.setQuestion(quesBank.getQuestion());
				queBank.setOptionA(quesBank.getOptionA());
				queBank.setOptionB(quesBank.getOptionB());
				queBank.setOptionC(quesBank.getOptionC());
				queBank.setOptionD(quesBank.getOptionD());
				queBank.setAnswer(quesBank.getAnswer());
				session.saveOrUpdate(queBank);
				session.beginTransaction().commit();
			}
		}
		questionInsertion = StoreConstants.QUESTION_INSERTED;
		return questionInsertion;
	}

	public Integer getMainQuestionNumber(String examId, Integer examIdMainNumber) {
		Integer questionNumber = StoreConstants.QUESTION_PROCESSING;
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("select questionnos from QuestionsBank where questionno=:QUESTIONNO and examid=:EXAMID");
		query.setInteger("QUESTIONNO", examIdMainNumber);
		query.setString("EXAMID", examId);
		List<Integer> listOfQuestion = query.list();
		questionNumber = listOfQuestion.get(0);
		return questionNumber;
	}

	public Integer getMaxQuestionAllsNumber() throws DaoException {

		Integer questionInsertion = StoreConstants.QUESTION_PROCESSING;
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("select Max(questionnos) from  QuestionsBank");
		List<Integer> listOfMax = query.list();
		questionInsertion = listOfMax.get(0);
		return questionInsertion;

	}

	public Integer getMaxQuestionNumber(String examID) throws DaoException {

		Integer questionInsertion = StoreConstants.QUESTION_PROCESSING;
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("select Max(questionno) from  QuestionsBank as qb where qb.examid=:EXAMID");
		query.setString("EXAMID", examID);
		List<Integer> listOfMax = query.list();
		questionInsertion = listOfMax.get(0);
		return questionInsertion;
	}

	public Integer getUpdateQuestion(String examId) {

		Integer getUpdateQuesteion = StoreConstants.QUESTION_PROCESSING;
		Session session = sessionFactory.openSession();
		try {
			Query query = session
					.createQuery("SELECT questionno FROM QuestionsBank WHERE insertQuestionTime=(SELECT min(insertQuestionTime) FROM QuestionsBank WHERE examid=:EXAMID)");
			query.setString("EXAMID", examId);
			List<Integer> listOfQuestion = query.list();
			List<Integer> listOfQuestionInfo = new ArrayList<Integer>();
			for (int i = 0; i < listOfQuestion.size(); i++) {
				Integer questNo = listOfQuestion.get(i);
				listOfQuestionInfo.add(questNo);
			}
			getUpdateQuesteion = Collections.min(listOfQuestionInfo);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return getUpdateQuesteion;
	}
	
	public List<QuestionsBank> getAllQuestionInfo(Integer questionNumber,String examId)throws DaoException{
		List<QuestionsBank> listOfQuestions=new ArrayList<QuestionsBank>();
		Session session = sessionFactory.openSession();
		System.out.println("questionDaoImpl"+questionNumber+"  "+examId);
		Query query=session.createQuery("FROM QuestionsBank as qb where qb.examid=:EXAMID and qb.questionno=:QUESTIONNO");
		query.setString("EXAMID", examId);
		query.setInteger("QUESTIONNO", questionNumber);
		listOfQuestions=query.list();
		return listOfQuestions;
	}
}
