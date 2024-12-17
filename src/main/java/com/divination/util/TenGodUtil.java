package com.divination.util;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.divination.domain.vo.GanFiveEnergyStatusVO;
import com.divination.domain.vo.GanTenGodVO;
import com.divination.domain.vo.HiddenGanVO;
import com.divination.enums.TenGodEnum;
import com.nlf.calendar.Lunar;

import java.util.*;

/**
 * 十神工具类
 */
public class TenGodUtil {


    /**
     * 根据日主获取对应五行天干状态以及十神信息
     * @param dayMaster 日主天干，例如：甲
     * @return
     */
    public static GanFiveEnergyStatusVO getTenGod(String dayMaster){

        // 1先取出日主五行关系
        GanFiveEnergyStatusVO vo = GanUtil.getGanStatusForMe(dayMaster);

        // 2先根据五行找到对应天干
        Integer myYinYangStatus = vo.getYinYangStatus();
        Integer reverseYinYangStatus = (myYinYangStatus+1)%2;

        String sameMeGan = GanUtil.findGanByYinYangFiveEnergy(vo.getSameMe(), myYinYangStatus);
        vo.setSameMeGan(sameMeGan);
        String reSameMeGan = GanUtil.findGanByYinYangFiveEnergy(vo.getReverseSameMe(), reverseYinYangStatus);
        vo.setReverseSameMeGan(reSameMeGan);

        String myChildGan = GanUtil.findGanByYinYangFiveEnergy(vo.getMyChild(), myYinYangStatus);
        vo.setMyChildGan(myChildGan);
        String reMyChildGan = GanUtil.findGanByYinYangFiveEnergy(vo.getReverseMyChild(), reverseYinYangStatus);
        vo.setReverseMyChildGan(reMyChildGan);

        String killMeGan = GanUtil.findGanByYinYangFiveEnergy(vo.getKillMe(), myYinYangStatus);
        vo.setKillMeGan(killMeGan);
        String reKillMeGan = GanUtil.findGanByYinYangFiveEnergy(vo.getReverseKillMe(), reverseYinYangStatus);
        vo.setReverseKillMeGan(reKillMeGan);

        String careMeGan = GanUtil.findGanByYinYangFiveEnergy(vo.getCareMe(), myYinYangStatus);
        String reCareMeGanGan = GanUtil.findGanByYinYangFiveEnergy(vo.getReverseCareMe(), reverseYinYangStatus);
        vo.setCareMeGan(reCareMeGanGan);
        vo.setReverseCareMeGan(careMeGan);

        String hateMeGan = GanUtil.findGanByYinYangFiveEnergy(vo.getHateMe(), myYinYangStatus);
        vo.setHateMeGan(hateMeGan);
        String reHateMeGanGan = GanUtil.findGanByYinYangFiveEnergy(vo.getReverseHateMe(), reverseYinYangStatus);
        vo.setReverseHateMeGan(reHateMeGanGan);



        // 3将原来五行填充为十神
        vo.setSameMe(TenGodEnum.shoulderMan.getName());
        vo.setReverseSameMe(TenGodEnum.robber.getName());
        vo.setCareMe(TenGodEnum.allah.getName());
        vo.setReverseCareMe(TenGodEnum.unrulyGod.getName());
        vo.setMyChild(TenGodEnum.enjoyMan.getName());
        vo.setReverseMyChild(TenGodEnum.delinquent.getName());
        vo.setHateMe(TenGodEnum.wealthOfFate.getName());
        vo.setReverseHateMe(TenGodEnum.wealthOfGod.getName());
        vo.setKillMe(TenGodEnum.pandora.getName());
        vo.setReverseKillMe(TenGodEnum.handOfKing.getName());

        return vo;
    }

