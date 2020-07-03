package com.young.springbootkafka.kafka.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

/**
 * kafka 回调方法
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/2 14:01
 */
//@Component
@Slf4j
public class KafkaSendResultHandler implements ProducerListener {

    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        log.info("Message send success : " + producerRecord.toString());
    }

    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {
        log.info("Message send error : " + producerRecord.toString());
    }
}
