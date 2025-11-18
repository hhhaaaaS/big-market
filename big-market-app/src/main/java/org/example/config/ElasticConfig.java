/**
 * @BelongsProject: big-market
 * @BelongsPackage: org.example.config
 * @Author: 黄勇铭
 * @CreateTime: 2025-11-18  15:00
 * @Description: TODO
 * @Version: 1.0
 */
package org.example.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableConfigurationProperties(ElasticConfigProperties.class)
public class ElasticConfig {

    @Bean
    public RestClient restClient(ElasticConfigProperties properties) {
        return RestClient.builder(new HttpHost(properties.getHost(), properties.getPort(), "http"))
                // 设置连接超时和socket超时
                .setRequestConfigCallback(requestConfigBuilder ->
                        requestConfigBuilder
                                .setConnectTimeout(5000)  // 连接超时 5秒
                                .setSocketTimeout(60000)  // socket超时 60秒
                )
                // 设置HTTP客户端配置
                .setHttpClientConfigCallback(httpClientBuilder ->
                        httpClientBuilder
                                .setMaxConnTotal(100)     // 最大连接数
                                .setMaxConnPerRoute(100)  // 每路由最大连接数
                                .setConnectionTimeToLive(30, java.util.concurrent.TimeUnit.SECONDS) // 连接存活时间
                )
                .build();
    }

    @Bean
    public ElasticsearchTransport elasticsearchTransport(RestClient restClient) {
        return new RestClientTransport(restClient, new JacksonJsonpMapper());
    }

    @Bean
    public ElasticsearchClient elasticsearchClient(ElasticsearchTransport transport) {
        return new ElasticsearchClient(transport);
    }
}