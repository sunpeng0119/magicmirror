package com.alibaba.webx.magicmirror.service;

import com.alibaba.webx.magicmirror.vo.Forecast;

/**
 * Created by sunpeng on 2017/2/27.
 */
public interface IWeatherService {

    Forecast getForecast();
}
