package com.allinpay.core.config;

import com.allinpay.core.interceptor.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private AuthorityInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //访问js/css/img/file等静态资源 pathPatterns指的是url路径规则
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //配置磁盘外虚拟目录映射 用于访问上传的图片
        registry.addResourceHandler("/etcimg/**").addResourceLocations("file:/home/etcprouser/");
        //访问html资源，一般是设置进制访问的
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
    }
}
