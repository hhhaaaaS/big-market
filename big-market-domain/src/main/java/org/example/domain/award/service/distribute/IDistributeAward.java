package org.example.domain.award.service.distribute;

import org.example.domain.award.model.entity.DistributeAwardEntity;

/**
 * @description 分发奖品接口
 */
public interface IDistributeAward {

    void giveOutPrizes(DistributeAwardEntity distributeAwardEntity);
}
