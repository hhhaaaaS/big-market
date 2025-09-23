package org.example.infrastructure.persistent.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.RaffleActivity;

/**
 * @description 抽奖活动表Dao
 */
@Mapper
public interface IRaffleActivityDao {

    RaffleActivity queryRaffleActivityByActivityId(Long activityId);

}
