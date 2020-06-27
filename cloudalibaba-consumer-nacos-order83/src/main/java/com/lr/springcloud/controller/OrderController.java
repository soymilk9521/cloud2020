package com.lr.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/06/27 10:39
 */
@RestController
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private String serviceURL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serviceURL + "/payment/nacos/" + id, String.class);
    }
}
