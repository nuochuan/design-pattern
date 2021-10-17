package com.nuochuan.design.pattern.prototype;

/**
 * 不使用原型模式
 * <p>
 * 场景，如果一个对象，我们希望拷贝一个这个对象，就是弄出来这个类的另外一个实例，实例的属性跟之前的实例是一模一样的
 * <p>
 * 我们要用原型模式，以某一个对象为原型，然后对这个对象进行拷贝，得到拷贝后的另外一个对象
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        /**
         * 原型模式：就是在要拷贝的类里面实现一个clone()方法，自己拷贝自己
         * 注意浅拷贝和深拷贝
         */
        Product product = new Product("原型模式产品", new Component("原型模式组件"));
        try {
            // 手动copy
            Product copyProduct = product.clone();
            System.out.println(copyProduct);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
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

        @Override
        protected Component clone() throws CloneNotSupportedException {
            return new Component(getName());
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

        @Override
        protected Product clone() throws CloneNotSupportedException {
            return new Product(getName(),getComponent().clone());
        }
    }

}
