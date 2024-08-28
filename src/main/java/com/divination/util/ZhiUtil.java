package com.divination.util;

import com.nlf.calendar.Lunar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 地支工具类
 */
public class ZhiUtil {

    /**
     * 根据地支list获取对应的合冲状态
     * @param list 地支列表
     * @return
     */
    public static String findZhiSyzygyStatus(List<String> list, Lunar lunar){
        StringBuilder stringBuilder = new StringBuilder();

        // 0 三刑
        if(list.contains("丑") && list.contains("未") && list.contains("戌")){
            stringBuilder.append("丑未戌恃势之刑  ");
        }
        if(list.contains("寅") && list.contains("巳")  && list.contains("申")){
            stringBuilder.append("寅巳申无恩之刑  ");
        }
        if(list.contains("卯") && list.contains("子")){
            stringBuilder.append("子卯无礼之刑  ");
        }

        // 1 三会
        if(list.contains("寅") && list.contains("卯") && list.contains("辰")){
            stringBuilder.append("寅卯辰三会东方木  ");
        }
        if(list.contains("巳") && list.contains("午") && list.contains("未")){
            stringBuilder.append("巳午未三会南方火  ");
        }
        if(list.contains("申") && list.contains("酉") && list.contains("戌")){
            stringBuilder.append("申酉戌三会西方金  ");
        }
        if(list.contains("亥") && list.contains("子") && list.contains("丑")){
            stringBuilder.append("亥子丑三会北方水  ");
        }


        // 2 三合
        if(list.contains("申") && list.contains("子") && list.contains("辰")){
            stringBuilder.append("申子辰三合水  ");
        }
        if(list.contains("亥") && list.contains("卯") && list.contains("未")){
            stringBuilder.append("亥卯未三合木  ");
        }
        if(list.contains("寅") && list.contains("午") && list.contains("戌")){
            stringBuilder.append("寅午戌三合火  ");
        }
        if(list.contains("巳") && list.contains("酉") && list.contains("丑")){
            stringBuilder.append("巳酉丑三合金  ");
        }

        // 3 六合
        if(list.contains("子") && list.contains("丑")){
            stringBuilder.append("子丑合土  ");
        }
        if(list.contains("寅") && list.contains("亥")){
            stringBuilder.append("寅亥合木  ");
        }
        if(list.contains("卯") && list.contains("戌")){
            stringBuilder.append("卯戌合火  ");
        }
        if(list.contains("辰") && list.contains("酉")){
            stringBuilder.append("辰酉合成金  ");
        }
        if(list.contains("巳") && list.contains("申")){
            stringBuilder.append("巳申合成水  ");
        }
        if(list.contains("午") && list.contains("未")){
            // 午未合既有可能是火也可能是土，按照八字里燥热程度来区分，这里火有三成则为火
            Integer fireEnergyStatus = FiveEnergyUtil.getFireEnergyStatus(Arrays.asList(lunar.getYearGan(),
                    lunar.getMonthGan(), lunar.getDayGan(), lunar.getTimeGan(),
                    lunar.getYearZhi(), lunar.getMonthZhi(), lunar.getDayZhi(), lunar.getTimeZhi()));
            if(fireEnergyStatus == 0){
                stringBuilder.append("午未合土  ");
            }else{
                stringBuilder.append("午未合火  ");
            }
        }


        // 4 六冲
        if(list.contains("子") && list.contains("午")){
            stringBuilder.append("子午冲  ");
        }
        if(list.contains("卯") && list.contains("酉")){
            stringBuilder.append("卯酉冲  ");
        }
        if(list.contains("寅") && list.contains("申")){
            stringBuilder.append("寅申冲  ");
        }
        if(list.contains("巳") && list.contains("亥")){
            stringBuilder.append("巳亥冲  ");
        }
        if(list.contains("辰") && list.contains("戌")){
            stringBuilder.append("辰戌冲  ");
        }
        if(list.contains("丑") && list.contains("未")){
            stringBuilder.append("丑未冲  ");
        }

        // 5 六害
        if(list.contains("寅") && list.contains("巳")){
            stringBuilder.append("寅巳害  ");
        }
        if(list.contains("卯") && list.contains("辰")){
            stringBuilder.append("卯辰害  ");
        }
        if(list.contains("酉") && list.contains("戌")){
            stringBuilder.append("酉戌害  ");
        }
        if(list.contains("申") && list.contains("亥")){
            stringBuilder.append("申亥害  ");
        }
        if(list.contains("丑") && list.contains("午")){
            stringBuilder.append("丑午害  ");
        }
        if(list.contains("子") && list.contains("未")){
            stringBuilder.append("子未害  ");
        }

        // 6 六破
        if(list.contains("子") && list.contains("酉")){
            stringBuilder.append("子酉破  ");
        }
        if(list.contains("寅") && list.contains("亥")){
            stringBuilder.append("寅亥破  ");
        }
        if(list.contains("卯") && list.contains("午")){
            stringBuilder.append("卯午破  ");
        }
        if(list.contains("辰") && list.contains("丑")){
            stringBuilder.append("辰丑破  ");
        }
        if(list.contains("巳") && list.contains("申")){
            stringBuilder.append("巳申破  ");
        }
        if(list.contains("戌") && list.contains("未")){
            stringBuilder.append("未戌破  ");
        }

        // 辰午酉亥 自刑
        if(list.stream().filter(f->f.equals("午")).collect(Collectors.toList()).size()>=2){
            stringBuilder.append("午午自刑  ");
        }
        if(list.stream().filter(f->f.equals("辰")).collect(Collectors.toList()).size()>=2){
            stringBuilder.append("辰辰自刑  ");
        }
        if(list.stream().filter(f->f.equals("酉")).collect(Collectors.toList()).size()>=2){
            stringBuilder.append("酉酉自刑  ");
        }
        if(list.stream().filter(f->f.equals("亥")).collect(Collectors.toList()).size()>=2){
            stringBuilder.append("亥亥自刑  ");
        }

        return stringBuilder.toString();
    }

}
