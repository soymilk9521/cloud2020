package com.lr.springcloud.controller;

import com.lr.springcloud.entities.CommonResult;
import com.lr.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/07/04 9:17
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200, "库存扣减成功");
    }
}
