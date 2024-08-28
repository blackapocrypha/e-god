package com.divination.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EightGodTimeVO {

    /**
     * 流年 - 大运
     */
    private String timeLuckyGan;

    /**
     * 流年 - 年干
     */
    private String timeYearGan;

    /**
     * 流年 - 月干
     */
    private String timeMonthGan;

    /**
     * 流年 - 日干
     */
    private String timeDayGan;




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
     * 流年 - 大运
     */
    private String timeLuckyZhi;

    /**
     * 流年 - 年支
     */
    private String timeYearZhi;

    /**
     * 流年 - 月支
     */
    private String timeMonthZhi;

    /**
     * 流年 - 日支
     */
    private String timeDayZhi;


    /**
     * 天干十神信息
     */
    private List<GanTenGodVO> tenGodStatusList;

    /**
     * 地支藏干List  数组0 1 2 3分别对应年 月 日 时 地支的藏干信息
     */
    private List<HiddenGanVO> zhiHiddenGanList;

    /**
     * 十年大运
     */
    private List<TimeLuckyVO> tenLuckyList;

    /**
     * 流年列表
     */
    private List<TimeLuckyVO> flowYearList;

    /**
     * 流月列表
     */
    private List<TimeLuckyVO> flowMonthList;

    /**
     * 流日列表
     */
    private List<TimeLuckyVO> flowDayList;

    /**
     * 天干合冲信息
     */
    private String ganSyzygyStatus;

    /**
     * 地支合冲状态
     */
    private String zhiSyzygyStatus;


    /**
     * 性别
     */
    private String gender;



}
