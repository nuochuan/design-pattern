package com.nuochuan.design.pattern.composite;

import java.util.LinkedList;
import java.util.List;

/**
 * 使用组合模式
 * <p>
 * 场景：
 * （1）父部门->子部门->子部门
 * （2）我们要对部门树，删除一个父部门以及其下所有的子部门
 */
public class CompositePatternDemo {

    /**
     * 组合模式：
     * 将树形结构的数据，用一个类至二个类，就可以拼装成一棵树的形状
     * 直接对一个父级的数据执行某个操作，这个操作会直接递归调用所有的操作
     * 完美执行自己递归自己的方式
     * 好处：
     * 对树形的数据操作，不需要调用复杂的for代码执行
     * 外部只要操作一棵树，直接对树的父级节点调用，这颗树自己递归
     */
    public static void main(String[] args) {
        // 叶子部门
        Department leadDept1 = new Department("叶子部门1");
        Department leadDept2 = new Department("叶子部门2");
        Department leadDept3 = new Department("叶子部门3");

        // 子部门
        Department subDept1 = new Department("子部门1");
        subDept1.getChildren().add(leadDept1);
        subDept1.getChildren().add(leadDept2);
        Department subDept2 = new Department("子部门2");
        subDept2.getChildren().add(leadDept3);

        // 父部门
        Department parentDept = new Department("父部门");
        parentDept.getChildren().add(subDept1);
        parentDept.getChildren().add(subDept2);

        parentDept.remove();
    }

    public static class Department {
        private String name;
        private List<Department> children = new LinkedList<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Department> getChildren() {
            return children;
        }

        public void setChildren(List<Department> children) {
            this.children = children;
        }

        public Department(String name) {
            this.name = name;
        }

        public void remove() {
            if(children.size() > 0){
                for (Department child : children) {
                    child.remove();
                }
            }
            System.out.println("删除部门【" + getName()+"】");
        }

        @Override
        public String toString() {
            return "Department{" +
                    "name='" + name + '\'' +
                    ", children=" + children +
                    '}';
        }
    }
}
