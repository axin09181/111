package com.sys.supervision.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * 获取当天还剩余的毫秒数
     *
     * @return
     */
    public static Long getTodayTimeLeft() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return tomorrow.atStartOfDay(ZoneId.systemDefault()).toEpochSecond() * 1000
                - now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }


    /**
     * +1天
     *
     * @param date
     * @return
     */
    public static Date plusOneDay(Date date) {
        if (date == null) return null;
        LocalDate localDate = asLocalDate(date);
        localDate = localDate.plusDays(1);
        return asDate(localDate);
    }

    /**
     * -1天
     *
     * @param date
     * @return
     */
    public static Date minusOneDay(Date date) {
        if (date == null) return null;
        LocalDate localDate = asLocalDate(date);
        localDate = localDate.minusDays(1);
        return asDate(localDate);
    }


    public static String formatDate(Date date) {
        if (date == null) return "";
        try {
            return sdf.format(date);
        } catch (Exception var) {
            return "";
        }
    }


    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    public static String localDateToString(LocalDate localDate) {
        if (localDate == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDate.format(formatter);
    }

    public static LocalDate stringToLocalDate(String param) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.getDefault());  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        return LocalDate.parse(param, formatter);
    }


    public static long getTimeStamp(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }


    public static Integer getYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static Integer getMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static Date addDays(Integer days) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, days);
        return c.getTime();
    }


    public static void main(String[] args) {
        LocalDate date = stringToLocalDate("2018-11-11");
        LocalDate yes = date.minusDays(1);
        System.out.println(getTimeStamp(date.atStartOfDay()));
        System.out.println(getTimeStamp(yes.atStartOfDay()));
    }
}
