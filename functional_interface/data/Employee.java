package functional_interface.data;


public class Employee {
    private String name;
    private String dept;
    private long salary;

    public Employee(String name, String dept, long sal){
        this.name = name;
        this.dept = dept;
        this.salary = sal;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for dept
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }

    // Getter and Setter for salary
    public long getSalary() {
        return salary;
    }
    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String toString(){
        return "Name: "+this.name+ ", Deapartment: "+this.dept+", Salary: "+this.salary;
    }
}

