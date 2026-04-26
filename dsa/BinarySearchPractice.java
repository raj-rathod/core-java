package dsa;

public class BinarySearchPractice {
    public int findLastIndex(int[] arr, int key){
        int left = 0, right = arr.length-1;
        int result = -1;

        while(left<= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == key){
                result = mid;
                left = mid+1;
            }else if(arr[mid] < key){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return result;
    }
}
