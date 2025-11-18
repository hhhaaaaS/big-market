/**
 * @BelongsProject: big-market
 * @BelongsPackage: org.example.infrastructure.elastic
 * @Author: 黄勇铭
 * @CreateTime: 2025-11-18  15:34
 * @Description: TODO
 * @Version: 1.0
 */
package org.example.infrastructure.elastic;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import lombok.extern.slf4j.Slf4j;
import org.example.infrastructure.elastic.index.RaffleActivityOrderIdx;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ElasticService {

    @Resource
    ElasticsearchClient elasticsearchClient;

    public List<RaffleActivityOrderIdx> queryRaffleActivityOrderByName(String activityName){
        SearchRequest request = SearchRequest.of(b -> b
                .index(RaffleActivityOrderIdx.getIdxName())
                .query(q -> q
                        .match(m -> m
                                .field("_activity_name")  // 检索字段
                                .query(activityName) // 检索关键词
                        )
                )
        );
        List<RaffleActivityOrderIdx> result = new ArrayList<>();
        try {
            SearchResponse<RaffleActivityOrderIdx> response = elasticsearchClient.search(request, RaffleActivityOrderIdx.class);
            result = response.hits().hits().stream()
                    .map(Hit::source)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.info("查询抽奖活动单失败！活动名:{},原因:{}", activityName, e);
        }
        return result;
    }

}