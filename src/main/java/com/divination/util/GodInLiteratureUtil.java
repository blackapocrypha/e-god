package com.divination.util;

import java.util.Arrays;
import java.util.List;

/**
 * 文昌工具类
 */
public class GodInLiteratureUtil {

    /**
     *
     * 1. 甲年干或者日元的人的文昌位在已方，即东南偏南方向：
     * 2. 乙年干或者日元的人的文昌位在午方，即正南方向
     * 3. 丙年干或者日元的人的文昌位在申方，即西南偏西方
     * 4. 丁年干或者日元的人的文昌位在酉方，即正西方向；
     * 5. 戊年干或者日元的人的文昌位在申方，即西南偏西方向
     * 6. 己年干或者日元的人的文昌位在酉方，即正西方向
     * 7. 庚年干或者日元的人的文昌位在亥方，即西北偏北方向
     * 8. 辛年干或者日元的人的文昌位在子方，即正北方向
     * 9. 壬年干或者日元的人的文昌位在寅方，即东北偏东方向
     * 10. 癸年干或者日元的人的文昌位在卯方，即正东方
     * @param gan 天干
     * @return
     */
    public static String getGodInLiterature(String gan){
        List<String> list = Arrays.asList("东南偏南", "正南", "西南", "正西", "西南偏西", "正西", "西北偏北", "正北", "东北偏东", "正东");
        for (int i = 0; i < ConstantUtil.ganList.size(); i++) {
           if( ConstantUtil.ganList.get(i).equals(gan)){
               return list.get(i);
           }
        }
        return null;
    }
}
