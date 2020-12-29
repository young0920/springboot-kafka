package com.young.springbootkafka.controller;

import cn.hutool.core.util.IdUtil;
import com.young.springbootkafka.constant.ResultBody;
import com.young.springbootkafka.pojo.Users;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * RocketMqController
 *
 * @author yangbing
 * @date 2020/12/29 下午2:08
 */
@RestController
@Slf4j
@RequestMapping(value = "/mq")
@Api(tags = "用户管理相关接口")
public class RocketMqController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value("${rocketmq.producer.topic}")
    private String topic;

    /**
     * 同步发送 sync
     * 发送消息采用同步模式，这种方式只有在消息完全发送完成之后才返回结果，此方式存在需要同步等待发送结果的时间代价。
     * 这种方式具有内部重试机制，即在主动声明本次消息发送失败之前，内部实现将重试一定次数，默认为2次（DefaultMQProducer＃getRetryTimesWhenSendFailed）。
     * 发送的结果存在同一个消息可能被多次发送给给broker，这里需要应用的开发者自己在消费端处理幂等性问题。
     *
     * @param users
     * @return
     */
    @PostMapping("sync")
    public ResultBody<SendResult> testSync(@Validated @RequestBody Users users) {
        log.info("sync 入参：" + users);
        // 创建多条 消息    同步批量发送消息
        List<Message<Message<Users>>> messages = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Message<Users> message = MessageBuilder.withPayload(users).setHeader("KEYS", IdUtil.simpleUUID()).build();
            messages.add(MessageBuilder.withPayload(message).build());

        }
        //syncSendOrderly 顺序消费
        //设置key
        //Message<Users> message = MessageBuilder.withPayload(users).setHeader("KEYS", IdUtil.simpleUUID()).build();
        SendResult syncSend = rocketMQTemplate.syncSend(topic + ":tag1", messages);
        return ResultBody.success(syncSend);
    }

    /**
     * 异步发送 async
     * 发送消息采用异步发送模式，消息发送后立刻返回，当消息完全完成发送后，会调用回调函数sendCallback来告知发送者本次发送是成功或者失败。
     * 异步模式通常用于响应时间敏感业务场景，即承受不了同步发送消息时等待返回的耗时代价。同同步发送一样，异步模式也在内部实现了重试机制，
     * 默认次数为2次（DefaultMQProducer#getRetryTimesWhenSendAsyncFailed}）。发送的结果同样存在同一个消息可能被多次发送给给broker，
     * 需要应用的开发者自己在消费端处理幂等性问题。
     *
     * @param users
     * @return
     */
    @PostMapping("async")
    public ResultBody<Boolean> testAsync(@Validated @RequestBody Users users) {
        log.info("async 入参：" + users);
        rocketMQTemplate.asyncSend(topic + ":tag2", users, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("async success " + sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                log.error("send fail", throwable.getMessage());
            }
        });


        //直接发送 one-way
        //采用one-way发送模式发送消息的时候，发送端发送完消息后会立即返回，不会等待来自broker的ack来告知本次消息发送是否完全完成发送。
        //这种方式吞吐量很大，但是存在消息丢失的风险，所以其适用于不重要的消息发送，比如日志收集
        rocketMQTemplate.sendOneWay("my-topic", "sendOneWay");
        //发送带tag的消息，没有消息发送的结果。syncSend也可发送带tag的消息，同时也有消息发送的结果。发送带tag的消息，格式是topic:tag
        rocketMQTemplate.convertAndSend("my-topic", "convertAndSend");
        return ResultBody.success(true);
    }
}
