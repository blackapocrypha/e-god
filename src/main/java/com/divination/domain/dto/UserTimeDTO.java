package com.divination.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 大运入参
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTimeDTO {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birth;

    /**
     * 性别 1男 2女
     */
    private Integer gender;

    /**
     * 大运
     */
    private String lucky;

    /**
     * 年
     */
    private Integer year;

    /**
     * 月
     */
    private String month;

    /**
     * 日
     */
    private String day;
}
