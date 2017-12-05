package com.opensource.jiangbiao.agileTool.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by p2vdug on 9/26/2017.
 */
public class TimeFormat {

    public static String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    public static String formatTimeStamp(String timeStamp){
        DateFormat df =new SimpleDateFormat("yyyy/MM/dd");
        String date = df.format(timeStamp);
        return date;
    }

    public static String dateToString(Date date){
        DateFormat df =new SimpleDateFormat("yyyy/MM/dd");
        String s = df.format(date);
        return s;
    }

    public static Date stringToDate(String sDate){
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = df.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("String to Date error!");
        }
        return date;
    }

    public static Long getDatePoor(String sDate){
        return getDatePoor(sDate,getCurrentTime());
    }

    public static Long getDatePoor(String sDate,String nDate){
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        //long ns = 1000;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        Date startDate = stringToDate(sDate);
        Date nowDate = stringToDate(nDate);
        long diff = nowDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        //long sec = diff % nd % nh % nm / ns;

        return day*24*60+hour*60+min;
    }

    public static void main(String[] args){
        System.out.println(TimeFormat.getCurrentTime());
        System.out.println(getDatePoor(TimeFormat.getCurrentTime(),TimeFormat.getCurrentTime()));

    }
}
