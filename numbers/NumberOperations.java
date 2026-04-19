package numbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
        return n * factorial(n-1);
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


    public boolean isPrime(int n){
        if(n<= 1){
            return false;
        }
        for(int i=2; i*i<=n;i++){
            if(n%i == 0){
                return false;
            }
           
        }
        return true;
    }
    // time = O(n*ROOT(n))
    // space = O(1)
    public void printPrimes(int n){
        for(int i=2;i<=n;i++){
            if(isPrime(i)){
                System.out.print(i+ " ");
            }
        }
    }
    // time = O(log(log(n)))
    // space = O(N) due to isPrime Array
    public void printPrimesSieve(int n){
        boolean[] isPrime = new boolean[n+1];
        for(int i=2; i<=n; i++){
            isPrime[i] = true;
        }

        for(int i=2; i*i <= n; i++){
            if(isPrime[i]){
                for(int j = i*i; j<=n; j+= i){
                    isPrime[j] = false;
                }
            }
        }

        for(int i=2;i<=n; i++){
            if(isPrime[i]){
                System.out.print(i+ " ");
            }
        }
    }


    public void findGCDAndLCM(int a, int b){
        int gcd = BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
        int lcm = (a*b)/gcd;
        System.out.println("GCD of "+ a +", "+b+" : "+ gcd);
        System.out.println("LCM of "+ a +", "+b+" : "+ lcm);
    }

    public List<Integer> findAllDivisors(int n){
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i*i <=n; i++){
            if(n%i ==0){
                if(n/i == i){
                    list.add(i);
                }else{
                    list.add(i);
                    list.add(n/i);
                }
            }
        }
        return list;
    }



}
