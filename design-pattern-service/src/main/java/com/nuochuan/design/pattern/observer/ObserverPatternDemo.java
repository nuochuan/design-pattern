package com.nuochuan.design.pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 使用观察者模式
 * <p>
 * 我们有一个目标对象，一旦这个目标对象的状态改变了，然后的话就去通知相关的对象，我的状态改变了，数据也变化了
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {
        Subject subject = new Subject(0);
        Observer observer = new ConcreteObserver();
        subject.addObserver(observer);

        subject.setState(2);
        subject.setState(5);

    }

    public static class Subject extends Observable {

        private Integer state;

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            // 改变状态
            this.state = state;
            // 通知观察者模式
            this.setChanged();
            // 推模式
            this.notifyObservers(state);
            //拉模式
            this.notifyObservers();
        }

        public Subject(Integer state) {
            this.state = state;
        }
    }

    public static class ConcreteObserver implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            // 推模式
            Integer pushState = (Integer) arg;
            System.out.println("推模式：目标对象的状态变化成:" + pushState);
            // 拉模式
            Subject subject = (Subject) o;
            Integer pullState = subject.getState();
            System.out.println("拉模式：目标对象的状态变化成:" + pullState);
        }
    }

}
