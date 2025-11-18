/**
 * @BelongsProject: big-market
 * @BelongsPackage: org.example.config
 * @Author: 黄勇铭
 * @CreateTime: 2025-11-18  15:00
 * @Description: TODO
 * @Version: 1.0
 */
package org.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "elastic.config", ignoreInvalidFields = true)
public class ElasticConfigProperties {

    private String host;

    private Integer port;
}