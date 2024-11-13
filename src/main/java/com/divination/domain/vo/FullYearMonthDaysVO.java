package com.divination.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullYearMonthDaysVO {

    /**
     * 年份
     */
    private Integer year;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 月份干支
     */
    private String monthGanZhi;

    /**
     * 日期
     */
    private List<TimeLuckyMonthDayVO> days;


}
