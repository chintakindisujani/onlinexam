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
@Table(name = "exam_results")
public class ExamResult {

	@Id
	@Column(name = "UEID")
	private String ueid;

	@Column(name = "EXAMID_EXAM")
	private String examId;

	@Column(name = "UserId")
	private String userId;

	@Column(name = "ExamName")
	private String examName;

	@Column(name = "MarksScored")
	private String totalMarks;

	@Column(name = "timestampdateofexam")
	private Timestamp startTime;

	@Column(name = "NOOFQUESTION")
	private Integer noOfQuestions;

	@Column(name = "DURATION")
	private String duration;

	
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Integer getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(Integer noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "examId_examlist", insertable = false, updatable = false)
	private ExamList eList;

	public ExamList geteList() {
		return eList;
	}

	public void seteList(ExamList eList) {
		this.eList = eList;
	}

	public String getUeid() {
		return ueid;
	}

	public void setUeid(String ueid) {
		this.ueid = ueid;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

}
