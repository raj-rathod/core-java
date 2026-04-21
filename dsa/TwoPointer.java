package dsa;

public class TwoPointer {
    public void twoSumSortedArray(int[] arr, int target){
        int sum = 0, left = 0, right = arr.length-1;
        while(left<right){
            sum = arr[left]+ arr[right];
            if(sum > target){
                right --;
            }else if( sum < target){
                left++;
            }else{
                System.out.println("Sum of two values: ("+ arr[left]+","+arr[right]+")");
                return;
            }

        }
    }

    public void rainWaterTrap(int[] height){
        int left = 0, right = height.length-1;
        int max = 0;
        while(left < right){
            int area = Math.min(height[left], height[right])*(right-left);
            max = Math.max(area, max);
            System.out.println(area);
            if(height[left]< height[right]){
                left++;
            }else{
                right--;
            }
        }

        System.out.println("Traped Water: "+ max);
    }

    public void moveAllZero(int[] arr){
      int i = 0; 
      for(int j=0; j<arr.length; j++){
        if(arr[j] !=0){
            arr[i] = arr[j];
            i++;
        }
      }
      for(int k = 0; k < i;k++){
        System.out.print(arr[k]+" ");
      }
    }


    public void removeDuplicatesFromSortedArray(int[] arr){
       int i = 0; 
      for(int j=1; j<arr.length; j++){
        if(arr[j] !=arr[i]){
            i++;
            arr[i] = arr[j];
        }
      }
      for(int k = 0; k < i+1;k++){
        System.out.print(arr[k]+" ");
      }
    }
}
