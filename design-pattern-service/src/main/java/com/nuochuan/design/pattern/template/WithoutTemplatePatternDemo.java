package com.nuochuan.design.pattern.template;

public class WithoutTemplatePatternDemo {
    public static void main(String[] args) {
        /**
         * 问题：
         * 通用计算模式，需要修改三个地方
         */
        DiscountCalculator1 calculator1 = new DiscountCalculator1();
        calculator1.calculate();

        DiscountCalculator2 calculator2 = new DiscountCalculator2();
        calculator2.calculate();

        DiscountCalculator3 calculator3 = new DiscountCalculator3();
        calculator3.calculate();
    }

    public static class DiscountCalculator1 {
        public void calculate() {
            System.out.println("通用的计算模式！");
            System.out.println("第一种计算模式！");
        }
    }

    public static class DiscountCalculator2 {
        public void calculate() {
            System.out.println("通用的计算模式！");
            System.out.println("第二种计算模式！");
        }
    }

    public static class DiscountCalculator3 {
        public void calculate() {
            System.out.println("通用的计算模式！");
            System.out.println("第三种计算模式！");
        }
    }
}
