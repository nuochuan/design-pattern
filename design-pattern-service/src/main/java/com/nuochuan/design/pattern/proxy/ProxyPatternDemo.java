package com.nuochuan.design.pattern.proxy;

/**
 * 使用代理模式
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Proxy proxy = new Proxy(subject);
        proxy.request();
    }

    public interface Subject {

        void request();

    }

    public static class ConcreteSubject implements Subject {

        @Override
        public void request() {
            System.out.println("执行功能");
        }

    }

    public static class Proxy implements Subject {

        private Subject subject;

        public Proxy(Subject subject) {
            this.subject = subject;
        }

        @Override
        public void request() {
            System.out.println("执行额外的条件判断，考虑是否要调用request()方法！");
            boolean invoke = true;
            if (invoke) {
                subject.request();
            }
        }

    }

}
