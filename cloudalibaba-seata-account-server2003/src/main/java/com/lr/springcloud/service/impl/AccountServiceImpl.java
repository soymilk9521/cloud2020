package com.lr.springcloud.service.impl;

import com.lr.springcloud.dao.AccountDao;
import com.lr.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/07/04 11:26
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------> 账户余额扣减开始");
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId, money);
        log.info("------> 账户余额扣减结束");
    }
}
