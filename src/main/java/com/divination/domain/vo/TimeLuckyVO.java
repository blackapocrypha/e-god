package com.divination.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 大运
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeLuckyVO {

    /**
     * 开始年份
     */
    private Integer startYear;

    /**
     * 结束年份
     */
    private Integer endYear;

    /**
     * 大运名称
     */
    private String name;

}
