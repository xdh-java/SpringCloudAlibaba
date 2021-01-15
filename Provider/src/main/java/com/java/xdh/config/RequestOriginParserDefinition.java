package com.java.xdh.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import com.ctc.wstx.util.StringUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 薛登辉
 * @time 2021/1/14 0014 21:01
 * @description 这是我的代码风格
 */
//配置必须加上name参数的方法
public class RequestOriginParserDefinition implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {

        String name = httpServletRequest.getParameter("name");
        //这里判断是否name为空
        if(StringUtils.isEmpty(name)){
            throw new RuntimeException("名字不可以为空，傻X玩意，孙子？");
        }
        System.out.println(name);
        return name;
    }
}
