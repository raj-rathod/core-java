package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import oops.classes_object.Employee;

public class StreamPractice {
    public void flatSentenceToWord(List<String> strList){
        List<String> list = strList
        .stream()
        .flatMap(s -> Arrays.stream(s.split("[ ,]")))
        .collect(Collectors.toList());
        System.out.println(list);
    }


    public void groupFlattenWords(List<String> strList){
        Map<String, Long> map = strList
        .stream()
        .flatMap(s -> Arrays.stream(s.split("[ ,]")))
        .collect(Collectors.groupingBy(s->s, TreeMap::new, Collectors.counting()));
        System.out.println(map);
          
    }

    public void groupEmployee(List<Employee> empList){
        
    Map<String, List<Employee>> groupedEmployees =
            empList.stream()
                   .collect(Collectors.groupingBy(emp-> emp.name));
    System.out.println(groupedEmployees);
    }
}
