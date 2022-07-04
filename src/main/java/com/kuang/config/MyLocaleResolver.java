package com.kuang.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取请求参数
        String lang = request.getParameter("l");
        // 如果请求中没有区域值，就用默认的
        Locale locale = Locale.getDefault();
        if(StringUtils.hasText(lang)){
            // 分割请求参数
            String[] split = lang.split("_");
            // 语言、地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}


