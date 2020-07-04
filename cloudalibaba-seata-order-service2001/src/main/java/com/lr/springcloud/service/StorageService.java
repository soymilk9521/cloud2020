package com.lr.springcloud.service;

import com.lr.springcloud.entities.CommonResult;
import com.lr.springcloud.entities.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/07/03 23:16
 */
@FeignClient(value = "cloud-seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
