package com.divination.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 大运中的流月流日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeLuckyMonthDayVO {

    /**
     * 日干支
     */
    private String dayGanZhi;

    /**
     * 纯数字日期
     */
    private Integer day;

    /**
     * 日期
     */
    private String date;

}
