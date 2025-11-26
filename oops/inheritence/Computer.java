package oops.inheritence;

abstract class InnerComputer {
    abstract void showCpu();
    abstract void showRam(int ram);
    abstract void showStorage(int hdd);
}

public class Computer extends InnerComputer {
     public String name = "Rajesh";
     public void showCpu() {
      System.out.println("Computer cpu");
    }

    public void showRam(int ram) {
      System.out.println("Ram is : "+ ram +"GB");
    }

   public  void showStorage(int hdd) {
      System.out.println("Storaeg : "+ hdd + "GB");
    }

  public void display(){
      System.out.println("This is computer belong to : "+ this.name );
  }
    
}
