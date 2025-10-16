package org.example.domain.award.repository;

import org.example.domain.award.model.aggregate.GiveOutPrizesAggregate;
import org.example.domain.award.model.aggregate.UserAwardRecordAggregate;

/**
 * @description 奖品仓储服务
 */
public interface IAwardRepository {

    void saveUserAwardRecord(UserAwardRecordAggregate userAwardRecordAggregate);

    String queryAwardConfig(Integer awardId);

    void saveGiveOutPrizesAggregate(GiveOutPrizesAggregate giveOutPrizesAggregate);

    String queryAwardKey(Integer awardId);

}
