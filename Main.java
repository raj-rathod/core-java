import java.util.*;

import oops.abstract_interface.Student;
import oops.abstract_interface.StudentInterface;
import oops.classes_object.BasicClass;
import oops.inheritence.Computer;
import oops.inheritence.Desktop;
import oops.inheritence.GamingLaptop;
import oops.inheritence.Laptop;

public class Main {
    public static void main(String[] arg) {
        System.out.println("Pragram start from here ---- !");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        /*
         * String opratipns
         * String str = sc.nextLine();
         * BasicString bstr = new BasicString(str);
         * bstr.show();
         * bstr.subString(1,4);
         * bstr.startWith("Ra");
         * bstr.endWith("sh");
         * bstr.reverseString();
         * bstr.charAt(3);
         * bstr.indexOfChar('e');
         * bstr.substringCheck("je");
         * StringManupulation strMan = new StringManupulation();
         * strMan.frequencyCheckOfCharacters(str);
         * strMan.frequencyCountUsingStream(str);
         * strMan.titleCase(str);
         * strMan.firstNonRepeatingChar(str);
         * strMan.isPallindrom(str);
         * strMan.isAnagram(str, str2);\
         * strMan.maxAccuranceCharcater(str);
         * 
         */

        // Number oprations
        /*
         * NumberOperations numOP = new NumberOperations();
         * int revNum = numOP.reverseNumber(n);
         * System.out.println("Reverse Number: "+ revNum);
         * numOP.ispallindrom(n);
         * long fac = numOP.factorial(n);
         * System.out.println("Factorial of "+ n + " is : "+fac);
         * 
         * numOP.fibonacciSeries(n);
         * Map<Integer, Integer> memo = new HashMap<>();
         * 
         * for (int i = 0; i < n; i++) {
         * System.out.print(numOP.fibonacciMemo(i, memo) + " ");
         * }
         * 
         */

        // Basic Array operations
        /*
         * BasicArray arr = new BasicArray();
         * arr.createAnArray(n);
         * arr.sortAnArray(n);
         * 
         * arr.compareAnArray(n);
         * 
         * arr.binarySearch(n);
         */

        // BasicArrayProblems arrProb = new BasicArrayProblems();

        // int[] arr1 = new int[n];
        // int[] arr2 = new int[n-2];
        // Arrays.setAll(arr1, index -> (int)(Math.random()*100));
        // Arrays.setAll(arr2, index -> (int)(Math.random()*100));
        // Arrays.sort(arr1);
        // Arrays.sort(arr2);
        // System.out.println("Array1 is : "+ Arrays.toString(arr1));
        // System.out.println("Array2 is : "+ Arrays.toString(arr2));
        // long result = arrProb.sumArray(arr);
        // System.out.println("Sum of given array is: "+ result);
        // try{
        // double average = arrProb.averageOfArray(arr);
        // System.out.println("Average of given array is : "+ average);
        // }catch(Exception e){
        // System.out.println(e);
        // }

        // int result[] = arrProb.mergeTwoSortedArray(arr1, arr2);
        // System.out.println("Merge two sorted Array is: "+ Arrays.toString(result));
        // int result[] = arrProb.mergeTwoNotSortedArray(arr1, arr2);
        // System.out.println("Merge two not sorted Array is: "+
        // Arrays.toString(result));

        // arrProb.duplicatesElements(arr1);
        // arrProb.firstNonRepeatingElement(arr1);

        // int el = arrProb.kthLargestElement(arr1, 2);
        // System.out.println("kth largest elemnet is : "+el);
        // int el2 = arrProb.kthSmallestElement(arr2, 3);
        // System.out.println("kth smallest elemnet is : "+el2);

        // BasicClass obj = new BasicClass();
        // //obj.age = n; // private varible can't access outside the class;
        // obj.setAge(n);
        // obj.setName("Rajesh Rathore");

        // System.out.println(obj.toString());

        // Student st = new Student(); // abstract and interface
        // st.setAge(n);
        // st.setName("Rajesh");
        // st.setCollageName("dbit");
        // st.setDepartmentName("CSE");
        // st.setSemesterName("8th");
        // st.setMarks(600);

        // st.showStudentRule();
        // StudentInterface.showStudentPassingMarks(); // static method inside the interface

        // System.out.println();

        Laptop laptop = new Laptop();
        Desktop desk = new Desktop();
        GamingLaptop gaminglap = new GamingLaptop(); 

        laptop.showCpu();
        desk.editing();
        gaminglap.gaming();

        sc.close();
    }
}
