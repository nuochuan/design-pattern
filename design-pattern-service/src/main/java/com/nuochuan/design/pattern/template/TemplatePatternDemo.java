package com.nuochuan.design.pattern.template;

/**
 * 模板模式
 */
public class TemplatePatternDemo {

    public static void main(String[] args) {
        DiscountCalculator1 calculator1 = new DiscountCalculator1();
        calculator1.calculate();

        DiscountCalculator2 calculator2 = new DiscountCalculator2();
        calculator2.calculate();

        DiscountCalculator3 calculator3 = new DiscountCalculator3();
        calculator3.calculate();
    }

    public interface DiscountCalculator {
        void calculate();
    }

    /**
     * 模版方法实现的精华
     */
    public static abstract class AbstractDiscountCalculator implements DiscountCalculator {

        @Override
        public void calculate() {
            commonCalculate();
            specificCalculate();
        }

        private void commonCalculate() {
            System.out.println("通用的计算模式！袖个挂！");
        }

        protected abstract void specificCalculate();
    }


    public static class DiscountCalculator1 extends AbstractDiscountCalculator {
        @Override
        protected void specificCalculate() {
            System.out.println("第一种计算模式！");
        }
    }

    public static class DiscountCalculator2 extends AbstractDiscountCalculator {
        @Override
        protected void specificCalculate() {
            System.out.println("第二种计算模式！");
        }
    }

    public static class DiscountCalculator3 extends AbstractDiscountCalculator {
        @Override
        protected void specificCalculate() {
            System.out.println("第三种计算模式！");
        }
    }


}
