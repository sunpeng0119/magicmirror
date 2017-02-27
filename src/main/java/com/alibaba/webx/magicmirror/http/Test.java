package com.alibaba.webx.magicmirror.http;

/**
 * Created by sunpeng on 2017/2/27.
 */
public class Test {
    public static void main(String[] args){
        HttpClinetUntil httpClinet = new HttpClinetUntil();
        httpClinet.doGet("http://restapi.amap.com/v3/weather/weatherInfo?city=110000&key=b0a8e7c54d812c620b3f0893f7413dce&extensions=all&output=json");
    }
}
