package com.divination.util;

import java.util.Arrays;

/**
 * 桃花工具类
 */
public class LoveUtil {

    /**
     * 看年支和日支，年支桃花主要主社会上招人喜欢，日支桃花则是主夫妻姻缘
     *
     * 寅午戌兔从卯里出【生肖虎、马、狗的桃花为兔】
     * 申子辰鸡叫乱人伦【生肖猴、鼠、龙的桃花为鸡】
     * 亥卯未鼠子当头忌【生肖猪、兔、羊的桃花为鼠】
     * 巳酉丑跃马南方走【生肖蛇、鸡、牛的桃花为马】
     * @param zhi 地支
     * @return
     */
    public static String getLove(String zhi){
        if(Arrays.asList("申","子","辰").contains(zhi)){
            return "鸡";
        }
        else if(Arrays.asList("寅","午","戌").contains(zhi)){
            return "兔";
        }
        else if(Arrays.asList("亥","卯","未").contains(zhi)){
            return "鼠";
        }
        else {
            return "马";
        }
    }

}
