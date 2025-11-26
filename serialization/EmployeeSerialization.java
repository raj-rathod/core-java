package serialization;

import java.io.Serializable;

public class EmployeeSerialization implements Serializable {
      private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    transient private String password; // this field will not be serialized

    public EmployeeSerialization(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", password=" + password + "]";
    }
}
