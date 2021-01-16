package com.java.xdh.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.google.common.collect.Ordering;
import com.java.xdh.entity.Order;
import com.java.xdh.service.HelloService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author 薛登辉
 * @time 2021/1/13 0013 19:36
 * @description 这是我的代码风格
 */
@RestController
public class HandlerProvider {

    @Autowired
    private HelloService helloService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }
    @GetMapping("/list")
    public String list(){
        return "list";
    }


    @GetMapping("/test1")
    public String test1(){

        this.helloService.testHello();
        return "test1.....";
    }
    @GetMapping("/test2")
    public String  test2(){
        this.helloService.testHello();
        return "test2.....";
    }
    @GetMapping("/hot")
    @SentinelResource("hot")
    public String hot(
            @RequestParam(value = "num1",required = false) Integer num1,
            @RequestParam(value = "num2",required = false) Integer num2) {

        return num1+"拼接"+num2;
    }


    @GetMapping("/hots2/{num1}")
    public String hot2(@PathVariable("num1") Long num1){
        return num1+"caodan";
    }

    //编写RocketMQ的代码
    //注入RocketMQ
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/create")
    public Order create(){
        Order order = new Order(1,"zs","123123","软件园",new Date());
        rocketMQTemplate.convertAndSend("xdhTopic",order);
        return order;
    }







}