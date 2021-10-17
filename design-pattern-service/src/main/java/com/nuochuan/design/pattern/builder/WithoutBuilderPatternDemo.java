package com.nuochuan.design.pattern.builder;

/**
 * 不使用构造器模式
 */
public class WithoutBuilderPatternDemo {

    public static void main(String[] args) {
        Product product = new Product();

        // 设置field1属性
        System.out.println("在设置field1之前进行复杂的校验逻辑！");
        product.setField1("值1");
        // 设置field2属性
        System.out.println("在设置field1之前进行复杂的格式转换逻辑！");
        product.setField2("值2");
        // 设置field3属性
        System.out.println("在设置field1之前进行复杂的数据处理逻辑！");
        product.setField3("值3");

        System.out.println(product);

        /**
         * 如果上面的代码极度膨胀，非常复杂
         * 大量的代码堆积在一起，维护性非常差，可读性非常差
         * 如果这段逻辑，在很多个地方使用的话，一旦逻辑出现了变化，那么可能需要在多个地方改同一段代码
         * 把不同的构造步骤，抽取成一个单独的方法
         */

    }
    public static class Product{
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
