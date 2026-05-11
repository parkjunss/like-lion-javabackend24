package day21;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class GroupingExample {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "IT", 5000),
                new Employee("Bob", "HR", 4000),
                new Employee("Charlie", "IT", 5500),
                new Employee("David", "HR", 4500),
                new Employee("Eve", "Sales", 4800)
        );

        Map<String, List<Employee>> byDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        byDepartment.forEach((key, value) -> System.out.println(key + " : " + value));
        byDepartment.forEach((dept, emps) -> {
            System.out.println(dept + ": " +
                    emps.stream().map(Employee::getName).toList());
        });

        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        avgSalaryByDept.forEach((dept, avg) ->
                System.out.println(dept + ": " + avg));

        Map<String, Map<Boolean, List<String>>> complexGrouping =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.partitioningBy(
                                        employee -> employee.getSalary() > 4500,
                                        Collectors.mapping(Employee::getName, Collectors.toList())
                                )
                        ));

        complexGrouping.forEach((dept, emps) -> {
            System.out.println(dept + ": " + emps);
        });
    }

}
