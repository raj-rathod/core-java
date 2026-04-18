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

    // 7. Check anagram

    public boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()) {
            return false;
        }
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int[] freq = new int[26];
        for(int i =0; i< str1.length();i++){
            freq[str1.charAt(i)-'a']++;
            freq[str2.charAt(i)-'a']--;
        }

        for(int count:freq){
            if(count != 0){
                return false;
            }
        }

        return true;

    }

    //8. generate all substrings 

    public void generateSubstrings(String str){
       for(int i = 0; i<str.length();i++){
        for(int j = i; j<=str.length();j++){
            System.out.print(str.substring(i,j)+" ");
        }
        System.out.println();
       }
    }

    // 9. find longest word in the sentence

    public void findLongestWord(String str){
        String[] words = str.split(" ");
        String maxLengthWord = "";
        for(String word: words){
            if(maxLengthWord.length() < word.length()){
                maxLengthWord = word;
            }
        }

        System.out.println("Longest word : "+ maxLengthWord);
    }

    // 10. remove duplicates

    public void removeDuplicates(String str){
        Set<Character> set = new HashSet<>();
         StringBuilder sb = new StringBuilder();
        for(int i = 0; i<str.length();i++){
           if(set.add(str.charAt(i))){
               sb.append(str.charAt(i));
           }
        }

        System.out.println("Remove duplicate characters from " + str +" : "+ sb.toString());
    }

    public String lengthOfLongestSubStringWithoutRepeatChar(String str){
        Set<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        int start = 0;
        for(int right = 0; right< str.length(); right++){
            while(set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(str.charAt(right));
            // max = Math.max(max, right-left+1);
            if(right-left+1 > max){
                max = right-left+1;
                start = left;
            }
        }
        //return max;
        return str.substring(start, start+max);
    }


    public int countSubstringWithAtMostKDistinctChar(String str, int k){
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, count = 0;

        for(int right=0; right< str.length();right++){
            map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0)+1);
            while(map.size()>k){
                char leftChar = str.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
                left++;
            }
            count+= right-left+1;
        }
        return count;
    }


    public String longestSubStringWithKDisChar(String str, int k){
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0, start = 0;

        for(int right=0; right < str.length(); right++){
           map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0)+1);
           while(map.size()>k){
               char leftChar = str.charAt(left);
               map.put(leftChar, map.get(leftChar)-1);
               if(map.get(leftChar) == 0){
                map.remove(leftChar);
               }
               left++;
           }

           if(right-left+1>max){
                max = right-left+1;
                start = left;
           }
        }

        return str.substring(start, start+max);
    }


}
