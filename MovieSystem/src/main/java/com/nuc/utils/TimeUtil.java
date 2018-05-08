package com.nuc.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class TimeUtil {

    public static Timestamp increaTime(Timestamp time,int minutes){
        long timeL = time.getTime() + (minutes * 1000 * 60);
        Timestamp timestamp = new Timestamp(timeL);
        return timestamp;
    }

    public static String getNowTime(){
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

}
