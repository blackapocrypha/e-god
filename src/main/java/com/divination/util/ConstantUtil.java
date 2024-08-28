package com.divination.util;

import java.util.Arrays;
import java.util.List;

/**
 * 常量工具
 */
public class ConstantUtil {

    /**
     * 天干列表
     */
    public static List<String> ganList = Arrays.asList("甲","乙","丙","丁","戊","己","庚","辛","壬","癸");
    /**
     * 阳干列表
     */
    public static List<String> yangGanList = Arrays.asList("甲","丙","戊","庚","壬");
    /**
     * 阴干列表
     */
    public static List<String> yinGanList = Arrays.asList("乙","丁","己","辛","癸");

    /**
     * 地支列表
     */
    public static List<String> zhiList = Arrays.asList("子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥");

    /**
     * 地支对应五行列表
     */
    public static List<String> zhiEnergyList = Arrays.asList("水","土","木","木","土","火","火","土","金","金","土","水");

    /**
     * 六十甲子
     */
    public static final List<String> jiaziList = Arrays.asList(
            "甲子", "乙丑", "丙寅", "丁卯", "戊辰", "己巳",
            "庚午", "辛未", "壬申", "癸酉", "甲戌", "乙亥",
            "丙子", "丁丑", "戊寅", "己卯", "庚辰", "辛巳",
            "壬午", "癸未", "甲申", "乙酉", "丙戌", "丁亥",
            "戊子", "己丑", "庚寅", "辛卯", "壬辰", "癸巳",
            "甲午", "乙未", "丙申", "丁酉", "戊戌", "己亥",
            "庚子", "辛丑", "壬寅", "癸卯", "甲辰", "乙巳",
            "丙午", "丁未", "戊申", "己酉", "庚戌", "辛亥",
            "壬子", "癸丑", "甲寅", "乙卯", "丙辰", "丁巳",
            "戊午", "己未", "庚申", "辛酉", "壬戌", "癸亥"
    );

}
