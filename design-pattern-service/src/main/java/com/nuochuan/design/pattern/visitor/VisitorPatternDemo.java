package com.nuochuan.design.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 */
public class VisitorPatternDemo {
	
	public static void main(String[] args) {
		Department leafDept1 = new Department("叶子部门1"); 
		Department leafDept2 = new Department("叶子部门2");
		Department leafDept3 = new Department("叶子部门3"); 
		
		Department subDept1 = new Department("子部门1");
		subDept1.getChildren().add(leafDept1);
		subDept1.getChildren().add(leafDept2);
		
		Department subDept2 = new Department("子部门2"); 
		subDept2.getChildren().add(leafDept3);
		
		Department parentDept = new Department("父部门");
		parentDept.getChildren().add(subDept1);
		parentDept.getChildren().add(subDept2);
		
		Visitor removeVisitor = new RemoveVisitor();
		parentDept.accept(removeVisitor);
		
		Visitor updateStatusVisitor = new UpdateStatusVisitor("禁用");  
		parentDept.accept(updateStatusVisitor);
	
		// 访问者模式，一般来说，就是跟组合模式结合起来使用的
		// 组合模式代表了一种复杂的对象的类型
		// 如果你后面要给树形的数据结构增加个什么功能，修改代码可能会比较麻烦
		// 但是如果采用访问者模式来做，你可以在任何时候给树形的数据结构增加任何的功能
	}
	
	public static class Department {
		
		private String name;
		private List<Department> children = new ArrayList<>();
		
		public Department(String name) {
			super();
			this.name = name;
		}
		
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
		
		public void accept(Visitor visitor) {
			visitor.visit(this);
		}
		
	}
	
	public interface Visitor {
		
		void visit(Department dept);
		
	}
	
	public static class RemoveVisitor implements Visitor {

		@Override
		public void visit(Department dept) {
			if(dept.getChildren().size() > 0) {
				for(Department child : dept.getChildren()) {  
					child.accept(this);  
				}
			}
			System.out.println("删除部门【" + dept.getName() + "】");  
		}
		
	}	
	
	public static class UpdateStatusVisitor implements Visitor {
		
		private String status;
		
		@Override
		public void visit(Department dept) {
			if(dept.getChildren().size() > 0) {
				for(Department child : dept.getChildren()) {  
					child.accept(this);  
				}
			}
			System.out.println("将部门【" + dept.getName() + "】的状态修改为：" + status);  
		}
		
		public UpdateStatusVisitor(String status) {
			this.status = status;
		}
		
	}
	
}
