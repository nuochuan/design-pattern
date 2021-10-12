package com.nuochuan.design.pattern.factory;

public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {

        // 产品A1 + 产品B1
        ProductA productA1 = FactoryImpl1.getInstance().createProductA();
        ProductB productB1 = FactoryImpl1.getInstance().createProductB();
        productA1.operate();
        productB1.operate();

        // 产品A2 + 产品B2
        ProductA productA2 = FactoryImpl2.getInstance().createProductA();
        ProductB productB2 = FactoryImpl2.getInstance().createProductB();
        productA1.operate();
        productB1.operate();
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


    public interface ProductA {

        void operate();

    }

    public interface ProductB {

        void operate();

    }

    public static class ProductAImpl1 implements ProductA {

        @Override
        public void operate() {
            System.out.println("产品A的实现1的功能执行");
        }

    }

    public static class ProductBImpl1 implements ProductB {

        @Override
        public void operate() {
            System.out.println("产品B的实现1的功能执行");
        }

    }

    public static class ProductAImpl2 implements ProductA {

        @Override
        public void operate() {
            System.out.println("产品A的实现2的功能执行");
        }

    }

    public class ProudctBImpl2 implements ProductB {

        @Override
        public void operate() {
            System.out.println("产品B的实现2的功能执行");
        }

    }

    public interface AbstractFactory {

        ProductA createProductA();

        ProductB createProductB();

    }

    public static class FactoryImpl1 implements AbstractFactory {
        /**
         * 变成单例模式
         */
        private static final FactoryImpl1 instance = new FactoryImpl1();

        public static FactoryImpl1 getInstance() {
            return instance;
        }

        public FactoryImpl1() {
        }

        @Override
        public ProductA createProductA() {
            return new ProductAImpl1();
        }

        @Override
        public ProductB createProductB() {
            return new ProductBImpl1();
        }

    }

    public static class FactoryImpl2 implements AbstractFactory {
        /**
         * 变成单例模式
         */
        private static final FactoryImpl2 instance = new FactoryImpl2();

        public static FactoryImpl2 getInstance() {
            return instance;
        }

        public FactoryImpl2() {
        }

        @Override
        public ProductA createProductA() {
            return new ProductAImpl2();
        }

        @Override
        public ProductB createProductB() {
            return new ProductBImpl1();
        }

    }
}
