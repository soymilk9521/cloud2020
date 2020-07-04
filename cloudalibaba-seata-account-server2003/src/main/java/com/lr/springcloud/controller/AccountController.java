package com.lr.springcloud.controller;

import com.lr.springcloud.entities.CommonResult;
import com.lr.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/07/04 11:30
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200, "账户余额扣减成功！");
    }
}
