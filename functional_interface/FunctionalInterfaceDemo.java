package functional_interface;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalInterfaceDemo {
   
    public void evenNumberList(int[] arr){

        Predicate<Integer> isEven = n -> n%2 == 0;

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        List<Integer>  result = list.stream().filter(isEven).collect(Collectors.toList());

        System.out.println("Given Array: "+ list.toString());

        System.out.println("Filtered List : "+ result.toString());

    }

    public void filterNullOrEmptyStrings(String[] strArr){
        Predicate<String> isValidString = str -> (str != null && !str.trim().isEmpty());
        List<String> list = Arrays.stream(strArr).filter(isValidString).collect(Collectors.toList());
         System.out.println("Given String Array: "+ Arrays.toString(strArr));

        System.out.println("Filtered List : "+ list);
    }


    public <T> List<T> FilterData(List<T> data, Predicate<T> condition){
        return data.stream().filter(condition).collect(Collectors.toList());
    }




}
