package com.divination.controller;

import cn.hutool.core.date.DateUtil;
import com.divination.domain.vo.FullYearMonthDaysVO;
import com.divination.util.LunarCalendarUtil;
import com.nlf.calendar.Lunar;

import java.util.Date;
import java.util.List;

public class TestController {
    public static void main(String[] args) {

        Date date =DateUtil.parse("2024-12-01 00:00:00");
        List<FullYearMonthDaysVO> fullYearMonthDays = LunarCalendarUtil.getFullYearMonthDays(2024);
    }
}
