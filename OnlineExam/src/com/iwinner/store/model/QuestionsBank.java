package com.iwinner.store.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam_question_bank")
public class QuestionsBank {

	@Id
	@Column(name = "all_questions")
	private Integer questionnos;

	
	@Column(name = "QUESTIONNO")
	private Integer questionno;

	@Column(name = "examId_que")
	private String examid;
	@Column(name = "question")
	private String question;
	@Column(name = "OptionA")
	private String optionA;
	@Column(name = "OptionB")
	private String optionB;
	@Column(name = "OptionC")
	private String optionC;
	@Column(name = "OptionD")
	private String optionD;
	@Column(name = "Answer")
	private String answer;
	
	@Column(name="insertQuestionTime")
	private Timestamp insertQuestionTime;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "examId_examlist", insertable = false, updatable = false)
	private ExamList examList;

	public ExamList getExamList() {
		return examList;
	}

	public void setExamList(ExamList examList) {
		this.examList = examList;
	}

	public String getExamid() {
		return examid;
	}

	public void setExamid(String examid) {
		this.examid = examid;
	}

	public Integer getQuestionnos() {
		return questionnos;
	}

	public void setQuestionnos(Integer questionnos) {
		this.questionnos = questionnos;
	}

	public Integer getQuestionno() {
		return questionno;
	}

	public void setQuestionno(Integer questionno) {
		this.questionno = questionno;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Timestamp getInsertQuestionTime() {
		return insertQuestionTime;
	}

	public void setInsertQuestionTime(Timestamp insertQuestionTime) {
		this.insertQuestionTime = insertQuestionTime;
	}
	
	
}
