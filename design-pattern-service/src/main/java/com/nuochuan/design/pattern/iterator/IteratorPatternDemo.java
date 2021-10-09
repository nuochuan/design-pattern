package com.nuochuan.design.pattern.iterator;

public class IteratorPatternDemo {

    public static void main(String[] args) {
        Student student1 = new Student("小赖");
        Student student2 = new Student("小唐");

        Classroom classroom = new Classroom(2);
        classroom.addStudent(student1);
        classroom.addStudent(student2);

        Iterator iterator = classroom.iterator();
        while (iterator.hasNext()){
            Student student = (Student)iterator.next();
            System.out.println(student.getName());
        }
    }


    /**
     * 代表一个集合类
     */
    public interface Aggregate {
        public abstract Iterator iterator();
    }

    /**
     * 定义一个我们自己的迭代器接口
     */
    public interface Iterator {

        public abstract boolean hasNext();

        public abstract Object next();
    }

    public static class Student {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(String name) {
            this.name = name;
        }
    }


    /**
     * 教室类
     */
    public static class Classroom implements Aggregate {

        private final Student[] students;
        /**
         * 数组的长度
         */
        private int last = 0;

        public Classroom(int size) {
            this.students = new Student[size];
        }

        public Student getStudent(int index) {
            return students[index];
        }

        public void addStudent(Student student) {
            this.students[last] = student;
            last++;
        }

        public int getLength() {
            return last;
        }

        /**
         * 返回一个教室迭代器，封装了自己，让迭代器可以获取呀教室中的数据
         * @return Iterator
         */
        @Override
        public Iterator iterator() {
            return new ClassroomIterator(this);
        }

    }


    public static class ClassroomIterator implements Iterator {

        private Classroom classroom;
        private int index;

        public ClassroomIterator(Classroom classroom) {
            this.classroom = classroom;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            if (index < classroom.getLength()) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * 从数组中获取当前这个学生，同时将index往下移动一位
         * 比如一开始index是0，然后数组长度是2
         * 此时便利获取类第一个学生之后，返回的数组为0的元素，然后将index变为1
         * @return Object
         */
        @Override
        public Object next() {
            Student student = classroom.getStudent(index);
            index++;
            return student;
        }

    }

}
