package com.young.springbootkafka.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.transaction.KafkaTransactionManager;

import java.util.HashMap;
import java.util.Map;

/**
 * kafka配置类
 *
 * @Author yangbing
 * @Date 2020/7/2 10:46
 * @Version 1.0
 */
//@Configuration
//@EnableKafka
@Slf4j
public class KafkaConfiguration {
    /**
     * ConcurrentKafkaListenerContainerFactory为创建Kafka监听器的工程类，这里只配置了消费者
     *
     * @return factory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    /**
     * 根据consumerProps填写的参数创建消费者工厂
     *
     * @return ConsumerFactory
     */
    @Bean
    public ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerProps());
    }

    /**
     * Bean方式创建监听容器
     *
     * @return KafkaMessageListenerContainer
     */
    @Bean
    public KafkaMessageListenerContainer demoListenerContainer() {
        ContainerProperties properties = new ContainerProperties("topic.quick.bean");

        properties.setGroupId("bean");

        properties.setMessageListener((MessageListener<Integer, String>) record -> log.info("topic.quick.bean receive : " + record.toString()));

        return new KafkaMessageListenerContainer(consumerFactory(), properties);
    }

    /**
     * 根据senderProps填写的参数创建生产者工厂
     * <p>
     * 使用注解方式开启事务还是比较方便的，不过首先需要我们配置KafkaTransactionManager，
     * 这个类就是Kafka提供给我们的事务管理类，我们需要使用生产者工厂来创建这个事务管理类。
     * 需要注意的是，我们需要在producerFactory中开启事务功能，并设置TransactionIdPrefix，
     * TransactionIdPrefix是用来生成Transactional.id的前缀。
     *
     * @return DefaultKafkaProducerFactory
     */
    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        DefaultKafkaProducerFactory factory = new DefaultKafkaProducerFactory<>(senderProps());
        factory.transactionCapable();
        factory.setTransactionIdPrefix("tran-");
        return factory;
    }

    @Bean
    public KafkaTransactionManager transactionManager(ProducerFactory producerFactory) {
        return new KafkaTransactionManager(producerFactory);
    }

    /**
     * kafkaTemplate实现了Kafka发送接收等功能
     * Primary注解的意思是在拥有多个同类型的Bean时优先使用该Bean
     *
     * @return KafkaTemplate
     */
    @Bean
    @Primary
    public KafkaTemplate<Integer, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean("defaultKafkaTemplate")
    public KafkaTemplate<Integer, String> defaultKafkaTemplate() {
        KafkaTemplate template = new KafkaTemplate<Integer, String>(producerFactory());
        template.setDefaultTopic("topic.quick.default");
        return template;
    }

    /**
     * 消费者配置参数
     *
     * @return props
     */
    private Map<String, Object> consumerProps() {
        Map<String, Object> props = new HashMap<>();
        //连接地址
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        //GroupID
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "bootKafka");
        //是否自动提交
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        //自动提交的频率
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        //Session超时设置
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        //键的反序列化方式
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        //值的反序列化方式
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

    /**
     * 生产者配置
     *
     * @return props
     */
    private Map<String, Object> senderProps() {
        Map<String, Object> props = new HashMap<>();
        //连接地址
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        //重试，0为不启用重试机制
        props.put(ProducerConfig.RETRIES_CONFIG, 1);
        //控制批处理大小，单位为字节
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        //批量发送，延迟为1毫秒，启用该功能能有效减少生产者发送消息次数，从而提高并发量
        props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        //生产者可以使用的总内存字节来缓冲等待发送到服务器的记录
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 1024000);
        //键的序列化方式
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        //值的序列化方式
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }
}
