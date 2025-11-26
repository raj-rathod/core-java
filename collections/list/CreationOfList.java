package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreationOfList {
    public <T> List<T> createList(T[] arr){
        return Arrays.asList(arr);
    }

    public List<Integer> createList(int[] arr){
       return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public List<String> createList(String[] arr){
     List<String> strList = new ArrayList<>();
     for(String str: arr){
        strList.add(str);
     }
     return strList;
    }
}
