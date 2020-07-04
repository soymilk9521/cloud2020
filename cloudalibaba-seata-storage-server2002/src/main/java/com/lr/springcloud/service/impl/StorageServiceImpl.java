package com.lr.springcloud.service.impl;

import com.lr.springcloud.dao.StorageDao;
import com.lr.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author LR
 * @since 2020/07/04 9:12
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------> 库存扣减开始");
        storageDao.decrease(productId, count);
        log.info("------> 库存扣减结束");
    }


}
