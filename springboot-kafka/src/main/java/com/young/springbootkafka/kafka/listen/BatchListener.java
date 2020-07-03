package com.young.springbootkafka.kafka.listen;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 批量消费
 *
 * @author yangbing
 * @version 1.0
 * @date 2020/7/2 15:18
 */
//@Component
@Slf4j
public class BatchListener {
    private Map<String, Object> consumerProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        //一次拉取消息数量
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "5");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

    @Bean("batchContainerFactory")
    public ConcurrentKafkaListenerContainerFactory listenerContainer() {
        ConcurrentKafkaListenerContainerFactory container = new ConcurrentKafkaListenerContainerFactory();
        container.setConsumerFactory(new DefaultKafkaConsumerFactory(consumerProps()));
        //设置并发量，小于或等于Topic的分区数
        container.setConcurrency(5);
        //设置为批量监听
        container.setBatchListener(true);
        return container;
    }

    @Bean
    public NewTopic batchTopic() {
        return new NewTopic("topic.quick.batch", 8, (short) 1);
    }


    @KafkaListener(id = "batch", clientIdPrefix = "batch", topics = {"topic.quick.batch"}, containerFactory = "batchContainerFactory")
    public void batchListener(List<String> data) {
        log.info("topic.quick.batch  receive : ");
    }

    @Bean
    public NewTopic batchWithPartitionTopic() {
        return new NewTopic("topic.quick.batch.partition", 8, (short) 1);
    }

    @KafkaListener(id = "batchWithPartition",clientIdPrefix = "bwp",containerFactory = "batchContainerFactory",
            topicPartitions = {
                    @TopicPartition(topic = "topic.quick.batch.partition",partitions = {"1","3"}),
                    @TopicPartition(topic = "topic.quick.batch.partition",partitions = {"0","4"},
                            partitionOffsets = @PartitionOffset(partition = "2",initialOffset = "100"))
            }
    )
    public void batchListenerWithPartition(List<String> data) {
        log.info("topic.quick.batch.partition  receive : ");
    }
}
