package com.divination.enums;

import java.util.Objects;

public enum FiveEnergyEnum {

    TREE(1,"木"),
    FIRE(2,"火"),
    SOIL(3,"土"),
    GOLD(4,"金"),
    WATER(5,"水")
    ;

    private Integer code;

    private String name;

    FiveEnergyEnum(Integer code, String name) {
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
        for (FiveEnergyEnum value : values()) {
            if(value.name.equals(name)){
                return value.code;
            }
        }
        return 0;
    }


}
