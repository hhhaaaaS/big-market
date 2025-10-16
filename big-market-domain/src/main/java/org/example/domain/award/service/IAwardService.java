package org.example.domain.award.service;

import org.example.domain.award.model.entity.DistributeAwardEntity;
import org.example.domain.award.model.entity.UserAwardRecordEntity;

/**
 * @description 奖品服务接口
 */
public interface IAwardService {

    void saveUserAwardRecord(UserAwardRecordEntity userAwardRecordEntity);

    /**
     * 配送发货奖品
     */
    void distributeAward(DistributeAwardEntity distributeAwardEntity);

}
