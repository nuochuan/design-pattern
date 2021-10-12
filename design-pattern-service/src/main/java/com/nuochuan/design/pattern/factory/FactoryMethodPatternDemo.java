package com.nuochuan.design.pattern.factory;

public class FactoryMethodPatternDemo {

    public static void main(String[] args) {
        Product product1 = Product1Factory.getInstance().createProduct();
        Product product2 = Product2Factory.getInstance().createProduct();
        Product product3 = Product3Factory.getInstance().createProduct();

        product1.execute();
        product2.execute();
        product3.execute();
    }

    public interface Product {
        void execute();
    }

    public static class Product1 implements Product {

        @Override
        public void execute() {

        }
    }

    public static class Product2 implements Product {

        @Override
        public void execute() {

        }
    }

    public static class Product3 implements Product {

        @Override
        public void execute() {

        }
    }

    public static abstract class AbstractProductFactory {
        public Product createProduct() {
            commonCreate();
            return specificCreate();
        }

        public static void commonCreate() {
            System.out.println("生成通用的手机！修改类！");
        }

        protected abstract Product specificCreate();

    }

    public static class Product1Factory extends AbstractProductFactory {

        private static final Product1Factory instance = new Product1Factory();

        public Product1Factory() {
        }

        public static Product1Factory getInstance() {
            return instance;
        }

        @Override
        protected Product specificCreate() {
            System.out.println("生成特殊的手机1！");
            return new Product1();
        }
    }

    public static class Product2Factory extends AbstractProductFactory {

        private static final Product2Factory instance = new Product2Factory();

        public Product2Factory() {
        }

        public static Product2Factory getInstance() {
            return instance;
        }

        @Override
        protected Product specificCreate() {
            System.out.println("生成特殊的手机2！");
            return new Product2();
        }
    }

    public static class Product3Factory extends AbstractProductFactory {

        private static final Product3Factory instance = new Product3Factory();

        public Product3Factory() {
        }

        public static Product3Factory getInstance() {
            return instance;
        }

        @Override
        protected Product specificCreate() {
            System.out.println("生成特殊的手机3！");
            return new Product3();
        }
    }

}
