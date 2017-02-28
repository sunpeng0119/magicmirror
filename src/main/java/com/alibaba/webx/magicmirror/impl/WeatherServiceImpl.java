package com.alibaba.webx.magicmirror.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.webx.magicmirror.http.HttpClinetUntil;
import com.alibaba.webx.magicmirror.service.IWeatherService;
import com.alibaba.webx.magicmirror.vo.*;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by sunpeng on 2017/2/27.
 */
public class WeatherServiceImpl implements IWeatherService {

    @Autowired
    private HttpClinetUntil httpClinet;

    @Override
    public Forecast getForecast(){
        Forecast forecast = new Forecast();
        City city = findCity();
        forecast = getForecast(city);





        return  forecast;
    }

    private City findCity() {
        City city ;
        String jsonString = httpClinet.doGet(
        String.format("http://restapi.amap.com/v3/ip?key=%s&output=json", SystemConstant.GAODEAK));

        city = JSON.parseObject(jsonString,City.class);


        return city;
    }

    private Forecast getForecast(City city){
        Forecast forecast = new Forecast();
        String jsonString = httpClinet.doGet(
        String.format(UrlConstant.WEATHERFORCASTS, city.getAdcode(),SystemConstant.GAODEAK));

        ForecastResponse response  = JSON.parseObject(jsonString,ForecastResponse.class);
        forecast = response.getForecasts()[0];
        return forecast;
    }
}

