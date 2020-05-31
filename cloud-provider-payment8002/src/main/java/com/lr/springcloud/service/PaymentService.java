package com.lr.springcloud.service;

import com.lr.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/05/14 22:57
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
