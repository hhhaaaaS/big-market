package org.example.domain.strategy.service.armory;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyArmoryTest {

    @Resource
    IStrategyArmory strategyArmory;

    @Test
    public void assembleLotteryStrategy() {
        boolean b = strategyArmory.assembleLotteryStrategy(100001L);
    }

    @Test
    public void getRandomAwardId() {
    }
}