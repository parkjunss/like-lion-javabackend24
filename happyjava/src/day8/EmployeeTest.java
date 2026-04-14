package day8;

public class EmployeeTest {
    static void main(String[] args) {
        Employee employee = new Employee();
//        employee.name; // private은 외부 접근 불가
        employee.salary = 1000; // default 같은 패키지
        employee.department = "what"; // protected 같은 패키지 가능 + 상속받은 자식 클래스는 접속 가능

    }
}
