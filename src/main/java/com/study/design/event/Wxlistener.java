package com.study.design.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: springdemo
 * @description:
 * @author: Mc
 * @date: 2020-04-21 19:41
 **/
@Component
public class Wxlistener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == OrderEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {

        return sourceType == String.class;
    }

    @Override
    public int getOrder() {
        return 10;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("10微信发送成功！");
    }
}
