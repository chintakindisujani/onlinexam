package com.iwinner.store.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exam_list")
public class ExamList {
	@Id
	@Column(name = "examId_examlist")
	private String examId;

	@Column(name = "EXAMNAME")
	private String examName;

	@Column(name = "EXAMDESCRIPTION")
	private String examDescription;


	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamDescription() {
		return examDescription;
	}

	public void setExamDescription(String examDescription) {
		this.examDescription = examDescription;
	}

}
