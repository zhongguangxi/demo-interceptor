package com.bxoon.service.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：GuangxiZhong
 * @date ：Created in 2021/1/2 16:15
 * @description：
 * @modified By：
 * @version: 1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        addDefaultHttpMessageConverters(messageConverters);
        for (int i = 0; i < messageConverters.size(); i++) {
            HttpMessageConverter<?> mc = messageConverters.get(i);
            if (mc instanceof MappingJackson2HttpMessageConverter) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                ((MappingJackson2HttpMessageConverter) mc).setObjectMapper(objectMapper);
            }
            converters.add(mc);
        }
    }
}
