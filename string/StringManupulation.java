package string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringManupulation {
    public void frequencyCheckOfCharacters(String str){
        LinkedHashMap<Character, Integer> freq = new LinkedHashMap<>();

        for(char ch: str.toCharArray()){
            if(ch != ' '){
              freq.put(ch, freq.getOrDefault(ch,0)+1);
            }
        }

        System.out.println("Map"+ freq);
    }

    public void frequencyCountUsingStream(String str){
        LinkedHashMap<Character, Long> freq = str.chars()
                                       .mapToObj(ch-> (char)ch)
                                       .collect(Collectors.groupingBy(ch->ch, LinkedHashMap::new, Collectors.counting()));
        System.out.println("Map"+ freq);
    }

    public void titleCase(String str){
        StringBuilder titleCase = new StringBuilder();
        for(String word: str.split(" ")){
            if(word.length()>=1){
                titleCase.append(Character.toUpperCase(word.charAt(0)))
                .append(word.substring(1).toLowerCase())
                .append(" ");
            }
        }

        String titlecaseStr = titleCase.toString().trim();
        System.out.println("Without stream: "+ titlecaseStr);

        String steamTitleCase = Arrays.asList(str.split(" ")).stream()
                                .map( word -> Character.toUpperCase(word.charAt(0)) + word.substring(1) )
                                .collect(Collectors.joining(" "));
       System.out.println("Using Stream : "+ steamTitleCase);
    }

    public void firstNonRepeatingChar(String str){
        LinkedHashMap<Character, Integer> freq = new LinkedHashMap<>();
        for(char ch: str.toCharArray()){
            if(ch != ' '){
              freq.put(ch, freq.getOrDefault(ch,0)+1);
            }
        }

       char c =  freq.entrySet()
       .stream()
       .filter(ch -> ch.getValue() ==1 )
       .map(ch-> ch.getKey())
       .findFirst()
       .orElse(null);
       System.out.println("Non-repeating character is : "+ c);

       char finalChar = str.chars()
                        .mapToObj(ch-> (char)ch)
                        .collect(Collectors.groupingBy(ch->ch, LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(ch-> ch.getValue() == 1)
                        .map(ch-> ch.getKey())
                        .findFirst()
                        .orElse(' ');
        System.out.println("With Stream first non repeating character : "+ finalChar);

    }

    public void isPallindrom(String str){
        boolean isPallindrom = str.equals(new StringBuilder(str).reverse().toString());
        System.out.println("Is String Pallindrom: "+ isPallindrom);
    }

    public void isAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            System.out.println("Not aa anagram");
        }else{
            boolean isAnagram = str1.chars().sorted().boxed().collect(Collectors.toList()).equals(
                str2.chars().sorted().boxed().collect(Collectors.toList())
            );

            System.out.println("Given string is the anagram: "+ isAnagram);
        }
    }

    public void maxAccuranceCharcater(String str){
        char ch = str.chars().mapToObj(c-> (char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()))
        .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        System.out.println("Max Occurance character is: "+ ch);
    }
}
