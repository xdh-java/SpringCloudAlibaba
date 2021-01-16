package com.java.xdh.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author 薛登辉
 * @time 2021/1/14 0014 21:05
 * @description 这是我的代码风格
 */
//主要是让RequestOriginParserDefinition这个配置类生效而已。
/*@Configuration*/
public class SentinelConfiguration {
    @PostConstruct
    public void init(){
        WebCallbackManager.setRequestOriginParser(new RequestOriginParserDefinition());
    }
}