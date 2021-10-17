package com.nuochuan.design.pattern.command;

/**
 * 使用命令模式
 */
public class CommandPatternDemo {
    public static void main(String[] args) {
        CommandA commandA = new CommandA();
        CommandB commandB = new CommandB();

        Invoker invoker = new Invoker();
        invoker.setCommand(commandA);
        invoker.execute();

        invoker.setCommand(commandB);
        invoker.execute();

        /*
         * 缓存架构
         * 读请求&写请求
         * 命令模式：将读请求的功能逻辑封装到ReadCommand里面，将写请求封装到WriteCommand里面
         * 然后设置一个通用的命令执行类
         * 读请求了，就封装ReadCommand，交给命令执行类
         * 写请求了，就封装WriteCommand，交给命令执行类来执行即可
         *
         * 采用模式的思想，去设计好代码
         * 从面向对象设计的角度来考虑
         * 如果没有设计，一年以后，系统的代码没人能看懂
         * 反过来说，按照设计模式体现出优秀的面向对象设计思想，来规划你的代码设计，N年后照样可以扩展
         *
         * 构造器模式：builder 也可以用工厂模式，但是builder更舒服！
         */
    }

    public interface Command {

        void execute();

    }

    public static class CommandA implements Command {

        @Override
        public void execute() {
            System.out.println("命令A的逻辑");
        }

    }

    public static class CommandB implements Command {

        @Override
        public void execute() {
            System.out.println("命令B的逻辑");
        }

    }

    public static class Invoker {

        private Command command;

        public Command getCommand() {
            return command;
        }

        public void setCommand(Command command) {
            this.command = command;
        }

        public Invoker() {
        }

        public Invoker(Command command) {
            this.command = command;
        }

        public void execute() {
            System.out.println("方法的前置逻辑！");
            command.execute();
            System.out.println("方法的后置逻辑！");
        }

    }


}
