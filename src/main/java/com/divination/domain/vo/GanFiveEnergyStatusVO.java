package com.divination.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 五行关系 - 天干 - 十神
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GanFiveEnergyStatusVO {

    /**
     * 同我者 - 同五行同阴阳
     */
    private String sameMe;

    /**
     * 同我者 - 同五行同阴阳 - 天干
     */
    private String sameMeGan;

    /**
     * 同我者 - 同五行异阴阳
     */
    private String reverseSameMe;

    /**
     * 同我者 - 同五行异阴阳 -天干
     */
    private String reverseSameMeGan;

    /**
     * 我生者 - 同五行同阴阳
     */
    private String myChild;

    /**
     * 我生者 - 同五行同阴阳 - 天干
     */
    private String myChildGan;

    /**
     * 我生者 - 同五行异阴阳
     */
    private String reverseMyChild;

    /**
     * 我生者 - 同五行异阴阳 -天干
     */
    private String reverseMyChildGan;

    /**
     * 克我者 - 同五行同阴阳
     */
    private String killMe;

    /**
     * 克我者 - 同五行同阴阳 -天干
     */
    private String killMeGan;

    /**
     * 克我者 - 同五行异阴阳
     */
    private String reverseKillMe;

    /**
     * 克我者 - 同五行异阴阳 -天干
     */
    private String reverseKillMeGan;

    /**
     * 生我者 - 同五行同阴阳
     */
    private String careMe;

    /**
     * 生我者 - 同五行同阴阳 -天干
     */
    private String careMeGan;

    /**
     * 生我者 - 同五行异阴阳
     */
    private String reverseCareMe;

    /**
     * 生我者 - 同五行异阴阳 -天干
     */
    private String reverseCareMeGan;

    /**
     * 我克者 - 同五行同阴阳
     */
    private String hateMe;

    /**
     * 我克者 - 同五行同阴阳 -天干
     */
    private String hateMeGan;

    /**
     * 我克者 - 同五行异阴阳
     */
    private String reverseHateMe;

    /**
     * 我克者 - 同五行异阴阳 -天干
     */
    private String reverseHateMeGan;

    /**
     * 日主阴阳状态  1阳 0阴
     */
    private Integer yinYangStatus;
}
