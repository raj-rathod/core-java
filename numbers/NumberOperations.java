package numbers;

import java.util.Map;

public class NumberOperations {
    public int reverseNumber(int n){
        int rev = 0;
        int rem = 0;
        while(n>0){
            rem = n % 10;
            rev = rev * 10 + rem;
            n = n/10;
        }
        return rev;
    }

    public void ispallindrom(int n){
       int rev = this.reverseNumber(n);
       if(n==rev){
           System.out.println("Given number is pallindrom : "+ n);
       }else{
        System.out.println("Given number not a pallindrom");
       }
    }

    public long factorial(int n){
        if(n == 1 || n==0) return 1;
        return n*factorial(n-1);
    }

    public void fibonacciSeries(int n){
        int a = 0;
        int b = 1;
        int c = 0;
        System.out.print(a+" "+ b+ " ");
        for(int i = 2; i<n; i++){
            c = a+b;
            System.out.print(c+" ");
            a = b;
            b = c;
        }
    }


    public int fibonacciMemo(int n, Map<Integer, Integer> memo){
        if(n<=1) return n;
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int result = fibonacciMemo(n-1, memo)+ fibonacciMemo(n-2, memo);
        memo.put(n, result);
        return result;
    }


    public boolean isEven(int n){
        return (n & 1) == 0;
    }



}
