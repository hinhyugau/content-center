package com.itmuch.contentcenter.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Description:
 * @Author bryan
 * @Date 2021/3/7 6:28 下午
 * @Version 1.0
 */
public class UserFeignClientConfiguration {

    @Bean
    public Logger.Level level() {
        //让Feign打印所有请求的细节
        return Logger.Level.FULL;
    }
}