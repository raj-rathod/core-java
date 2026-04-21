import java.util.Arrays;

import dsa.SlidingWindow;
import dsa.StackPractice;
import dsa.TwoPointer;

public class Main {
    public static void main(String[] arg) {
    //   SlidingWindow obj = new SlidingWindow();
    //   obj.longestSubStringWithoutRepeatChar("geeksforgeeks");
    //   obj.minimunWindowSubstring("timetopractice", "toc");

      //TwoPointer obj = new TwoPointer();
      //int[] arr = new int[]{0,1,2,3,4,0,5,6,7,8,0,10,0,12};
      //obj.twoSumSortedArray(arr,20);
      //int[] height = new int[]{3, 1, 2, 4, 5};
      //obj.rainWaterTrap(height);
      //obj.moveAllZero(arr);
      //Arrays.sort(arr);
      //obj.removeDuplicatesFromSortedArray(arr);

      StackPractice obj = new StackPractice();
      int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
      //obj.nextGreaterElement(arr);
      //obj.stackSpan(arr);
      String str = "{{}]()}";
     boolean isVlaid =  obj.isValidParintheses(str);

     System.out.println("Given String ("+str+") have the valid paranthese: "+ isVlaid);

    }


  
}
