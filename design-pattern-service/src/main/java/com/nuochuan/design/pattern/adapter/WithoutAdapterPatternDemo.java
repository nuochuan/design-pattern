package com.nuochuan.design.pattern.adapter;

public class WithoutAdapterPatternDemo {

    public static void main(String[] args) {
        /**
         * 如果不用任何设计模式
         * 问题是，新代码中，融合的新老两套接口，非常麻烦
         * 如果硬这么写，面向是规范和风格不同的两套接口，理解和维护的成本提高了
         * 如果强制按规范走，老版本的实现类没有版本使用
         */
        OldInterface oldObject = new OldInterfaceImpl();
        NewInterface newObject = new NewInterfaceImpl();
        oldObject.oldExecute();
        newObject.newExecute();
    }

    /**
     * 老版本接口
     */
    public interface OldInterface {
        void oldExecute();
    }

    /**
     * 老版本实现类
     */
    public static class OldInterfaceImpl implements OldInterface {

        @Override
        public void oldExecute() {
            System.out.println("老版本接口实现的功能逻辑！");
        }
    }

    /**
     * 新版本接口
     */
    public interface NewInterface {
        void newExecute();
    }

    /**
     * 新版本实现类
     */
    public static class NewInterfaceImpl implements NewInterface {

        @Override
        public void newExecute() {
            System.out.println("新版本接口实现的功能逻辑！");
        }
    }


}
