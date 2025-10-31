package org.example.domain.credit.repository;

import org.example.domain.credit.model.aggregate.TradeAggregate;
import org.example.domain.credit.model.entity.CreditAccountEntity;

/**
 * @description 用户积分仓储
 */
public interface ICreditRepository {

    void saveUserCreditTradeOrder(TradeAggregate tradeAggregate);

    CreditAccountEntity queryUserCreditAccount(String userId);

}
