package com.iwinner.store.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
public static Date getPasswordDate(){
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.DATE, 60);
	return cal.getTime();
}
public static Timestamp getTimestamp(){
	Date date=new Date();
	Timestamp timestamp=new Timestamp(date.getTime());
	return timestamp;
}
public static void main(String[] args) {
	DateUtils dateUtils=new DateUtils();
	Date date=dateUtils.getPasswordDate();
	System.out.println(date);
}
}
