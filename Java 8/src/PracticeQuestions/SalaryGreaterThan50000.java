package PracticeQuestions;


import java.util.Arrays;
import java.util.List;

class Employee {
    private String name;
    private double salary;

    // Constructor
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // To print employee details
    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

public class SalaryGreaterThan50000 {
 /*
        Question: Filter a list of employees whose salary is more than 50,000 using streams.
  */
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Manish", 60000),
                new Employee("Amit", 45000),
                new Employee("Raj", 70000),
                new Employee("Ravi", 40000),
                new Employee("Ankit", 55000)
        );

        employees.stream()
                .filter(x -> x.getSalary() > 50000)
                .forEach(x -> System.out.println("Name: "+x.getName() + " " + "Salary: " + x.getSalary()));
    }

}
