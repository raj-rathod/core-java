import java.util.List;

import numbers.NumberOperations;

public class Main {
    public static void main(String[] arg) {
       NumberOperations numObj = new NumberOperations();
       List<Integer> divisorsList = numObj.findAllDivisors(36);
       System.out.println("Divisors of " +36+ " : "+ divisorsList);
    }
  
}
