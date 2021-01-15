package com.java.xdh.test;
import org.springframework.web.client.RestTemplate;

/**
 * @author 薛登辉
 * @time 2021/1/14 0014 16:55
 * @description 这是我的代码风格
 */
public class GuanLian {
    public static void main(String[] args) throws InterruptedException {

         RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8015/list";
        for (int i = 0; i < 100; i++) {
            restTemplate.getForObject(url, String.class);
            Thread.sleep(200);
        }

    }
}
