package com.lr.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/15 22:48
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate getRestTempate() {
        return new RestTemplate();
    }
}
