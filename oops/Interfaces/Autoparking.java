package oops.Interfaces;

public interface Autoparking {
    void autoDrive(String car);

    static void showAutoDriveModel(){
        System.out.println("Auto driving model is :-> Tesla s3");
    }
    
    default void start(){
        System.out.println("Auto driver starting the car...");
    }
}
