package com.java.xdh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 薛登辉
 * @time 2021/1/13 0013 19:12
 * @description 这是我的代码风格
 */

@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/instances")
    public List<ServiceInstance> instances(){
        List<ServiceInstance> provider = discoveryClient.getInstances("provider");
        return provider;
    }
    //调用provider里面的index方法，实现思路很简单，只不过是在provider里面拿到了url地址，进行拼接，最后
    //通过restTemplate去间接的调用即可。
    @GetMapping("/index")
    public String index(){

        List<ServiceInstance> list = discoveryClient.getInstances("provider");

        //这个里面是所有的属性，就相当于要把这里面的属性拆分出来
        //1、从list里面获取出来url地址
        //1.1首先呢，list里面封装了三个随机的参数，所以要用到随机数来获取
        int index = ThreadLocalRandom.current().nextInt(list.size());
        ServiceInstance serviceInstance = list.get(index);
        //这个是被调用者里面的方法的url地址而已
        String url = serviceInstance.getUri() + "/index";

        //2、使用restTemplate完成服务之间的调用结果
        log.error("调用的端口是:{}",serviceInstance.getPort());
        log.error("调用的uri为：{}",serviceInstance.getUri());
        log.error("被调用者的url是:{}",url);
        //restTemplate.getForObject(url,String.class)这个里面，url就好比一个超链接一样，String.class是被调用方
        //要返回的方法对象
        String rest = restTemplate.getForObject(url, String.class);
        return "调用的了端口为："+serviceInstance.getPort()+"的服务，"+"返回的结果是:"+rest;



      /*  //调用provider里面的index方法
        //1、找到provider实例
        List <ServiceInstance> list = discoveryClient.getInstances("provider");
        //1.1先获取随机数字
        int index = ThreadLocalRandom.current().nextInt(list.size());
        //2、根据list.get(index)获取到具体的serviceInstance对象
        ServiceInstance serviceInstance = list.get(index);
        //3、既然你要访问其provider里面的index方法，那必然要获取其里面的url地址
        //这里面封装的就是任意provider里面的url属性
        String url = serviceInstance.getUri()+"/index";
        //4、这个时候开始调用了
        log.error("调用的url是:{}",url);
        log.error("调用的端口是，{}",serviceInstance.getPort());
        return "调用了端口为:"+serviceInstance.getPort()+"的服务，返回结果是:"+this.restTemplate.getForObject(url,String.class);*/

    }
    //使用Ribbon实现负载均衡。
    @GetMapping("/load")
    public String load_index(){
        return "consumer远程调用 provider:"+this.restTemplate.getForObject("http://provider/index",String.class);
    }



}
