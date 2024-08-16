package com.divination.enums;

import java.util.Objects;

/**
 * 十神枚举
 */
public enum TenGodEnum {

    shoulderMan(1,"比肩"),
    robber(2,"劫财"),
    allah(3,"正印"),
    unrulyGod(4,"偏印"),
    enjoyMan(5,"食神"),
    delinquent(6,"伤官"),
    wealthOfGod(7,"正财"),
    wealthOfFate(8,"偏财"),
    handOfKing(9,"正官"),
    pandora(10,"七杀")
    ;

    private Integer code;

    private String name;

    TenGodEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Integer getCodeByName(String name){
        if(Objects.isNull(name)){
            return 0;
        }
        name = name.trim();
        for (TenGodEnum value : values()) {
            if(value.name.equals(name)){
                return value.code;
            }
        }
        return 0;
    }


}
