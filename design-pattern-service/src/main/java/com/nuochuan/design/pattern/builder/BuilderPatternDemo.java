package com.nuochuan.design.pattern.builder;

/**
 * 使用构造器模式
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        /**
         * 好处1： 通过builder接口将复杂构建步骤拆分了多个部分，代码逻辑清晰，维护性和扩展性都好
         * 好处2：将对象构建的过着，封装到director里面，director来基于builder进行构建，构建逻辑修改，不需要修改主代码
         * 好处3：相对于工厂，有一个很好的抽象设计，director和builder
         */
        Director director = new Director(new ConcreteBuilder());
        Product product = director.build("内容1","内容2","内容3");
        System.out.println(product);
    }

    public interface Builder {
        void field1(String value);

        void field2(String value);
        void field3(String value);

        Product create();
    }

    public static class ConcreteBuilder implements Builder {
        Product product = new Product();

        @Override
        public void field1(String value) {
            // 设置field1属性
            System.out.println("在设置field1之前进行复杂的校验逻辑！");
            product.setField1(value);
        }

        @Override
        public void field2(String value) {
            // 设置field2属性
            System.out.println("在设置field1之前进行复杂的格式转换逻辑！");
            product.setField2(value);
        }

        @Override
        public void field3(String value) {
            // 设置field3属性
            System.out.println("在设置field1之前进行复杂的数据处理逻辑！");
            product.setField3(value);
        }

        @Override
        public Product create() {
            return product;
        }

    }

    /**
     * Director里面向builder的接口，进行编程的
     * Director可以复杂控制构建的步骤，具体的每个步骤逻辑封装在builder类中
     * 如果我们辞职要更换一整套的构建步骤，可以在搞一个新的builder类就可以了
     * 但是我们的整个构建的步骤是没有任何改变的
     *
     * 如果构建步骤有变化，对构建逻辑无影响
     */
    public static class Director {
        private Builder builder;

        public Director(Builder builder) {
            this.builder = builder;
        }

        public Product build(String field1, String field2, String field3) {
            builder.field1(field1);
            builder.field2(field2);
            builder.field3(field3);
            return builder.create();
        }
    }

    public static class Product {
        private String field1;
        private String field2;
        private String field3;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "field1='" + field1 + '\'' +
                    ", field2='" + field2 + '\'' +
                    ", field3='" + field3 + '\'' +
                    '}';
        }
    }
}
