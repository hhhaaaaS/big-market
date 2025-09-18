package org.example.infrastructure.persistent.dao;


import org.apache.ibatis.annotations.Mapper;
import org.example.infrastructure.persistent.po.Award;

import java.util.List;

/**
 *
 * @description 奖品表DAO
 * @create 2023-12-16 13:23
 */
@Mapper
public interface IAwardDao {

    List<Award> queryAwardList();

}
