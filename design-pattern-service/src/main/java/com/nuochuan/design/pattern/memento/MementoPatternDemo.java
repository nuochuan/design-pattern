package com.nuochuan.design.pattern.memento;

/**
 * 使用备忘录模式
 */
public class MementoPatternDemo {
    /**
     * 场景
     * <p>
     * （1）类，计算出来一份中间数据
     * （2）这个类，之后需要基于这份中间数据再执行另外两次操作，每次操作都要基于这份中间数据去执行
     * （3）第一次基于中间数据操作过后，会对中间数据做出修改
     * （4）要求是第二次再执行操作的时候，需要基于未修改之前的中间数据来执行
     */
    public static void main(String[] args) {
        Originator originator = new Originator();

        // 准备好了中间数据
        originator.prepare();
        // 将中间数据保存到备忘录中去
        Memento memento = originator.createMemento();
        // 将备忘录保存到备忘录管理器中去
        Caretaker caretaker = new Caretaker();
        caretaker.saveMemento(memento);
        // 基于中间数据执行了A方法，但是此时中间数据已经改变了
        originator.executeA();
        // 从备忘录管理器中获取备忘录
        memento = caretaker.retriveMemento();
        // 将备忘录中保存好的中间数据重新设置到原发器中去，就将中间数据恢复成了之前备忘的状态
        originator.setMemento(memento);
        // 接着再次执行方法B
        originator.executeB();

    }

    public interface Memento {

    }

    public static class Originator {

        private String state;

        public void prepare() {
            this.state = "中间数据";
        }

        public void executeA() {
            System.out.println("基于中间数据【" + state + "】进行了A方法的执行");
            state += "，A方法的结果数据";
        }

        public void executeB() {
            System.out.println("基于中间数据【" + state + "】进行了B方法的执行");
            state += "，B方法的结果数据";
        }

        public Memento createMemento() {
            return new MementoImpl(state);
        }

        public void setMemento(Memento memento) {
            MementoImpl mementoImpl = (MementoImpl) memento;
            this.state = mementoImpl.getState();
        }

        private static class MementoImpl implements Memento {

            private String state;

            public MementoImpl(String state) {
                this.state = state;
            }

            public String getState() {
                return state;
            }

        }

    }

    public static class Caretaker {

        private Memento memento;

        public void saveMemento(Memento memento) {
            this.memento = memento;
        }

        public Memento retriveMemento() {
            return this.memento;
        }

    }

}
