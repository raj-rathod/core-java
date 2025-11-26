import exceptions.ExcepectionHandling;
import string.StringManupulation;

public class Main {
    public static void main(String[] arg) {
        System.out.println("Pragram start from here ---- !");
        StringManupulation obj = new StringManupulation();
        //obj.findLongestWord("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
       // obj.findNonRepeatingCharacter("swiss");
      // obj.reverseAString("hello");

      //obj.mostRepeatedCharacter("hello");

      ExcepectionHandling exceptionObj = new ExcepectionHandling();

      //exceptionObj.divide(10,0);

      try{
        exceptionObj.addToCart(6);
      }catch(Exception e){
        System.out.println(e);
      }

      exceptionObj.isMailValid("rr");




        
       
    }
}
