--秒杀执行存储过程
delimiter $$

--定义存储过程
--参数：in：入参；out：出参
--row_count():返回上一条增删改sql的影响行数，返回值：0：未修改数据；>0：修改的行数；<0：错误或未执行sql
--r_result:出参，-1：重复秒杀；-2：sql出错；0：秒杀结束或还没开始；1：秒杀成功
CREATE PROCEDURE seckill.execute_seckill
  (in v_seckill_id bigint, in v_phone bigint,
    in v_kill_time TIMESTAMP, out r_result int)
  BEGIN
      DECLARE insert_count int DEFAULT 0;
      start TRANSACTION ;
      INSERT ignore INTO success_killed
          (seckill_id, user_phone, create_time)
          VALUES (v_seckill_id, v_phone, v_kill_time);
      SELECT ROW_COUNT() INTO insert_count;
      if (insert_count=0) THEN -- 主键冲突，即重复秒杀
          ROLLBACK ;
          SET r_result =  -1;
      elseif (insert_count<0) THEN -- 出错
          ROLLBACK ;
          SET r_result = -2;
      ELSE
          update seckill set number = number - 1
            where seckill_id = v_seckill_id
            AND number>0
            AND v_kill_time > start_time
            AND v_kill_time < end_time;
          SELECT ROW_COUNT() INTO insert_count;
          if (insert_count=0) THEN -- 秒杀结束或还没开始
              ROLLBACK ;
              SET r_result = 0;
          elseif (insert_count<0) THEN -- 出错或等待行级锁超时
              ROLLBACK ;
              SET r_result = -2;
          ELSE
              COMMIT ;
              SET r_result = 1;
          end if;
      end if;
  END;
$$  -- 存储过程的定义结束

delimiter ;

set @r_result = -3;
call execute_seckill(1003,12345678945,now(),@r_result);

select @r_result