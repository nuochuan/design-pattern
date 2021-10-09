package com.nuochuan.design.pattern.adapter;

public class AdapterPatternDemo {

    public class Adaptee {

        public void specificRequest() {
            System.out.println("老的方法实现");
        }

    }

    public interface Target {

        void request();

    }

    public class Adapter implements Target {

        private Adaptee adaptee;

        public Adapter(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void request() {
            //            adaptee.spcificRequest();

        }

    }


}
