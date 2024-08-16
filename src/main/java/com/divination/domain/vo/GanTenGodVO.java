package com.divination.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 天干对应十神VO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GanTenGodVO {

    /**
     * 天干
     */
    private String gan;

    /**
     * 十神
     */
    private String god;
}
