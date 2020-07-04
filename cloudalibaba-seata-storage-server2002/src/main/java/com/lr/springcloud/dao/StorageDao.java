package com.lr.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/07/04 8:58
 */
@Mapper
public interface StorageDao {
    void decrease(@Param("productId")Long productId, @Param("count") Integer count);
}
