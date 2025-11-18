/**
 * @BelongsProject: big-market
 * @BelongsPackage: org.example.infrastructure.elastic.index
 * @Author: 黄勇铭
 * @CreateTime: 2025-11-18  15:46
 * @Description: TODO
 * @Version: 1.0
 */
package org.example.infrastructure.elastic.index;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaffleActivityOrderIdx implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("_activity_id")
    private String activityId;

    @JsonProperty("_activity_name")
    private String activityName;

    @JsonProperty("_create_time")
    private Date createTime;

    @JsonProperty("_day_count")
    private String dayCount;

    @JsonProperty("_month_count")
    private String monthCount;

    @JsonProperty("_order_id")
    private String orderId;

    @JsonProperty("_order_time")
    private String orderTime;

    @JsonProperty("_out_business_no")
    private String outBusinessNo;

    @JsonProperty("_pay_amount")
    private String payAmount;

    @JsonProperty("_sku")
    private String sku;

    @JsonProperty("_state")
    private String state;

    @JsonProperty("_strategy_id")
    private String strategyId;

    @JsonProperty("_total_count")
    private String totalCount;

    @JsonProperty("_update_time")
    private Date updateTime;

    @JsonProperty("_user_id")
    private String userId;

    public  static String getIdxName(){
        return "big_market.raffle_activity_order";
    }

}