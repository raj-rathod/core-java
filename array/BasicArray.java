package array;

import java.util.Arrays;

public class BasicArray {
    // create an array with default value 

    public void createAnArray(int n){
        int[] arr = new int[n];
        Arrays.fill(arr, 10);

        System.out.println("Create array is: "+ Arrays.toString(arr));
    }

    public void sortAnArray(int n){
        int[] arr = new int[n];
        Arrays.setAll(arr, index-> (int)(Math.random()*100));
        System.out.println("Array: "+ Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted Array: "+ Arrays.toString(arr));
    }

    public void compareAnArray(int n){
        int[] arr = new int[n];
        Arrays.setAll(arr, index-> (int)(Math.random()*100));
        System.out.println("Array: "+ Arrays.toString(arr));
        int[] copyArr = Arrays.copyOf(arr, n);
        System.out.println("Copied Array : " + Arrays.toString(copyArr));

        System.out.println("Compair these array: "+ Arrays.compare(arr, copyArr));
    }

    public void binarySearch(int n){
        int[] arr = new int[n];
        Arrays.setAll(arr, index-> (int)(Math.random()*100));
        System.out.println("Array: "+ Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted Array: "+ Arrays.toString(arr));
        int key = arr[8]; // this case for checking the key present. if you want random check assign any value to this
        System.out.println("Search Key is : " + key);
        int index = Arrays.binarySearch(arr, key);
        if(index>-1){
            System.out.println("Key is present at index : "+ index);
        }else{
            System.out.println("Key is not present");
        }
    }
}
