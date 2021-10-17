package com.nuochuan.design.pattern.mediator;

/**
 * 不使用中介者模式
 */
public class WithoutMediatorPatternDemo {

    public static void main(String[] args) {
        /*
         * 模块之前有非常复杂的调用
         * 每个模块都要关心其他的模块，互相之前耦合很严重
         *
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
            ModuleB moduleB = new ModuleB();
            ModuleC moduleC = new ModuleC();
            moduleB.execute("模块A");
            moduleC.execute("模块A");
        }

        public void execute(String invoker) {
            System.out.println(invoker + "调用模块A的功能！");
        }
    }

    public static class ModuleB {
        public void execute() {
            ModuleA moduleA = new ModuleA();
            ModuleC moduleC = new ModuleC();
            moduleA.execute("模块B");
            moduleC.execute("模块B");
        }

        public void execute(String invoker) {
            System.out.println(invoker + "调用模块B的功能！");
        }
    }

    public static class ModuleC {
        public void execute() {
            ModuleA moduleA = new ModuleA();
            ModuleB moduleB = new ModuleB();
            moduleA.execute("模块C");
            moduleB.execute("模块C");
        }

        public void execute(String invoker) {
            System.out.println(invoker + "调用模块C的功能！");
        }
    }
}
