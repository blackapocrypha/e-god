package com.divination.util;

import com.nlf.calendar.Lunar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 神煞工具类
 */
public class HolyGeneralUtil {

    /**
     * 根据地支详情获取神煞
     *
     * @param lunar 八字信息
     * @return
     */
    public static List<List<String>> getHolyGeneral(Lunar lunar,String gender){
        /**
         * 录入神煞：
         * 天乙贵人，月德贵人，天德贵人，太极贵人，文昌贵人，国印贵人，天厨贵人,魁罡贵人 天赫贵人，
         * 驿马，劫煞，灾煞，桃花，华盖，血刃，学堂，词馆，将星，金舆，天医，红鸾，六厄，披麻，
         * 亡神，羊刃，十灵日，童子煞，十恶大败，勾绞煞，红艳煞，丧门，吊客，孤辰，寡宿，阴差阳错，
         * 福星贵人，德秀贵人，金神,天罗地网
         */

        List<List<String>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        // 地支列表
        List<String> zhiList = Arrays.asList(lunar.getYearZhi(), lunar.getMonthZhi(), lunar.getDayZhi(), lunar.getTimeZhi());
        List<String> ganList = Arrays.asList(lunar.getYearGan(), lunar.getMonthGan(), lunar.getDayGan(), lunar.getTimeGan());


        /**
         * 天乙贵人
         * 甲戊庚遇到丑未，乙己遇到子申  丙丁遇到亥酉，壬癸遇到已卯，庚辛遇到午寅
         */
        String yearGan = lunar.getYearGan();
        String dayGan = lunar.getDayGan();
        List<String> yearDayGanList = Arrays.asList(yearGan, dayGan);
        for (String gan : yearDayGanList) {
            if(Arrays.asList("甲","戊","庚").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("丑","未").contains(zhiList.get(i))){
                        list.get(i).add("天乙贵人");
                    }
                }

            }else if(Arrays.asList("乙","己").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("子","申").contains(zhiList.get(i))){
                        list.get(i).add("天乙贵人");
                    }
                }
            }
            else if(Arrays.asList("丙","丁").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("亥","酉").contains(zhiList.get(i))){
                        list.get(i).add("天乙贵人");
                    }
                }
            }
            else if(Arrays.asList("壬","癸").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("已","卯").contains(zhiList.get(i))){
                        list.get(i).add("天乙贵人");
                    }
                }
            }
            else if(Arrays.asList("庚","辛").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("午","寅").contains(zhiList.get(i))){
                        list.get(i).add("天乙贵人");
                    }
                }
            }
        }

        /**
         * 天德贵人
         * 寅月生者见丁	申月生者见癸	卯月生者见申	酉月生者见寅 辰月生者见壬	戌月生者见丙
         * 已月生者见辛	亥月生者见乙  午月生者见亥	子月生者见已	未月生者见甲	丑月生者见庚
         */
        String monthZhi = lunar.getMonthZhi();
        if(monthZhi.equals("寅")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("丁".equals(zhiList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }
        else if(monthZhi.equals("申")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("癸".equals(zhiList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }
        else if(monthZhi.equals("卯")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("申".equals(zhiList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }
        else if(monthZhi.equals("酉")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("寅".equals(zhiList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }
        else if(monthZhi.equals("辰")){
            for (int i = 0; i < ganList.size(); i++) {
                if("壬".equals(ganList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }
        else if(monthZhi.equals("戌")){
            for (int i = 0; i < ganList.size(); i++) {
                if("丙".equals(ganList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }
        else if(monthZhi.equals("己")){
            for (int i = 0; i < ganList.size(); i++) {
                if("辛".equals(ganList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }
        else if(monthZhi.equals("亥")){
            for (int i = 0; i < ganList.size(); i++) {
                if("乙".equals(ganList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }
        else if(monthZhi.equals("午")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("亥".equals(zhiList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }
        else if(monthZhi.equals("子")){
            for (int i = 0; i < ganList.size(); i++) {
                if("己".equals(ganList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }
        else if(monthZhi.equals("未")){
            for (int i = 0; i < ganList.size(); i++) {
                if("甲".equals(ganList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }
        else if(monthZhi.equals("丑")){
            for (int i = 0; i < ganList.size(); i++) {
                if("庚".equals(ganList.get(i))){
                    list.get(i).add("天德贵人");
                }
            }
        }

        /**
         * 天厨贵人
         * "甲巳", "乙午", "丙巳", "丁午","戊申","己酉","庚亥","辛子","壬巳","癸午"
         */
        List<String> foodGodList = Arrays.asList("甲巳", "乙午", "丙巳", "丁午","戊申","己酉","庚亥","辛子","壬巳","癸午");
        for (int i = 0; i < ganList.size(); i++) {
            // 只判断年日两柱
            if(i==1 || i==3){continue;}
            String string = ganList.get(i);
            for (String zhi : zhiList) {
                String ganzhi = string+zhi;
                if(foodGodList.contains(ganzhi)){
                    list.get(i).add("天厨贵人");
                }
            }
        }

        /**
         * 魁罡贵人
         * "庚辰", "庚戌", "壬辰", "戊戌" 四日
         */
        List<String> ironGodList = Arrays.asList("庚辰", "庚戌", "壬辰", "戊戌");
        for (int i = 0; i < ganList.size(); i++) {
            // 只判断日柱
            if(i!=2){continue;}
            String string = ganList.get(i);
            for (String zhi : zhiList) {
                String ganzhi = string+zhi;
                if(ironGodList.contains(ganzhi)){
                    list.get(i).add("魁罡贵人");
                }
            }
        }

        /**
         * 天赫贵人
         * 春季寅、卯、辰月（农历正、二、三月）出生人，若日主为戊寅，则就是命带天赦；
         * 夏季巳、午、未月（农历四、五、六月）出生人，若日主为甲午，则就是命带天赦；
         * 秋季申、酉、戌月（农历七、八、九月）出生人，若日主为戊申，则就是命带天赦；
         * 冬季亥、子、丑月（十、十一、十二月）出生人，若日主为甲子，则就是命带天赦
         */
        String tempMonthZhi = lunar.getMonthZhi();
        String dayMaster = lunar.getDayGan()+lunar.getDayZhi();
        if(Arrays.asList("寅","卯","辰").contains(tempMonthZhi)){
            if(dayMaster.equals("戊寅")){
                list.get(1).add("天赫贵人");
            }
        } else if(Arrays.asList("巳","午","未").contains(tempMonthZhi)){
            if(dayMaster.equals("甲午")){
                list.get(1).add("天赫贵人");
            }
        }else if(Arrays.asList("申","酉","戌").contains(tempMonthZhi)){
            if(dayMaster.equals("戊申")){
                list.get(1).add("天赫贵人");
            }
        }else if(Arrays.asList("亥","子","丑").contains(tempMonthZhi)){
            if(dayMaster.equals("甲子")){
                list.get(1).add("天赫贵人");
            }
        }


        /**
         * 月德贵人
         * 寅午戌月生者见丙，申子辰月生者见壬,亥卯未月生者见甲，已酉丑月生者见庚
         */
        if(Arrays.asList("寅","午","戌").contains(monthZhi)) {
            for (int i = 0; i < ganList.size(); i++) {
                if ("丙".equals(ganList.get(i))) {
                    list.get(i).add("月德贵人");
                }
            }
        }
        else if(Arrays.asList("申","子","辰").contains(monthZhi)) {
            for (int i = 0; i < ganList.size(); i++) {
                if ("壬".equals(ganList.get(i))) {
                    list.get(i).add("月德贵人");
                }
            }
        }
        else if(Arrays.asList("亥","卯","未").contains(monthZhi)) {
            for (int i = 0; i < ganList.size(); i++) {
                if ("甲".equals(ganList.get(i))) {
                    list.get(i).add("月德贵人");
                }
            }
        }
        else if(Arrays.asList("巳","酉","丑").contains(monthZhi)) {
            for (int i = 0; i < ganList.size(); i++) {
                if ("庚".equals(ganList.get(i))) {
                    list.get(i).add("月德贵人");
                }
            }
        }


        /**
         * 驿马
         * 申子辰马在寅，寅午戌马在申，已酉丑马在亥，亥卯未马在巳
         */
        String yearZhi = lunar.getYearZhi();
        String dayZhi = lunar.getDayZhi();
        List<String> yearDayZhiList = Arrays.asList(yearZhi, dayZhi);
        for (String zhi : yearDayZhiList) {
            if(Arrays.asList("申","子","辰").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("寅".equals(zhiList.get(i))){
                        list.get(i).add("驿马");
                    }
                }
            }else if(Arrays.asList("寅","午","戌").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("申".equals(zhiList.get(i))){
                        list.get(i).add("驿马");
                    }
                }
            }
            else if(Arrays.asList("已","酉","丑").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("亥".equals(zhiList.get(i))){
                        list.get(i).add("驿马");
                    }
                }
            }
            else if(Arrays.asList("亥","卯","未").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("巳".equals(zhiList.get(i))){
                        list.get(i).add("驿马");
                    }
                }
            }

        }


        /**
         * 太极贵人
         * 以年干或日干看地支，是甲或乙的地支再遇到子或午，是丙或丁的地支再遇到卯或酉，是戊或己的地支再遇到辰或戌或丑或未，是庚或辛的地支再遇到寅或亥，是壬或癸的地支再遇到巳或申
         */
        for (String gan : yearDayGanList) {
            if(Arrays.asList("甲","乙").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("子","午").contains(zhiList.get(i))){
                        list.get(i).add("太极贵人");
                    }
                }
            }else if(Arrays.asList("丙","丁").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("卯","酉").contains(zhiList.get(i))){
                        list.get(i).add("太极贵人");
                    }
                }
            }
            else if(Arrays.asList("戊","己").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("辰","戌","丑","未").contains(zhiList.get(i))){
                        list.get(i).add("太极贵人");
                    }
                }
            }else if(Arrays.asList("庚","辛").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("寅","亥").contains(zhiList.get(i))){
                        list.get(i).add("太极贵人");
                    }
                }
            }
            else if(Arrays.asList("壬","癸").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("巳","申").contains(zhiList.get(i))){
                        list.get(i).add("太极贵人");
                    }
                }
            }
        }


        /**
         * 华盖
         * 寅午戌见戌，亥卯未见未
         * 申子辰见辰，已酉丑见丑
         */
        for (String zhi : yearDayZhiList) {
            if(Arrays.asList("申","子","辰").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("辰".equals(zhiList.get(i))){
                        list.get(i).add("华盖");
                    }
                }
            }else if(Arrays.asList("寅","午","戌").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("戌".equals(zhiList.get(i))){
                        list.get(i).add("华盖");
                    }
                }
            }
            else if(Arrays.asList("已","酉","丑").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("丑".equals(zhiList.get(i))){
                        list.get(i).add("华盖");
                    }
                }
            }
            else if(Arrays.asList("亥","卯","未").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("未".equals(zhiList.get(i))){
                        list.get(i).add("华盖");
                    }
                }
            }
        }

        /**
         * 桃花
         * 寅午戌兔从茅里出【生肖虎、马、狗的桃花为兔】
         * 申子辰鸡叫乱人伦【生肖猴、鼠、龙的桃花为鸡】
         * 亥卯未鼠子当头忌【生肖猪、兔、羊的桃花为鼠】
         * 已酉丑跃马南方走【生肖蛇、鸡、牛的桃花为马】
         */
        for (String zhi : yearDayZhiList) {
            if(Arrays.asList("申","子","辰").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("酉".equals(zhiList.get(i))){
                        list.get(i).add("桃花");
                    }
                }
            }else if(Arrays.asList("寅","午","戌").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("卯".equals(zhiList.get(i))){
                        list.get(i).add("桃花");
                    }
                }
            }
            else if(Arrays.asList("巳","酉","丑").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("午".equals(zhiList.get(i))){
                        list.get(i).add("桃花");
                    }
                }
            }
            else if(Arrays.asList("亥","卯","未").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("子".equals(zhiList.get(i))){
                        list.get(i).add("桃花");
                    }
                }
            }
        }

        /**
         * 劫煞
         * 申子辰兮蛇开口，申子辰见巳；亥卯未兮猴速走，亥卯未见申
         * 寅午戌兮猪面黑，寅午戌见亥；巳酉丑兮虎哮吼，巳酉丑见寅
         */
        for (String zhi : yearDayZhiList) {
            if(Arrays.asList("申","子","辰").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("巳".equals(zhiList.get(i))){
                        list.get(i).add("劫煞");
                    }
                }
            }else if(Arrays.asList("寅","午","戌").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("亥".equals(zhiList.get(i))){
                        list.get(i).add("劫煞");
                    }
                }
            }
            else if(Arrays.asList("巳","酉","丑").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("寅".equals(zhiList.get(i))){
                        list.get(i).add("劫煞");
                    }
                }
            }
            else if(Arrays.asList("亥","卯","未").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("申".equals(zhiList.get(i))){
                        list.get(i).add("劫煞");
                    }
                }
            }
        }

        /**
         * 灾煞
         * 申子辰见午，卯未见酉，寅午戌见子，巳酉丑见卯
         */
        if(Arrays.asList("申","子","辰").contains(yearZhi)){
            for (int i = 0; i < zhiList.size(); i++) {
                if("午".equals(zhiList.get(i))){
                    list.get(i).add("灾煞");
                }
            }
        }else if(Arrays.asList("寅","午","戌").contains(yearZhi)){
            for (int i = 0; i < zhiList.size(); i++) {
                if("子".equals(zhiList.get(i))){
                    list.get(i).add("灾煞");
                }
            }
        }
        else if(Arrays.asList("巳","酉","丑").contains(yearZhi)){
            for (int i = 0; i < zhiList.size(); i++) {
                if("卯".equals(zhiList.get(i))){
                    list.get(i).add("灾煞");
                }
            }
        }
        else if(Arrays.asList("亥","卯","未").contains(yearZhi)){
            for (int i = 0; i < zhiList.size(); i++) {
                if("酉".equals(zhiList.get(i))){
                    list.get(i).add("灾煞");
                }
            }
        }

        /**
         * 将星
         * 寅午戌见午，巳酉丑见酉，申子辰见子，辛卯未见卯。
         */
        for (String zhi : yearDayZhiList) {
            if(Arrays.asList("申","子","辰").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("子".equals(zhiList.get(i))){
                        list.get(i).add("将星");
                    }
                }
            }else if(Arrays.asList("寅","午","戌").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("午".equals(zhiList.get(i))){
                        list.get(i).add("将星");
                    }
                }
            }
            else if(Arrays.asList("巳","酉","丑").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("酉".equals(zhiList.get(i))){
                        list.get(i).add("将星");
                    }
                }
            }
            else if(Arrays.asList("亥","卯","未").contains(zhi)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("卯".equals(zhiList.get(i))){
                        list.get(i).add("将星");
                    }
                }
            }
        }

        /**
         * 金舆
         * 甲龙乙蛇丙戊羊，丁己猴歌庚犬方，辛猪壬牛癸逢虎
         */
        if(dayGan.equals("甲")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("辰".equals(zhiList.get(i))){
                    list.get(i).add("金舆");
                }
            }
        }else if(dayGan.equals("乙")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("巳".equals(zhiList.get(i))){
                    list.get(i).add("金舆");
                }
            }
        }
        else if(dayGan.equals("丙")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("未".equals(zhiList.get(i))){
                    list.get(i).add("金舆");
                }
            }
        }
        else if(dayGan.equals("丁")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("酉".equals(zhiList.get(i))){
                    list.get(i).add("金舆");
                }
            }
        }
        else if(dayGan.equals("戊")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("未".equals(zhiList.get(i))){
                    list.get(i).add("金舆");
                }
            }
        }
        else if(dayGan.equals("己")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("酉".equals(zhiList.get(i))){
                    list.get(i).add("金舆");
                }
            }
        }
        else if(dayGan.equals("庚")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("戌".equals(zhiList.get(i))){
                    list.get(i).add("金舆");
                }
            }
        }
        else if(dayGan.equals("辛")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("亥".equals(zhiList.get(i))){
                    list.get(i).add("金舆");
                }
            }
        }
        else if(dayGan.equals("壬")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("丑".equals(zhiList.get(i))){
                    list.get(i).add("金舆");
                }
            }
        }else if(dayGan.equals("癸")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("寅".equals(zhiList.get(i))){
                    list.get(i).add("金舆");
                }
            }
        }


        /**
         * 血刃
         * 日元是甲，地支见卯；日元是己，地支见未
         * 日元是乙，地支见辰；日元是庚，地支见酉
         * 日元是丙，地支见午；日元是辛，地支见戌
         * 日元是丁，地支见未；日元是壬，地支见子
         * 日元是戊，地支见午；日元是癸，地支见丑
         */
        if(dayGan.equals("甲")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("卯".equals(zhiList.get(i))){
                    list.get(i).add("血刃");
                }
            }
        }else if(dayGan.equals("乙")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("辰".equals(zhiList.get(i))){
                    list.get(i).add("血刃");
                }
            }
        }
        else if(dayGan.equals("丙")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("午".equals(zhiList.get(i))){
                    list.get(i).add("血刃");
                }
            }
        }
        else if(dayGan.equals("丁")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("未".equals(zhiList.get(i))){
                    list.get(i).add("血刃");
                }
            }
        }
        else if(dayGan.equals("戊")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("午".equals(zhiList.get(i))){
                    list.get(i).add("血刃");
                }
            }
        }
        else if(dayGan.equals("己")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("未".equals(zhiList.get(i))){
                    list.get(i).add("血刃");
                }
            }
        }
        else if(dayGan.equals("庚")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("酉".equals(zhiList.get(i))){
                    list.get(i).add("血刃");
                }
            }
        }
        else if(dayGan.equals("辛")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("戌".equals(zhiList.get(i))){
                    list.get(i).add("血刃");
                }
            }
        }
        else if(dayGan.equals("壬")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("子".equals(zhiList.get(i))){
                    list.get(i).add("血刃");
                }
            }
        }else if(dayGan.equals("癸")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("丑".equals(zhiList.get(i))){
                    list.get(i).add("血刃");
                }
            }
        }


        /**
         * 文昌贵人
         * 甲乙巳午报君知，丙戊申宫丁己鸡。庚猪辛鼠壬逢虎，癸人见卯入云梯
         * 甲见巳，乙见午，丙见申，戊见申，丁见酉，己见酉，庚见亥，辛见子，壬见寅，癸见卯
         */
        for (String gan : yearDayGanList) {
            if("甲".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("巳".equals(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if("乙".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("午".equals(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if("丙".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("申".equals(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if("戊".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("申".equals(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if("丁".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("酉".equals(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if("己".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("酉".equals(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if("庚".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("亥".equals(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if("辛".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("子".equals(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if("壬".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("寅".equals(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if("癸".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("卯".equals(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }

        }


        /**
         * 国印贵人
         * 甲见戌，乙见亥，丙见丑，丁见寅，戊见丑，己见寅，庚见辰，辛见巳。壬见未，癸见申
         */
        for (String gan : yearDayGanList){
            if(gan.equals("甲")){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("戌".equals(zhiList.get(i))){
                        list.get(i).add("国印贵人");
                    }
                }
            }else if(gan.equals("乙")){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("亥".equals(zhiList.get(i))){
                        list.get(i).add("国印贵人");
                    }
                }
            }
            else if(gan.equals("丙")){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("丑".equals(zhiList.get(i))){
                        list.get(i).add("国印贵人");
                    }
                }
            }
            else if(gan.equals("丁")){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("寅".equals(zhiList.get(i))){
                        list.get(i).add("国印贵人");
                    }
                }
            }
            else if(gan.equals("戊")){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("丑".equals(zhiList.get(i))){
                        list.get(i).add("国印贵人");
                    }
                }
            }
            else if(gan.equals("己")){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("寅".equals(zhiList.get(i))){
                        list.get(i).add("国印贵人");
                    }
                }
            }
            else if(gan.equals("庚")){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("辰".equals(zhiList.get(i))){
                        list.get(i).add("国印贵人");
                    }
                }
            }
            else if(gan.equals("辛")){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("巳".equals(zhiList.get(i))){
                        list.get(i).add("国印贵人");
                    }
                }
            }
            else if(gan.equals("壬")){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("未".equals(zhiList.get(i))){
                        list.get(i).add("国印贵人");
                    }
                }
            }else if(gan.equals("癸")){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("申".equals(zhiList.get(i))){
                        list.get(i).add("国印贵人");
                    }
                }
            }
        }

        /**
         * 学堂
         * 金命见巳，辛巳为正; 木命见亥，己亥为正; 水命见申，甲申为正; 土命见申，戊申为正; 火命见寅，丙寅为正。
         */
        String nayinwuxing = lunar.getEightChar().getYearNaYin().substring(2, 3);
        if("火".equals(nayinwuxing)){
            for (int i = 1; i < zhiList.size(); i++) {
                if("寅".equals(zhiList.get(i))){
                    list.get(i).add("学堂");
                }
            }
        }
        else if("水".equals(nayinwuxing)){
            for (int i = 1; i < zhiList.size(); i++) {
                if("申".equals(zhiList.get(i))){
                    list.get(i).add("学堂");
                }
            }
        }
        else if("金".equals(nayinwuxing)){
            for (int i = 1; i < zhiList.size(); i++) {
                if("巳".equals(zhiList.get(i))){
                    list.get(i).add("学堂");
                }
            }
        }
        else if("木".equals(nayinwuxing)){
            for (int i = 1; i < zhiList.size(); i++) {
                if("亥".equals(zhiList.get(i))){
                    list.get(i).add("学堂");
                }
            }
        }
        else if("土".equals(nayinwuxing)){
            for (int i = 1; i < zhiList.size(); i++) {
                if("申".equals(zhiList.get(i))){
                    list.get(i).add("学堂");
                }
            }
        }


        /**
         * 词馆
         * 甲干见庚寅，乙干见辛卯，丙干见乙巳，丁干见戊午，戊干见丁巳，己干见庚午，庚干见壬申，辛干见癸酉，壬干见癸亥，癸干见壬戌
         */
        List<String> allGanZhi = Arrays.asList(lunar.getYearGan() + lunar.getYearZhi(), lunar.getMonthGan() + lunar.getMonthZhi(), lunar.getDayGan() + lunar.getDayZhi(), lunar.getTimeGan() + lunar.getTimeZhi());
        for (String gan : yearDayGanList){
            if("甲".equals(gan)){
                for (int i = 0; i < allGanZhi.size(); i++) {
                   if("庚寅".equals(allGanZhi.get(i))){
                       list.get(i).add("词馆");
                   }
                }
            }else if("乙".equals(gan)){
                for (int i = 0; i < allGanZhi.size(); i++) {
                    if("辛卯".equals(allGanZhi.get(i))){
                        list.get(i).add("词馆");
                    }
                }
            }
            else if("丙".equals(gan)){
                for (int i = 0; i < allGanZhi.size(); i++) {
                    if("乙巳".equals(allGanZhi.get(i))){
                        list.get(i).add("词馆");
                    }
                }
            }
            else if("丁".equals(gan)){
                for (int i = 0; i < allGanZhi.size(); i++) {
                    if("戊午".equals(allGanZhi.get(i))){
                        list.get(i).add("词馆");
                    }
                }
            }
            else if("戊".equals(gan)){
                for (int i = 0; i < allGanZhi.size(); i++) {
                    if("丁巳".equals(allGanZhi.get(i))){
                        list.get(i).add("词馆");
                    }
                }
            }
            else if("己".equals(gan)){
                for (int i = 0; i < allGanZhi.size(); i++) {
                    if("庚午".equals(allGanZhi.get(i))){
                        list.get(i).add("词馆");
                    }
                }
            }
            else if("庚".equals(gan)){
                for (int i = 0; i < allGanZhi.size(); i++) {
                    if("壬申".equals(allGanZhi.get(i))){
                        list.get(i).add("词馆");
                    }
                }
            }
            else if("辛".equals(gan)){
                for (int i = 0; i < allGanZhi.size(); i++) {
                    if("癸酉".equals(allGanZhi.get(i))){
                        list.get(i).add("词馆");
                    }
                }
            }
            else if("壬".equals(gan)){
                for (int i = 0; i < allGanZhi.size(); i++) {
                    if("癸亥".equals(allGanZhi.get(i))){
                        list.get(i).add("词馆");
                    }
                }
            }
            else if("癸".equals(gan)){
                for (int i = 0; i < allGanZhi.size(); i++) {
                    if("壬戌".equals(allGanZhi.get(i))){
                        list.get(i).add("词馆");
                    }
                }
            }
        }


        /**
         * 天医
         * 正月生见丑，二月生见寅，三月生见卯，四月生见辰，五月生见巳，六月生见午，七月生见未，八月生见申，九月生见酉，十月生见戌，十一月生见亥，十二月生见子
         */

        if(monthZhi.equals("寅")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("丑".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }else if(monthZhi.equals("卯")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("寅".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }
        else if(monthZhi.equals("辰")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("卯".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }
        else if(monthZhi.equals("巳")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("辰".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }
        else if(monthZhi.equals("午")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("巳".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }
        else if(monthZhi.equals("未")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("午".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }
        else if(monthZhi.equals("申")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("未".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }
        else if(monthZhi.equals("酉")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("申".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }
        else if(monthZhi.equals("戌")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("酉".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }else if(monthZhi.equals("亥")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("戌".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }
        else if(monthZhi.equals("子")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("亥".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }
        else if(monthZhi.equals("丑")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("子".equals(zhiList.get(i))){
                    list.get(i).add("天医");
                }
            }
        }

        /**
         * 红鸾
         * 以出生年支查四支，见之者为是。如年支为子，地支中有卯，则为红鸾桃花。
         * 如子见卯、丑见寅、寅见丑、卯见子、辰见亥、巳见戌，午见酉、未见申、申见未、酉见午、戌见巳、亥见辰等都是命中有红鸾
         */
        String tempYearZhi = lunar.getYearZhi();
        if(tempYearZhi.equals("子")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("卯")){
                    list.get(i).add("红鸾");break;
                }
            }
        }else if(tempYearZhi.equals("丑")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("寅")){
                    list.get(i).add("红鸾");break;
                }
            }
        }else if(tempYearZhi.equals("寅")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("丑")){
                    list.get(i).add("红鸾");break;
                }
            }
        }
        else if(tempYearZhi.equals("卯")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("子")){
                    list.get(i).add("红鸾");break;
                }
            }
        }
        else if(tempYearZhi.equals("辰")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("亥")){
                    list.get(i).add("红鸾");break;
                }
            }
        }
        else if(tempYearZhi.equals("巳")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("戌")){
                    list.get(i).add("红鸾");break;
                }
            }
        }
        else if(tempYearZhi.equals("午")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("酉")){
                    list.get(i).add("红鸾");break;
                }
            }
        }
        else if(tempYearZhi.equals("未")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("申")){
                    list.get(i).add("红鸾");break;
                }
            }
        }
        else if(tempYearZhi.equals("申")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("未")){
                    list.get(i).add("红鸾");break;
                }
            }
        }
        else if(tempYearZhi.equals("酉")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("午")){
                    list.get(i).add("红鸾");break;
                }
            }
        }     else if(tempYearZhi.equals("戌")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("巳")){
                    list.get(i).add("红鸾");break;
                }
            }
        }
        else if(tempYearZhi.equals("亥")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("辰")){
                    list.get(i).add("红鸾");break;
                }
            }
        }

        /**
         * 天喜
         * 以年支查其余三个地支，子见酉、丑见申、寅见未、卯见午、辰见巳、巳见辰；午见卯、未见寅、申见丑、酉见子、戌见亥、亥见戌。
         */
        if(tempYearZhi.equals("子")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("酉")){
                    list.get(i).add("天喜");break;
                }
            }
        }else if(tempYearZhi.equals("丑")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("申")){
                    list.get(i).add("天喜");break;
                }
            }
        }else if(tempYearZhi.equals("寅")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("未")){
                    list.get(i).add("天喜");break;
                }
            }
        }
        else if(tempYearZhi.equals("卯")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("午")){
                    list.get(i).add("天喜");break;
                }
            }
        }
        else if(tempYearZhi.equals("辰")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("巳")){
                    list.get(i).add("天喜");break;
                }
            }
        }
        else if(tempYearZhi.equals("巳")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("辰")){
                    list.get(i).add("天喜");break;
                }
            }
        }
        else if(tempYearZhi.equals("午")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("卯")){
                    list.get(i).add("天喜");break;
                }
            }
        }
        else if(tempYearZhi.equals("未")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("寅")){
                    list.get(i).add("天喜");break;
                }
            }
        }
        else if(tempYearZhi.equals("申")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("丑")){
                    list.get(i).add("天喜");break;
                }
            }
        }
        else if(tempYearZhi.equals("酉")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("子")){
                    list.get(i).add("天喜");break;
                }
            }
        }     else if(tempYearZhi.equals("戌")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("亥")){
                    list.get(i).add("天喜");break;
                }
            }
        }
        else if(tempYearZhi.equals("亥")){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("戌")){
                    list.get(i).add("天喜");break;
                }
            }
        }

        /**
         * 六厄
         * 年支为申子辰的，地支见卯，就为六厄；
         * 年支为寅午戌的，地支见酉，就是六厄；
         * 年支为亥卯未的，地支见午，就是六厄；
         * 年支为巳酉丑的，地支见子，就是六厄
         */
        if(Arrays.asList("申","子","辰").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("卯")){
                    list.get(i).add("六厄");
                    break;
                }
            }
        }
        else if(Arrays.asList("寅","午","戌").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("酉")){
                    list.get(i).add("六厄");
                    break;
                }
            }
        }
        else if(Arrays.asList("亥","卯","未").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("午")){
                    list.get(i).add("六厄");
                    break;
                }
            }
        }
        else if(Arrays.asList("巳","酉","丑").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                String zhiString = zhiList.get(i);
                if(zhiString.equals("子")){
                    list.get(i).add("六厄");
                    break;
                }
            }
        }


        /**
         * 披麻
         * 子见酉，丑见戌，寅见亥，卯见子，辰见丑，
         * 巳见寅，午见卯，未见辰，申见巳，酉见午，
         * 戌见未，亥见申。
         * 以年支或日支查余支。
         */
        List<String> parentLostList = Arrays.asList("子酉", "丑戌", "寅亥", "卯子","辰丑","巳寅","午卯","未辰","申巳","酉午","戌未","亥申");
        for (int i = 0; i < zhiList.size(); i++) {
            // 只判断年日两柱
            if(i!=0){continue;}
            String string = zhiList.get(i);
            for (String zhi : zhiList) {
                String ganzhi = string+zhi;
                if(parentLostList.contains(ganzhi)){
                    list.get(i).add("披麻");
                }
            }
        }

        /**
         * 亡神
         * 以年支日支看地支
         * 寅午戌见巳，亥卯未见寅，巳酉丑见申，申子辰见亥
         */
        for (String zhi : yearDayZhiList) {
            if(Arrays.asList("寅","午","戌").contains(zhi)) {
                for (int i = 0; i < zhiList.size(); i++) {
                    if ("巳".equals(zhiList.get(i))) {
                        list.get(i).add("亡神");
                    }
                }
            }
            else if(Arrays.asList("申","子","辰").contains(zhi)) {
                for (int i = 0; i < zhiList.size(); i++) {
                    if ("亥".equals(zhiList.get(i))) {
                        list.get(i).add("亡神");
                    }
                }
            }
            else if(Arrays.asList("亥","卯","未").contains(zhi)) {
                for (int i = 0; i < zhiList.size(); i++) {
                    if ("寅".equals(zhiList.get(i))) {
                        list.get(i).add("亡神");
                    }
                }
            }
            else if(Arrays.asList("巳","酉","丑").contains(zhi)) {
                for (int i = 0; i < zhiList.size(); i++) {
                    if ("申".equals(zhiList.get(i))) {
                        list.get(i).add("亡神");
                    }
                }
            }
        }


        /**
         * 元辰
         * 1、阳男阴女元辰
         * 子年见未，丑年见申，寅年见酉，卯年见戌，辰年见亥，巳年见子，午年见丑，未年见寅，申年见卯，酉年见辰，戌年见巳，亥年见午。
         *
         * 2、阴男阳女元辰
         * 子年见巳，丑年见午，寅年见未，卯年见申，辰年见酉，巳年见戌，午年见亥，未年见子，申年见丑，酉年见寅，戌年见卯，亥年见辰。
         */
        Integer yinYangByGan = YinYangUtil.getYinYangByGan(lunar.getDayGan());
        if((gender.equals("乾造") && yinYangByGan==1) || (gender.equals("坤造") && yinYangByGan==0) ){
            if(lunar.getYearZhi().equals("子")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("未".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }else if(lunar.getYearZhi().equals("丑")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("申".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }else if(lunar.getYearZhi().equals("寅")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("酉".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("卯")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("戌".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("辰")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("亥".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("巳")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("子".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("午")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("丑".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("未")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("寅".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("申")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("卯".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("酉")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("辰".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("戌")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("巳".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("亥")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("午".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
        }else{
            if(lunar.getYearZhi().equals("子")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("巳".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }else if(lunar.getYearZhi().equals("丑")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("午".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }else if(lunar.getYearZhi().equals("寅")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("未".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("卯")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("申".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("辰")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("酉".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("巳")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("戌".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("午")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("亥".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("未")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("子".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("申")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("丑".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("酉")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("寅".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("戌")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("卯".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
            else if(lunar.getYearZhi().equals("亥")){
                for (int i = 1; i < zhiList.size(); i++) {
                    if("辰".equals(zhiList.get(i))){
                        list.get(i).add("元辰");
                    }
                }
            }
        }

        /**
         * 羊刃
         * 以日干看四支，甲见卯，乙见寅，丙见午，丁见巳，戊见午，己见巳，庚见酉，辛见申，壬见子
         */
        if("甲".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("卯".equals(zhiList.get(i))){
                    list.get(i).add("羊刃");
                }
            }
        }else if("乙".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("寅".equals(zhiList.get(i))){
                    list.get(i).add("羊刃");
                }
            }
        }
        else if("丙".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("午".equals(zhiList.get(i))){
                    list.get(i).add("羊刃");
                }
            }
        }
        else if("丁".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("巳".equals(zhiList.get(i))){
                    list.get(i).add("羊刃");
                }
            }
        }
        else if("戊".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("午".equals(zhiList.get(i))){
                    list.get(i).add("羊刃");
                }
            }
        }
        else if("己".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("巳".equals(zhiList.get(i))){
                    list.get(i).add("羊刃");
                }
            }
        }
        else if("庚".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("酉".equals(zhiList.get(i))){
                    list.get(i).add("羊刃");
                }
            }
        }
        else if("辛".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("申".equals(zhiList.get(i))){
                    list.get(i).add("羊刃");
                }
            }
        }
        else if("壬".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("子".equals(zhiList.get(i))){
                    list.get(i).add("羊刃");
                }
            }
        }
        else if("癸".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("亥".equals(zhiList.get(i))){
                    list.get(i).add("羊刃");
                }
            }
        }

        /**
         * 十灵日
         * 只看日柱
         * 甲辰，乙亥，丙辰，丁酉，戊午，庚戌，庚寅，辛亥，壬寅，癸未
         */
        List<String> tenDays = Arrays.asList("甲辰", "乙亥", "丙辰", "丁酉", "戊午", "庚戌", "庚寅", "辛亥", "壬寅", "癸未");
        String dayGanZhi = lunar.getDayGan()+lunar.getDayZhi();
        if(tenDays.contains(dayGanZhi)){
            list.get(2).add("十灵日");
        }

        /**
         * 十恶大败
         * 只看日柱
         * 甲辰，乙巳，壬申，丙申，丁亥，庚辰，戊戌，癸亥，辛巳，己丑
         */
        List<String> tenBadDays = Arrays.asList("甲辰", "乙巳", "壬申", "丙申", "丁亥", "庚辰", "戊戌", "癸亥", "辛巳", "己丑");
        if(tenDays.contains(dayGanZhi)){
            list.get(2).add("十恶大败");
        }

        /**
         * 童子煞
         * 1 生在春天或者秋天的，日支或时支见到寅或子
         * 2 生在冬季或夏季的，日支或时支见到卯或未或辰
         * 3 年柱纳音金木，日支或时支见到午或卯
         * 4 年柱纳音水火，日支或时支见到酉或戌
         * 5 年柱纳音土，日支或时支见到辰或巳
         */
        if(Arrays.asList("寅","卯","辰","申","酉","戌").contains(lunar.getMonthZhi())){
            for (int i = 2; i < zhiList.size(); i++) {
                if(Arrays.asList("寅","子").contains(zhiList.get(i))){
                    list.get(i).add("童子煞");
                }
            }
        }else if(Arrays.asList("巳","午","未","亥","子","丑").contains(lunar.getMonthZhi())){
            for (int i = 2; i < zhiList.size(); i++) {
                if(Arrays.asList("卯","未","辰").contains(zhiList.get(i))){
                    list.get(i).add("童子煞");
                }
            }
        }
        if(Arrays.asList("金","木").contains(nayinwuxing)){
            for (int i = 2; i < zhiList.size(); i++) {
                if(Arrays.asList("卯","午").contains(zhiList.get(i))){
                    list.get(i).add("童子煞");
                }
            }
        }else if(Arrays.asList("火","水").contains(nayinwuxing)){
            for (int i = 2; i < zhiList.size(); i++) {
                if(Arrays.asList("酉","戌").contains(zhiList.get(i))){
                    list.get(i).add("童子煞");
                }
            }
        }else if(Arrays.asList("土").contains(nayinwuxing)){
            for (int i = 2; i < zhiList.size(); i++) {
                if(Arrays.asList("辰","巳").contains(zhiList.get(i))){
                    list.get(i).add("童子煞");
                }
            }
        }

        /**
         * 勾绞煞
         * 以年支看其余地支，子见卯，丑见辰，寅见巳，卯见午，辰见未，巳见申，午见酉，未见戌，申见亥，酉见子，戌见丑，亥见寅
         */
        if(lunar.getYearZhi().equals("子")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("卯".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }
        else if(lunar.getYearZhi().equals("丑")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("辰".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }
        else if(lunar.getYearZhi().equals("寅")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("巳".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }
        else if(lunar.getYearZhi().equals("卯")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("午".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }
        else if(lunar.getYearZhi().equals("辰")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("未".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }
        else if(lunar.getYearZhi().equals("巳")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("申".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }
        else if(lunar.getYearZhi().equals("午")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("酉".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }
        else if(lunar.getYearZhi().equals("未")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("戌".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }
        else if(lunar.getYearZhi().equals("申")){
            for (int i = 0; i < zhiList.size(); i++) {
                if("亥".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }
        else if(lunar.getYearZhi().equals("酉")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("子".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }
        else if(lunar.getYearZhi().equals("戌")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("丑".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }
        else if(lunar.getYearZhi().equals("亥")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("寅".equals(zhiList.get(i))){
                    list.get(i).add("勾绞煞");
                }
            }
        }

        /**
         * 丧门
         * 只看年支
         * 子见寅，丑见卯，寅见辰，卯见巳，辰见午，巳见未，午见申，未见酉，申见戌，酉见亥，戌见子，亥见丑
         */
        if(lunar.getYearZhi().equals("子")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("寅".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }
        else if(lunar.getYearZhi().equals("丑")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("卯".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }
        else if(lunar.getYearZhi().equals("寅")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("辰".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }
        else if(lunar.getYearZhi().equals("卯")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("巳".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }
        else if(lunar.getYearZhi().equals("辰")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("午".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }
        else if(lunar.getYearZhi().equals("巳")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("未".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }
        else if(lunar.getYearZhi().equals("午")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("申".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }
        else if(lunar.getYearZhi().equals("未")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("酉".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }
        else if(lunar.getYearZhi().equals("申")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("戌".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }
        else if(lunar.getYearZhi().equals("酉")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("亥".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }
        else if(lunar.getYearZhi().equals("戌")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("子".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }
        else if(lunar.getYearZhi().equals("亥")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("丑".equals(zhiList.get(i))){
                    list.get(i).add("丧门");
                }
            }
        }

        /**
         * 吊客
         * 只看年支
         * 子见戌，丑见亥，寅见子，卯见丑，辰见寅，巳见卯，午见辰，未见巳，申见午，酉见未，戌见申，亥见酉
         */
        if(lunar.getYearZhi().equals("子")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("戌".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }
        else if(lunar.getYearZhi().equals("丑")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("亥".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }
        else if(lunar.getYearZhi().equals("寅")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("子".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }
        else if(lunar.getYearZhi().equals("卯")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("丑".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }
        else if(lunar.getYearZhi().equals("辰")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("寅".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }
        else if(lunar.getYearZhi().equals("巳")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("卯".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }
        else if(lunar.getYearZhi().equals("午")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("辰".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }
        else if(lunar.getYearZhi().equals("未")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("巳".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }
        else if(lunar.getYearZhi().equals("申")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("午".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }
        else if(lunar.getYearZhi().equals("酉")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("未".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }
        else if(lunar.getYearZhi().equals("戌")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("申".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }
        else if(lunar.getYearZhi().equals("亥")){
            for (int i = 1; i < zhiList.size(); i++) {
                if("酉".equals(zhiList.get(i))){
                    list.get(i).add("吊客");
                }
            }
        }



        /**
         * 红艳煞
         * 以日干查其余地支
         * 甲日午，乙日午，丙日寅，丁日未，戊日辰，己日辰，庚日戌，辛日酉，壬日子，癸日申
         */
        if("甲".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("午".equals(zhiList.get(i))){
                    list.get(i).add("红艳煞");
                }
            }
        }
        else if("乙".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("午".equals(zhiList.get(i))){
                    list.get(i).add("红艳煞");
                }
            }
        }
        else if("丙".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("寅".equals(zhiList.get(i))){
                    list.get(i).add("红艳煞");
                }
            }
        }
        else if("丁".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("未".equals(zhiList.get(i))){
                    list.get(i).add("红艳煞");
                }
            }
        }
        else if("戊".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("辰".equals(zhiList.get(i))){
                    list.get(i).add("红艳煞");
                }
            }
        }
        else if("己".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("辰".equals(zhiList.get(i))){
                    list.get(i).add("红艳煞");
                }
            }
        }
        else if("庚".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("戌".equals(zhiList.get(i))){
                    list.get(i).add("红艳煞");
                }
            }
        }
        else if("辛".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("酉".equals(zhiList.get(i))){
                    list.get(i).add("红艳煞");
                }
            }
        }
        else if("壬".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("申".equals(zhiList.get(i))){
                    list.get(i).add("红艳煞");
                }
            }
        }
        else if("癸".equals(lunar.getDayGan())){
            for (int i = 0; i < zhiList.size(); i++) {
                if("申".equals(zhiList.get(i))){
                    list.get(i).add("红艳煞");
                }
            }
        }

        /**
         * 孤辰
         * 以年支查其余地支
         * 亥子丑见寅，寅卯辰见巳，巳午未见申，申酉戌见亥
         */
        if (Arrays.asList("亥","子","丑").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                if("寅".equals(zhiList.get(i))){
                    list.get(i).add("孤辰");
                }
            }
        }
        else if (Arrays.asList("寅","卯","辰").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                if("巳".equals(zhiList.get(i))){
                    list.get(i).add("孤辰");
                }
            }
        }
        else if (Arrays.asList("巳","午","未").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                if("申".equals(zhiList.get(i))){
                    list.get(i).add("孤辰");
                }
            }
        }
        else if (Arrays.asList("申","酉","戌").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                if("亥".equals(zhiList.get(i))){
                    list.get(i).add("孤辰");
                }
            }
        }

        /**
         * 寡宿
         * 以年支查其余地支
         * 亥子丑见戌，寅卯辰见丑，巳午未见辰，申酉戌见未
         */
        if (Arrays.asList("亥","子","丑").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                if("戌".equals(zhiList.get(i))){
                    list.get(i).add("寡宿");
                }
            }
        }
        else if (Arrays.asList("寅","卯","辰").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                if("丑".equals(zhiList.get(i))){
                    list.get(i).add("寡宿");
                }
            }
        }
        else if (Arrays.asList("巳","午","未").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                if("辰".equals(zhiList.get(i))){
                    list.get(i).add("寡宿");
                }
            }
        }
        else if (Arrays.asList("申","酉","戌").contains(lunar.getYearZhi())){
            for (int i = 1; i < zhiList.size(); i++) {
                if("未".equals(zhiList.get(i))){
                    list.get(i).add("寡宿");
                }
            }
        }

        /**
         * 福星贵人
         * 以年干或日干看地支
         * 甲丙见寅或子，乙癸见卯或丑，戊见申，己见未，丁见亥，庚见午，辛见巳，壬见辰
         */
        for (String gan : yearDayGanList) {
            if(Arrays.asList("甲","丙").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("寅","子").contains(zhiList.get(i))){
                        list.get(i).add("福星贵人");
                    }
                }
            }
            else if(Arrays.asList("乙","癸").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("卯","丑").contains(zhiList.get(i))){
                        list.get(i).add("福星贵人");
                    }
                }
            }
            else if("戊".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("申".equals(zhiList.get(i))){
                        list.get(i).add("福星贵人");
                    }
                }
            }
            else if("己".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("未".equals(zhiList.get(i))){
                        list.get(i).add("福星贵人");
                    }
                }
            }
            else if("丁".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("亥".equals(zhiList.get(i))){
                        list.get(i).add("福星贵人");
                    }
                }
            }
            else if("庚".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("午".equals(zhiList.get(i))){
                        list.get(i).add("福星贵人");
                    }
                }
            }
            else if("辛".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("巳".equals(zhiList.get(i))){
                        list.get(i).add("福星贵人");
                    }
                }
            }
            else if("壬".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("辰".equals(zhiList.get(i))){
                        list.get(i).add("福星贵人");
                    }
                }
            }
        }

        /**
         * 德秀贵人
         * 以月支看天干
         * 寅午戌见丙或丁，同时见戊或癸；申子辰见壬或癸或戊或己，同时见甲或己或丙或辛；巳酉丑见庚或辛，同时见乙或庚；亥卯未见甲或乙，同时见丁或壬
         */
        if (Arrays.asList("寅","午","戌").contains(lunar.getMonthZhi())){
            for (String gan : ganList) {
                if(Arrays.asList("丙","丁").contains(gan)){
                    for (int i = 0; i < ganList.size(); i++) {
                        if(Arrays.asList("戊","癸").contains(ganList.get(i))){
                            list.get(i).add("德秀贵人");break;
                        }
                    }
                }
            }
        }
        else if (Arrays.asList("申","子","辰").contains(lunar.getMonthZhi())){
            for (String gan : ganList) {
                if(Arrays.asList("壬","癸","戊","己").contains(gan)){
                    for (int i = 0; i < ganList.size(); i++) {
                        if(Arrays.asList("甲","己","丙","辛").contains(ganList.get(i))){
                            list.get(i).add("德秀贵人");break;
                        }
                    }
                }
            }
        }
        else if (Arrays.asList("巳","酉","丑").contains(lunar.getMonthZhi())){
            for (String gan : ganList) {
                if(Arrays.asList("庚","辛").contains(gan)){
                    for (int i = 0; i < ganList.size(); i++) {
                        if(Arrays.asList("乙","庚").contains(ganList.get(i))){
                            list.get(i).add("德秀贵人");break;
                        }
                    }
                }
            }
        }
        else if (Arrays.asList("亥","卯","未").contains(lunar.getMonthZhi())){
            for (String gan : ganList) {
                if(Arrays.asList("甲","乙").contains(gan)){
                    for (int i = 0; i < ganList.size(); i++) {
                        if(Arrays.asList("丁","壬").contains(ganList.get(i))){
                            list.get(i).add("德秀贵人");break;
                        }
                    }
                }
            }
        }

        /**
         * 金神
         * 只看日柱或年柱，乙丑，己巳，癸酉
         */
        List<String> goldenGod = Arrays.asList("乙丑", "己巳", "癸酉");
        if(goldenGod.contains(lunar.getDayGan()+lunar.getDayZhi())){
            list.get(2).add("金神");
        }
        if(goldenGod.contains(lunar.getYearGan()+lunar.getYearZhi())){
            list.get(0).add("金神");
        }

        /**
         * 天罗地网
         * 以年纳音查日支，纳音火命见戌亥为天罗，水土逢辰巳为地网
         */
        if("火".equals(nayinwuxing)){
            if(Arrays.asList("戌","亥").contains(lunar.getDayZhi())){
                list.get(2).add("天罗地网");
            }
        }else if(Arrays.asList("水","土").contains(nayinwuxing)){
            if(Arrays.asList("辰","巳").contains(lunar.getDayZhi())){
                list.get(2).add("天罗地网");
            }
        }

        /**
         * 阴差阳错
         * 只看日柱
         * 丙子，丙午，丁丑，丁未，戊寅，戊申，辛卯，辛酉，壬辰，壬戌，癸巳，癸亥
         */
        List<String> yinYangErrorList = Arrays.asList("丙子","丙午","丁丑","丁未","戊寅","戊申","辛卯","辛酉","壬辰","壬戌","癸巳","癸亥");
        if(yinYangErrorList.contains(dayGanZhi)){
            list.get(2).add("阴差阳错");
        }


        //去重,同时最多只显示6个神煞
        for (int i = 0; i < list.size(); i++) {
            List<String> collect = list.get(i).stream().distinct().collect(Collectors.toList());
            if(collect.size()>6){
                collect.subList(6,list.size()).clear();
            }
            list.set(i,collect);
        }
        return list;
    }

}
