package com.nuochuan.design.pattern.factory;

public class FactoryPatternDemo {

    public static void main(String[] args) {
        Product product = ProductFactory.create();
        product.excute();
    }

    public interface Product {
        void excute();
    }

    public static class ProductImpl implements Product {
        @Override
        public void excute() {
            System.out.println("产品手机的实现!");
        }
    }

    public static class Product1Impl implements Product {
        @Override
        public void excute() {
            System.out.println("产品手机1的实现!");
        }
    }

    public static class ProductFactory {
        public static Product create() {
            return new ProductImpl();
        }
    }

}
