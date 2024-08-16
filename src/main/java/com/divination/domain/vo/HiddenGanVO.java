package com.divination.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 藏干
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HiddenGanVO {

    /**
     * 本气
     */
    private String height;

    /**
     * 本气对应十神
     */
    private String heightGodName;

    /**
     * 中气
     */
    private String middle;

    /**
     * 中气对应十神
     */
    private String middleGodName;

    /**
     * 余气
     */
    private String low;

    /**
     * 余气对应十神
     */
    private String lowGodName;

}
