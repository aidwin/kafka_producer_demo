package com.gc.guoch_kafka.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class DateUtils {

    /**
     * 将日期字符串转化为 date类型
     *
     * @param datetime
     */
    public static Date datetimeToDate(Object datetime) {
        if (datetime != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDate localDate = LocalDate.parse(datetime.toString(), formatter);
            if (null == localDate) {
                return null;
            }
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
            return Date.from(zonedDateTime.toInstant());
        }
        return null;
    }

    /**
     * 将日期字符串转化为 datetime类型
     *
     * @param datetime
     */
    public static Date DateStrConersionDate(Object datetime) {
        if (datetime != null) {
            ZoneId zoneId = ZoneId.systemDefault();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.parse(datetime.toString(), formatter);
            return Date.from(localDateTime.atZone(zoneId).toInstant());
        }
        return null;
    }

    /**
     * 获取当前时间
     */
    public static Date getCurrentDatetime() {
        ZoneId zoneId = ZoneId.systemDefault();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 日期时间转字符串
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(formatter);
        LocalDateTime localDateTime = LocalDateTime.parse(format, formatter);
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }


//    /**
//     * 时间格式化
//     */
//    public static String datetime2str() {
//        String DATE_FORMAT_DAY = "yyyy-MM-dd";
//        ZoneId zoneId = ZoneId.systemDefault();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        // 日期时间转字符串
//        LocalDateTime now = LocalDateTime.now();
//        String format = now.format(formatter);
//        LocalDateTime localDateTime = LocalDateTime.parse(format, formatter);
//        return Date.from(localDateTime.atZone(zoneId).toInstant());
//    }
}
