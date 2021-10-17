package com.nuochuan.design.pattern.chain;

/**
 * 不使用责任链模式
 */
public class WithoutChainPatternDemo {

    public static void main(String[] args) {
        /**
         * 不使用责任链模式
         * 会出现大量的重复代码，有复制粘贴的现象
         * 如果要对某个功能进行修改，就非常麻烦！
         */

        // 业务流程1
        System.out.println("执行功能1");
        System.out.println("执行功能2");
        System.out.println("执行功能3");

        // 业务流程2
        System.out.println("执行功能2");
        System.out.println("执行功能1");
        System.out.println("执行功能3");
    }
}
