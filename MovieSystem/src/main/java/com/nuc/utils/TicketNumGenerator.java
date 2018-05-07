package com.nuc.utils;

import java.util.Random;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class TicketNumGenerator {

    static String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
   static Random rand = new Random();

   public static String generatorTicketNum(int cinemaid) {
       StringBuffer flag = new StringBuffer();
       for (int j = 0; j < 4; j++) {
           flag.append(sources.charAt(rand.nextInt(9)) + "");
       }
      return TimeUtil.getNowTime()+markNum(cinemaid,4)+flag.toString();
   }

   private static String markNum(int num,int targetLength){
       String result = num+"";
       int target = targetLength - result.length();
        for (int i = 0; i < target ; i++){
            result = "0" + result;
        }
        return result;
   }

}
