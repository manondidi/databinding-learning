package com.czq.mvvm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    public static long getMillisecond(long time) {
        if (time < 10000000000L) {
            time *= 1000;
        }
        return time;
    }

    public static String getFormatTime(long time) {
        return getFormatTime(new Date(TimeUtil.getMillisecond(time)));
    }

    public static String getFormatTime(Date date) {
        try {
            SimpleDateFormat sdf1;
            Date now = new Date();
            int days = daysBetween(date, now);
            if (days == 0) {//同一天

                long min = (now.getTime() - date.getTime()) / (1000 * 60);
                long hours = (now.getTime() - date.getTime()) / (1000 * 60 * 60);
                if (min < 5) {
                    return "刚刚";
                }
                if (hours <= 24) {
                    sdf1 = new SimpleDateFormat("HH:mm");
                    return sdf1.format(date);
                } else {
                    return hours + "小时前";
                }
            } else if (days <= 3) {
                return days + "天前";
            } else if (isCurrentYear(date)) {//xx月xx日
                sdf1 = new SimpleDateFormat("MM-dd");
                return sdf1.format(date);
            } else {
                sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                return sdf1.format(date);
            }
        } catch (ParseException e) {

            e.printStackTrace();
            return "";
        }
    }

    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static boolean isCurrentYear(Date date) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        return c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR);

    }
}
