package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {
    /**
     *
     * @param seckillId
     * @param killTime
     * @return
     */
    public abstract int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date  killTime);

    public abstract Seckill queryById(long seckillId);

    /*
     *根据偏移量查询秒杀商品
     */
    public abstract List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    public abstract void killByProcedure(Map<String, Object> paramMap);

}
