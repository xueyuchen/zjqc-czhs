package co.bohc.diet.domain.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import co.bohc.diet.domain.common.enums.BaseFlg;
import co.bohc.diet.domain.common.enums.SleepTime;

public final class TimeUtils {
    private static final String DEFAULT_FARMAT_YYYYMMDD = "yyyy/MM/dd";

    private static final String DEFAULT_FARMAT_YYYYMMDDHHMM = "yyyy/MM/dd HH:mm";

    private static final String DEFAULT_FARMAT_YYYYMMDDHHMM2 = "yyyy-MM-dd HH:mm";

    private static final DateFormat DF = new SimpleDateFormat(DEFAULT_FARMAT_YYYYMMDD);

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String Y_M_D = "%s年%s月%s日";

    private TimeUtils() {
    }

    public static Calendar dateToCalerdar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     * the first day of week
     */
    public static Date getFirstDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());

        DateTime time = new DateTime(c.getTime());
        return new DateTime(time.getYear(), time.getMonthOfYear(), time.getDayOfMonth(), 0, 0, 0).toDate();
    }

    /**
     * the first day of week
     */
    // TODO
    public static Date getFirstDayOfWeek(String date, String... format) {
        if (date == null) {
            return null;
        }
        String fmt = null;
        if (format != null && format.length > 0) {
            fmt = format[0];
        } else {
            fmt = YYYY_MM_DD;
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern(fmt);
        DateTime dateTime = formatter.parseDateTime(date);

        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(dateTime.toDate());
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());

        DateTime time = new DateTime(c.getTime());
        return new DateTime(time.getYear(), time.getMonthOfYear(), time.getDayOfMonth(), 0, 0, 0).toDate();
    }

    /**
     * the last day of week
     */
    public static Date getLastDayOfWeek(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);

        DateTime time = new DateTime(c.getTime());
        return new DateTime(time.getYear(), time.getMonthOfYear(), time.getDayOfMonth(), 23, 59, 59).toDate();
    }

    public static String dateToStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD);
        return formatter.format(date);
    }

    public static String datetimeToStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        return formatter.format(date);
    }

    public static Date strToDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD);
        Date dt = null;
        try {
            dt = formatter.parse(date);
        } catch (Exception e) {
            throw new IllegalArgumentException(date);
        }
        return dt;
    }

    /**
     * @author GuoKai 2015-1-27
     * @param
     * @param dt
     * @param days
     * @param status
     *            0:begin of one day. 1: end of one day
     * @return
     * 
     */
    public static Date getDateNextDays(Date dt, int days, Integer... status) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.add(Calendar.DATE, days);
        DateTime time = new DateTime(cal.getTime());
        if (status != null && status.length > 0 && BaseFlg.ON.getValue().equals(status[0])) {
            return new DateTime(time.getYear(), time.getMonthOfYear(), time.getDayOfMonth(), 23, 59, 59).toDate();
        }
        return new DateTime(time.getYear(), time.getMonthOfYear(), time.getDayOfMonth(), 0, 0, 0).toDate();
    }

    /**
     * @param date
     * @param format
     * @return
     * @author LiuYifan 2014-12-30 18:36:46
     */
    // TODO
    public static String convertDate2String(Date date, String... format) {
        String fmt = null;
        DateFormat df = null;
        String dateStr = null;
        if (date != null) {
            if (format != null && format.length > 0) {
                fmt = format[0];
                df = StringUtils.isNotBlank(fmt) ? new SimpleDateFormat(fmt) : DF;
            } else {
                df = DF;
            }
            dateStr = df.format(date);
        }
        return dateStr;
    }

    /**
     * @param date
     * @return
     * @author LiuYifan Jan 4, 2015 5:29:10 PM
     */
    public static Date getStartTimeOfDay(Date date) {
        if (date != null) {
            DateTime time = new DateTime(date.getTime());
            return new DateTime(time.getYear(), time.getMonthOfYear(), time.getDayOfMonth(), 0, 0, 0).toDate();
        }
        return null;
    }

    /**
     * @param date
     * @param format
     * @return
     * @author LiuYifan Jan 4, 2015 5:29:15 PM
     */
    public static Date getStartTimeOfDay(String date, String... format) {
        if (date != null && !"".equals(date)) {
            String fmt = null;
            if (format == null || format.length == 0) {
                fmt = DEFAULT_FARMAT_YYYYMMDDHHMM2;
            } else {
                fmt = format[0];
            }
            DateTimeFormatter formatter = DateTimeFormat.forPattern(fmt);
            DateTime time = new DateTime(formatter.parseDateTime(date));
            return new DateTime(time.getYear(), time.getMonthOfYear(), time.getDayOfMonth(), 0, 0, 0).toDate();
        }
        return null;
    }

    /**
     * @param date
     * @return
     * @author LiuYifan Jan 4, 2015 5:29:10 PM
     */
    public static Date getEndTimeOfDay(Date date) {
        if (date != null) {
            DateTime time = new DateTime(date.getTime());
            return new DateTime(time.getYear(), time.getMonthOfYear(), time.getDayOfMonth(), 23, 59, 59).toDate();
        }
        return null;
    }

    /**
     * @param date
     * @param format
     * @return
     * @author LiuYifan Jan 4, 2015 5:29:15 PM
     */
    public static Date getEndTimeOfDay(String date, String... format) {
        if (date != null && !"".equals(date)) {
            String fmt = null;
            if (format == null || format.length == 0) {
                fmt = DEFAULT_FARMAT_YYYYMMDDHHMM2;
            } else {
                fmt = format[0];
            }
            DateTimeFormatter formatter = DateTimeFormat.forPattern(fmt);
            DateTime time = new DateTime(formatter.parseDateTime(date));
            return new DateTime(time.getYear(), time.getMonthOfYear(), time.getDayOfMonth(), 23, 59, 59).toDate();
        }
        return null;
    }

    public static Date strToDateTime(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        Date dateTime = null;
        try {
            dateTime = formatter.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(date);
        }
        return dateTime;
    }

    /**
     * @author GuoKai 2015-1-20
     * @param date
     * @return
     */
    public static Date getPushDate(Date date) {
        Integer time = Integer.parseInt(new SimpleDateFormat("HHmmss").format(date));
        if (time > SleepTime.START.getTime() || time < SleepTime.END.getTime()) {
            date = getDateNextDays(date, 1);
            DateTime dt = new DateTime(date.getTime());
            return new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), SleepTime.END.getHour(),
                    SleepTime.END.getMinute(), 0).toDate();
        }
        return date;
    }

    /**
     * @author GuoKai 2015-1-20
     * @param dateStr
     * @param format
     * @return
     */
    public static Date convertString2Date(String dateStr, String... format) {
        if (dateStr != null && !"".equals(dateStr)) {
            String fmt = null;
            if (format == null || format.length == 0) {
                fmt = DEFAULT_FARMAT_YYYYMMDDHHMM;
            } else {
                fmt = format[0];
            }
            SimpleDateFormat formatter = new SimpleDateFormat(fmt);
            Date dateTime = null;
            try {
                dateTime = formatter.parse(dateStr);
            } catch (ParseException e) {
                throw new IllegalArgumentException(dateStr);
            }
            return dateTime;
        } else {
            return null;
        }

    }

    public static Integer compareDate(Date fromDt, Date toDt) {
        return fromDt.compareTo(toDt);
    }

    public static boolean isPast(String targetDateStr) {
        // 現在の日付の時間部分が00:00:00となるような文字列を取得
        Date now = strToDate(dateToStr(new Date()));
        Date targetDate = strToDate(targetDateStr);
        System.out.println(compareDate(targetDate, now));
        return (compareDate(targetDate, now) < 0);
    }

    public static int daysBetween(Date smdate, Date bdate) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
        try {
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
        } catch (ParseException e) {
            throw new IllegalArgumentException(smdate.toString());
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static String dayInJpWeek(DateTime dt) {
        String str[] = { "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日", "日曜日" };
        int day = dt.getDayOfWeek();// 获取时间
        return str[day - 1];
    }

    // 转换类型为XX年XX月XX日
    public static String formatDate2String(DateTime dt) {
        int year = dt.getYear();
        int month = dt.getMonthOfYear();
        int day = dt.getDayOfMonth();
        return String.format(Y_M_D, year, month, day);
    }

    // 转换类型为XX年XX月XX日
    public static String formatDate2String(Date dt) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        return String
                .format(Y_M_D, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
    }

    public static String getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return dateToStr(cal.getTime());
    }

    public static Date getStartTimeOfMonth(Date date) {
        if (date != null) {
            DateTime time = new DateTime(date.getTime());
            return new DateTime(time.getYear(), time.getMonthOfYear(), 1, 0, 0, 0).toDate();
        }
        return null;
    }

    public static Date getEndTimeOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            DateTime time = new DateTime(date.getTime());
            return new DateTime(time.getYear(), time.getMonthOfYear(), cal.get(Calendar.DAY_OF_MONTH), 23, 59, 59)
                    .toDate();
        }
        return null;
    }
}
