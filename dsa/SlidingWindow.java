package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SlidingWindow {
    public void longestSubStringWithoutRepeatChar(String str){
        int left = 0;
        int maxLength = 0, start = 0;

        Set<Character> set = new HashSet<>();
        for(int right = 0; right<str.length(); right++){
            while(set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(right));
            if(right-left+1 > maxLength){
                maxLength = right-left+1;
                start = left;
            }
        }

        System.out.println("Longest Substring Lenth: "+maxLength+" Substring is: "+ str.substring(start, start+maxLength));

    }

    public void minimunWindowSubstring(String str, String match){
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int required = 0, formed = 0, minLength = Integer.MAX_VALUE;
        int start = 0, left = 0;

        for(int i =0; i< match.length();i++){
            need.put(match.charAt(i), need.getOrDefault(match.charAt(i),0)+1);
        }
        required = need.size();

        for(int right = 0; right<str.length(); right++){
            char rightChar = str.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0)+1);
            if(need.containsKey(rightChar) && need.get(rightChar) == window.get(rightChar)){
                formed++;
            }

            while(required == formed){
                if(right-left+1 < minLength){
                    minLength = right-left+1;
                    start = left;
                }
                char leftChar = str.charAt(left);
                window.put(leftChar, window.get(leftChar)-1);
                if(need.containsKey(leftChar) && need.get(leftChar) > window.get(leftChar)){
                    formed--;
                }
                left++;
            }
        }

        String result = minLength == Integer.MAX_VALUE?"": str.substring(start, start+minLength);

        System.out.println("Minimum window Substring: "+ result);

    }

    public  List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int i=0, j=0;
        while(j<arr.length){
            if(arr[j]<0){
                queue.offer(arr[j]);
            }

            if(j-i+1 == k){
                if(!queue.isEmpty()){
                    result.add(queue.peek());
                } else{
                    result.add(0);
                }

                if(!queue.isEmpty() && arr[i] == queue.peek()){
                    queue.poll();
                }
                i++;
            }

            j++;
        }
        return result;
        
    }

    public int search(String pat, String txt) {
        int res = 0, count = 0;

        Map<Character, Integer> map = new HashMap<>();

        int i =0, j=0;

        for(char ch: pat.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        count = map.size();

        while(j< txt.length()){
            char ch = txt.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0){
                    count--;
                }
            }

            if(j-i+1 == pat.length()){
                if(count == 0) res++;
                char leftChar = txt.charAt(i);
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar)+1);
                    if(map.get(leftChar) == 1){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
    
        return res;
    }
}
