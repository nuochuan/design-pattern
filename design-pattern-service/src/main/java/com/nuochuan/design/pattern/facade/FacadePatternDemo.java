package com.nuochuan.design.pattern.facade;

/**
 * 外观模式
 */
public class FacadePatternDemo {

    public static void main(String[] args) {
        /**
         * 子系统2
         *
         * 好处1：子系统2不需要关注太多的模块，只要关注一个门面类的接口就可以类
         * 好处2: 如果多个地方都要调用这段逻辑，如果逻辑有变更，只需要在门面类一个地方修改就可以了
         */
        SystemFacade facade = new SystemFacade();
        facade.execute();
    }

    /**
     * 子系统1的门面类
     */
    public static class SystemFacade {
        public void execute() {
            ModuleA moduleA = new ModuleA();
            ModuleB moduleB = new ModuleB();
            ModuleC moduleC = new ModuleC();
            moduleA.execute();
            moduleB.execute();
            moduleC.execute();
            System.out.println("新增的一段逻辑！");
        }
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
