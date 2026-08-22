import dsa.TwoPointer;
import system_design.cache.LRUCache;

public class Main {
    public static void main(String[] arg) {
        // TwoPointer twoPointer = new TwoPointer();
        // int[] arr = {3,2,9,8,7,1};
        // twoPointer.nextGreaterPermutation(arr);
        // for(int el:arr){
        //     System.out.print(el +" ");
        // }
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1,"A");
        cache.put(2,"B");
        cache.put(3,"C");
        System.out.println(cache);
        cache.get(1);
        System.out.println(cache);
        cache.put(4,"D");
        System.out.println(cache);
    }
}
