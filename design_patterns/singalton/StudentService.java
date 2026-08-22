package design_patterns.singalton;

public class StudentService {
    private static volatile StudentService instance;
    public int x = 0;

    private StudentService(){}

    public static StudentService getInstance() {
        if(instance == null){
            synchronized (StudentService.class){
                if(instance == null){
                    instance = new StudentService();
                }
            }
        }

        return instance;
    } 
}
