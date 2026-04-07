package string;

import java.util.*;
import java.util.stream.Collectors;

public class StringPractice {
    // 1. Reverse a String
    public void reverseAString(String str){
        char[] charArray = str.toCharArray(); 
        int first = 0;
        int last = charArray.length-1;
        while(first<last){
            char temp = charArray[first];
            charArray[first] = charArray[last];
            charArray[last] = temp;
            first++;
            last--;
        }

        System.out.println("Reverse String: "+ new String(charArray)); 
    }

    // 2. Check Palindrome
    public void checkPalindrome(String str){
        int first = 0;
        int last = str.length()-1;
        while(first<last){
            if(str.charAt(first) != str.charAt(last)){
                System.out.println("Given String "+ str +" is not a palindrome");
                return;
            }
            first++;
            last--;
        }

        System.out.println("Given String "+ str +" is a palindrome");
    }

    // 3. Count Vowels & Consonants stream version
    public void countVowelsAndConsonants(String str){
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();

        for(int i=0; i< str.length();i++){
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
               if(ch =='a' || ch =='e' || ch == 'i' || ch =='o' || ch=='u'){
                  vowels++;
               }else{
                 consonants++;
               }
            }
        }

        System.out.println("Vowels: "+ vowels);
        System.out.println("Consonants: "+ consonants);

    }

    // 4. Count Occurrence of Character
    public void countFrequencyOfChar(String str, char ch){
       int count = 0;
       for(int i =0; i< str.length(); i++){
          char strchar = str.charAt(i);
          if(ch == strchar){
            count++;
          }
       }

       System.out.println("Count of " + ch + " in "+ str+ ": "+ count);
    }

    // 5. Remove Spaces

    public void removeSpaces(String str){
        //str = str.replaceAll(" ", "");
        //System.out.println("Removed spaces: " + str); // slower due to regex opration
        StringBuilder result = new StringBuilder();

        for(int i = 0; i< str.length(); i++){
            char ch =  str.charAt(i);
            if(ch != ' '){
                result.append(ch);
            }
        }

        System.out.println("Removed spaces: " + result.toString()); 

    }

    // 6. First Non-Repeating Character

    public void firstNonRepeatingChar(String str){
        str.chars().mapToObj(ch -> (char)ch)
        .collect(Collectors.groupingBy(ch->ch, LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() == 1)
        .findFirst()
        .ifPresentOrElse(
         e -> System.out.println("First Non Repeating Character: "+ e.getKey()),
         () -> System.out.println("All Characters are duplicate") 
        );
    }
}
