package com.example.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class test111 {
    public static void main(String[] args){
        List<TvSeriesDto> list =  new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,Calendar.OCTOBER,12,0,0);
        list.add( new TvSeriesDto(1,"WestWorld",1,calendar.getTime()));
        System.out.println(list);
    }
}
