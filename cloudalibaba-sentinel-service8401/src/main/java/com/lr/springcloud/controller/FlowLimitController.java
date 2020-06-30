package com.lr.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/06/29 8:32
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
//        try {
//            Thread.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "---------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "---------testB";
    }

    @GetMapping("/testD")
    public String testD(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD 测试RT");
//        log.info("testD 测试异常比例");
        log.info("testD 测试异常数");
        int age = 10/0;
        return "---------testD";
    }
}
