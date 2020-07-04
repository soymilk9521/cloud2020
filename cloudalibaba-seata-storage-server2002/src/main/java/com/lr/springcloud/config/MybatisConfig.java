package com.lr.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/07/04 10:15
 */
@Configuration
@MapperScan({"com.lr.springcloud.dao"})
public class MybatisConfig {
}
