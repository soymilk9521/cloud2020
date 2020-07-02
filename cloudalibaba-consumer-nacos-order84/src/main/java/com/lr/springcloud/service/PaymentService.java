package com.lr.springcloud.service;

import com.lr.springcloud.entities.CommonResult;
import com.lr.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/07/02 22:26
 */
@FeignClient(value = "cloud-nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
