package com.divination.util;

import java.util.Arrays;
import java.util.List;

/**
 * 二十四节气中的节工具
 */
public class JieUtil {

    /**
     * 节
     */
    public static List<String> jieList = Arrays.asList("立冬","大雪","小寒","立春","惊蛰","清明","立夏","芒种","小暑", "立秋","白露","寒露");

    /**
     * 根据当前节的名字获取下一个节
     */
    public static String  getNextJieByThisJie(String name){
        int size = jieList.size();
        for (int i = 0; i < jieList.size(); i++) {
           if( jieList.get(i).equals(name)){
               int next = i+1;
               if(next<size){
                   return jieList.get(next);
               }
           }
        }
        return "立冬";
    }


    /**
     * 根据当前节的名字获取上一个节
     */
    public static String  getLastJieByThisJie(String name){
        int size = jieList.size();
        for (int i = 0; i < jieList.size(); i++) {
            if(jieList.get(i).equals(name)){
                int next = size-i;
                if(next>=0){
                    return jieList.get(next);
                }
            }
        }
        return "寒露";
    }
}
