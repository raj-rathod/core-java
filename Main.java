import dsa.SlidingWindow;
import dsa.TwoPointer;

public class Main {
    public static void main(String[] arg) {
    //   SlidingWindow obj = new SlidingWindow();
    //   obj.longestSubStringWithoutRepeatChar("geeksforgeeks");
    //   obj.minimunWindowSubstring("timetopractice", "toc");

      TwoPointer obj = new TwoPointer();
      //int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};
      //obj.twoSumSortedArray(arr,20);
      int[] height = new int[]{3, 1, 2, 4, 5};
      obj.rainWaterTrap(height);



    }


  
}
