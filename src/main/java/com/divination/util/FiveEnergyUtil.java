package com.divination.util;

import com.divination.domain.vo.GanFiveEnergyStatusVO;
import com.divination.enums.FiveEnergyEnum;
import com.nlf.calendar.Lunar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * 五行工具类
 */
public class FiveEnergyUtil {



    /**
     * 根据天干获取五行元素名称
     * @param gan 天干
     * @return String
     */
    public static String getFiveEnergyByGan(String gan){
        if(Objects.isNull(gan)){
            return null;
        }
        Integer index = null;
        // 防止地支误传进来
        if(ConstantUtil.zhiList.contains(gan)){
            return getFiveEnergyColorByZhi(gan);
        }
        for (int i = 0; i < ConstantUtil.ganList.size(); i++) {
            String  g= ConstantUtil.ganList.get(i);
            if(g.equals(gan)){
                index = i;
                break;
            }
        }
        index = index/2;
        if(index==0){
            return FiveEnergyEnum.TREE.getName();
        }
        else if(index==1){
            return FiveEnergyEnum.FIRE.getName();
        }
        else if(index==2){
            return FiveEnergyEnum.SOIL.getName();
        }
        else if(index==3){
            return FiveEnergyEnum.GOLD.getName();
        }

        return FiveEnergyEnum.WATER.getName();


    }

    /**
     * 根据天干返回对应颜色
     * @param gan 天干
     * @return String
     */
    public static String getFiveEnergyColorByGan(String gan){
        String fiveEnergyByGan = getFiveEnergyByGan(gan);
        if(FiveEnergyEnum.TREE.getName().equals(fiveEnergyByGan)){
            return "color: green";
        }else if(FiveEnergyEnum.FIRE.getName().equals(fiveEnergyByGan)){
            return "color: red";
        }else if(FiveEnergyEnum.SOIL.getName().equals(fiveEnergyByGan)){
            return "color: black";
        }else if(FiveEnergyEnum.GOLD.getName().equals(fiveEnergyByGan)){
            return "color: gold";
        }else{
            return "color: Cyan";
        }
    }

    /**
     * 根据天干获取五行元素code
     * @param gan 天干
     * @return String
     */
    public static Integer getFiveEnergyCodeByGan(String gan){
        String fiveEnergyByGan = getFiveEnergyByGan(gan);
        return FiveEnergyEnum.getCodeByName(fiveEnergyByGan);
    }

    /**
     * 根据地支获取五行元素名称
     * @param zhi 地支
     * @return String
     */
    public static String getFiveEnergyByZhi(String zhi){
        if(Objects.isNull(zhi)){return null;}
        for (int i = 0; i < ConstantUtil.zhiList.size(); i++) {
            String z = ConstantUtil.zhiList.get(i);
            if(z.equals(zhi.trim())){
                return ConstantUtil.zhiEnergyList.get(i);
            }
        }
        return null;
    }

    /**
     * 根据地支获取对应五行的颜色
     * @param zhi 地支
     * @return String
     */
    public static String getFiveEnergyColorByZhi(String zhi){
        String fiveEnergyByZhi = getFiveEnergyByZhi(zhi);
        if(FiveEnergyEnum.TREE.getName().equals(fiveEnergyByZhi)){
            return "color: green";
        }else if(FiveEnergyEnum.FIRE.getName().equals(fiveEnergyByZhi)){
            return "color: red";
        }else if(FiveEnergyEnum.SOIL.getName().equals(fiveEnergyByZhi)){
            return "color: black";
        }else if(FiveEnergyEnum.GOLD.getName().equals(fiveEnergyByZhi)){
            return "color: gold";
        }else{
            return "color: Cyan";
        }
    }

