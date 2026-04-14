package day9.hw2.problem1;

public class Student {
    private final String name;
    private int age;
    private final int studentID;
    private double gpa;

    // 기본 생성자 age 기본 18 gpa 기본 0.0
    public Student(String name, int studentID) {
        this(name, studentID, 18, 0.0);
    }

    // 추가 정보 입력시 생성자
    public Student(String name, int studentID, int age, double gpa) {
        this.name = name;
        this.studentID = studentID;
        this.age = age;
        this.gpa = gpa;
    }

    // 나이 업데이트
    public void updateAge(int age) {
        if (age < 15 || age > 100) {
            System.out.println("Age must be between 15 and 100");

        } else {
            this.age = age;
        }
    }
    // gpa 업데이트
    public void updateGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            System.out.println("GPA must be between 0.0 and 4.0");
        } else {
            this.gpa = gpa;
        }
    }

    // 정보 출력
    public void displayInfo(){
        System.out.println("Name: " + this.getName());
        System.out.println("Student ID: " + this.getStudentID());
        System.out.println("Age: " + this.getAge());
        System.out.println("GPA: " + this.getGpa());
    }

    // 상위 성적 여부
    public boolean isExcellent(){
        return this.gpa >= 3.5;
    }

    // 이름 가져오기
    public String getName(){
        return this.name;
    }
    // 학번 가져오기
    public int getStudentID(){
        return this.studentID;
    }
    // 나이 가져오기
    public int getAge(){
        return this.age;
    }
    // gpa 가져오기
    public double getGpa(){
        return this.gpa;
    }

}
