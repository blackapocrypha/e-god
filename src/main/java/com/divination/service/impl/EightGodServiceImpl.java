package com.divination.service.impl;


import cn.hutool.core.date.DateUtil;
import com.divination.domain.dto.UserBirthDTO;
import com.divination.domain.dto.UserTimeDTO;
import com.divination.domain.vo.*;
import com.divination.service.EightGodService;
import com.divination.util.*;
import com.nlf.calendar.Lunar;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EightGodServiceImpl implements EightGodService {


    @Override
    public JsonResult<EightGodVO> getEightGodCount(UserBirthDTO userBirthDTO) {
        JsonResult<EightGodVO> jsonResult = new JsonResult();
        // 0 校验并载入性别
        if(Objects.isNull(userBirthDTO.getBirth())){
            return jsonResult.buildFalse("出生日期不能为空");
        }
        if(Objects.isNull(userBirthDTO.getGender())){
            return jsonResult.buildFalse("性别不能为空");
        }
        EightGodVO godVO = new EightGodVO();
        if(userBirthDTO.getGender()==1){
            godVO.setGender("乾造");
        }else{
            godVO.setGender("坤造");
        }


        // 1 取到八字并着色
        Lunar lunar = new Lunar(userBirthDTO.getBirth());
        godVO.setYearGan(lunar.getYearGan());
        godVO.setMonthGan(lunar.getMonthGan());
        godVO.setDayGan(lunar.getDayGan());
        godVO.setTimeGan(lunar.getTimeGan());
        godVO.setYearZhi(lunar.getYearZhi());
        godVO.setMonthZhi(lunar.getMonthZhi());
        godVO.setDayZhi(lunar.getDayZhi());
        godVO.setTimeZhi(lunar.getTimeZhi());
        godVO.setYearGanColor(FiveEnergyUtil.getFiveEnergyColorByGan(lunar.getYearGan()));
        godVO.setMonthGanColor(FiveEnergyUtil.getFiveEnergyColorByGan(lunar.getMonthGan()));
        godVO.setDayGanColor(FiveEnergyUtil.getFiveEnergyColorByGan(lunar.getDayGan()));
        godVO.setTimeGanColor(FiveEnergyUtil.getFiveEnergyColorByGan(lunar.getTimeGan()));
        godVO.setYearZhiColor(FiveEnergyUtil.getFiveEnergyColorByZhi(lunar.getYearZhi()));
        godVO.setMonthZhiColor(FiveEnergyUtil.getFiveEnergyColorByZhi(lunar.getMonthZhi()));
        godVO.setDayZhiColor(FiveEnergyUtil.getFiveEnergyColorByZhi(lunar.getDayZhi()));
        godVO.setTimeZhiColor(FiveEnergyUtil.getFiveEnergyColorByZhi(lunar.getTimeZhi()));

        // 2 取到天干对应十神
        List<GanTenGodVO> ganGodVOList = TenGodUtil.getGanGodVOList(godVO.getDayGan());
        godVO.setTenGodStatusList(ganGodVOList);

        // 3 取到地支藏干信息
        List<HiddenGanVO> hiddenGanListByZhi = GanUtil.findHiddenGanListByZhi(godVO.getYearZhi(), godVO.getMonthZhi(), godVO.getDayZhi(), godVO.getTimeZhi(), godVO.getDayGan());
        godVO.setZhiHiddenGanList(hiddenGanListByZhi);

        // 4 取天干 地支 合冲状态
        String ganSyzygyStatus = GanUtil.findGanSyzygyStatus(Arrays.asList(godVO.getYearGan(), godVO.getMonthGan(), godVO.getDayGan(), godVO.getTimeGan()));
        godVO.setGanSyzygyStatus(ganSyzygyStatus);
        String zhiSyzygyStatus = ZhiUtil.findZhiSyzygyStatus(Arrays.asList(godVO.getYearZhi(), godVO.getMonthZhi(), godVO.getDayZhi(), godVO.getTimeZhi()), lunar);
        godVO.setZhiSyzygyStatus(zhiSyzygyStatus);

        // 5 取神煞
        List<List<String>> holyGeneral = HolyGeneralUtil.getHolyGeneral(lunar);
        godVO.setHolyGeneralList(holyGeneral);

        // 6 取纳音
        ArrayList<String> voiceList = new ArrayList<>();
        voiceList.add(EnergyVoiceUtil.getVoiceByGanZhi(godVO.getYearGan()+godVO.getYearZhi()));
        voiceList.add(EnergyVoiceUtil.getVoiceByGanZhi(godVO.getMonthGan()+godVO.getMonthZhi()));
        voiceList.add(EnergyVoiceUtil.getVoiceByGanZhi(godVO.getDayGan()+godVO.getDayZhi()));
        voiceList.add(EnergyVoiceUtil.getVoiceByGanZhi(godVO.getTimeGan()+godVO.getTimeZhi()));
        godVO.setVoliceList(voiceList);

        // 7 取空亡
        ArrayList<String> fallList = new ArrayList<>();
        fallList.add(GanUtil.getFall(godVO.getYearGan()+godVO.getYearZhi()));
        fallList.add(GanUtil.getFall(godVO.getMonthGan()+godVO.getMonthZhi()));
        fallList.add(GanUtil.getFall(godVO.getDayGan()+godVO.getDayZhi()));
        fallList.add(GanUtil.getFall(godVO.getTimeGan()+godVO.getTimeZhi()));
        godVO.setFallList(fallList);

        jsonResult.buildTrue();
        jsonResult.setData(godVO);
        return jsonResult;
    }

    /**
     * 获取大运
     *
     * @param timeDTO 大运入参
     * @return
     */
    @Override
    public JsonResult<EightGodTimeVO> getEightGodTime(UserTimeDTO timeDTO) {
        JsonResult<EightGodTimeVO> result = new JsonResult<>();
        EightGodTimeVO vo = new EightGodTimeVO();
        Integer year = timeDTO.getYear();
        String month = timeDTO.getMonth();
        String day = timeDTO.getDay();
        String lucky = timeDTO.getLucky();

        // 1 复用八字接口取八字
        UserBirthDTO birthDTO = new UserBirthDTO();
        BeanUtils.copyProperties(timeDTO,birthDTO);
        JsonResult<EightGodVO> eightGodCount = getEightGodCount(birthDTO);
        EightGodVO eightYearData = eightGodCount.getData();
        BeanUtils.copyProperties(eightYearData,vo);

        // 2 补充当前时间的日期
        Lunar lunar = new Lunar(new Date());
        if(Objects.isNull(lucky)){
            if(Objects.isNull(year)){
                vo.setTimeYearGan(lunar.getYearGan());
                vo.setTimeYearZhi(lunar.getYearZhi());
                if(Objects.isNull(month)){
                    vo.setTimeMonthGan(lunar.getMonthGan());
                    vo.setTimeMonthZhi(lunar.getMonthZhi());
                    if(Objects.isNull(day)){
                        vo.setTimeDayGan(lunar.getDayGan());
                        vo.setTimeDayZhi(lunar.getDayZhi());
                    }
                }
            }
        }




        // 3 取十年大运，流年，流月
        List<TimeLuckyVO> tenLucky = LuckyTimeUtil.getTenLucky(birthDTO);
        List<TimeLuckyVO> flowYears = new ArrayList<>();
        List<TimeLuckyVO> flowMonth = new ArrayList<>();
        List<TimeLuckyVO> flowDays = new ArrayList<>();
        vo.setTenLuckyList(tenLucky);

        if(Objects.isNull(year)){
            year = DateUtil.year(new Date());
        }

        // 如果选中了大运，强制载入选中大运内的时间
        if(Objects.nonNull(lucky)){
            for (TimeLuckyVO timeLuckyVO : tenLucky) {
                if(timeDTO.getLucky().equals(timeLuckyVO.getName())){
                    // 如果没有大运，说明还没有起运，用月份的干支替代
                    if(Objects.nonNull(timeLuckyVO.getName())){
                        String[] split = timeLuckyVO.getName().split("");
                        vo.setTimeLuckyGan(split[0]);
                        vo.setTimeLuckyZhi(split[1]);
                    }else{
                        String[] split = timeDTO.getLucky().split("");
                        vo.setTimeLuckyGan(split[0]);
                        vo.setTimeLuckyZhi(split[1]);
                    }


                    // 在该大运里生成全部流年
                    for (int i = timeLuckyVO.getStartYear(); i <timeLuckyVO.getEndYear() ; i++) {

                        TimeLuckyVO flow = new TimeLuckyVO();
                        flow.setStartYear(i);
                        Lunar flowLunnar = new Lunar(DateUtil.parseDate(i + "-06-01 00:00:00"));
                        flow.setName(flowLunnar.getYearGan()+flowLunnar.getYearZhi());
                        flowYears.add(flow);
                        // 如果选中了年份且与当前大运相同
                        if(Objects.nonNull(year) && year.equals(Integer.parseInt(i+""))){
                            vo.setTimeYearGan(flowLunnar.getYearGan());
                            vo.setTimeYearZhi(flowLunnar.getYearZhi());
                        }
                    }
                    break;
                }

            }
        }
        else{
            for (TimeLuckyVO timeLuckyVO : tenLucky) {
                // 找到今年所属的大运阶段，写入对应的天干地支
                if(timeLuckyVO.getStartYear()<= year && timeLuckyVO.getEndYear()>=year){
                    // 如果没有大运，说明还没有起运，用月份的干支替代
                    if(Objects.nonNull(timeLuckyVO.getName())){
                        String[] split = timeLuckyVO.getName().split("");
                        vo.setTimeLuckyGan(split[0]);
                        vo.setTimeLuckyZhi(split[1]);
                    }

                    if(Objects.isNull(month)){
                        vo.setTimeMonthGan(lunar.getMonthGan());
                        vo.setTimeMonthZhi(lunar.getMonthZhi());
                    }
                    if(Objects.isNull(day)){
                        vo.setTimeDayGan(lunar.getDayGan());
                        vo.setTimeDayZhi(lunar.getDayZhi());
                    }

                    // 在该大运里生成全部流年
                    for (int i = timeLuckyVO.getStartYear(); i <timeLuckyVO.getEndYear() ; i++) {
                        TimeLuckyVO flow = new TimeLuckyVO();
                        flow.setStartYear(i);
                        Lunar flowLunnar = new Lunar(DateUtil.parseDate(i + "-06-01 00:00:00"));
                        flow.setName(flowLunnar.getYearGan()+flowLunnar.getYearZhi());
                        flowYears.add(flow);
                    }
                    break;
                }
            }
        }

        // 找不到匹配的年份大运，说明还没起运，用月干支替代
        if(Objects.isNull(vo.getTimeLuckyGan()) || Objects.isNull(vo.getTimeLuckyZhi())){
            vo.setTimeLuckyGan(vo.getMonthGan());
            vo.setTimeLuckyZhi(vo.getMonthZhi());
        }
        vo.setFlowYearList(flowYears);


        // 处理流月
        for (int i = 1; i <=12; i++) {
            //Date monthDay = DateUtil.parseDate(year+"-"+String.format("%02d",i)+"-01 00:00:00");
            Lunar monthLunnar = new Lunar(year,i,1);
            TimeLuckyVO monthVo = new TimeLuckyVO();
            monthVo.setStartYear(i);
            monthVo.setName(monthLunnar.getMonthGan()+monthLunnar.getMonthZhi());
            flowMonth.add(monthVo);
            // 如果是当前选中了月份
            if(Objects.nonNull(month) && month.equals(i+"")){
                vo.setTimeMonthGan(monthLunnar.getMonthGan());
                vo.setTimeMonthZhi(monthLunnar.getMonthZhi());
            }
        }
        vo.setFlowMonthList(flowMonth);

        // 处理流日
        if(Objects.nonNull(month)){

            int thisMonth = Integer.parseInt(month);
            Date thisTime = DateUtil.parseDate(year+"-"+String.format("%02d",thisMonth)+"-01 00:00:00");
            int days = LunarCalendarUtil.howManyDays(thisTime);
            for (int i = 1; i <= days; i++) {
                Date fTime = DateUtil.parseDate(year+"-"+String.format("%02d",thisMonth)+"-"+String.format("%02d",i)+" 00:00:00");
                TimeLuckyVO dayVO = new TimeLuckyVO();
                Lunar dayLunar = new Lunar(fTime);
                dayVO.setName(dayLunar.getDayGan()+dayLunar.getDayZhi());
                dayVO.setStartYear(i);
                flowDays.add(dayVO);
                // 如果传入了日期且是当前日期
                if(Objects.nonNull(day)){
                    int intDay = Integer.parseInt(day);
                    if(intDay == i){
                        vo.setTimeDayGan(dayLunar.getDayGan());
                        vo.setTimeDayZhi(dayLunar.getDayZhi());
                    }
                }
            }
        }else{

            int thisMonth =  DateUtil.month(new Date())+1;
            Date thisTime = DateUtil.parseDate(year+"-"+String.format("%02d",thisMonth)+"-01 00:00:00");
            int days = LunarCalendarUtil.howManyDays(thisTime);
            for (int i = 1; i <= days; i++) {
                Date fTime = DateUtil.parseDate(year+"-"+String.format("%02d",thisMonth)+"-"+String.format("%02d",i)+" 00:00:00");
                TimeLuckyVO dayVO = new TimeLuckyVO();
                Lunar dayLunar = new Lunar(fTime);
                dayVO.setName(dayLunar.getDayGan()+dayLunar.getDayZhi());
                dayVO.setStartYear(i);
                flowDays.add(dayVO);
            }
        }
        vo.setFlowDayList(flowDays);

        // 4 重新处理藏干
        List<HiddenGanVO> yearHiddenGanList = vo.getZhiHiddenGanList();
        List<HiddenGanVO> newHiddenGanListByZhi = GanUtil.findHiddenGanListByZhi(vo.getTimeDayZhi(), vo.getTimeMonthZhi(), vo.getTimeYearZhi(), vo.getTimeLuckyZhi(), vo.getDayGan());
        for (HiddenGanVO hiddenGanVO : yearHiddenGanList) {
            newHiddenGanListByZhi.add(hiddenGanVO);
        }
        vo.setZhiHiddenGanList(newHiddenGanListByZhi);


        // 5 重新取天干 地支 合冲状态
        List<String> ganList = new ArrayList<>();
        ganList.addAll(Arrays.asList(vo.getYearGan(), vo.getMonthGan(), vo.getDayGan(), vo.getTimeGan()));
        List<String> zhiList = new ArrayList<>();
        zhiList.addAll(Arrays.asList(vo.getYearZhi(), vo.getMonthZhi(), vo.getDayZhi(), vo.getTimeZhi()));
        if(Objects.nonNull(vo.getTimeLuckyGan())){
            ganList.add(vo.getTimeLuckyGan());
            zhiList.add(vo.getTimeLuckyZhi());
        }
        if(Objects.nonNull(vo.getTimeYearGan())){
            ganList.add(vo.getTimeYearGan());zhiList.add(vo.getTimeYearZhi());
        }
        if(Objects.nonNull(vo.getTimeMonthGan())){
            ganList.add(vo.getTimeMonthGan());zhiList.add(vo.getTimeMonthZhi());
        }

        if(Objects.nonNull(vo.getTimeDayGan())){
            ganList.add(vo.getTimeDayGan());zhiList.add(vo.getTimeDayZhi());
        }
        String ganSyzygyStatus = GanUtil.findGanSyzygyStatus(ganList);
        vo.setGanSyzygyStatus(ganSyzygyStatus);
        String zhiSyzygyStatus = ZhiUtil.findZhiSyzygyStatus(zhiList, lunar);
        vo.setZhiSyzygyStatus(zhiSyzygyStatus);


        // 6载入流年流月流日大运的颜色
        vo.setTimeLuckyGanColor(FiveEnergyUtil.getFiveEnergyColorByGan(vo.getTimeLuckyGan()));
        vo.setTimeYearGanColor(FiveEnergyUtil.getFiveEnergyColorByGan(vo.getTimeYearGan()));
        vo.setTimeMonthGanColor(FiveEnergyUtil.getFiveEnergyColorByGan(vo.getTimeMonthGan()));
        vo.setTimeDayGanColor(FiveEnergyUtil.getFiveEnergyColorByGan(vo.getTimeDayGan()));

        vo.setTimeLuckyZhiColor(FiveEnergyUtil.getFiveEnergyColorByZhi(vo.getTimeLuckyZhi()));
        vo.setTimeYearZhiColor(FiveEnergyUtil.getFiveEnergyColorByZhi(vo.getTimeYearZhi()));
        vo.setTimeMonthZhiColor(FiveEnergyUtil.getFiveEnergyColorByZhi(vo.getTimeMonthZhi()));
        vo.setTimeDayZhiColor(FiveEnergyUtil.getFiveEnergyColorByZhi(vo.getTimeDayZhi()));

        result.buildTrue();
        result.setData(vo);
        return result;
    }

}
