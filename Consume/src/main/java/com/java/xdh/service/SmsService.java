package com.java.xdh.service;

import com.java.xdh.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author 薛登辉
 * @time 2021/1/16 0016 21:11
 * @description 这是我的代码风格
 */
@Service
@Slf4j
@RocketMQMessageListener(consumerGroup = "myConsumer",topic = "xdhTopic")
public class SmsService implements RocketMQListener<Order> {

    @Override
    public void onMessage(Order order) {
        log.info("新订单{},发短信",order);
    }
}
