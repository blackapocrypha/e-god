package com.divination.controller;

import com.nlf.calendar.Lunar;

import java.util.Date;

public class NayinTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Lunar lun = new Lunar(new Date());
        System.out.println(lun.getEightChar().getYearNaYin().substring(2, 3));
    }

}
