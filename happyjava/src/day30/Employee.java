package day30;

class CalculatePayment {
    private double payment = 0;

    public CalculatePayment(Employee employee) {
        this.payment = employee.getSalary();
    }

    public double bonus(Employee employee) {
        if (employee.getName().equals("John")) {
            return payment * 0.1;
        }
        return payment * 0;
    }

    public double getPayment() {
        return payment;
    }
}

class DataSave {
    private Employee employee;
    public DataSave(Employee employee) {
        this.employee = employee;
    }

    public void saveEmployee(Employee employee) {
        System.out.println("Saving employee " + employee.getName());
    }

}


public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}