package oops.abstract_interface;

abstract class College{
    abstract String collegeName();
    abstract String departmentName();
    abstract String SemesterName();

    public void showCollegeName(String collegeName){
        System.out.println("College Name is: "+ collegeName);
    }
} 