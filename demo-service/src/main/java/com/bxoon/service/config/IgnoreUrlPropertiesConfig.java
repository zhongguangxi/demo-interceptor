package com.bxoon.service.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: admin
 * @description: 过滤URL属性配置类
 */
@Data
@ConfigurationProperties(prefix = "ignore")
@Component
public class IgnoreUrlPropertiesConfig {

    private List<String> urls = new ArrayList<>();


}
