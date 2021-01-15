package com.java.xdh.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 薛登辉
 * @time 2021/1/13 0013 19:34
 * @description 这是我的代码风格
 */
@Configuration
public class ConsumerConfig {
    //装入到ioc容器里面

    @Bean
    /*@LoadBalanced*/
    //使用Ribbon来管理负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
