package com.nuochuan.design.pattern.singleton;

/**
 * 线程安全的饱汉模式
 */
public class SafeFullSingletonPatternDemo {

    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        singleton.execute();
    }

    public static class Singleton {

        private static Singleton instance;

        public Singleton() {
        }

        public static Singleton getInstance() {
            if (null == instance) {
                synchronized (SafeFullSingletonPatternDemo.class) {
                    if (null == instance) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }

        public void execute() {
            System.out.println("线程安全的饱汉模式！");
        }
    }
}
