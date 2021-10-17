package com.nuochuan.design.pattern.adapter;

/**
 * 适配器模式
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {
        /**
         * 适配器模式：
         * 有新老两个接口和一个老接口的实现类
         * 但是系统要面向老接口开发，老接口的实现类不能直接用了，不能直接面向老接口开发
         * 此时需要开发一个老接口到新接口的适配器
         * 适配器是实现老新接口的，但是适配器中持有老接口实现类实例的引用
         * 适配器的新接口方法的实现，全部基于老接口实现类的老方法来实现即可
         * 对于调用方而言，只要使用适配器来开发即可，就可以通过面向新接口开发，底层使用老接口实现类
         */
        NewInterface oldObject = new NewInterfaceAdapter(new OldInterfaceImpl());
        NewInterface newObject = new NewInterfaceImpl();
        oldObject.newExecute();
        newObject.newExecute();
    }

    /**
     * 定义一个适配器类
     */
    public static class NewInterfaceAdapter implements NewInterface {

        private final OldInterface oldObject;

        public NewInterfaceAdapter(OldInterface oldObject) {
            this.oldObject = oldObject;
        }

        @Override
        public void newExecute() {
            oldObject.oldExecute();
        }
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
