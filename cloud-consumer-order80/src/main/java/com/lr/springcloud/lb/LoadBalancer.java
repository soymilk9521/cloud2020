package com.lr.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/06/05 8:02
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> instances);
}
