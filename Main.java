import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import numbers.NumberOperations;
import string.*;

public class Main {
    public static void main(String[] arg){
        System.out.println("Pragram start from here ---- !");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

     /*  String opratipns    
       String str = sc.nextLine();
        BasicString bstr = new BasicString(str);
        bstr.show();
        bstr.subString(1,4);
        bstr.startWith("Ra");
        bstr.endWith("sh");
        bstr.reverseString();
        bstr.charAt(3);
        bstr.indexOfChar('e');
        bstr.substringCheck("je");
        StringManupulation strMan = new StringManupulation();
        strMan.frequencyCheckOfCharacters(str);
        strMan.frequencyCountUsingStream(str);
        strMan.titleCase(str);
        strMan.firstNonRepeatingChar(str);
        strMan.isPallindrom(str);
       strMan.isAnagram(str, str2);\
       strMan.maxAccuranceCharcater(str);

    */

     // number oprations
     NumberOperations numOP = new NumberOperations();
    //  int revNum = numOP.reverseNumber(n);
    //  System.out.println("Reverse Number: "+ revNum);
    //numOP.ispallindrom(n);
    // long fac = numOP.factorial(n);
    // System.out.println("Factorial of "+ n + " is : "+fac);

    // numOP.fibonacciSeries(n);
        Map<Integer, Integer> memo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            System.out.print(numOP.fibonacciMemo(i, memo) + " ");
        }



    sc.close();
    }
}
