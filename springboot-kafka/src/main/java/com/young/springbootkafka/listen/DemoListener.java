package com.young.springbootkafka.listen;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * 类注释
 *
 * @author yangbing
 * @date 2020/7/2 10:54
 * @version 1.0
 */
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
