package com.divination.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EightGodVO {

    /**
     * 年干
     */
    private String yearGan;

    /**
     * 月干
     */
    private String monthGan;

    /**
     * 日干
     */
    private String dayGan;

    /**
     * 时干
     */
    private String timeGan;

    /**
     * 年支
     */
    private String yearZhi;

    /**
     * 月支
     */
    private String monthZhi;

    /**
     * 日支
     */
    private String dayZhi;

    /**
     * 时支
     */
    private String timeZhi;


    /**
     * 年干-颜色
     */
    private String yearGanColor;

    /**
     * 月干-颜色
     */
    private String monthGanColor;

    /**
     * 日干-颜色
     */
    private String dayGanColor;

    /**
     * 时干-颜色
     */
    private String timeGanColor;

    /**
     * 年支-颜色
     */
    private String yearZhiColor;

    /**
     * 月支-颜色
     */
    private String monthZhiColor;

    /**
     * 日支-颜色
     */
    private String dayZhiColor;

    /**
     * 时支-颜色
     */
    private String timeZhiColor;


    /**
     * 天干十神信息
     */
    private List<GanTenGodVO> tenGodStatusList;

    /**
     * 地支藏干List  数组0 1 2 3分别对应年 月 日 时 地支的藏干信息
     */
    private List<HiddenGanVO> zhiHiddenGanList;

    /**
     * 天干合冲信息
     */
    private String ganSyzygyStatus;

    /**
     * 地支合冲状态
     */
    private String zhiSyzygyStatus;

    /**
     * 神煞
     */
    private List<List<String>> holyGeneralList;

    /**
     * 性别
     */
    private String gender;


    /**
     * 纳音
     */
    private List<String> voliceList;

    /**
     * 空亡
     */
    private List<String> fallList;


    /**
     * 感情桃花位
     */
    private String loveInHome;

    /**
     * 社会桃花位
     */
    private String loveInSociety;

    /**
     * 文昌位
     */
    private String literature;

    /**
     * 袁天罡称骨
     */
    private String yuanTianGang;

    /**
     * 起大运时间
     */
    private String fateStart;

}
