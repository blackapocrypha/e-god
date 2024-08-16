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


}