    /**
     * 根据当前五行获取对应生克状态
     * @param thisEnergy
     * @return
     */
    public static Map<String,String> getEnergyStatusByThisEnergy(String thisEnergy){
        Map<String,String> statusMap = new HashMap<>();

        if(FiveEnergyEnum.TREE.getName().equals(thisEnergy)){
            // 木
            statusMap.put("同我",FiveEnergyEnum.TREE.getName());
            statusMap.put("生我",FiveEnergyEnum.WATER.getName());
            statusMap.put("我生",FiveEnergyEnum.FIRE.getName());
            statusMap.put("我克",FiveEnergyEnum.SOIL.getName());
            statusMap.put("克我",FiveEnergyEnum.GOLD.getName());
        }
        else if (FiveEnergyEnum.FIRE.getName().equals(thisEnergy)){
            // 火
            statusMap.put("同我",FiveEnergyEnum.FIRE.getName());
            statusMap.put("生我",FiveEnergyEnum.TREE.getName());
            statusMap.put("我生",FiveEnergyEnum.SOIL.getName());
            statusMap.put("我克",FiveEnergyEnum.GOLD.getName());
            statusMap.put("克我",FiveEnergyEnum.WATER.getName());
        }
        else if (FiveEnergyEnum.SOIL.getName().equals(thisEnergy)){
            // 土
            statusMap.put("同我",FiveEnergyEnum.SOIL.getName());
            statusMap.put("生我",FiveEnergyEnum.FIRE.getName());
            statusMap.put("我生",FiveEnergyEnum.GOLD.getName());
            statusMap.put("我克",FiveEnergyEnum.WATER.getName());
            statusMap.put("克我",FiveEnergyEnum.TREE.getName());
        }
        else if (FiveEnergyEnum.GOLD.getName().equals(thisEnergy)){
            // 金
            statusMap.put("同我",FiveEnergyEnum.GOLD.getName());
            statusMap.put("生我",FiveEnergyEnum.SOIL.getName());
            statusMap.put("我生",FiveEnergyEnum.WATER.getName());
            statusMap.put("我克",FiveEnergyEnum.TREE.getName());
            statusMap.put("克我",FiveEnergyEnum.FIRE.getName());
        }else{
            // 水
            statusMap.put("同我",FiveEnergyEnum.WATER.getName());
            statusMap.put("生我",FiveEnergyEnum.GOLD.getName());
            statusMap.put("我生",FiveEnergyEnum.TREE.getName());
            statusMap.put("我克",FiveEnergyEnum.FIRE.getName());
            statusMap.put("克我",FiveEnergyEnum.SOIL.getName());
        }

        return statusMap;
    }


    /**
     * 获取八字中火的比例
     * @param List<String> list
     * @return
     */
    public static Integer getFireEnergyStatus(List<String> list){

        Integer firePower = 0;
        for (String ganzhi : list) {
            // 如果是天干
            if(ConstantUtil.ganList.contains(ganzhi)){
                String fiveEnergyByZhi = getFiveEnergyByGan(ganzhi);
                if(fiveEnergyByZhi.equals(FiveEnergyEnum.FIRE.getName())){
                    firePower+=1;
                }
            }

            // 如果是地支
            if(ConstantUtil.zhiList.contains(ganzhi)){
                String fiveEnergyByZhi = getFiveEnergyByZhi(ganzhi);
                if(fiveEnergyByZhi.equals(FiveEnergyEnum.FIRE.getName())){
                    firePower+=1;
                }
            }

        }
        if(firePower>=3){
            return 1;
        }

        return 0;
    }

    /**
     * 获取五行旺相休囚死状态
     * @param energy    目标五行
     * @param lord      坐标系五行
     * @return
     */
    public static String getProsperityAndDecline(String energy,String lord){
        // 获取参照系的五行关系
        Map<String, String> statusByThisEnergy = getEnergyStatusByThisEnergy(lord);
        if(statusByThisEnergy.get("同我").equals(energy)){
            return "旺";
        }else if(statusByThisEnergy.get("我生").equals(energy)){
            return "相";
        }
        else if(statusByThisEnergy.get("生我").equals(energy)){
            return "休";
        }
        else if(statusByThisEnergy.get("克我").equals(energy)){
            return "囚";
        }else{
            return "死";
        }
    }

    /**
     * 获取该天干的五行在命局中的得分
     * @param lunar
     * @param gan   目标天干
     * @return
     */
    public static Integer getEnergyScore(Lunar lunar,String gan){
        Integer score = 0;
        // 得令加40分。月干日干得令加12分，其他加8分

        // 获取对应天干的五行
        String fiveEnergyByGan = getFiveEnergyByGan(gan);
        String fiveEnergyByMonth = getFiveEnergyByZhi(lunar.getMonthZhi());
        String prosperityAndDecline = getProsperityAndDecline(fiveEnergyByGan, fiveEnergyByMonth);
        if(prosperityAndDecline.equals("旺") || prosperityAndDecline.equals("相")){
            score+=40;
        }else{
            score-=40;
        }

        // 分别计算其他天干
        String yearGan = lunar.getYearGan();
        String monthGan = lunar.getMonthGan();
        String dayGan = lunar.getDayGan();
        String timeGan = lunar.getTimeGan();
        String yearGanStatus = getProsperityAndDecline(fiveEnergyByGan, getFiveEnergyByGan(yearGan));
        if(yearGanStatus.equals("旺") || yearGanStatus.equals("相")){
            score+=8;
        }else{
            score-=8;
        }

        String mGanStatus = getProsperityAndDecline(fiveEnergyByGan, getFiveEnergyByGan(monthGan));
        if(mGanStatus.equals("旺") || mGanStatus.equals("相")){
            score+=12;
        }else{
            score-=12;
        }

        String dGanStatus = getProsperityAndDecline(fiveEnergyByGan, getFiveEnergyByGan(dayGan));
        if(dGanStatus.equals("旺") || dGanStatus.equals("相")){
            score+=12;
        }else{
            score-=12;
        }

        String tGanStatus = getProsperityAndDecline(fiveEnergyByGan, getFiveEnergyByGan(timeGan));
        if(tGanStatus.equals("旺") || tGanStatus.equals("相")){
            score+=8;
        }else{
            score-=8;
        }

        return score;
    }
}
