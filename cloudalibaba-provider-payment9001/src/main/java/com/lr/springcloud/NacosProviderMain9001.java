package com.lr.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <p >
 *
 * </p>
 *
 * @author LR
 * @since 2020/06/27 7:23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9001.class, args);
    }
}
