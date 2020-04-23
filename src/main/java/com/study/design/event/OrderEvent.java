package com.study.design.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Mc
 * @date 2020-04-21 19:26
 **/
public class OrderEvent extends ApplicationEvent {


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public OrderEvent(Object source) {
        super(source);
    }
}
