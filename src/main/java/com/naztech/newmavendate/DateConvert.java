/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naztech.newmavendate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author DOLPHIN
 */
public class DateConvert {
    
    public static OffsetDateTime fromCalenderLocalDateTimeToOffsetDateTime(Calendar calender) {


        OffsetDateTime offsetDate=OffsetDateTime.of(fromCalenderDateToLocalDate(calender), fromCalenderTimeToLocalTime(calender), fromCalenderTimeToZonedOffsetTime(calender));
        
        //ZoneOffset zonedOffset = ZoneOffset.ofHoursMinutesSeconds(calender.get(Calendar.HOUR), calender.get(Calendar.MINUTE), calender.get(Calendar.SECOND));

        System.out.println("Zoned Offset Time "+ offsetDate);
        return offsetDate;
    }
    public static LocalDate fromCalenderDateToLocalDate(Calendar calender) {

        LocalDate localDate =LocalDate.of(calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DATE));

        System.out.println("Local date: " + localDate);
        return localDate;

    }
     
      public static LocalTime fromCalenderTimeToLocalTime(Calendar calender) {

        LocalTime localTime = LocalTime.of(calender.get(Calendar.HOUR_OF_DAY), calender.get(Calendar.MINUTE), calender.get(Calendar.SECOND));

        System.out.println("Local Time: " + localTime);
        return localTime;

    } 
      
        public static ZoneOffset fromCalenderTimeToZonedOffsetTime(Calendar calender) {
        
        ZoneOffset zonedOffset = ZoneOffset.ofHoursMinutesSeconds(calender.get(Calendar.HOUR), calender.get(Calendar.MINUTE), calender.get(Calendar.SECOND));

        System.out.println("Zoned Offset Time "+ zonedOffset);
        return zonedOffset;
    }
         public static ZonedDateTime fromCalenderToZonedDateTime(Calendar calender) {

         String zone = calender.getTimeZone().getID();

         ZoneId zoneId = ZoneId.of(zone);
          System.out.println("Zoned Date Time "+ zoneId);
    
         ZonedDateTime zonedatetime=ZonedDateTime.of(calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DATE), calender.get(Calendar.HOUR_OF_DAY), calender.get(Calendar.MINUTE), calender.get(Calendar.SECOND),calender.get(Calendar.MILLISECOND), zoneId);
        
        System.out.println("Zoned Date Time "+ zonedatetime);
        return zonedatetime;
    }
         public static LocalDate fromDateToLocalDate(Date date) {
		
		LocalDate localDate = LocalDate.of(date.getYear()+1900, date.getMonth() + 1,date.getDate());
		return localDate;

	}
         public static LocalTime fromDateToLocalTime(Date date) {
		
		LocalTime localTime = LocalTime.of(date.getHours(), date.getMinutes(),date.getSeconds());

		return localTime;
	}
      
         public static  LocalDateTime fromDateToLocalDateTime(Date date) {

            LocalDateTime localDateTime = LocalDateTime.of(date.getYear()+1900, date.getMonth()+1, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
	    System.out.println(localDateTime);
            return localDateTime;
  }
         
         public static Date fromLocalDateToDate(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
  }
         public static Date fromLocalTimeToDate(LocalTime localTime) {
		
		Instant instant = localTime.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant();
		return  Date.from(instant);
		
	}
        

         

	
         
}
