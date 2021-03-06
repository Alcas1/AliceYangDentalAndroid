package com.bim.dentistaliceyang;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Setting  {

	
	public static final String DAY = getDayOfTheWeek();
	public static final String OFFICE_PHONE = "2032650788";
	public static final String OFFICE_EMAIL = "aliceyangdental@gmail.com";
	public static final String OFFICE_LAT_LON = "41.474776,-72.817622";
	public static final String OFFICE_EVENT_TITLE = "Dentist Appointment";
	public static final String OFFICE_EVENT_DESC = "You have a dentist appointment with Dr. Alice Yang";
	public static final String OFFICE_EVENT_ADDRESS = "174 N Plains Industrial Road, Wallingford, CT 06492";
	public static final String EMAIL_OUTRO="Sent from Alice Yang Family Dentistry Android App";
	public static String getDayOfTheWeek()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		Date d = new Date();
		String dayOfTheWeek = sdf.format(d);
		return dayOfTheWeek;
	}
}
