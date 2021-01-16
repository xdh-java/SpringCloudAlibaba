package com.java.xdh.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author 薛登辉
 * @time 2021/1/16 0016 16:14
 * @description 这是我的代码风格
 */
@Slf4j
public class Producer {

    public static void main(String[] args) throws Exception {
        //创建消息生产者
        DefaultMQProducer producer = new DefaultMQProducer("xdh-----group");
        // 设置NameServer
        producer.setNamesrvAddr("192.168.206.129:9876");
        // 启动生产者
        producer.start();
        // 构建消息对象
        Message message = new Message("xdh----myTop", "xdh---myTag", ("薛登辉-----测试RocketMQ").getBytes());
        // 发送消息
        SendResult result = producer.send(message, 5000);
        System.out.println(result);
        //关闭生产者
        producer.shutdown();
    }
}
