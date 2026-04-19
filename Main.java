import string.StringPractice;
import thread.ThreadPractice;

public class Main {
    public static void main(String[] arg) {
        //ThreadPractice obj = new ThreadPractice();
        //obj.printNumberInOrderAndReverse();
        //obj.threadCounter();
        //obj.printEvenOdd();
        //obj.producerConsumer();
        //obj.printSequenceUsingThreeThread();

        StringPractice obj = new StringPractice();
        //System.out.println("Longest substring length: "+ obj.lengthOfLongestSubStringWithoutRepeatChar("abcabcdefbsba"));
        //System.out.println("Substring Count: "+ obj.countSubstringWithAtMostKDistinctChar("eceba",  2));
        //System.out.println("Longest Substring: "+ obj.longestSubStringWithKDisChar("eceba",2));

        System.out.println("minimun lrngth substring contains match:"+ obj.minWindowSubstring("ADOBECODEBANC", "ABC"));
    }


  
}
