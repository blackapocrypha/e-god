package com.divination.service.impl;


import com.divination.domain.dto.UserBirthDTO;
import com.divination.domain.vo.EightGodVO;
import com.divination.domain.vo.GanFiveEnergyStatusVO;
import com.divination.domain.vo.GanTenGodVO;
import com.divination.domain.vo.HiddenGanVO;
import com.divination.service.EightGodService;
import com.divination.util.*;
import com.nlf.calendar.Lunar;
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


        // 1 取到八字
        Lunar lunar = new Lunar(userBirthDTO.getBirth());
        godVO.setYearGan(lunar.getYearGan());
        godVO.setMonthGan(lunar.getMonthGan());
        godVO.setDayGan(lunar.getDayGan());
        godVO.setTimeGan(lunar.getTimeGan());
        godVO.setYearZhi(lunar.getYearZhi());
        godVO.setMonthZhi(lunar.getMonthZhi());
        godVO.setDayZhi(lunar.getDayZhi());
        godVO.setTimeZhi(lunar.getTimeZhi());

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

        jsonResult.buildTrue();
        jsonResult.setData(godVO);
        return jsonResult;
    }

}
