package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
//        System.out.println(successKilledDao.insertSuccessKilled(1001, 15602407738L));
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
//        System.out.println(successKilledDao.queryByIdWithSeckill(1001, 15602407738L));
    }

}