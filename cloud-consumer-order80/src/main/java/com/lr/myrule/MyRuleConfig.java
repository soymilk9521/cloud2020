package com.lr.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/06/04 8:53
 */
@Configuration
public class MyRuleConfig {
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
