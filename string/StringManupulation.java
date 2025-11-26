package string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringManupulation {
    public void findLongestWord(String str){
        List<String> list = Arrays.asList(str.split(" "));
        System.out.println(list);
        String word = list.stream().max(Comparator.comparingInt(String::length)).orElse("Not found");
        System.out.println(word);
    }

    public void findNonRepeatingCharacter(String str){
        String nonRepeatingStr = Arrays.asList(str.split("")).stream()
        .collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(s -> s.getValue()==1)
        .map(Map.Entry::getKey)
        .findFirst()
        .orElse("Not found");

        System.out.println(nonRepeatingStr);
    }

    public void reverseAString(String str){
        String reversedStr = Stream.of(str.split("")).reduce("",(a,b)->b+a);
        System.out.println(reversedStr);
    }


    public void mostRepeatedCharacter(String str){
        String mostRepeat = Arrays.asList(str.split(""))
        .stream()
        .collect(Collectors.groupingBy(c->c, Collectors.counting()))
        .entrySet()
        .stream()
        .max(Comparator.comparingLong(c-> c.getValue()))
        .map(Map.Entry::getKey)
        .orElse("not found");

        System.out.println(mostRepeat);
        
    
    }
}
