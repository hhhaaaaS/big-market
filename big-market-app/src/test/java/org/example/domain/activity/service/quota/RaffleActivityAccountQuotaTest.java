package org.example.domain.activity.service.quota;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.activity.model.entity.SkuRechargeEntity;
import org.example.domain.activity.model.valobj.OrderTradeTypeVO;
import org.example.domain.credit.model.entity.TradeEntity;
import org.example.domain.credit.model.valobj.TradeNameVO;
import org.example.domain.credit.model.valobj.TradeTypeVO;
import org.example.domain.credit.service.ICreditAdjustService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleActivityAccountQuotaTest {

    @Resource
    RaffleActivityAccountQuotaService quotaService;

    @Resource
    ICreditAdjustService creditAdjustService;

    @Test
    public void createOrder() {
        SkuRechargeEntity skuRechargeEntity = new SkuRechargeEntity();
        skuRechargeEntity.setUserId("xiaofuge");
        skuRechargeEntity.setSku(9011L);
        // outBusinessNo 作为幂等仿重使用，同一个业务单号2次使用会抛出索引冲突 Duplicate entry '700091009111' for key 'uq_out_business_no' 确保唯一性。
        skuRechargeEntity.setOutBusinessNo("70009240608007");
        skuRechargeEntity.setOrderTradeType(OrderTradeTypeVO.credit_pay_trade);
        String orderId = quotaService.createOrder(skuRechargeEntity);
    }


    @Test
    public void test_createOrder_pay() throws InterruptedException {
        TradeEntity tradeEntity = new TradeEntity();
        tradeEntity.setUserId("xiaofuge");
        tradeEntity.setTradeName(TradeNameVO.CONVERT_SKU);
        tradeEntity.setTradeType(TradeTypeVO.REVERSE);
        tradeEntity.setAmount(new BigDecimal("-1.68"));
        tradeEntity.setOutBusinessNo("70009240609001");
        creditAdjustService.createOrder(tradeEntity);
        new CountDownLatch(1).await();
    }

}