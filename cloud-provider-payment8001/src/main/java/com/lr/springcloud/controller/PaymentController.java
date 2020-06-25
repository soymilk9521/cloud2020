package com.lr.springcloud.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.lr.springcloud.entities.CommonResult;
import com.lr.springcloud.entities.Payment;
import com.lr.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/14 23:01
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果： "+ result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功" + serverPort, result);
        }
        return new CommonResult(444, "插入数据库是吧");
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("******查询结果： "+ result);
        if (result != null) {
            return new CommonResult(200, "查询成功!!!!" + serverPort, result);
        }
        return new CommonResult(555, "没有对应记录， 查询ID：" + id);
    }

    @GetMapping(value = "/payment/lb")
    public String lb() {
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi, i am  paymentzipkin server fall back, welcome to here, O(∩_∩)O哈哈~";
    }
}