    /**
     * 根据日主天干获取 【天干】-【十神】的对应List
     * @param dayMaster 日主
     * @return
     */
    public static List<GanTenGodVO>  getGanGodVOList(String dayMaster){
        GanFiveEnergyStatusVO statusVO = getTenGod(dayMaster);
        List<GanTenGodVO> list = new ArrayList<>();

        GanTenGodVO same = new GanTenGodVO(statusVO.getSameMeGan(),statusVO.getSameMe());
        GanTenGodVO reSame = new GanTenGodVO(statusVO.getReverseSameMeGan(),statusVO.getReverseSameMe());
        GanTenGodVO child = new GanTenGodVO(statusVO.getMyChildGan(),statusVO.getMyChild());
        GanTenGodVO reChild = new GanTenGodVO(statusVO.getReverseMyChildGan(),statusVO.getReverseMyChild());
        GanTenGodVO care = new GanTenGodVO(statusVO.getCareMeGan(),statusVO.getCareMe());
        GanTenGodVO reCare = new GanTenGodVO(statusVO.getReverseCareMeGan(),statusVO.getReverseCareMe());
        GanTenGodVO hate = new GanTenGodVO(statusVO.getHateMeGan(),statusVO.getHateMe());
        GanTenGodVO reHate = new GanTenGodVO(statusVO.getReverseHateMeGan(),statusVO.getReverseHateMe());
        GanTenGodVO kill = new GanTenGodVO(statusVO.getKillMeGan(),statusVO.getKillMe());
        GanTenGodVO reKill = new GanTenGodVO(statusVO.getReverseKillMeGan(),statusVO.getReverseKillMe());

        list.add(same);
        list.add(reSame);
        list.add(child);
        list.add(reChild);
        list.add(care);
        list.add(reCare);
        list.add(hate);
        list.add(reHate);
        list.add(kill);
        list.add(reKill);

        return list;
    }


    /**
     * 取格局 （从正八格里取）
     * @param lunar
     * @return
     */
    public static String getTenGodStructure(Lunar lunar){
        // 获取十神关系
        List<GanTenGodVO> godVOList = getGanGodVOList(lunar.getDayGan());
        Map<String, GanTenGodVO> tenGodVOMap = ListUtil.transformationByListToMapObject(godVOList, GanTenGodVO::getGan);

        // 取出年干十神
        GanTenGodVO yearGod = tenGodVOMap.get(lunar.getYearGan());
        GanTenGodVO monthGod = tenGodVOMap.get(lunar.getMonthGan());
        GanTenGodVO timeGod = tenGodVOMap.get(lunar.getTimeGan());
        List<String> ganGodList = Arrays.asList(yearGod.getGod(), monthGod.getGod(), timeGod.getGod());

        // 比肩劫财不入格，处理月下藏干直接透出情况
        List<String> monthGanList = new ArrayList<>();
        List<String> removeList = Arrays.asList(TenGodEnum.shoulderMan.getName(), TenGodEnum.robber.getName());
        HiddenGanVO hiddenGanByZhi = GanUtil.getHiddenGanByZhi(lunar.getMonthZhi());
        GanTenGodVO heightGod = tenGodVOMap.get(hiddenGanByZhi.getHeight());
        if(!removeList.contains(heightGod.getGod())){
            monthGanList.add(heightGod.getGod());
        }
        if(Objects.nonNull(hiddenGanByZhi.getMiddle())){
            GanTenGodVO midGod = tenGodVOMap.get(hiddenGanByZhi.getMiddle());
            if(!removeList.contains(midGod.getGod())){
                monthGanList.add(midGod.getGod());
            }
        }
        if(Objects.nonNull(hiddenGanByZhi.getLow())){
            GanTenGodVO lowGod = tenGodVOMap.get(hiddenGanByZhi.getLow());
            if(!removeList.contains(lowGod.getGod())){
                monthGanList.add(lowGod.getGod());
            }
        }
        for (String g : monthGanList) {
            // 月下藏干在天干透出，直接成格
            if(ganGodList.contains(g)){
                return g;
            }
        }

        // 没有直接透出，计算除了比肩劫财外能量最大的一个
        Integer yearNum = 0;
        Integer monthNum = 0;
        Integer timeNum = 0;
        HiddenGanVO hiddenGanByYear = GanUtil.getHiddenGanByZhi(lunar.getYearZhi());
        HiddenGanVO hiddenGanByDay = GanUtil.getHiddenGanByZhi(lunar.getDayZhi());
        HiddenGanVO hiddenGanByTime = GanUtil.getHiddenGanByZhi(lunar.getTimeZhi());
        // 找出天干和月令得分
        if(removeList.contains(yearGod.getGod())){
            yearNum = -999;
        }else{
            yearNum += FiveEnergyUtil.getEnergyScore(lunar,lunar.getYearGan());
            yearNum = handleSocreByHiddenGan(hiddenGanByYear, hiddenGanByDay, hiddenGanByTime, yearGod , yearNum, tenGodVOMap);
        }
        if(removeList.contains(monthGod.getGod())){
            monthNum = -999;
        }else{
            monthNum += FiveEnergyUtil.getEnergyScore(lunar,lunar.getMonthGan());
            monthNum = handleSocreByHiddenGan(hiddenGanByYear, hiddenGanByDay, hiddenGanByTime, monthGod , monthNum, tenGodVOMap);
        }
        if(removeList.contains(timeGod.getGod())){
            timeNum = -999;
        }else{
            timeNum += FiveEnergyUtil.getEnergyScore(lunar,lunar.getTimeGan());
            timeNum = handleSocreByHiddenGan(hiddenGanByYear, hiddenGanByDay, hiddenGanByTime, timeGod , timeNum, tenGodVOMap);
        }

        // 取出
        if(yearNum > monthNum && yearNum > timeNum){
            return yearGod.getGod();
        }
       else if(monthNum > yearNum && monthNum > timeNum){
            return monthGod.getGod();
        }
        else if(timeNum > yearNum && timeNum > monthNum){
            return timeGod.getGod();
        }
        // 存在相等情况，以年为大
        return yearGod.getGod();

    }

