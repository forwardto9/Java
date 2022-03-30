package com.uwei.syntax.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * author: uwei
 * create:2022-03-30
 */
public class DateType {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        String dString = "2010-01-03";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.parse(dString));
        System.out.println(dateFormat.format(date));

        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
        System.out.println(c.get(Calendar.YEAR));

        c.set(Calendar.MONTH, 11);
        System.out.println(c.getTime());
    }
}
