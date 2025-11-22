package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class BasicArrayProblems {
    public long sumArray(int[] arr){
        return Arrays.stream(arr).sum();
    }

    public double averageOfArray(int[] arr){
        int n = arr.length;
        if(n==0){
            throw new ArithmeticException("Average not posible for empty array");
        }
        //return (double) this.sumArray(arr)/n;

        return Arrays.stream(arr).average().orElse(0.0);

    }

    public int[] mergeTwoNotSortedArray(int[] arr1, int[] arr2){
        int result[] = new int[arr1.length+arr2.length];
        int k = 0;
        for(int el: arr1) result[k++] = el;
        for(int el: arr2) result[k++] = el;
        return result;
    }

    public int[] mergeTwoSortedArray(int[] arr1, int[] arr2){
        int result[] = new int[arr1.length+arr2.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while(i<arr1.length && j< arr2.length){
            result[k++] = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
        }
        while(i < arr1.length) result[k++] = arr1[i++];
        while(j < arr2.length) result[k++] = arr2[j++];
        return result;
    }

    public void duplicatesElements(int[] arr){
       LinkedHashMap<Integer, Long> map =  Arrays.stream(arr).boxed().collect(Collectors.groupingBy(el-> el,LinkedHashMap:: new ,Collectors.counting()));

       System.out.println(map.entrySet().toString());
       int[] res = map.entrySet().stream().filter(el-> el.getValue()>1).mapToInt(el-> el.getKey()).toArray();
       System.out.println("Duplicate elements are: "+ Arrays.toString(res));
    }

    public void firstNonRepeatingElement(int [] arr){
        LinkedHashMap<Integer, Long> map =  Arrays.stream(arr).boxed().collect(Collectors.groupingBy(el-> el,LinkedHashMap:: new ,Collectors.counting()));
        System.out.println(map.entrySet().toString());
       int res = map.entrySet().stream().filter(el-> el.getValue()==1).mapToInt(el-> el.getKey()).findFirst().orElse(-1);
       System.out.println("First non repeating element is : "+ res);
    }

    public int kthSmallestElement(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int el: arr){
            maxHeap.add(el);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public int kthLargestElement(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
          for(int el: arr){
            minHeap.add(el);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }


}
