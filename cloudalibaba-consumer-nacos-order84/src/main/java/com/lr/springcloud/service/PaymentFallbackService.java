package com.lr.springcloud.service;

import com.lr.springcloud.entities.CommonResult;
import com.lr.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/07/02 22:29
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult(444, "服务降级返回， ------ PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
