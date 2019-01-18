/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naztech.newmavendate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author DOLPHIN
 */
public class Driver {
      public static void main(String[] args) {

       
        Calendar calender = Calendar.getInstance();
        calender.set(2019, 01, 17);
        calender.set(Calendar.HOUR_OF_DAY, 11);
        calender.set(Calendar.MINUTE, 30);
        calender.set(Calendar.SECOND, 40);
        calender.set(Calendar.MILLISECOND, 0);
        DateConvert.fromCalenderDateToLocalDate(calender);
        DateConvert.fromCalenderTimeToLocalTime(calender);
        DateConvert.fromCalenderTimeToZonedOffsetTime(calender);
        DateConvert.fromCalenderLocalDateTimeToOffsetDateTime(calender);
        DateConvert.fromCalenderToZonedDateTime(calender);


    Date date = new Date();
   
    
   DateConvert. fromDateToLocalDateTime(date);
        
   LocalDate ld = LocalDate.of(2019,01, 02);
   System.out.println("LocalDate to date : " +DateConvert.fromLocalDateToDate(ld) ); 
      
   
      //Date input = new Date();
		
      
        
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("meeee"+DateConvert.fromDateToLocalDateTime(date).format(formatter));

        String formatDateTime = LocalDateTime.now().format(formatter);
        
        System.out.println("Fail1"+formatDateTime);
    
      
      
      }
       
      
      
       
}
