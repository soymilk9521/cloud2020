package com.lr.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/06/07 15:05
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK, id: " + String.valueOf(id) + "\tO(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_timeout(Integer id) {
        // 服务降级，生产者侧出现程序异常或者超时时产生
        // int age = 10/0;
        long sleep = 3000;
        try {
            TimeUnit.MILLISECONDS.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_timeout, id: " + id + "\tO(∩_∩)O哈哈~ 耗时（毫秒）： " + sleep;
    }

    public String paymentInfo_timeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " 8001系统繁忙或者运行报错，请稍后再试, id: " + id + "\to(╥﹏╥)o";
    }
}
