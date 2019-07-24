package com.iwinner.store.constants;

import java.util.Date;

import java.util.ResourceBundle;

public class StoreConstants {
	// Propertiles file loading
	public static ResourceBundle CONFIG = ResourceBundle.getBundle("com.iwinner.store.utils.iexam");
	// Login Screen 
	public static String LOGIN="Login";
	public static String REGISTER="Register";
	public static String MANAGER="Manager";
    public static String NULL=null;
    public static String LOGIN_REDIRECT_URL="login";
    public static String LOGIN_USER="username_";
    public static String EMAIL_ID="emailId";
    public static String HOME_URL="home";
	
	//New User Register
	public static String BACK_BUTTON="BACK";
	public static String REGISTER_REDIRECT_URL="register";
	
	//Admin Page URL
	public static String ADMIN_REDIRECT_URL="admin";
	
	//Ajax Calling purpose
	public static String USER_AVAIABLE_PROCESSING="Processing ...";
	public static String USER_AVAIABLE="Chose Another ID";
	public static String USER_NOT_AVAIABLE_="NOT AVAIABLE";
	public static String USER_AVAIABLE_ERROR="Processing Error,Please contract System admin";
	
	public static String EXAM_ID_NOT_FOUND="ExamId Not Found";
	public static String EXAM_ID_EXISTS="ExamId AVAIABLE,Chose anothre Id";
	public static String EXAM_ID_PROCESSING_ERROR="Exam processing error";
	
	
	//InstructionPage
	public static String INSTUCTION_REDIRECT_URL="instructionsPage";
	
	// Application Codes
	public static Integer START_DEFAULT_CODE=0;
	public static Integer ERROR_CODE=0;
	public static Integer SUCCESS_CODE=1;
	public static Integer USER_NOT_AVAIABLE=2;
	public static Integer USER_EXISTS=3;
	public static Integer SYSTEM_ERROR=4;
	public static Integer USER_CREATED=5;
	// Date Setting
	public static Date START_TIME=new Date();
	public static Date END_TIME=new Date();
   //Account Setting
	public static String ACCOUNT_STATUS_ACTIVE="ACTIVE";
	public static String ACCOUNT_STATUS_LOCKED="LOCKED";
	
	// Question Info
	public static Integer FIRST_QUESTION=1;
	public static String QUESTION_REDIRECT_URL="firstQuestion";
	public static String QUESTION="question";
	public static int ZERO=0;
	public static Integer FOUR=4;
	public static Integer FIVE=5;
	public static Integer SIX=6;
	public static Integer SEVEN=7;
	
	//SQL Querys
	public static String LOGIN_QUERY="FROM User as us where us.username=:username and us.password=:password";

	//Constatn for Store
	public static Integer MAX_QUESTIONS=20;
	public static String DOWNLOAD_DIRECTORY="E:/Tech_Learning/saiWork_space/OnlineExamDir/output/SampleQuestions.csv";
	public static String UPLOAD_DIRECTORY="E:/Tech_Learning/saiWork_space/OnlineExamDir/input/";
	public static String EXAM_ID="ExamId is Processing";
	public static String EXAM_ID_REQUIRED="Please Select ExamId ";
	
	public static Integer ADD_ONE=1;
	

	public static Integer EXAM_INSERTED=10;
	public static Integer EXAM_INSERTED_FAILED=11;
	public static Integer EXAM_ALREDY_EXISTS=12;

	public static String EXAM_ID_PROCESSING="ExamId insertion processing ";
	public static String EXAM_INSERTED_="ExamInserted Successfully";
	public static String EXAM_INSERTED_FAILED_="ExamId Creation failed,Please try again";
	public static String EXAM_ALREDY_EXISTS_="Alredy ExamId is existed";
	
	public static String EXAMID_DELETED="ExamId deleted Successfully";
	public static String EXAMID_DELETED_NOT_FOUND="Deleted ExamId not found,Please contact System admin";
	public static String EXAMID_DELETE_PROCESS="Exam Id delete processing";
	public static String EXAMID_DELETE_ERROR="Exam Id delete processing,Please try again";
	
	// Question Insertion
	public static Integer QUESTION_PROCESSING=10;
	public static Integer QUESTION_INSERTED=11;
	public static Integer QUESTION_INSERTION_FAILED=12;
	public static Integer QUESTION_ALREDY_EXISTED=13;
}
