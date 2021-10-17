package com.nuochuan.design.pattern.facade;

/**
 * 不使用外观模式
 */
public class WithoutFacadePatternDemo {

    public static void main(String[] args) {
        /**
         * 假设系统2要基于系统1的3个模块功能实现一个业务逻辑
         * 问题？
         * 1、对应子系统1来说，维护成本高，因为要关注多个子系统2的模块，如果20个模块，维护成本很高
         * 2、多个模块组成的一个功能，如果子系统1的多个地方都使用到类，那么这段代码就会多个地方有重复
         * 会有非常多的复制粘贴，垃圾代码
         */
        ModuleA moduleA = new ModuleA();
        ModuleB moduleB = new ModuleB();
        ModuleC moduleC = new ModuleC();
        moduleA.execute();
        moduleB.execute();
        moduleC.execute();
    }

    public static class ModuleA {
        public void execute() {
            System.out.println("系统1中的模块功能A");
        }
    }
    public static class ModuleB {
        public void execute() {
            System.out.println("系统1中的模块功能B");
        }
    }
    public static class ModuleC {
        public void execute() {
            System.out.println("系统1中的模块功能C");
        }
    }
}
