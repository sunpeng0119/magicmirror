package com.alibaba.webx.magicmirror.app1.module.screen;

import com.alibaba.webx.magicmirror.MagicUntil;
import com.alibaba.webx.magicmirror.service.IWeatherService;
import com.alibaba.webx.magicmirror.vo.Forecast;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sunpeng on 2017/2/27.
 */
public class MagicService {

    @Autowired
    IWeatherService weatherService;

    @Autowired
    private HttpServletResponse response;

    public void execute(HttpServletRequest request) throws Exception{
        String serverType = request.getParameter("serviceType");
        if ("weather".equals(serverType)){
            Forecast forecast = weatherService.getForecast();
            System.out.println(forecast);
            MagicUntil.writeJSON(response,forecast);
        }

    }
}
