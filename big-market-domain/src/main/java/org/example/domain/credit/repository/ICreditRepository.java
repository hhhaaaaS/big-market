package org.example.domain.credit.repository;

import org.example.domain.credit.model.aggregate.TradeAggregate;

/**
 * @description 用户积分仓储
 */
public interface ICreditRepository {

    void saveUserCreditTradeOrder(TradeAggregate tradeAggregate);

}
