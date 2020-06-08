package com.lr.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/06/08 6:13
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---PaymentFallbackService---, paymentInfo_OK, 系统异常请稍后重试！o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "---PaymentFallbackService---, paymentInfo_Timeout, 系统异常请稍后重试！o(╥﹏╥)o";
    }
}
