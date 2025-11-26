package oops.inheritence;

public class Desktop extends Computer {
    public String name = "Rama";
     public void editing(){
        System.out.println("Deskot i am using for editing the videos");
    }

    public void display(){
      System.out.println("This is desktop belong to : "+this.name );
  }
}
