package com.young.springbootkafka.kafka.listen;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * kafka 单个消费
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/2 15:16
 */
//@Component
@Slf4j
public class SingleListener {

    @KafkaListener(id = "consumer", topics = "topic.quick.consumer")
    public void consumerListener(ConsumerRecord<Integer, String> record) {
        log.info("topic.quick.consumer receive : " + record.toString());
    }
}
