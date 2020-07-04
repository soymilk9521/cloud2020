package com.lr.springcloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/07/04 11:24
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}
