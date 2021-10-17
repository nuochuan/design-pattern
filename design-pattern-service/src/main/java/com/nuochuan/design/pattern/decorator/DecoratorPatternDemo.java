package com.nuochuan.design.pattern.decorator;

/**
 * 使用装饰器模式
 */
public class DecoratorPatternDemo {

    /**
     * 场景
     * （1）假设我们手头已经有了一个类，可以执行一些功能
     * （2）但是我们还是希望对这个类的功能做一些增强，此时怎么办呢？基于已有的类的功能基础之上，再增强一些功能，可以做装饰
     */
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Component decorator = new Decorator(component);
        decorator.execute();
    }

    public interface Component {
        void execute();

    }

    public static class ConcreteComponent implements Component {

        @Override
        public void execute() {
            System.out.println("组件的基础功能");

            // 典型的装饰器模式
           /* try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("流")));
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
    }



    public static class Decorator implements Component {

        protected Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void execute() {
            System.out.println("实现某些动态加强功能");
            component.execute();
            System.out.println("实现某些动态加强功能");
        }
    }
}
