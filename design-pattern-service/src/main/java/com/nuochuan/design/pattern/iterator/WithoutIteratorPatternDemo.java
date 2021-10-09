package com.nuochuan.design.pattern.iterator;

public class WithoutIteratorPatternDemo {

    public static void main(String[] args) {
        Student student1 = new Student("小赖");
        Student student2 = new Student("小唐");

        Student[] students = new Student[2];
        students[0] = student1;
        students[1] = student2;

        Classroom classroom = new Classroom();
        classroom.setStudents(students);

        Student[] resultStudents = classroom.getStudents();

        for (Student resultStudent : resultStudents) {
            System.out.println(resultStudent.getName());
        }
    }

    /**
     * 学生类
     */
    private static class Student {
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
     * 教师类
     */
    private static class Classroom {
        private Student[] students;

        public Student[] getStudents() {
            return students;
        }

        public void setStudents(Student[] students) {
            this.students = students;
        }
    }

}