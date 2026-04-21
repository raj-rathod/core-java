package dsa;

public class RecursionPractice {
    public int sampleFunc(int n){
        if(n==0){
            return 2;
        }else{
            return 1+sampleFunc(n-1);
        }
    }
}