    private static Integer handleSocreByHiddenGan(HiddenGanVO hiddenGanByYear,HiddenGanVO hiddenGanByDay,HiddenGanVO hiddenGanByTime,
                                        GanTenGodVO yearGod ,Integer num,
                                        Map<String, GanTenGodVO> tenGodVOMap ){
        // 计算十神在地支下的强度，本气+8 中气+5  余气+2

        // 处理年
        GanTenGodVO tenGodVO = tenGodVOMap.get(hiddenGanByYear.getHeight());
        if(tenGodVO.getGod().equals(yearGod.getGod())){
            num+=8;
        }
        if(Objects.nonNull(hiddenGanByYear.getMiddle())){
            GanTenGodVO mGodVO = tenGodVOMap.get(hiddenGanByYear.getMiddle());
            if(mGodVO.getGod().equals(yearGod.getGod())){
                num+=5;
            }
        }
        if(Objects.nonNull(hiddenGanByYear.getLow())){
            GanTenGodVO tGodVO = tenGodVOMap.get(hiddenGanByYear.getLow());
            if(tGodVO.getGod().equals(yearGod.getGod())){
                num+=2;
            }
        }

        // 处理日
        GanTenGodVO dayGodVO = tenGodVOMap.get(hiddenGanByDay.getHeight());
        if(dayGodVO.getGod().equals(yearGod.getGod())){
            num+=8;
        }
        if(Objects.nonNull(hiddenGanByDay.getMiddle())){
            GanTenGodVO mGodVO = tenGodVOMap.get(hiddenGanByDay.getMiddle());
            if(mGodVO.getGod().equals(yearGod.getGod())){
                num+=5;
            }
        }
        if(Objects.nonNull(hiddenGanByDay.getLow())){
            GanTenGodVO tGodVO = tenGodVOMap.get(hiddenGanByDay.getLow());
            if(tGodVO.getGod().equals(yearGod.getGod())){
                num+=2;
            }
        }

        // 处理时
        GanTenGodVO timeGodVO = tenGodVOMap.get(hiddenGanByTime.getHeight());
        if(timeGodVO.getGod().equals(yearGod.getGod())){
            num+=8;
        }
        if(Objects.nonNull(hiddenGanByTime.getMiddle())){
            GanTenGodVO mGodVO = tenGodVOMap.get(hiddenGanByTime.getMiddle());
            if(mGodVO.getGod().equals(yearGod.getGod())){
                num+=5;
            }
        }
        if(Objects.nonNull(hiddenGanByTime.getLow())){
            GanTenGodVO tGodVO = tenGodVOMap.get(hiddenGanByTime.getLow());
            if(tGodVO.getGod().equals(yearGod.getGod())){
                num+=2;
            }
        }

        return num;

    }
}
