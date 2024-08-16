package com.divination.util;

import com.divination.domain.vo.GanFiveEnergyStatusVO;
import com.divination.enums.FiveEnergyEnum;
import com.nlf.calendar.Lunar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        Integer index = null;
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
        for (int i = 0; i < ConstantUtil.zhiList.size(); i++) {
            String z = ConstantUtil.zhiList.get(i);
            if(z.equals(zhi)){
                return ConstantUtil.zhiEnergyList.get(i);
            }
        }
        return null;
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
}
