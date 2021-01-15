package com.java.xdh.service;

/**
 * @author 薛登辉
 * @time 2021/1/14 0014 17:09
 * @description 这是我的代码风格
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @SentinelResource("test")
    public void testHello(){
        System.out.println("testHello..");
    }
}
