package oops.inheritence;

public class Laptop extends Computer {
    public String name = "Raghav";
    public void coding(){
        System.out.println("Laptop I am using for coding..");
    }

    public void display(){
      System.out.println("This is laptop belong to : "+this.name );
  }
}
