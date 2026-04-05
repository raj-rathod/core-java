package oops.classes_object;

public class Employee {

    private int id;
    public String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName(){
        return this.name;
    }

    public Double getSalary(){
        return this.salary;
    }

    public String getDeparment(){
        return this.department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
