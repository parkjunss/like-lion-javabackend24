package day6;

public class Student {
    private String name;
    private int age;
    private String grade;
    Student (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    public static void main(String[] args) {
        Student student = new Student("홍길동", 20);
        student.setGrade("1학년");
        System.out.println("학생 이름: " + student.getName());
        System.out.println("학생 나이: " + student.getAge());
        System.out.println("학년: " + student.getGrade());

    }
}
