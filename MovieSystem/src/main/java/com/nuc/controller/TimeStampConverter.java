package com.nuc.controller;

import java.sql.Timestamp;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 时间转换器接口
 * 用于controller直接接收Timestamp时把对应的string转换成TimeStamp
 * （Spring Controller直接接时间戳参数会被当成String处理导致转换失败.有两种解决办法
 * 1、写转换器 2、把TimeStamp包装成一个对象中的参数，这样Spring可以直接通过JSON转）
 */
@Component
public class TimeStampConverter implements Converter<String,Timestamp>  {
    @Override
    public Timestamp convert(String s) {
        if (null == s || s.equals("") || s.equals("0")|| s.toLowerCase().equals("null")){
            return null;
        }
        return new Timestamp(Long.parseLong(s));
    }

}
