package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {

    /**
     *
     * @param seckillId
     * @param userPhone
     * @return 插入的记录数
     */
    public abstract int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     *
     * @param seckillId
     * @return 返回SuccessKilled，及其相应的Seckill（作为SuccessKilled的属性）
     */
    public abstract SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
