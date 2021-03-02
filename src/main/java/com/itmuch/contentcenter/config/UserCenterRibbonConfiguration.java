package com.itmuch.contentcenter.config;

import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;
import ribbonconfiguration.RibbonConfiguration;

/**
 * @Description:
 * @Author bryan
 * @Date 2021/3/2 2:09 下午
 * @Version 1.0
 */
@Configuration
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class UserCenterRibbonConfiguration {
}