package com.divination.util;

/**
 * 阴阳属性工具类
 * 统一为  1是阳  0是阴
 */
public class YinYangUtil {

    /**
     * 根据天干获取阴阳
     * @param gan 天干
     * @return
     */
    public static Integer getYinYangByGan(String gan){
        Integer index = null;
        for (int i = 0; i < ConstantUtil.ganList.size(); i++) {
            String  g= ConstantUtil.ganList.get(i);
            if(g.equals(gan)){
                index = i;
                break;
            }
        }
        index = index+1;
        if(index%2==0){
            return 0;
        }
        return 1;
    }

    /**
     * 根据地支获取阴阳
     * @param zhi 地支
     * @return
     */
    public static Integer getYinYangByZhi(String zhi){
        Integer index = null;
        for (int i = 0; i < ConstantUtil.zhiList.size(); i++) {
            String  g= ConstantUtil.zhiList.get(i);
            if(g.equals(zhi)){
                index = i;
                break;
            }
        }
        index = index+1;
        if(index%2==0){
            return 0;
        }
        return 1;
    }

}
