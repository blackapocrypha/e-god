package com.divination.util;

import java.util.Arrays;

/**
 * 纳音工具类
 */
public class EnergyVoiceUtil {

    /**
     * 甲子乙丑海中金，丙寅丁卯炉中火，戊辰己巳大林木，庚午辛未路旁土，壬申癸酉剑锋金
     * 甲戌乙亥山头火，丙子丁丑漳下水，戊寅己卯城头土，庚辰辛巳白蜡金，壬午癸未杨柳木
     * 甲申乙酉泉中水，丙戌丁亥屋上土，戊子己丑霹雳火，庚寅辛卯松柏木，壬辰癸巳长流水
     * 甲午乙未砂石金，丙申丁酉山下火，戊戌己亥平地木，庚子辛丑壁上土，壬寅癸卯金箔金
     * 甲辰乙巳覆灯火，丙午丁未天河水，戊申己酉大驿土，庚戌辛亥钗钏金，壬子癸丑桑柘木
     * 甲寅乙卯大溪水，丙辰丁巳沙中土，戊午己未天上火，庚申辛酉石榴木，壬戌癸亥大海水
     */

    /**
     * 根据干支组合成的字符串取到纳音
     * @param ganzhi  干支组合
     * @return String
     */
    public static String getVoiceByGanZhi(String ganzhi){
        // 甲子乙丑海中金，丙寅丁卯炉中火，戊辰己巳大林木，庚午辛未路旁土，壬申癸酉剑锋金
        if(Arrays.asList("甲子","乙丑").contains(ganzhi)){
            return "海中金";
        }
        if(Arrays.asList("丙寅","丁卯").contains(ganzhi)){
            return "炉中火";
        }
        if(Arrays.asList("戊辰","己巳").contains(ganzhi)){
            return "大林木";
        }
        if(Arrays.asList("庚午","辛未").contains(ganzhi)){
            return "路旁土";
        }
        if(Arrays.asList("壬申","癸酉").contains(ganzhi)){
            return "剑锋金";
        }

        // 甲戌乙亥山头火，丙子丁丑漳下水，戊寅己卯城头土，庚辰辛巳白蜡金，壬午癸未杨柳木
        if(Arrays.asList("甲戌","乙亥").contains(ganzhi)){
            return "山头火";
        }
        if(Arrays.asList("丙子","丁丑").contains(ganzhi)){
            return "漳下水";
        }
        if(Arrays.asList("戊寅","己卯").contains(ganzhi)){
            return "城头土";
        }
        if(Arrays.asList("庚辰","辛巳").contains(ganzhi)){
            return "白蜡金";
        }
        if(Arrays.asList("壬午","癸未").contains(ganzhi)){
            return "杨柳木";
        }


        // 甲申乙酉泉中水，丙戌丁亥屋上土，戊子己丑霹雳火，庚寅辛卯松柏木，壬辰癸巳长流水
        if(Arrays.asList("甲申","乙酉").contains(ganzhi)){
            return "泉中水";
        }
        if(Arrays.asList("丙戌","丁亥").contains(ganzhi)){
            return "屋上土";
        }
        if(Arrays.asList("戊子","己丑").contains(ganzhi)){
            return "霹雳火";
        }
        if(Arrays.asList("庚寅","辛卯").contains(ganzhi)){
            return "松柏木";
        }
        if(Arrays.asList("壬辰","癸巳").contains(ganzhi)){
            return "长流水";
        }


        // 甲午乙未砂石金，丙申丁酉山下火，戊戌己亥平地木，庚子辛丑壁上土，壬寅癸卯金箔金
        if(Arrays.asList("甲午","乙未").contains(ganzhi)){
            return "砂石金";
        }
        if(Arrays.asList("丙申","丁酉").contains(ganzhi)){
            return "山下火";
        }
        if(Arrays.asList("戊戌","己亥").contains(ganzhi)){
            return "平地木";
        }
        if(Arrays.asList("庚子","辛丑").contains(ganzhi)){
            return "壁上土";
        }
        if(Arrays.asList("壬寅","癸卯").contains(ganzhi)){
            return "金箔金";
        }

        // 甲辰乙巳覆灯火，丙午丁未天河水，戊申己酉大驿土，庚戌辛亥钗钏金，壬子癸丑桑柘木
        if(Arrays.asList("甲辰","乙巳").contains(ganzhi)){
            return "覆灯火";
        }
        if(Arrays.asList("丙午","丁未").contains(ganzhi)){
            return "天河水";
        }
        if(Arrays.asList("戊申","己酉").contains(ganzhi)){
            return "大驿土";
        }
        if(Arrays.asList("庚戌","辛亥").contains(ganzhi)){
            return "钗钏金";
        }
        if(Arrays.asList("壬子","癸丑").contains(ganzhi)){
            return "桑柘木";
        }


        // 甲寅乙卯大溪水，丙辰丁巳沙中土，戊午己未天上火，庚申辛酉石榴木，壬戌癸亥大海水
        if(Arrays.asList("甲寅","乙卯").contains(ganzhi)){
            return "大溪水";
        }
        if(Arrays.asList("丙辰","丁巳").contains(ganzhi)){
            return "沙中土";
        }
        if(Arrays.asList("戊午","己未").contains(ganzhi)){
            return "天上火";
        }
        if(Arrays.asList("庚申","辛酉").contains(ganzhi)){
            return "石榴木";
        }
        if(Arrays.asList("壬戌","癸亥").contains(ganzhi)){
            return "大海水";
        }

        return null;
    }

}
