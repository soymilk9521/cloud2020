package com.lr.springcloud.service.impl;

import com.lr.springcloud.dao.OrderDao;
import com.lr.springcloud.entities.Order;
import com.lr.springcloud.service.AccountService;
import com.lr.springcloud.service.OrderService;
import com.lr.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/07/03 23:16
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 下订单 -> 减库存 -> 扣余额 -> 改状态
     * @param order
     */
    @Override
    @GlobalTransactional(name = "lr-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------> 开始新建订单");
        orderDao.create(order);
        log.info("------> 订单微服务开始调用库存， 做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------> 订单微服务开始调用库存， 做扣减END");

        log.info("------> 订单微服务开始调用账户， 做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------> 订单微服务开始调用账户， 做扣减END");

        log.info("------> 修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("------> 修改订单状态结束");

        log.info("------> 下订单结束 O(∩_∩)O哈哈~");
    }
}
