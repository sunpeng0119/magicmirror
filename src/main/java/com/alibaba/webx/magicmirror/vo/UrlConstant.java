package com.alibaba.webx.magicmirror.vo;

/**
 * Created by sunpeng on 2017/2/27.
 */
public interface UrlConstant {

    public static String IP2POSTION="http://restapi.amap.com/v3/ip?key=%s&output=json";

    public static String WEATHERFORCASTS="http://restapi.amap.com/v3/weather/weatherInfo?city=%s&key=%s&extensions=all&output=json";
}
