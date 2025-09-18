package org.example.infrastructure.persistent.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.Strategy;
import org.example.infrastructure.persistent.po.StrategyRule;

import java.util.List;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 策略规则 DAO
 * @create 2023-12-16 13:25
 */
@Mapper
public interface IStrategyRuleDao {

    List<StrategyRule> queryStrategyRuleList();

    StrategyRule queryStrategyRule(StrategyRule strategyRuleReq);

    String queryStrategyRuleValue(StrategyRule strategyRule);


}
