package com.divination.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.divination.domain.vo.EightGodTimeVO;
import com.divination.domain.vo.FullYearMonthDaysVO;
import com.divination.domain.vo.TimeLuckyMonthDayVO;
import com.divination.domain.vo.TimeLuckyVO;
import com.nlf.calendar.JieQi;
import com.nlf.calendar.Lunar;

import java.util.*;

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
     * @param date  日期
     * @param isJie 是否节按照气
     * @return
     */
    public static int howManyDays(Date date,Boolean isJie) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // 如果是按节令区分
        if(isJie){
            Date realBegin = null;
            Date realEnd = null;
            String nextJie = null;
            Date begin = DateUtil.beginOfMonth(date);
            for (int i = 1; i <= actualMaximum; i++) {
                Lunar lunar = new Lunar(begin);
                String jie = lunar.getJie();
                // 找到当月的节，并以此未根据找到下一个节
                if(Objects.nonNull(jie) && !"".equals(jie)){
                    realBegin = begin;
                    nextJie =JieUtil.getNextJieByThisJie(jie);
                }
                if(jie.equals(nextJie)){
                    realEnd = begin;
                }
                // 日期向后增加1
                begin = DateUtil.offsetDay(begin,1);
            }
            // 如果一个月内没找到下一个节的日期，则继续
            if(Objects.isNull(realEnd)){
                for (int i = 1; i <= 32; i++) {
                    Lunar lunar = new Lunar(begin);
                    String jie = lunar.getJie();
                    if(jie.equals(nextJie)){
                        realEnd = begin;
                        break;
                    }
                    // 日期向后增加1
                    begin = DateUtil.offsetDay(begin,1);
                }
            }
            return Integer.parseInt(DateUtil.between(realBegin,realEnd, DateUnit.DAY)+"");
        }


        return actualMaximum;
    }

    /**
     * 根据当月日期找到全部按节划分的流日
     * @param date 日期
     * @return
     */
    public static List<TimeLuckyMonthDayVO> getFlowDaysByThisMonth(Date date ){
        List<TimeLuckyMonthDayVO> allList = new ArrayList<>();
        // 穿过来的日期必然是1号，但该月份是从第一个节开始
        Lunar lunar = new Lunar(date);
        JieQi jie = lunar.getNextJie();
        String nextJie = JieUtil.getNextJieByThisJie(jie.getName());

        boolean flag = false;
        for (int i = 0; i < 60; i++) {
            Lunar myLunar = new Lunar(date);

            // 如果遇到过节，直接开始增加
            if(flag){
                TimeLuckyMonthDayVO vo = new TimeLuckyMonthDayVO();
                vo.setDate(DateUtil.format(date,"yyyy-MM-dd HH:mm:ss"));
                vo.setDay(DateUtil.dayOfMonth(date));
                vo.setDayGanZhi(myLunar.getDayGan()+myLunar.getDayZhi());
                allList.add(vo);
            }

            // 如果遇到节了，从这里开始增加
            if(myLunar.getJie().equals(jie.getName())){
                TimeLuckyMonthDayVO vo = new TimeLuckyMonthDayVO();
                vo.setDate(DateUtil.format(date,"yyyy-MM-dd HH:mm:ss"));
                vo.setDay(DateUtil.dayOfMonth(date));
                vo.setDayGanZhi(myLunar.getDayGan()+myLunar.getDayZhi());
                flag = true;
                allList.add(vo);
            }

            date = DateUtil.offsetDay(date,1);
            Lunar nextLunnar = new Lunar(date);
            // 如果遇到下一个节了，说明结束，并且不载入
            if(nextLunnar.getJie().equals(nextJie)){
              break;
            }


        }
        return allList;

    }


    /**
     * 根据年份获取该年全部流月流日
     * @param year 年份
     * @return
     */
    public static List<FullYearMonthDaysVO> getFullYearMonthDays(Integer year){
        List<FullYearMonthDaysVO> list = new ArrayList<>();

        for (int i = 1; i <=12; i++) {
            Date thisDate = DateUtil.parse(year + "-"+String.format("%02d",i)+"-01 00:00:00");

            FullYearMonthDaysVO monthVO = new FullYearMonthDaysVO();
            monthVO.setMonth(i);
            monthVO.setYear(year);
            List<TimeLuckyMonthDayVO> days = getFlowDaysByThisMonth(thisDate);
            monthVO.setDays(days);
            TimeLuckyMonthDayVO timeLuckyMonthDayVO = days.get(0);
            Lunar realLunar = new Lunar(DateUtil.parse(timeLuckyMonthDayVO.getDate()));
            monthVO.setMonthGanZhi(realLunar.getMonthGan()+realLunar.getMonthZhi());

            list.add(monthVO);
        }
        return list;
    }

}
