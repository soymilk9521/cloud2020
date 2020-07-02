package com.lr.springcloud.controller;

import com.lr.springcloud.entities.CommonResult;
import com.lr.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/07/02 8:28
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> map = new HashMap<>();
    static {
        map.put(1l, new Payment(1l, "b4b7fd0d-f6d4-496a-be77-db4b46d246c7"));
        map.put(1l, new Payment(1l, "0a29c497-ec88-4139-b529-9b45d575570b"));
        map.put(1l, new Payment(1l, "7e69cbb8-8f78-4410-bcbd-b79cf761547b"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = map.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql, serverPort: " + serverPort, payment);
        return result;
    }
}
