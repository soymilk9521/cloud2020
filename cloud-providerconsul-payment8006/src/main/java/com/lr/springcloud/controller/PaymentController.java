package com.lr.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/06/02 20:09
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.cloud.consul.discovery.health-check-path}")
    private String clientIp;

    @GetMapping("/payment/consul")
    public String paymentConsul() {
        return "SpringCloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

    @GetMapping("/payment/info")
    public String info() {
        return "clientIp: " + clientIp;
    }
}
