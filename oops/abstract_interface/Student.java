package oops.abstract_interface;

public class Student implements StudentInterface {
    private int age;
    private int marks;
    private String name;
    private String collageName;
    private String departmentName;
    private String semesterName;

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCollageName(String collageName) {
        this.collageName = collageName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Override
    public int getAge() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAge'");
    }

    @Override
    public int getMarks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMarks'");
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public String getCollageName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCollageName'");
    }

    @Override
    public String getDepartmentName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDepartmentName'");
    }

    @Override
    public String getSemesterName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSemesterName'");
    }

//     public String collegeName() {
//         return "College Name: " + this.collageName;
//     }

//    public  String departmentName() {
//         return "Department Name: " + this.departmentName;
//     }

//    public  String SemesterName() {
//         return "Semester: " + this.semesterName;
//     }

//     public String toString(){
//         return "Name: "+ this.name+", Age: "+this.age+", Markrs: "+this.marks;
//     }

}
