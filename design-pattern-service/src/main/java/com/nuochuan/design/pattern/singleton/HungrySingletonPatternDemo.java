package com.nuochuan.design.pattern.singleton;

/**
 * 饿汉单例模式
 */
public class HungrySingletonPatternDemo {

    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        singleton.execute();
    }

    /**
     * 第一步：直接将这个类的实例在创建出来，赋予static final 修饰的变量
     * <p>
     * static 静态变量
     * final 这个变量的引用第一次初始化赋值之后，就再也不能修改引用了
     */
    public static class Singleton {
        private static final Singleton instance = new Singleton();

        /**
         * 第二步：
         * 将构造函数搞成private私有的
         * 此时除了这个类自己本身，其他任何人都不能够创建这个实例对象
         */
        public Singleton() {
        }

        /**
         * 第三步：
         * 给一个static静态方法，返回自己唯一的内部创建的一个实例
         *
         * @return Singleton
         */
        public static Singleton getInstance() {
            return instance;
        }

        public void execute() {
            System.out.println("饿汉模式！");
        }
    }
}
