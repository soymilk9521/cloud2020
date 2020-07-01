package com.lr.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lr.springcloud.entities.CommonResult;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/07/01 22:34
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException e) {
        return new CommonResult(444, "按照客户自定义，Global HandlerException！------1");
    }

    public static CommonResult handlerException2(BlockException e) {
        return new CommonResult(444, "按照客户自定义，Global HandlerException！------2");
    }
}
