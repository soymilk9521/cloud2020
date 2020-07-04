package com.lr.springcloud.service;
/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/07/04 9:11
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
