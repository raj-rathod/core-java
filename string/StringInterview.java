package string;

import java.util.*;
import java.util.stream.*;

public class StringInterview {

    public void checkIsAnagram(String str1, String str2){
       boolean isAnagram = Arrays.stream(str1.split("")).sorted().collect(Collectors.joining(""))
       .equals(Arrays.stream(str2.split("")).sorted().collect(Collectors.joining("")));

       System.out.println("Stream based -> " + str1 +" and "+ str2 +" are anagram: "+isAnagram);
       System.out.println("Frequency based -> " + str1 +" and "+ str2 +" are anagram: "+ checkIsAnagramOptimize(str1, str2));
    }

    public boolean checkIsAnagramOptimize(String str1, String str2){
       
       if(str1.length() != str2.length()) return false;
       int[] freq = new int[256];
       for(char c: str1.toCharArray()) freq[c]++;
       for(char c: str2.toCharArray()) if(--freq[c] !=0) return false;

       return true;
    }

    public void isStringIsogram(String str){
        long uniqueCount = str.chars().distinct().count();
        boolean isIsogram = uniqueCount == str.length();
        System.out.println("Stream version -> " + "Given string "+str +" is isogram ?: "+ isIsogram);
        System.out.println("Set version -> " + "Given string "+str +" is isogram ?: "+ isStringIsogramSet(str));
    
    }

    public boolean isStringIsogramSet(String str){
        Set<Character> set = new HashSet<>();
        for(char c : str.toCharArray()){
            if(!set.add(c)) return false;
        }
        return true;
    }


    public void findUniqueCharacter(String str){
        String uniqueStr = Arrays.stream(str.split("")) 
                              .collect(Collectors.groupingBy(c -> c, HashMap:: new, Collectors.counting()))
                              .entrySet()
                              .stream()
                              .filter(c -> c.getValue() == 1)
                              .map(Map.Entry::getKey)
                              .collect(Collectors.joining(""));
        System.out.println("Unique chacters of given string ("+ str+ ") :-> "+ uniqueStr);

    }

    public void findFirstNonRepeatingCharacter(String str){
        String firstNonRepeatChar = Arrays.stream(str.split(""))
               .collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting()))
               .entrySet()
               .stream()
               .filter(c -> c.getValue() == 1)
               .map(Map.Entry:: getKey)
               .findFirst()
               .orElse("Not Found");
        System.out.println("First non repeating chacter of given string ("+ str+ ") :-> "+ firstNonRepeatChar);

    }

    public void convertStringToCamelCase(String str){
        String camelCaseStr = Arrays.stream(str.split(" "))
                              .map(word -> Character.toUpperCase(word.charAt(0))+ word.substring(1).toLowerCase())
                              .collect(Collectors.joining(" "));

        System.out.println("( "+ str + " ) To camel case conversion: "+ camelCaseStr);
    }

    public void countWords(String str){
        if(str == null || str.trim().length() == 0){
            System.out.println("Not a valid string");
        }

        str = str.trim();
        int count = 1;
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) == ' ' && str.charAt(i+1) != ' '){
                count++;
            }
        }

        System.out.println("Words present in given string ("+ str+ ") are : "+ count);

    }

    public void removeDuplicates(String str){
        String resultStr = Arrays.stream(str.split("")).distinct().collect(Collectors.joining());

        System.out.println("Remove duplicates fro the given string ("+str+") -> "+resultStr);
    }

    public void mostRepeatingCharacter(String str){
        String result = Arrays.stream(str.split(""))
                        .collect(Collectors.groupingBy(c->c, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Comparator.comparingLong( c -> c.getValue()))
                        .map(Map.Entry:: getKey)
                        .orElse("Not found");
        System.out.println("Most repeating charcter in given string ("+str+") is : "+ result);
    }

    public void findLargestWordInString(String str){
        String result = Arrays.stream(str.split(" "))
                        .max(Comparator.comparingInt(word -> word.length()))
                        .orElse("Not found");
        System.out.println("Largest word in given string("+str+") is :-> "+result);
    }
}
