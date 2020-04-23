package com.study.design.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @program: springdemo
 * @description:
 * @author: Mc
 * @date: 2020-04-21 19:30
 **/
@Service
public class OrderService {

    @Autowired
    ApplicationContext applicationContext;

    public void saveOrder() {
        System.out.println("1订单创建");

        OrderEvent event = new OrderEvent("参数");
        applicationContext.publishEvent(event);
    }

    public void test() {
        System.out.println("test");
    }

}
