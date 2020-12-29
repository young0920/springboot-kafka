package com.young.springbootkafka.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * RocketMqConsumer
 *
 * @author yangbing
 * @date 2020/12/29 下午2:39
 */
@Component
@Slf4j
@RocketMQMessageListener(
        topic = "${rocketmq.producer.topic}",
        consumerGroup = "${rocketmq.producer.group}",
        //选择tag  || 分割
        selectorExpression = "*"
        //顺序消费
        //consumeMode = ConsumeMode.ORDERLY,
        // 设置为广播消费
        //messageModel = MessageModel.BROADCASTING
)
public class RocketMqConsumer implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt message) {
        log.info("msgId:" + message.getMsgId() + "\n message:" + new String(message.getBody()));
    }
}
