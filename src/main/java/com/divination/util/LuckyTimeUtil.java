package com.divination.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson2.JSON;
import com.divination.domain.dto.UserBirthDTO;
import com.divination.domain.vo.TimeLuckyVO;
import com.nlf.calendar.JieQi;
import com.nlf.calendar.Lunar;

import java.util.*;

/**
 * 排大运工具类
 */
public class LuckyTimeUtil {

    /**
     * 获取十年大运
     * @return
     */
    public static List<TimeLuckyVO> getTenLucky(UserBirthDTO birthDTO){
        List<TimeLuckyVO> list = new ArrayList<>();

        Lunar lunar = new Lunar(birthDTO.getBirth());
        String bornMonthGanZhi = lunar.getMonthGan()+lunar.getMonthZhi();
        Integer gender = birthDTO.getGender();

        // 获取年份的阴阳
        Integer yinYangByGan = YinYangUtil.getYinYangByGan(lunar.getYearGan());
        List<String> jiaziList = new ArrayList<>();
        for (String jiazi : ConstantUtil.jiaziList) {
            jiaziList.add(jiazi);
        }


        Integer days = 0;
        Date startDate = null;
        // 如果是阳年生男，阴年生女则顺序;如果是阳年生女，阴年生男则逆序
        if((yinYangByGan==1 && gender==2) || (yinYangByGan==0 && gender==1)){
            Collections.reverse(jiaziList);
            JieQi nextJie = lunar.getPrevJie(true);
            String jieqiDay = nextJie.getSolar().toString()+" 00:00:00";
            Date jieqiDate = DateUtil.parseDate(jieqiDay);
            days =Integer.parseInt(DateUtil.betweenDay(birthDTO.getBirth(), jieqiDate, true)+"");
            startDate = DateUtil.endOfDay(birthDTO.getBirth());
        }else{
            // 取距离下一个节气的日期数
            JieQi nextJie = lunar.getNextJie(true);
            String jieqiDay = nextJie.getSolar().toString()+" 00:00:00";
            Date jieqiDate = DateUtil.parseDate(jieqiDay);
            days =Integer.parseInt(DateUtil.betweenDay(birthDTO.getBirth(), jieqiDate, true)+"");
            startDate = DateUtil.beginOfDay(birthDTO.getBirth());
        }

        // 起运的时间 天数三天为一年，一天为四个月，一个时辰为十天
        Date beginLuckDate = birthDTO.getBirth();
        Integer yearNum = days/3;
        Integer monthNum = 4 * (days%3);
        Integer betweenHour = (Math.abs(Integer.parseInt(DateUtil.between(startDate, birthDTO.getBirth(), DateUnit.HOUR)+""))/2)-1;
        if(betweenHour>=3){
            monthNum+=betweenHour/3;
        }
        if(yearNum!=0){
            beginLuckDate =  DateUtil.offsetYear(beginLuckDate,yearNum);
        }
        if(monthNum!=0){
            beginLuckDate =  DateUtil.offsetMonth(beginLuckDate,monthNum);
        }
//        if(betweenHour!=0){
//            beginLuckDate =  DateUtil.offsetMonth(beginLuckDate,monthNum);
//        }
        Integer beginLuckyYear = DateUtil.year(beginLuckDate);
        Integer beginLuckyYearEnd = beginLuckyYear+10;

        // 按照月干支的顺序找十年大运
        int tempI = -1;
        for (int i = 0; i < jiaziList.size(); i++) {
            String jiazi = jiaziList.get(i);
            if(tempI != -1 && list.size()<8){
                TimeLuckyVO timeLuckyVO = new TimeLuckyVO();
                timeLuckyVO.setName(jiazi);
                timeLuckyVO.setStartYear(beginLuckyYear);
                timeLuckyVO.setEndYear(beginLuckyYearEnd);
                list.add(timeLuckyVO);
                beginLuckyYear+=10;
                beginLuckyYearEnd+=10;
            }else if(list.size()>=10){
                break;
            }
            if(bornMonthGanZhi.equals(jiazi)){
                tempI = i;
            }
        }

        // 如果顺序找完还没有填满
        if(list.size()<8){
            for (String string : jiaziList) {
                if(list.size()==8){break;}
                TimeLuckyVO timeLuckyVO = new TimeLuckyVO();
                timeLuckyVO.setName(string);
                timeLuckyVO.setStartYear(beginLuckyYear);
                timeLuckyVO.setEndYear(beginLuckyYearEnd);
                list.add(timeLuckyVO);

            }
        }





        return list;
    }
}
