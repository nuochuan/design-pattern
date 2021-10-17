package com.nuochuan.design.pattern.singleton;

/**
 * 线程不安全的饱汉模式
 */
public class UnsafeFullSingletonPatternDemo {

    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        singleton.execute();
    }

    public static class Singleton {

        private static Singleton instance;

        public Singleton() {
        }

        public static Singleton getInstance() {
            /**
             * 假设两个线程，线程是并发执行的，cpu
             * 先执行一会线程1，然后停止线程，切换过去执行线程2，执行线程2一会之后，再停止执行线程，回来继续执行线程1
             *
             */
            if(null == instance){
                instance = new Singleton();
            }
            return instance;
        }

        public void execute() {
            System.out.println("线程不安全的饱汉模式！");
        }
    }
}
