package com.lr.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/06/05 8:04
 */
@Component
public class MyLoadBalancer implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    // 负载均衡算法： rest接口第几次请求数 % 服务器集群总数 = 实际调用服务器位置下标，每次服务器重启接口冲1开始计算
    @Override
    public ServiceInstance instances(List<ServiceInstance> instances) {
        int index = this.getAndIncrement() % instances.size();
        return instances.get(index);
    }

    private final int getAndIncrement() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE? 0: current + 1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("******第几次访问，次数next:" + next);
        return next;
    }
}
