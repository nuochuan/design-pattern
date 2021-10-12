package com.nuochuan.design.pattern.factory;

public class WithoutFactoryPatternDemo {

    public static void main(String[] args) {
        /**
         * 问题：
         * 面向类编程，new来创建实例，后面会很惨
         * 比如Product类要进行更换一个类，更换一个实现
         * 必须在创建这个实例的地方，都要修改代码，很麻烦
         */
        Product product = new Product("测试产品");
        System.out.println(product);
    }

    public static class Product {
        private String name;

        public Product(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
