package com.divination.util;

import com.divination.domain.vo.GanFiveEnergyStatusVO;
import com.divination.domain.vo.GanTenGodVO;
import com.divination.enums.TenGodEnum;

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

}
