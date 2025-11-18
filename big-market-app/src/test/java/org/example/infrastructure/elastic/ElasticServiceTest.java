package org.example.infrastructure.elastic;

import lombok.extern.slf4j.Slf4j;
import org.example.infrastructure.elastic.index.RaffleActivityOrderIdx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticServiceTest {

    @Resource
    private ElasticService elasticService;

    @Test
    public void queryRaffleActivityOrderByName() {
        List<RaffleActivityOrderIdx> activityOrderIdxes = elasticService.queryRaffleActivityOrderByName("测试活动");
        System.out.println("hh");
    }
}