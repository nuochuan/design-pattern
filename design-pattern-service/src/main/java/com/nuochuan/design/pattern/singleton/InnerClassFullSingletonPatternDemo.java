package com.nuochuan.design.pattern.singleton;

/**
 * 完全线程安全的饱汉模式
 * 实际开发过程中，最最最常用的单例模式！
 */
public class InnerClassFullSingletonPatternDemo {

    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        singleton.execute();
    }

    /**
     * 内部类，只要没有使用，就不会初始化，Singleton的实例就不会创建
     * 在第一次有人调用getInstance方法的时候，内部类会初始化，创建一个Singleton的实例
     * Java能确保，JVM类静态初始化的时候只有一次
     */
    public static class Singleton {

        private static Singleton instance;

        public Singleton() {
        }

        public static class InnerHolder{
            private static Singleton instance = new Singleton();

        }

        public static Singleton getInstance() {
            return InnerHolder.instance;
        }

        public void execute() {
            System.out.println("线程安全的饱汉模式！");
        }
    }
}
