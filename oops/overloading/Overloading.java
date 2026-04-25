package oops.overloading;

public class Overloading {
    // public String add(int a, int b){
    //     return (a+b)+"";
    // }

    // public int add(int a, int b){
    //     return a+b;
    // }

    // above mentioned case is not possible. it give the compile time error. 


    // this is not giving error here, but if you call this add(10,10) 
    //     Overloading overObj = new Overloading();
    //    double sum = overObj.add(10,10);
    // The method add(int, double) is ambiguous for the type Overloading// compile-time error

    public double add(int a, double b){
        return a+b;
    }

    public double add(double a, int b){
        return a+b;
    }
}
