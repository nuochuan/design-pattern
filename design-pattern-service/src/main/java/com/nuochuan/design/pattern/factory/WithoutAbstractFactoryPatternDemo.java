package com.nuochuan.design.pattern.factory;

public class WithoutAbstractFactoryPatternDemo {

    public static void main(String[] args) {
        Product product1 = Product1Factory.createProduct();
        Product product2 = Product2Factory.createProduct();
        Product product3 = Product3Factory.createProduct();

        /**
         * 创建不同的组合
         * 例如 产品1+产品3   产品2+产品3
         */
    }

    public interface Product {
        void exxcute();
    }

    public static class Product1 implements Product {

        @Override
        public void exxcute() {

        }
    }

    public static class Product2 implements Product {

        @Override
        public void exxcute() {

        }
    }

    public static class Product3 implements Product {

        @Override
        public void exxcute() {

        }
    }

    public static class Product1Factory {
        public static Product createProduct() {
            System.out.println("生成通用的手机！修改！");
            System.out.println("生成特殊的手机1！");
            return new Product1();
        }
    }

    public static class Product2Factory {
        public static Product createProduct() {
            System.out.println("生成通用的手机！");
            System.out.println("生成特殊的手机2！");
            return new Product2();
        }
    }

    public static class Product3Factory {
        public static Product createProduct() {
            System.out.println("生成通用的手机！");
            System.out.println("生成特殊的手机3！");
            return new Product3();
        }
    }

}
