package com.nuc.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Jiayiwu on 18/5/6.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public class SitConvertUtil {

    public static int[][] paraseJson(String json){
        String tem = JSONObject.toJSON(json).toString();
        JSONArray h =JSONObject.parseArray(tem);
        int [][] result = new int[h.size()][];
        for (int i = 0;i < h.size(); i++){
            JSONArray o1 = (JSONArray) h.get(i);
            result [i] = new int[o1.size()];
            for (int j = 0; j<o1.size();j++){
                result[i][j] = (Integer)o1.get(j);
            }
        }
        return result;

    }

    public static String toJson(int[][]sits){
       return JSONObject.toJSON(sits).toString();
    }

}
