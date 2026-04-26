import collections.CollectionPractice;
import dsa.BinarySearchPractice;
import oops.overloading.Overloading;

public class Main {
    public static void main(String[] arg) {
        //CollectionPractice obj = new CollectionPractice();
        int[] arr = {1,1,2,2,2,3,4,4,5};
        //obj.frequencyRelated(arr);
        //obj.removeDuplicates();
        //obj.findIntersectionOfTwoList();
        // String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        // obj.findGroupOfAnagram(strs);

        // Overloading overObj = new Overloading();
        // double sum = overObj.add(10,10.0);

        BinarySearchPractice obj = new BinarySearchPractice();
        System.out.println("Last index of the 2 is: "+ obj.findLastIndex(arr, 2));
    }


  
}
