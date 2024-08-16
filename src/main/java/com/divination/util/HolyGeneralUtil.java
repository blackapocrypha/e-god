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
    public static List<List<String>> getHolyGeneral(Lunar lunar){
        /**
         * 录入神煞：
         * 天乙贵人，月德贵人，天德贵人，太极贵人，文昌贵人，国印贵人，驿马，劫煞，灾煞，桃花，华盖，血刃，学堂，词馆，将星，金舆，天医
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
            else if(Arrays.asList("已","酉","丑").contains(zhi)){
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
         * 寅午戌兮猪面黑，寅午戌见亥；已酉丑兮虎哮吼，已酉丑见寅
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
            else if(Arrays.asList("已","酉","丑").contains(zhi)){
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
         * 申子辰见午，卯未见酉，寅午戌见子，已酉丑见卯
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
        else if(Arrays.asList("已","酉","丑").contains(yearZhi)){
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
            else if(Arrays.asList("已","酉","丑").contains(zhi)){
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
         * 日元是乙，地支贝辰；日元是康，地支见西
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
         */
        for (String gan : yearDayGanList) {
            if(Arrays.asList("甲","乙").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("巳","午").contains(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }else if(Arrays.asList("丙","戊").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("申").contains(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if(Arrays.asList("已","丁").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("酉").contains(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if(Arrays.asList("庚").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("亥").contains(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if(Arrays.asList("辛").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("子").contains(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if(Arrays.asList("壬").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("寅").contains(zhiList.get(i))){
                        list.get(i).add("文昌贵人");
                    }
                }
            }
            else if(Arrays.asList("癸").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("卯").contains(zhiList.get(i))){
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
        for (String gan : yearDayGanList){
            if(Arrays.asList("甲","乙").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("亥".equals(zhiList.get(i))){
                        list.get(i).add("学堂");
                    }
                }
            }else if(Arrays.asList("丙","丁").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("寅".equals(zhiList.get(i))){
                        list.get(i).add("学堂");
                    }
                }
            }
            else if(Arrays.asList("戊","己").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("申".equals(zhiList.get(i))){
                        list.get(i).add("学堂");
                    }
                }
            }
            else if(Arrays.asList("庚","辛").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("巳".equals(zhiList.get(i))){
                        list.get(i).add("学堂");
                    }
                }
            }
            else if(Arrays.asList("壬","癸").contains(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if("申".equals(zhiList.get(i))){
                        list.get(i).add("学堂");
                    }
                }
            }
        }

        /**
         * 词馆
         * 甲干见庚寅，乙干见辛卯，丙干见乙巳，丁干见戊午，戊干见丁巳，己干见庚午，庚干见壬申，辛干见癸酉，壬干见癸亥，癸干见壬戌
         */
        for (String gan : yearDayGanList){
            String ganFiveEnergy = FiveEnergyUtil.getFiveEnergyByGan(gan);
            if("甲".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("寅").contains(zhiList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){

                        list.get(i).add("词馆");
                        }
                    }
                }
                for (int i = 0; i < ganList.size(); i++) {
                    if(Arrays.asList("庚").contains(ganList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");}
                    }
                }
            }else if("乙".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("卯").contains(zhiList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                        list.get(i).add("词馆");}
                    }
                }
                for (int i = 0; i < ganList.size(); i++) {
                    if(Arrays.asList("辛").contains(ganList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
            }
            else if("丙".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("巳").contains(zhiList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
                for (int i = 0; i < ganList.size(); i++) {
                    if(Arrays.asList("乙").contains(ganList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
            }
            else if("丁".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("午").contains(zhiList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
                for (int i = 0; i < ganList.size(); i++) {
                    if(Arrays.asList("戊").contains(ganList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
            }
            else if("戊".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("巳").contains(zhiList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
                for (int i = 0; i < ganList.size(); i++) {
                    if(Arrays.asList("丁").contains(ganList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
            }
            else if("己".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("午").contains(zhiList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
                for (int i = 0; i < ganList.size(); i++) {
                    if(Arrays.asList("庚").contains(ganList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
            }
            else if("庚".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("申").contains(zhiList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
                for (int i = 0; i < ganList.size(); i++) {
                    if(Arrays.asList("壬").contains(ganList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
            }
            else if("辛".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("酉").contains(zhiList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
                for (int i = 0; i < ganList.size(); i++) {
                    if(Arrays.asList("癸").contains(ganList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
            }
            else if("壬".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("亥").contains(zhiList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
                for (int i = 0; i < ganList.size(); i++) {
                    if(Arrays.asList("癸").contains(ganList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
            }
            else if("癸".equals(gan)){
                for (int i = 0; i < zhiList.size(); i++) {
                    if(Arrays.asList("戌").contains(zhiList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
                    }
                }
                for (int i = 0; i < ganList.size(); i++) {
                    if(Arrays.asList("壬").contains(ganList.get(i))){
                        if(ganFiveEnergy.equals(FiveEnergyUtil.getFiveEnergyByGan(ganList.get(i)))){
                            list.get(i).add("词馆");
                        }
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
