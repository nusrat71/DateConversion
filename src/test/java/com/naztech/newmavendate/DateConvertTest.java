/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naztech.newmavendate;

import static com.naztech.newmavendate.DateConvert.fromCalenderDateToLocalDate;
import static com.naztech.newmavendate.DateConvert.fromCalenderTimeToLocalTime;
import static com.naztech.newmavendate.DateConvert.fromCalenderTimeToZonedOffsetTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DOLPHIN
 */
public class DateConvertTest {
    
    public DateConvertTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
     
      
    /**
     * Test of fromDateToLocalDate method, of class DateConvert.
     */
    
    
    @Test
    public void testFromDateToLocalDate() {
      
        Calendar calender = Calendar.getInstance();
        calender.set(2019, 01, 17);
        LocalDate ldate= LocalDate.of(2019, 01, 17);
        assertEquals(ldate, DateConvert.fromCalenderDateToLocalDate(calender));
        
    }
    
        @Test
    public void testfromCalenderLocalDateTimeToOffsetDateTime()    
    {
          Calendar calender = Calendar.getInstance();
       
        calender.set(2019, 01, 17, 11, 30, 40);
        LocalDate localDate =LocalDate.of(calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DATE));
        LocalTime localTime = LocalTime.of(calender.get(Calendar.HOUR_OF_DAY), calender.get(Calendar.MINUTE), calender.get(Calendar.SECOND));
        ZoneOffset zonedOffset = ZoneOffset.ofHoursMinutesSeconds(calender.get(Calendar.HOUR), calender.get(Calendar.MINUTE), calender.get(Calendar.SECOND));
        OffsetDateTime offsetTime= OffsetDateTime.of(localDate,localTime,zonedOffset);
        System.out.println("offset:"+offsetTime);
       assertEquals(offsetTime, DateConvert.fromCalenderLocalDateTimeToOffsetDateTime(calender));

    }

    /**
     * Test of fromTimeToLocalTime method, of class DateConvert.
     */
    @Test
    public void testFromCalenderTimeToLocalTime() {
       
        Calendar calender = Calendar.getInstance();
        calender.set(2019, 01, 17, 11, 30, 40);
        LocalTime localtime=LocalTime.of(11, 30, 40);
            System.out.println("Local Time: " + localtime);
        assertEquals(localtime, DateConvert.fromCalenderTimeToLocalTime(calender));
    }
    @Test
    public void testFromCalenderTimeToZonedOffsetTime()
    {
          Calendar calender = Calendar.getInstance();
         calender.set(2019, 01, 17, 11, 30, 40);
       ZoneOffset zo= ZoneOffset.ofHoursMinutesSeconds(11, 30, 40);
       System.out.println("offset:"+zo);
       assertEquals(zo, DateConvert.fromCalenderTimeToZonedOffsetTime(calender));

    }
    @Test
    public void testFromCalenderToZonedDateTime()
    {
         Calendar calender = Calendar.getInstance();
         calender.set(2019, 01, 17, 11, 30, 40);
          calender.set(Calendar.MILLISECOND, 0);
         ZoneId zoneId = ZoneId.of("America/Los_Angeles");
         ZonedDateTime zonetest=ZonedDateTime.of(2019, 01, 17, 11, 30, 40,0,zoneId);
          System.out.println("Zoned Date Time "+ zonetest);
          assertEquals(zonetest, DateConvert.fromCalenderToZonedDateTime(calender));
        
    }
    @Test
    public void testFromDatetoLocalDate() {
		Date date = new Date();
		assertEquals(LocalDate.now(), DateConvert.fromDateToLocalDate(date));
		
	}
    @Test
    public void testFromTimetoLocalTime() {
		Date input = new Date();
		input.setHours(10);
		input.setMinutes(10);
		input.setSeconds(40);
		assertEquals(LocalTime.of(10, 10, 40), DateConvert.fromDateToLocalTime(input));
	}
   @Test 
   public void testFromDateToLocalDateTime()
   {
        Date date = new Date();
     
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = LocalDateTime.now().format(formatter);
        System.out.println("Fail1"+formatDateTime);
        assertEquals(formatDateTime,DateConvert.fromDateToLocalDateTime(date).format(formatter));
   }
    
   @Test
   public void testFromLocalDateToDate()
   {
       Date d = new  Date(2019 , 01, 02);
       DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
       LocalDate ld = LocalDate.of(2019+1900, 01 , 02);
       assertEquals(df.format(d), df.format(DateConvert.fromLocalDateToDate(ld)));
      // System.out.println("Fail test"+df.format(d));
        System.out.println(df.format(DateConvert.fromLocalDateToDate(ld)));
   }
   
   public void testFromLocalTimeToDate() {
		Date input = new Date();
		input.setDate(17);
		input.setYear(119);
		input.setMonth(0);
		input.setHours(11);
		input.setMinutes(02);
		input.setSeconds(00);
		DateFormat dF = new SimpleDateFormat("yyyy-mm-dd");
		LocalTime lt=LocalTime.now();
                  //LocalTime.of(11, 02);
                System.out.println("Fail last test"+LocalTime.now()+".."+dF.format(DateConvert.fromLocalTimeToDate(lt)));
		assertEquals(dF.format(input), dF.format(DateConvert.fromLocalTimeToDate(lt)));
		
	}
    
    
    
}
