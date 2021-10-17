package com.nuochuan.design.pattern.strategy;

/**
 * 不使用策略模式
 */
public class WithoutStrategyPatternDemo {

    public static void main(String[] args) {
        /*
         * 如果这个参数是1，选择一种优化计价的方式
         * 如果这个参数是2，选择一种优化计价的方式
         * 如果这个参数是3，选择一种优化计价的方式
         */
        int discountStyle = 1;

        if(discountStyle == 1){
            System.out.println("执行优惠计价方式1的复杂业务逻辑！");
        }else if(discountStyle == 2){
            System.out.println("执行优惠计价方式2的复杂业务逻辑！");
        }else if(discountStyle == 3){
            System.out.println("执行优惠计价方式3的复杂业务逻辑！");
        }
        /*
         * 用if else 来判断条件很模糊，对这段代码进行变更，简直疯了！
         */
    }

}
