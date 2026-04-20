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
}
