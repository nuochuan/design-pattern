package com.nuochuan.design.pattern.chain;

/**
 * 使用责任链模式
 */
public class ChainPatternDemo {

    /**
     * 责任链模式，那也是经常会使用到的，对于那种复杂的业务流程，一种方案是采取面向对象的设计，将不同的业务逻辑封装到不同的类里去，
     * 然后通通过方法中的调用来控制业务流向；另外一种就是采用责任链模式，将业务逻辑封装到不同的handler里面去，形成链条式调用。
     *
     * 什么时候用责任链模式呢？很简单，就是如果你需要动态组装一个业务流程出来，流程中的每个handler业务逻辑需要复用，那就用责任链模式。
     */
    public static void main(String[] args) {
        // 业务流程1
        Handler thirdHandler1  = new ConcreteHandler3(null);
        Handler secondHandler1 = new ConcreteHandler2(thirdHandler1);
        Handler firstHandler1 = new ConcreteHandler1(secondHandler1);
        firstHandler1.handleRequest();

        // 业务流程2
        Handler thirdHandler2  = new ConcreteHandler1(null);
        Handler secondHandler2 = new ConcreteHandler2(thirdHandler2);
        Handler firstHandler2 = new ConcreteHandler3(secondHandler2);
        firstHandler2.handleRequest();
    }

    public abstract static class Handler {

        protected Handler successor;

        public void setSuccessor(Handler successor) {
            this.successor = successor;
        }

        public abstract void handleRequest();

    }

    public static class ConcreteHandler1 extends Handler {
        public ConcreteHandler1(Handler successor) {
            setSuccessor(successor);
        }

        @Override
        public void handleRequest() {
            System.out.println("ConcreteHandler1实现代码");
            if (successor != null) {
                successor.handleRequest();
            }
        }
    }

    public static class ConcreteHandler2 extends Handler {
        public ConcreteHandler2(Handler successor) {
            setSuccessor(successor);
        }

        @Override
        public void handleRequest() {
            System.out.println("ConcreteHandler2实现代码");
            if (successor != null) {
                successor.handleRequest();
            }
        }
    }

    public static class ConcreteHandler3 extends Handler {
        public ConcreteHandler3(Handler successor) {
            setSuccessor(successor);
        }
        @Override
        public void handleRequest() {
            System.out.println("ConcreteHandler3实现代码");
            if (successor != null) {
                successor.handleRequest();
            }
        }
    }
}
