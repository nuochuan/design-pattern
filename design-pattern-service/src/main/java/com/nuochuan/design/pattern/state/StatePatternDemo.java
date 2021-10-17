package com.nuochuan.design.pattern.state;

/**
 * 使用状态模式
 */
public class StatePatternDemo {

    /**
     * 其实状态模式，就是维护多种不同的状态，每种状态下可以去执行一些特殊的逻辑。然后由一个Context类负责根据请求参数调用，来维护这些状态之间的切换，形成一个状态机的概念。
     *
     * 状态模式里，非常重要的一点就是将状态之间流转的逻辑，封装在Context类里面。本来可能需要调用方自己维护复杂的状态流转逻辑，流转到不同的状态之后，执行状态对应的代码逻辑。
     *
     * 这个状态模式，在电商系统中有天然的运用场景，我们的系统中很多数据都有大量的状态变更的逻辑，我们可以将状态变更的逻辑用状态模式来实现，将状态流转封装在一个地方，每次状态变更就通知那个组件，让状态流转，同时执行状态对应的代码逻辑
     *
     */
    public static void main(String[] args) {
        Context context = new Context(new StateNew());
        context.execute(1);
        context.execute(2);
        context.execute(3);
        context.execute(4);
        /*
         * 试用场景：
         * 数据有状态，状态就一定会流转
         * 将不同状态要执行的代码封装到不同的state类中
         * 同时负责执行的那个新状态的代码逻辑
         *
         * 有一个类负责状态之间的扭转，和状态逻辑的执行
         * 对于有状态的场景，按照面向对象设计思想来设计，而不是一堆if else
         */
    }

    public interface State {
        void handle(String parameter);

    }

    public static class StateNew implements State {
        @Override
        public void handle(String parameter) {
            System.out.println(parameter + "执行销售出库单新建状态的逻辑！");
        }

    }

    public static class StateApproveing implements State {
        @Override
        public void handle(String parameter) {
            System.out.println(parameter + "执行销售出库单待审批状态的逻辑！");
        }

    }

    public static class StateApproved implements State {
        @Override
        public void handle(String parameter) {
            System.out.println(parameter + "执行销售出库单已审批状态的逻辑！");
        }

    }

    public static class StateFinish implements State {
        @Override
        public void handle(String parameter) {
            System.out.println(parameter + "执行销售出库单已完成状态的逻辑！");
        }

    }

    public static class Context {

        private State state;

        public void setState(State state) {
            this.state = state;
        }

        public Context(State state) {
            this.state = state;
            this.state.handle("扭转状态！");
        }

        public void execute(int stateType) {
            if (stateType == 1) {
                this.state = new StateNew();
                this.state.handle("销售出库单");
            } else if (stateType == 2) {
                this.state = new StateApproveing();
                this.state.handle("销售出库单");
            } else if (stateType == 3) {
                this.state = new StateFinish();
                this.state.handle("销售出库单");
            } else if (stateType == 4) {
                this.state = new StateFinish();
                this.state.handle("销售出库单");
            }
        }

    }

}
