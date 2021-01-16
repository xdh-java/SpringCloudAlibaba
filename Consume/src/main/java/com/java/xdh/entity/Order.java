package com.java.xdh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 薛登辉
 * @time 2021/1/16 0016 21:05
 * @description 这是我的代码风格
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private String buyerName;
    private String buyerTel;
    private String address;
    private Date createDate;

}
