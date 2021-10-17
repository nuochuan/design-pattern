package com.nuochuan.design.pattern.mediator;

/**
 * 使用中介者模式
 */
public class MediatorPatternDemo {

    public static void main(String[] args) {
        /*
         * 好处：
         * 模块A只要知道中介者就可以了，具体交互都封装在中介者里面了
         * 模块B、C同上！
         * 模块A、B、C之间不在有任何的耦合，不再有复杂的交互关系，互相之间修改不会对对方产生影响
         */
        Mediator mediator = new Mediator();
        ModuleA moduleA = new ModuleA(mediator);
        ModuleB moduleB = new ModuleB(mediator);
        ModuleC moduleC = new ModuleC(mediator);
        moduleA.execute();
        moduleB.execute();
        moduleC.execute();
    }

    public static class Mediator {
        private ModuleA moduleA;
        private ModuleB moduleB;
        private ModuleC moduleC;

        public ModuleA getModuleA() {
            return moduleA;
        }

        public void setModuleA(ModuleA moduleA) {
            this.moduleA = moduleA;
        }

        public ModuleB getModuleB() {
            return moduleB;
        }

        public void setModuleB(ModuleB moduleB) {
            this.moduleB = moduleB;
        }

        public ModuleC getModuleC() {
            return moduleC;
        }

        public void setModuleC(ModuleC moduleC) {
            this.moduleC = moduleC;
        }

        public void moduleAInvoke() {
            moduleB.execute("模块A通知中介者！");
            moduleC.execute("模块A通知中介者！");
        }

        public void moduleBInvoke() {
            moduleA.execute("模块B通知中介者！");
            moduleC.execute("模块B通知中介者！");
        }

        public void moduleCInvoke() {
            moduleA.execute("模块C通知中介者！");
            moduleB.execute("模块C通知中介者！");
        }
    }

    public static class ModuleA {

        private Mediator mediator;

        public ModuleA(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleA(this);
        }

        public void execute() {
            mediator.moduleAInvoke();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "调用模块A的功能！");
        }
    }

    public static class ModuleB {

        private Mediator mediator;

        public ModuleB(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleB(this);
        }

        public void execute() {
            mediator.moduleBInvoke();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "调用模块B的功能！");
        }
    }

    public static class ModuleC {
        private Mediator mediator;

        public ModuleC(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleC(this);
        }

        public void execute() {
            mediator.moduleCInvoke();
        }

        public void execute(String invoker) {
            System.out.println(invoker + "调用模块C的功能！");
        }
    }
}
