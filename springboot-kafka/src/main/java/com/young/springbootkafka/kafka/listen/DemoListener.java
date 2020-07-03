package com.young.springbootkafka.kafka.listen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * 监听实例
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/2 10:54
 */
//@Component
@Slf4j
public class DemoListener {
    /**
     * 声明consumerID为demo，监听topicName为topic.quick.demo的Topic
     *
     * @param msgData 内容
     */
    @KafkaListener(id = "demo", topics = "topic.quick.demo")
    public void listen(String msgData) {
        log.info("demo receive : " + msgData);
    }
}
