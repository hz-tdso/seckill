package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() throws Exception {
        Seckill seckill = seckillService.getById(1000);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
//        Exposer exposer = seckillService.exportSeckillUrl(1001);
//        logger.info("exposer={}", exposer);
    }

    @Test
    public void executeSeckill() throws Exception {
//        long seckillId = 1000;
//        long userPhone = 15602407738L;
//        String md5 = "cfd6488f0b6c40af18c540c0eeb7c5a8";
//        SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
//        logger.info("seckillExecution={}", seckillExecution);
    }

    @Test
    public void executeSeckillByProcedure(){
        Exposer exposer = seckillService.exportSeckillUrl(1003);
        if(exposer.isExposed()){
            SeckillExecution seckillExecution =
                    seckillService.executeSeckillByProcedure(1003,
                            13456788765L, exposer.getMd5());
            System.out.println(seckillExecution);
        }
    }
}