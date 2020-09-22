package com.young.springbootkafka.kafkatest;

import com.young.springbootkafka.SpringbootKafkaApplication;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * kafka 测试类
 *
 * @Author yangbing
 * @Date 2020/7/2 11:19
 * @Version 1.0
 */
@SpringBootTest(classes = SpringbootKafkaApplication.class)
public class KafkaTest {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Test
    public void testDemo() throws InterruptedException {
        kafkaTemplate.send("topic.quick.demo", "this is my first demo");


        //发送带有时间戳的消息
        kafkaTemplate.send("topic.quick.demo", 0, System.currentTimeMillis(), 0, "send message with timestamp");

        //使用ProducerRecord发送消息
        ProducerRecord record = new ProducerRecord("topic.quick.demo", "use ProducerRecord to send message");
        kafkaTemplate.send(record);

        //使用Message发送消息
        Map map = new HashMap();
        map.put(KafkaHeaders.TOPIC, "topic.quick.demo");
        map.put(KafkaHeaders.PARTITION_ID, 0);
        map.put(KafkaHeaders.MESSAGE_KEY, 0);
        GenericMessage message = new GenericMessage("use Message to send message", new MessageHeaders(map));
        kafkaTemplate.send(message);


        //休眠5秒，为了使监听器有足够的时间监听到topic的数据
        Thread.sleep(5000);
    }

    @Test
    @Transactional
    public void testTransactionalAnnotation() throws InterruptedException {
        kafkaTemplate.send("topic.quick.tran", "test transactional annotation");
        throw new RuntimeException("fail");
    }

    /**
     * 这种方式开启事务是不需要配置事务管理器的，也可以称为本地事务
     */
    @Test
    public void testExecuteInTransaction() {
        kafkaTemplate.executeInTransaction(kafkaOperations -> {
            kafkaOperations.send("topic.quick.tran", "test executeInTransaction");
            throw new RuntimeException("fail");
            //return true;
        });
    }
}
