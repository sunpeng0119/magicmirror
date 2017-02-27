package com.alibaba.webx.magicmirror;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.webx.magicmirror.vo.Forecast;
import com.alibaba.webx.magicmirror.vo.ForecastResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sunpeng on 2017/2/27.
 */
public class MagicUntil {

    private static Logger log = LoggerFactory.getLogger(MagicUntil.class);

    public static void writeJSON(HttpServletResponse response, Forecast result) {
        if (response != null && result != null) {
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            response.setHeader("Reason-code", "200"); // 用于zabbix状态码统计
            writeString(response, JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect));
        }
    }

    public static void writeString(HttpServletResponse response, String result) {
        if (response != null && result != null) {
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.print(result);
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            } finally {
                if (out != null) {
                    out.flush();
                }
            }
        }
    }
}
