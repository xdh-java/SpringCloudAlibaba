package com.java.xdh.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @author 薛登辉
 * @time 2021/1/16 0016 17:16
 * @description 这是我的代码风格
 */
@Slf4j
public class ConsumerTest {
    public static void main(String[] args) throws Exception {
        //创建消息消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("xdhConsumer-group");
        //设置NameServer
        consumer.setNamesrvAddr("192.168.206.129:9876");
        //指定订阅的主题和标签
        consumer.subscribe("xdh----myTop","*");
        //回调函数
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                log.info("Message=>{}",list);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者
        consumer.start();
    }
}
