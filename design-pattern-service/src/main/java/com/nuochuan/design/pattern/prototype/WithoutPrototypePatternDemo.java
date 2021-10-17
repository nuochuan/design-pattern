package com.nuochuan.design.pattern.prototype;

/**
 * 不使用原型模式
 * <p>
 * 场景，如果一个对象，我们希望拷贝一个这个对象，就是弄出来这个类的另外一个实例，实例的属性跟之前的实例是一模一样的
 * <p>
 * 我们要用原型模式，以某一个对象为原型，然后对这个对象进行拷贝，得到拷贝后的另外一个对象
 */
public class WithoutPrototypePatternDemo {

    public static void main(String[] args) {
        Product product = new Product("测试产品", new Component("测试组件"));
        // 手动copy
        Product copyProduct = new Product(product.getName(), product.getComponent());
        System.out.println(copyProduct);

        /**
         * 问题：
         * 代码动拷贝逻辑，是每个要拷贝动调用方自己来实现
         * 相同的拷贝逻辑会分散很多不同的地方，如果拷贝逻辑改变，多个调用的地方都要修改代码
         * 可维护性，可扩展性很差
         */
    }

    public static class Component {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Component(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Compent{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


    public static class Product {
        private String name;
        private Component component;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Component getComponent() {
            return component;
        }

        public void setComponent(Component component) {
            this.component = component;
        }

        public Product(String name, Component component) {
            this.name = name;
            this.component = component;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", component=" + component +
                    '}';
        }
    }

}
