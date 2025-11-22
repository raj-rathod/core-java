package oops.abstract_interface;

public interface StudentInterface {
    int  MIN_MARKS = 325; // by default it is public static final;
    void setAge(int age);
    int getAge();

    void setMarks(int marks);
    int getMarks();

    void setName(String name);
    String getName();

    void setCollageName(String collageName);
    String getCollageName();

    void setDepartmentName(String departmentName);
    String getDepartmentName();

    void setSemesterName(String semesterName);
    String getSemesterName();

    default void showStudentRule(){
        System.out.println("Passing marks should be greater than:"+ StudentInterface.MIN_MARKS);
    }

    static void showStudentPassingMarks(){
         System.out.println(" Student passing marks are: "+ StudentInterface.MIN_MARKS);
    }
}
