package com.lr.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lr.springcloud.entities.CommonResult;
import com.lr.springcloud.entities.Payment;
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
 * @since 2020/07/02 8:44
 */
@RestController
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serviceURL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback") // 没有配置服务降级
    @SentinelResource(value = "fallback", fallback = "handlerFallback") // 本例是fallback
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(serviceURL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id.compareTo(4l) == 0) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常...");
        }else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException, 该ID没有对应记录，空指针异常...");
        }
        return result;
    }

    // 本例是fallback
    public  CommonResult handlerFallback(Long id, Throwable e) {
        Payment payment = new Payment(id, null);
        return new CommonResult(444, "兜底方法handlerFallback， 异常内容： " + e.getMessage(), payment);
    }
}
