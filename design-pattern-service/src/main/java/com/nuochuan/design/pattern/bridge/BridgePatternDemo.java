package com.nuochuan.design.pattern.bridge;

/**
 * 使用桥接模式
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        /*
         * implementor认为一个代码组件，包含了一个接口和一个实现类
         * abstraction也是一个代码组件，包含类一个抽象类和一个子类
         * abstraction包含了implementor的接口
         * abstraction调用implementor的时候，实际上是面向implementor接口去编程和调用的
         * 只不过我们将implementor的实现类实例传入abstraction中
         *
         * abstraction调用implementor就是基于一个桥去调用的
         * 不是说abstraction直接仅仅面向implementor实现类去编程的，面向implementor接口去编程的
         * 所以abstraction和implementor俩个代码之前的桥，就是implementor接口
         * 一个代码组件面向另一个代码组件的接口来编程，就是将那个接口作为一个桥
         */
        Implementor implementor = new ImplementorA();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.execute();
    }

    public interface Implementor {
        void execute();
    }

    public static class ImplementorA implements Implementor {
        @Override
        public void execute() {
            System.out.println("具体的实现");
        }
    }

    public abstract static class Abstraction {

        protected Implementor implementor;

        public Abstraction(Implementor implementor) {
            this.implementor = implementor;
        }

        public abstract void execute();

    }

    public static class RefinedAbstraction extends Abstraction {

        public RefinedAbstraction(Implementor implementor) {
            super(implementor);
        }

        @Override
        public void execute() {
            implementor.execute();
        }
    }

}
