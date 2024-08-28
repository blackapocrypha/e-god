package com.divination.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具
 */
public class LunarCalendarUtil {



    private static final int[] LUNAR_MONTH_DAYS = {
            29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30
    };

    /**
     * 计算一个阴历月份有多少天
     * @param i     月份
     * @param year  年份
     * @return
     */
    public static int getLunarMonthDays(int i, int year) {
        if (i < 1 || i > 12) {
            throw new IllegalArgumentException("月份必须在1到12之间");
        }
        return LUNAR_MONTH_DAYS[i - 1];
    }


    /**
     * 获取该日期代表的月份总共多少天
     * @param date
     * @return
     */
    public static int howManyDays(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


}
