package com.iwinner.store.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	@Id
	@Column(name = "id")
	public Integer questionId;

	@Column(name = "questioname")
	public String questionName;

	@Column(name = "optionA")
	public String optionA;

	@Column(name = "optionB")
	public String optionB;

	@Column(name = "optionC")
	public String optionC;

	@Column(name = "optionD")
	public String optionD;

	@Column(name = "ans")
	public Integer ansId;

	@Column(name = "updatedTime")
	public Timestamp updatedTime;

	@Column(name = "usingTime")
	public Timestamp usingTime;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
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

	public Integer getAnsId() {
		return ansId;
	}

	public void setAnsId(Integer ansId) {
		this.ansId = ansId;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Timestamp getUsingTime() {
		return usingTime;
	}

	public void setUsingTime(Timestamp usingTime) {
		this.usingTime = usingTime;
	}

}
