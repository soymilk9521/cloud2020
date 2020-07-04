package com.lr.springcloud.dao;

import com.lr.springcloud.entities.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/07/03 22:48
 */
@Mapper
public interface OrderDao {
    // 1. 新建订单
    void create(Order order);

    // 2. 修改订单状态， 从0改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
