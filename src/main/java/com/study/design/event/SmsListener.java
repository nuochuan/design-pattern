package com.study.design.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @program: springdemo
 * @description:
 * @author: Mc
 * @date: 2020-04-21 19:28
 **/
@Component
public class SmsListener implements SmartApplicationListener  {

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        System.out.println("20发送短信成功");
    }

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
        return 20;
    }

}
