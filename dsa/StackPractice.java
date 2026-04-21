package dsa;

import java.util.Stack;

public class StackPractice {
    public void nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        for(int i = arr.length-1; i>=0; i--){
            while(!st.empty() && st.peek() <= arr[i]){
                st.pop();
            }

            result[i] = st.isEmpty() ? -1: st.peek();
            st.push(arr[i]);
        }

        for(int i=0; i< arr.length;i++){
            System.out.print(result[i]+" ");
        }
    }

    public void stackSpan(int[] arr){
        int[] span = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                span[i] = i+1;
            }else{
                span[i] = i - st.peek();
            }
            st.push(i);
        }

        for(int i=0; i< arr.length;i++){
            System.out.print(span[i]+" ");
        }

    }


    public boolean isValidParintheses(String str){
        Stack<Character> st = new Stack<>();
        for(char ch: str.toCharArray()){
            if(ch == '{' || ch == '[' || ch == '('){
                st.push(ch);
            }else{

                if(st.isEmpty()) return false;
                char top = st.pop();

                if((ch == '}' && top != '{') ||
                (ch == ']' && top != '[') ||
                (ch == ')' && top != '(') 
                ){
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
