package Comparable;

public class Employee implements Comparable<Employee>{

    private int employeeId;

    private String name;

    public Employee(int employeeId, String name){
        this.employeeId = employeeId;
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        // return Double.compare(o.getGpa - this.getGpa());
//        return o.getName().compareTo(this.getName()); // decreasing order
        return this.getName().compareTo(o.getName());   // increasing order
    }
}
