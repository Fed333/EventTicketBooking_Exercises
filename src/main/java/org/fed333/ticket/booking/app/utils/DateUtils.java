package org.fed333.ticket.booking.app.utils;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The utils class, which provide common util method to work with dates.<br>
 * @author Roman_Kovalchuk
 * */
public class DateUtils {

    /**
     * Parses date from a string.
     * @param dateAsString string in dd-MM-yyyy date format
     * @return {@link Date} object from the given string
     * */
    @SneakyThrows
    public static Date parseDate(String dateAsString) {
        return new SimpleDateFormat("dd-MM-yyyy").parse(dateAsString);
    }

    /**
     * Parses date from a string.
     * @param dateTimeAsString string in yyyy-MM-dd HH:mm:ss date format
     * @return {@link Date} object from the given string
     * */
    @SneakyThrows
    public static Date parseDateTime(String dateTimeAsString) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTimeAsString);
    }

    public static int extractYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int extractMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    public static int extractDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }



}
