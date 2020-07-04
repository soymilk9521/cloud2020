package com.lr.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author KR
 * @since 2020/07/04 11:09
 */
@Mapper
public interface AccountDao {
    void decrease(@Param("userId")Long userId, @Param("money") BigDecimal money);
}
