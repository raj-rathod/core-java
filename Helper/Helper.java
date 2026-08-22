package Helper;

public class Helper {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int start, int end){
        while(end > start){
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
