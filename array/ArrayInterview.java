package array;

import java.util.*;
import java.util.stream.*;

public class ArrayInterview {
   
    public void reverseArray(int[] arr){
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList()).reversed();
        System.out.println(list);
    }

    public void reverseArray(int[] arr, int start, int end){
        while (start < end ) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void kthSmallest(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int el: arr){
            maxHeap.add(el);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        System.out.println(k+"th smalllest element is: "+ maxHeap.peek());
    }


    public void kthLargest(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int el : arr){
            minHeap.add(el);
            if(minHeap.size() > k){
                  minHeap.poll();
            }
        }

        System.out.println(k+"th largest element is: "+ minHeap.peek());
    }

    public void findDuplicates(int[] arr){
        Set<Integer> set = new HashSet<>();
        List<Integer> duplicates = Arrays.stream(arr)
            .filter(el -> !set.add(el))
            .boxed()
            .collect(Collectors.toList());
        System.out.println("Duplicates: " + duplicates);
    }

    public void findNonRepeatingElements(int[] arr){
       List<Integer> nonRepeat = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.groupingBy(c->c, Collectors.counting()))
            .entrySet()
            .stream()
            .filter(el -> el.getValue() == 1)
            .map(Map.Entry :: getKey)
            .toList();


        System.out.println("Non Repeating elements are : " + nonRepeat);
    }


    public void findElementFrequency(int[] arr){
        Map<Integer, Long> map = Arrays.stream(arr)
           .boxed()
           .collect(Collectors.groupingBy(c-> c, Collectors.counting()));

        System.err.println("Elements frequencies: "+ map);
    }

    public void isSubset(int[] arr1, int[] arr2){
       
        Map<Integer, Long> freq1 = Arrays.stream(arr1)
            .boxed()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Map<Integer, Long> freq2 = Arrays.stream(arr2)
            .boxed()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        
        boolean isSubset = freq2.entrySet().stream()
                           .allMatch(el-> freq1.getOrDefault(el, 0L) >= el.getValue());
        
        System.out.println("Is arr2 is subset of arr1 : "+ isSubset);
    }


    public void mergeTwoUnsortedArray(int arr1[], int arr2[]){
        List<Integer> list = Stream.concat(
            Arrays.stream(arr1).boxed(),
            Arrays.stream(arr2).boxed()
        )
        .sorted()
        .toList();

      System.out.println("Merged and sorted array: "+ list);
    }

    public void mergeTwoSortedArray(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length ) {
            if(arr1[i]< arr2[j]){
                result[k++] = arr1[i++];
            }else{
                result[k++] = arr2[j++];
            }
        }
        while (i<arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j<arr2.length) {
            result[k++] = arr2[j++];
        }

        System.out.println("Merged two sorted arrays :"+ Arrays.stream(result).boxed().toList());

    }

    public void findSubArrayOfGivenSum(int[] arr, int target){
        int sum = 0;
        int left = 0;
        boolean found = false;
        for(int right = 0; right<arr.length; right++){
            sum += arr[right];

            while(sum > target && left<= right){
                sum -= arr[left++];
            }

            if(sum == target){
                found = true;
                System.out.println("Subarray found from index " + left + " to " + right);
                //return; // add return for single subarray
            }
        }
        if(!found){
           System.out.println("No subarray found");
        }
    }

    public void findMaximumSubArrayProduct(int arr[]){
        int maxProd = arr[0];
        int minProd = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = maxProd;

            maxProd = Math.max(arr[i], Math.max(maxProd * arr[i], minProd * arr[i]));
            minProd = Math.min(arr[i], Math.min(temp * arr[i], minProd * arr[i]));

            result = Math.max(result, maxProd);
        }

        System.out.println("Maximum subarray product: " + result);
    }

    public void findMaximumSubArraySum(int arr[]){ // Kadene's algorithm
        int maxSum = 0;
        int currentSum = 0;
        for(int i = 0; i< arr.length; i++){
            currentSum = Math.max(arr[i], currentSum+arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        } 
        System.out.println("Maximum subarray sum: "+ maxSum);
    }

    public void findMaxSumSubarrayOfSizeK(int[] arr, int k){
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i<k; i++){
            windowSum+= arr[i];
        }

        maxSum = windowSum;

        for(int i = k; i<arr.length; i++){
           windowSum += arr[i] - arr[i-k];
           maxSum = Math.max(windowSum, maxSum);
        }

        System.out.println("Maximum sum of subarray of size " + k + " is: "+ maxSum);
    }

    public void rotateByKStep(int[] arr, int k){
        int n = arr.length;
        k = k % n;
        reverseArray(arr, 0, n-1);
        reverseArray(arr, 0, k-1);
        reverseArray(arr,k, n-1);

        System.out.println("K step roteted array: "+ Arrays.stream(arr).boxed().toList());
        
    }

    public void moveAllZeroToLeft(int arr[]){
        int n = arr.length;
        int left = n-1;
        int right = n-1;
        while (right>=0) {
            if(arr[right] != 0){
                arr[left] = arr[right];
                left--;
            }
            right--;
        }

        while (left>=0) {
            arr[left] = 0;
            left--;
        }

        System.out.println("Move all zero to left: "+ Arrays.stream(arr).boxed().toList());
    }


    public void findTwoSum(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {0,0};
        boolean found = false;
        for(int i=0; i<arr.length; i++){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                 result[0] = map.get(complement);
                 result[1] = i;
                 found = true;
                 break;
            }
            map.put(arr[i],i);
        }

        if(!found){
            System.out.println("No pair found");
        }else{
           System.out.println("Indices: " + result[0] + ", " + result[1]);
        }


    }

    public void findThreeSumTarget(int arr[], int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0; i<n-2; i++){
            if(i>0 && arr[i]== arr[i-1]) continue;
            int left = i+1;
            int right = n-1;
            while (left<right) {
                int sum = arr[i]+ arr[left]+ arr[right];
                if(sum == target){
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    while (left<right && arr[left]==arr[left+1]) {
                        left++;
                    }
                    while (left<right && arr[right] == arr[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }

        System.err.println("Triplets with sum = " + target + ": " + result);
    }


    public void removeDuplicates(int arr[]){
        int n = arr.length;
        int i = 0;
        for(int j=1; j<n; j++){
            if(arr[j] != arr[i]){
                i++;
                arr[i] = arr[j];
            }
        }

        for(int k =0; k<i+1; k++){
            System.out.print(arr[k]+" ");
        }
        System.out.println(" ");
    }

    public void removeDuplicatesStream(int arr[]){
        List<Integer> list = Arrays.stream(arr).distinct().boxed().toList();
        System.out.println("Removed using stream "+ list);
    }


    public void longestConsecutiveSequence(int arr[]){
        if(arr.length == 0){
            System.out.println("Array is empty");
        }
        Arrays.sort(arr);
        int longest = 1;
        int currentStreak = 1;
        for(int i=1; i<arr.length; i++){
            if(arr[i]== arr[i-1]) continue;
            if(arr[i] == arr[i-1]+1){
                currentStreak++;
                longest = Math.max(longest, currentStreak);
            }else{
                currentStreak = 1;
            }
        }

        System.out.println("Longest sequence length: "+ longest);
    }



}
