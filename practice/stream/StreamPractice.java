package practice.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice {
        
        
    List<Employee> employees = Arrays.asList(
        new Employee(1L, "Raj", "IT", 80000, 28, "Delhi"),
        new Employee(2L, "Amit", "HR", 50000, 35, "Mumbai"),
        new Employee(3L, "Neha", "IT", 90000, 30, "Delhi"),
        new Employee(4L, "Priya", "Finance", 70000, 32, "Pune"),
        new Employee(5L, "Vikas", "IT", 120000, 40, "Bangalore"),
        new Employee(6L, "Ankit", "HR", 55000, 29, "Mumbai"),
        new Employee(7L, "Rohit", "Finance", 85000, 38, "Pune")
    );

    List<String> words = Arrays.asList("java", "spring", "boot", "java", "stream");
    List<List<Integer>> numbers = Arrays.asList(
        Arrays.asList(1,2,3),
        Arrays.asList(4,5,6),
        Arrays.asList(7,8,9)
    );

    
    // 1. Find all employees from IT department.
    public List<Employee> task1() {
        return employees.stream().filter( emp -> emp.getDepartment() == "IT").collect(Collectors.toList());
    }

    public List<String> task2(){
        return employees.stream().map(Employee::getName).collect(Collectors.toList());
    }

    public Long task3(){
        return employees.stream().filter(emp -> emp.getDepartment() == "HR").count();
    }

    public Optional<Employee> task4(){
        return employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
    }

    public Optional<Employee> task5(){
        return employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
    }


    public List<String> task6(){
        return employees.stream().map(emp -> emp.getName().toUpperCase()).collect(Collectors.toList());
    }

    public List<Employee> task7() {
        return employees.stream().filter( emp -> emp.getSalary() > 80000).collect(Collectors.toList());
    }

    public List<Employee> task8() {
        return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary))
        .collect(Collectors.toList());
    }

    public List<Employee> task9() {
        return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
        .collect(Collectors.toList());
    }

    public Optional<Employee> task10(){
        return employees.stream().filter(emp -> emp.getCity() == "Delhi").findFirst();
    }

    // level 2

    // 11. Group employees by department.

    public Map<String, List<Employee>> task11(){

        return employees.stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
    }

    // 12. Count employees in each department.

    public Map<String, Long> task12(){

        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    // 13. Average salary department-wise.

    public Map<String, Double> task13(){

        return employees.stream()
        .collect(
            Collectors.groupingBy(
                Employee::getDepartment, 
                Collectors.averagingDouble(Employee::getSalary)
            )
        );
    }

    // 14. Find highest-paid employee in each department.
    public Map<String, Optional<Employee>> task14(){

        return employees.stream()
        .collect(
            Collectors.groupingBy(
                Employee::getDepartment, 
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
            )
        );
    }

    // 15. Find total salary expense.

    public Double task15(){
        return employees.stream().reduce(0.0, (sum, employee) -> sum + employee.getSalary(), Double::sum);
    }

    // 16. Find average age of employees.

    public Double task16(){
        return employees.stream()
        .mapToInt(Employee::getAge)
        .average()
        .orElse(0.0);
    }

    // bonus question, asked by client in CI round. max age employee

    public Optional<Employee> taskBonus(){
        return employees.stream().max(Comparator.comparingInt(Employee::getAge));
    }

    // 17. Partition employees based on salary > 80000.

    public Map<Boolean, List<Employee>> task17(){
       return employees.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary()>80000));
    }

    //18. Find second-highest salary employee.

    public Employee task18(){
        return employees.stream()
        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
        .skip(1)
        .findFirst()
        .orElse(null);
    }

    // 19. Get unique cities.

    public Set<String> task19(){
        return employees.stream()
        .map(Employee::getCity)
        .collect(Collectors.toSet());
    }

    //20. Find employees older than 30 and sort by age.

    public List<Employee> task20(){
        return employees.stream()
        .filter(emp -> emp.getAge()>30)
        .sorted(Comparator.comparingInt(Employee::getAge))
        .toList();
    }

    // Level 3: Advanced Streams

    // 21. Department with highest average salary.

    public String task21(){
        return employees.stream()
        .collect(
            Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            )
        )
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse(null);
    }

    // 22. Find top 3 highest-paid employees.

    public List<Employee> task22(){
        return employees.stream()
        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
        .limit(3)
        .toList();

    }

    // 23. Find employees grouped by city and department.

    public Map<String, Map<String, List<Employee>>> task23() {
        return employees.stream()
        .collect(
            Collectors.groupingBy(
                Employee::getCity,
                Collectors.groupingBy(Employee::getDepartment,
                      Collectors.toList()
                )
            )
        );
    }

    // 24. Convert employee list into map using ID as key.
    public Map<Long, Employee> task24(){
        return employees.stream().collect(
            Collectors.toMap(
                Employee::getId,
                Function.identity()
            )
        );
    }

    // 26. Join all employee names using comma.

    public String task26(){
        return employees.stream().map(
            Employee::getName
        ).collect(Collectors.joining(", "));
    }

    // 28. Find youngest employee in each department.

    public Map<String, Employee> task28(){
        return employees.stream().collect(
            Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                    Collectors.minBy(Comparator.comparingInt(Employee::getAge)),
                    Optional::get
                )
            )
        
        );
    }

    //29. Find employees whose name starts with "R".

    public List<Employee> task29(){
        return employees.stream()
        .filter(emp-> emp.getName().startsWith("R"))
        .toList();
    }

    // 30. Check if all employees have salary greater than 40,000.

    public boolean task30(){
        return employees.stream().allMatch(emp -> emp.getSalary() > 40000);
    }

    // 31. Find frequency of each city.

    public Map<String, Long> task31(){
        return employees.stream()
        .collect(
            Collectors.groupingBy(
                Employee::getCity,
                Collectors.counting()
            )
        );
    }

    // 34. Find employees earning above department average.

    public List<Employee> task34(){
        Map<String, Double> deptAvg = employees.stream()
        .collect(
            Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            )
        );

        return employees.stream()
        .filter(emp -> emp.getSalary() > deptAvg.get(emp.getDepartment()))
        .toList();
    }

    // 35. Find department having maximum employees.
    public String task35(){
        return employees.stream()
        .collect(
                Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.counting()
                )
        )
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse(null);

    }

    // 36. Find employee names sorted by length.
    
    public List<String> task36(){
        return employees.stream()
        .map(Employee::getName)
        .sorted(Comparator.comparingInt(String::length))
        .toList();
    }

    // 37. Find longest employee name.

     public Optional<String> task37(){
        return employees.stream().map(Employee::getName)
        .max(Comparator.comparingInt(String::length));
    }

    // 40. Convert List<Employee> to

    public Map<String, List<String>> task40(){
        return employees.stream().collect(
            Collectors.groupingBy(
                Employee:: getDepartment,
                Collectors.mapping(
                        Employee::getName,
                        Collectors.toList()
                )
            )
        );
    }

