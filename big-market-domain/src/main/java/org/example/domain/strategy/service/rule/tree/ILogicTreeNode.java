package org.example.domain.strategy.service.rule.tree;


import org.example.domain.strategy.service.rule.tree.factory.engine.DefaultTreeFactory;

import java.util.Date;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 规则树接口
 * @create 2024-01-27 11:14
 */
public interface ILogicTreeNode {

    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue, Date endDateTime);

}
