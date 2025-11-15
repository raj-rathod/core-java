import java.util.Scanner;

import string.*;

public class Main {
    public static void main(String[] arg){
        System.out.println("Pragram start from here ---- !");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        //BasicString bstr = new BasicString(str);
        // bstr.show();
        // bstr.subString(1,4);
        // bstr.startWith("Ra");
        // bstr.endWith("sh");
        // bstr.reverseString();
        // bstr.charAt(3);
        // bstr.indexOfChar('e');
        // bstr.substringCheck("je");
        StringManupulation strMan = new StringManupulation();
        // strMan.frequencyCheckOfCharacters(str);
        // strMan.frequencyCountUsingStream(str);
        // strMan.titleCase(str);
        //strMan.firstNonRepeatingChar(str);
        //strMan.isPallindrom(str);
       // strMan.isAnagram(str, str2);\
       strMan.maxAccuranceCharcater(str);
        sc.close();
    }
}