//     Bonus Assignment (Most Asked in Interviews)
// Given
// List<String> words =
//  Arrays.asList("java", "spring", "boot", "java", "stream");

// 41. Find duplicate words.
public List<String> task41(){
    Set<String> set = new HashSet<>();
    return words.stream().filter(word -> !set.add(word)).toList();
}
// 42. Count frequency of each word.

public Map<String, Long> task42() {
   return words.stream().collect(Collectors.groupingBy(
        Function.identity(),
        Collectors.counting()
    )
   );
}

// 43. Find first non-repeated word.

public String task43(){
    return words.stream().collect(Collectors.groupingBy(
        Function.identity(),
        LinkedHashMap::new,
        Collectors.counting()
    )
   ).entrySet()
   .stream()
   .filter(map -> map.getValue() == 1)
   .map(Map.Entry::getKey)
   .findFirst()
   .orElse(null);
}

// 44. Find first repeated word.
public String task44(){
    return words.stream().collect(Collectors.groupingBy(
        Function.identity(),
        LinkedHashMap::new,
        Collectors.counting()
    )
   ).entrySet()
   .stream()
   .filter(map -> map.getValue() >1)
   .map(Map.Entry::getKey)
   .findFirst()
   .orElse(null);
}
// 45. Find longest word.
public String task45(){
    return words.stream().reduce((word1, word2) -> word1.length() > word2.length()? word1: word2)
    .orElse(null);
}
// 46. Sort words by length.// easy

// 47. Find character frequency in a string.

public Map<Character, Long> task47(String str){
    return str.chars().mapToObj(ch -> (char)ch).collect(Collectors.groupingBy(
        Function.identity(),
        Collectors.counting()
    ));
}

// 48. Flatten list using flatMap.

public List<Integer> task48(){
    return numbers.stream().flatMap(List::stream).toList();
}

// 49. Sum all numbers using streams.

public Integer task49(){
    return numbers.stream().flatMap(List::stream).reduce(Integer::sum).orElse(null);
}

// 50. Find all even numbers after flattening.

public Map<Boolean, List<Integer>> task50(){
    return numbers.stream().flatMap(List::stream).collect(Collectors.partitioningBy(num -> num%2 == 0));
}
// 51. second highest salary in each department.
public Map<String, Employee> task51(){
   return employees.stream().collect(
    Collectors.groupingBy(
        Employee::getDepartment,
        Collectors.collectingAndThen(
            Collectors.toList(),
            list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .skip(1).findFirst().orElse(null)
        )
        )
    );
}

}
