package com.divination.domain.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 十神
 */
@AllArgsConstructor
@NoArgsConstructor
public class TenGodVO {


    /**
     * 同我者 - 阳
     */
    private String yangSameMe;

    /**
     * 同我者 - 阴
     */
    private String yinSameMe;

    /**
     * 我生者 - 阳
     */
    private String yangMyChild;

    /**
     * 我生者 - 阴
     */
    private String yinMyChild;

    /**
     * 克我者 - 阳
     */
    private String yangKillMe;

    /**
     * 克我者 - 阴
     */
    private String yinKillMe;

    /**
     * 生我者 - 阳
     */
    private String yangCareMe;

    /**
     * 生我者 - 阴
     */
    private String yinCareMe;

}
