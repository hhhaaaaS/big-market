/**
 * @BelongsProject: big-market
 * @BelongsPackage: org.example.domain.credit.model.entity
 * @Author: 黄勇铭
 * @CreateTime: 2025-10-16  14:03
 * @Description: TODO
 * @Version: 1.0
 */
package org.example.domain.credit.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.domain.award.valobj.TaskStateVO;
import org.example.domain.credit.event.CreditAdjustSuccessMessageEvent;

import org.example.types.event.BaseEvent;

/**
 * @description 任务实体对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {

    /** 活动ID */
    private String userId;
    /** 消息主题 */
    private String topic;
    /** 消息编号 */
    private String messageId;
    /** 消息主体 */
    private BaseEvent.EventMessage<CreditAdjustSuccessMessageEvent.CreditAdjustSuccessMessage> message;
    /** 任务状态；create-创建、completed-完成、fail-失败 */
    private TaskStateVO state;

}
