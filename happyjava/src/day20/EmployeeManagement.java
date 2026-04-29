package day20;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private int salary;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // getter 메소드들
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public int getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("%s (%s) - %d원", name, department, salary);
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("김철수", "개발팀", 5000000),
                new Employee("이영희", "마케팅팀", 4500000),
                new Employee("박민수", "개발팀", 5500000),
                new Employee("정수진", "인사팀", 4000000),
                new Employee("최영수", "개발팀", 6000000)
        );

        // 1. 부서별 평균 급여 계산
        HashMap<String, Integer> totalSalaries = new HashMap<>();
        HashMap<String, Integer> counts = new HashMap<>();

        for (Employee employee : employees) {
            String dept = employee.getDepartment();
            int salary = employee.getSalary();

            totalSalaries.put(dept, totalSalaries.getOrDefault(dept, 0) + salary);
            counts.put(dept, counts.getOrDefault(dept, 0) + 1);
        }

        for (String dept : totalSalaries.keySet()) {
            double average = (double) totalSalaries.get(dept) / counts.get(dept);
            System.out.println(dept + " Avg Salary: " + average);
        }

        // 2. 급여가 500만원 이상인 개발팀 직원 찾기
        for (Employee employee : employees) {
            String dept = employee.getDepartment();
            int salary = employee.getSalary();

            if(dept.equals("개발팀") && salary >= 5000000) {
                System.out.println(employee);
            }
        }

        // 3. 전체 직원을 급여 순으로 정렬
        System.out.println("sort===========");

        int n = employees.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (employees.get(j).getSalary() < employees.get(j + 1).getSalary()) {
                    Employee temp = employees.get(j);
                    employees.set(j, employees.get(j + 1));
                    employees.set(j + 1, temp);
                }
            }
        }
        System.out.println(employees);

        // 4. 가장 높은 급여 찾기
        int topSalary = 0;
        for (Employee employee : employees) {
            if(employee.getSalary() > topSalary) {
                topSalary = employee.getSalary();
            }
        }
        System.out.println("\n최고 급여: " + topSalary + "원");


//
//        // 1. 부서별 평균 급여 계산
//        Map<String, Double> avgSalaryByDept = employees.stream()
//                .collect(Collectors.groupingBy(
//                        Employee::getDepartment,
//                        Collectors.averagingInt(Employee::getSalary)
//                ));
//
//        System.out.println("=== 부서별 평균 급여 ===");
//        avgSalaryByDept.forEach((dept, avgSalary) ->
//                System.out.printf("%s: %.0f원%n", dept, avgSalary));
//
//        // 2. 급여가 500만원 이상인 개발팀 직원 찾기
//        System.out.println("\n=== 급여 500만원 이상 개발팀 직원 ===");
//        employees.stream()
//                .filter(emp -> emp.getDepartment().equals("개발팀"))
//                .filter(emp -> emp.getSalary() >= 5000000)
//                .forEach(System.out::println);
//
//        // 3. 전체 직원을 급여 순으로 정렬
//        System.out.println("\n=== 급여 순 정렬 (내림차순) ===");
//        employees.stream()
//                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
//                .forEach(System.out::println);
//
//        // 4. 가장 높은 급여 찾기
//        Optional<Integer> maxSalary = employees.stream()
//                .map(Employee::getSalary)
//                .max(Integer::compareTo);
//
//        maxSalary.ifPresent(salary ->
//                System.out.println("\n최고 급여: " + salary + "원"));
    }
}