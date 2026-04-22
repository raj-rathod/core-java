package collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionPractice {
    public void frequencyRelated(int[] arr){
        Map<Integer,Long> map = 
        Arrays.stream(arr).boxed()
        .collect(Collectors.groupingBy(
            Function.identity(),
            LinkedHashMap:: new,
            Collectors.counting()
        ));

        System.out.println("Map:"+ map);// frequency of each element;

        //Return the first non-repeating element

        Optional<Integer> firstNonRepeat = map.entrySet().stream()
        .filter(el -> el.getValue() == 1 )
        .map(Map.Entry::getKey)
        .findFirst();

        firstNonRepeat.ifPresentOrElse(
            el -> System.out.println("First non repeating Element: "+ el), 
            () -> System.out.println("Not Present") 
        );

        //Return the most frequent element

        Optional<Integer> mostRepeatedEl = map.entrySet().stream()
        .max(Comparator.comparingLong(Map.Entry::getValue))
        .map(Map.Entry::getKey);

        mostRepeatedEl.ifPresentOrElse(
            el -> System.out.println("Most repeating Element: "+ el), 
            () -> System.out.println("Not Present") 
        );
    }

    public void removeDuplicates(){
        List<Integer> list = Arrays.asList(1,2,2,3,4,4,5);
        list.stream().distinct().forEach(el->{
            System.out.print(el+" "); 
        });
        System.out.println("");
    }

    public void findIntersectionOfTwoList(){
        List<Integer> l1 = Arrays.asList(1,2,3,4);
        List<Integer> l2 = Arrays.asList(3,4,5,6);
        Set<Integer> set = new HashSet<>(l2);
        //List<Integer> intersect = l1.stream().filter(l2::contains).toList();// this is not optimal because O(n*m) complexity
        Set<Integer> result = l1.stream().filter(set::contains).collect(Collectors.toCollection(LinkedHashSet::new));// Time: O(n+m) and Space: O(m)
        //System.out.println("Intersection of two list: "+ intersect);
        System.out.println("Intersection of two list: "+ result);  
    }

    public void findGroupOfAnagram(String[] arr){
        Map<String, List<String>> map  = Arrays.stream(arr).collect(Collectors.groupingBy(
            str -> {
                char[] charArr = str.toCharArray();
                //Arrays.sort(charArr);// O(klogk)// not optimize for large string
                //return new String(charArr);
                int[] count = new int[26];
                for(char ch: charArr){
                    count[ch-'a']++;
                }
                return Arrays.toString(count);
            }
        ));
        map.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);
    }


}
