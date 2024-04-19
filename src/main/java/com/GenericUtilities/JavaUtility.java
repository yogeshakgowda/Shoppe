package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
public int getRandomNo()
{
	Random ran=new Random();
	int random=ran.nextInt(500);
	return random; 
}
public String getSystemDate()
{
  Date dt=new Date();
  String date = dt.toString();
  return date;
}

public String getSystemDateInFormat()
{
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	Date dt=new Date();
	String sysDateInFormat = dateFormat.format(dt);
	return sysDateInFormat;
}

public String getSystemDateAndTime()
{
	String timeStamp = LocalDateTime.now().toString().replace(':', '-');
	return timeStamp;
}
}
