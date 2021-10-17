package com.nuochuan.design.pattern.composite;

import java.util.LinkedList;
import java.util.List;

/**
 * 不使用组合模式
 */
public class WithoutCompositePatternDemo {

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

        for (Department subDept : parentDept.getChildren()) {
            if (subDept.getChildren().size() > 0) {
                for (Department leadDept : subDept.getChildren()) {
                    leadDept.remove();
                }
                subDept.remove();
            }
        }
        /*
         * 对层级数据的操作很恶心，不方便，需要写大量的代码
         * 嵌套层级非常深
         * 1年后，没人看的懂
         */
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
            System.out.println("删除部门" + getName());
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
