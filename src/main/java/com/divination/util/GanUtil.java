package com.divination.util;

import com.divination.domain.vo.GanFiveEnergyStatusVO;
import com.divination.domain.vo.GanTenGodVO;
import com.divination.domain.vo.HiddenGanVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GanUtil {

    /**
     * 获取日主的五行天干关系
     * @param dayMaster 日主,例如： 甲
     * @return GanFiveEnergyStatusVO只包含五行
     */
    public static GanFiveEnergyStatusVO getGanStatusForMe(String dayMaster){
        GanFiveEnergyStatusVO vo = new GanFiveEnergyStatusVO();

        // 1 得到日主五行和阴阳
        String fiveEnergyByGan = FiveEnergyUtil.getFiveEnergyByGan(dayMaster);
        vo.setYinYangStatus(YinYangUtil.getYinYangByGan(dayMaster));

        // 2 得到该五行的生克五行
        Map<String, String> energyMap = FiveEnergyUtil.getEnergyStatusByThisEnergy(fiveEnergyByGan);
        vo.setSameMe(energyMap.get("同我"));
        vo.setReverseSameMe(energyMap.get("同我"));
        vo.setMyChild(energyMap.get("我生"));
        vo.setReverseMyChild(energyMap.get("我生"));
        vo.setKillMe(energyMap.get("克我"));
        vo.setReverseKillMe(energyMap.get("克我"));
        vo.setCareMe(energyMap.get("生我"));
        vo.setReverseCareMe(energyMap.get("生我"));
        vo.setHateMe(energyMap.get("我克"));
        vo.setReverseHateMe(energyMap.get("我克"));

        return vo;
    }

    /**
     * 根据五行状态和阴阳状态获取天干
     * @param fiveEnergy 五行,例如 火
     * @param yinyang  阴阳
     * @return
     */
    public static String findGanByYinYangFiveEnergy(String fiveEnergy,Integer yinyang){
        List<String> targetList = new ArrayList<>();

        if(yinyang==0){
            targetList = ConstantUtil.yinGanList;
        }else{
            targetList = ConstantUtil.yangGanList;
        }

        for (String string : targetList) {
            String energy = FiveEnergyUtil.getFiveEnergyByGan(string);
            if(energy.equals(fiveEnergy)){
                return string;
            }
        }

        return null;
    }


    /**
     * 根据地支获取对应藏干
     * @param zhi 地支
     * @return
     */
    public static HiddenGanVO getHiddenGanByZhi(String zhi){
        HiddenGanVO vo = new HiddenGanVO();
        if("子".equals(zhi)){
            vo.setHeight("癸");
        }
        else if("丑".equals(zhi)){
            vo.setHeight("己");
            vo.setMiddle("辛");
            vo.setLow("癸");
        }
        else if("寅".equals(zhi)){
            vo.setHeight("甲");
            vo.setMiddle("丙");
            vo.setLow("戊");
        }
        else if("卯".equals(zhi)){
            vo.setHeight("乙");
        }
        else if("辰".equals(zhi)){
            vo.setHeight("戊");
            vo.setMiddle("乙");
            vo.setLow("癸");
        }
        else if("巳".equals(zhi)){
            vo.setHeight("丙");
            vo.setMiddle("戊");
            vo.setLow("庚");
        }
        else if("午".equals(zhi)){
            vo.setHeight("丁");
            vo.setMiddle("己");
        }
        else if("未".equals(zhi)){
            vo.setHeight("己");
            vo.setMiddle("丁");
            vo.setLow("乙");
        }
        else if("申".equals(zhi)){
            vo.setHeight("庚");
            vo.setMiddle("壬");
            vo.setLow("戊");
        }
        else if("酉".equals(zhi)){
            vo.setHeight("辛");
        }
        else if("戌".equals(zhi)){
            vo.setHeight("戊");
            vo.setMiddle("辛");
            vo.setLow("丁");
        }
        else if("亥".equals(zhi)){
            vo.setHeight("壬");
            vo.setMiddle("甲");
        }

        return vo;
    }

    /**
     * 根据地支信息获取藏干
     * @param yearZhi       年支
     * @param monthZhi      月支
     * @param dayZhi        日支
     * @param timeZhi       时支
     * @param dayMaster     日主
     * @return
     */
    public static List<HiddenGanVO> findHiddenGanListByZhi(String yearZhi,String monthZhi,String dayZhi,String timeZhi,String dayMaster){
        // 取当前日主天干的对应十神
        List<GanTenGodVO> ganGodVOList = TenGodUtil.getGanGodVOList(dayMaster);
        Map<String, GanTenGodVO> tenGodVOMap = ListUtil.transformationByListToMapObject(ganGodVOList, GanTenGodVO::getGan);

        List<HiddenGanVO> list = new ArrayList<>();

        // 分别取年月日时支里的藏干，填充十神
        if(Objects.nonNull(yearZhi)){


        HiddenGanVO year = getHiddenGanByZhi(yearZhi);
        year.setHeightGodName(tenGodVOMap.get(year.getHeight()).getGod());
        if(Objects.nonNull(year.getMiddle())){
            year.setMiddleGodName(tenGodVOMap.get(year.getMiddle()).getGod());
        }
        if(Objects.nonNull(year.getLow())){
            year.setLowGodName(tenGodVOMap.get(year.getLow()).getGod());
        }
        list.add(year);}else{
            list.add(new HiddenGanVO());
        }

        if(Objects.nonNull(monthZhi)){
        HiddenGanVO month = getHiddenGanByZhi(monthZhi);
        month.setHeightGodName(tenGodVOMap.get(month.getHeight()).getGod());
        if(Objects.nonNull(month.getMiddle())){
            month.setMiddleGodName(tenGodVOMap.get(month.getMiddle()).getGod());
        }
        if(Objects.nonNull(month.getLow())){
            month.setLowGodName(tenGodVOMap.get(month.getLow()).getGod());
        }
        list.add(month);}else{
            list.add(new HiddenGanVO());
        }

        if(Objects.nonNull(dayZhi)){
        HiddenGanVO day = getHiddenGanByZhi(dayZhi);
        day.setHeightGodName(tenGodVOMap.get(day.getHeight()).getGod());
        if(Objects.nonNull(day.getMiddle())){
            day.setMiddleGodName(tenGodVOMap.get(day.getMiddle()).getGod());
        }
        if(Objects.nonNull(day.getLow())){
            day.setLowGodName(tenGodVOMap.get(day.getLow()).getGod());
        }
        list.add(day);}else{
            list.add(new HiddenGanVO());
        }

        if(Objects.nonNull(timeZhi)){
        HiddenGanVO time = getHiddenGanByZhi(timeZhi);
        time.setHeightGodName(tenGodVOMap.get(time.getHeight()).getGod());
        if(Objects.nonNull(time.getMiddle())){
            time.setMiddleGodName(tenGodVOMap.get(time.getMiddle()).getGod());
        }
        if(Objects.nonNull(time.getLow())){
            time.setLowGodName(tenGodVOMap.get(time.getLow()).getGod());
        }
        list.add(time);
        }else{
            list.add(new HiddenGanVO());
        }

        return list;
    }


    /**
     * 根据天干list获取对应的合冲状态
     * @param list 天干列表
     * @return
     */
    public static String findGanSyzygyStatus(List<String> list){
        StringBuilder stringBuilder = new StringBuilder();

        // 四冲
        if(list.contains("甲") && list.contains("庚")){
            stringBuilder.append("甲庚冲  ");
        }
        if(list.contains("乙") && list.contains("辛")){
            stringBuilder.append("乙辛冲  ");
        }
        if(list.contains("丙") && list.contains("壬")){
            stringBuilder.append("丙壬冲  ");
        }
        if(list.contains("丁") && list.contains("癸")){
            stringBuilder.append("丁癸冲  ");
        }


        // 五合
        if(list.contains("甲") && list.contains("己")){
            stringBuilder.append("甲己合土  ");
        }
        if(list.contains("乙") && list.contains("庚")){
            stringBuilder.append("乙庚合金  ");
        }
        if(list.contains("丙") && list.contains("辛")){
            stringBuilder.append("丙辛合水  ");
        }
        if(list.contains("丁") && list.contains("壬")){
            stringBuilder.append("丁壬合木  ");
        }
        if(list.contains("戊") && list.contains("癸")){
            stringBuilder.append("戊癸合火  ");
        }



        return stringBuilder.toString();
    }

    /**
     * 获取空亡
     * @param ganZhi 干支
     * @return  空亡
     */
    public static String getFall(String ganZhi){
        List<String> jiaziList = ConstantUtil.jiaziList;
        Integer tempI = 0;
        for (int i = 0; i < jiaziList.size(); i++) {
            if(ganZhi.equals(jiaziList.get(i))){
                tempI = i;break;
            }
        }

        Integer flag = tempI/10;
        String result = switch (flag) {
            case 0 -> "戌亥";
            case 1 -> "申酉";
            case 2 -> "午未";
            case 3 -> "辰巳";
            case 4 -> "寅卯";
            case 5 -> "子丑";
            default -> "";
        };

        return result;

    }
}
