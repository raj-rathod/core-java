package stream;

import java.util.*;
import java.util.stream.Collectors;
import oops.classes_object.Employee;
import oops.classes_object.Transaction;

public class StreamAssignment {
    // Tasks:
    // Filter numbers greater than 10
    // Square each number
    // Sort ascending
    // Print result

    public void Task1(){
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 30);
        numbers.stream()
        .filter(x-> x>10)
        .map(x -> x*x)
        .sorted()
        .forEach(System.out::println);
    }

    // 🔹 Assignment 2: Even/Odd

    // 👉 Tasks:

    // Find all even numbers
    // Count odd numbers
    // Find first even number

    public void Task2(){
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 30, 7, 8);

        List<Integer> evenNumbers = numbers.stream()
        .filter(x-> x % 2 == 0)
        .collect(Collectors.toList());
        System.out.println("Even numbers: "+ evenNumbers);

        long countOddNumbers = numbers.stream()
        .filter(x-> x %2 !=0)
        .count();
        System.out.println("Odd count: "+ countOddNumbers);


        Optional<Integer> firstEven = numbers.stream()
        .filter(x-> x%2 ==0)
        .findFirst();

        firstEven.ifPresent(n-> System.out.println("First Even Number: "+n));

        //solution 2

        Map<Boolean, List<Integer>> result = numbers.stream()
        .collect(Collectors.partitioningBy(x-> x%2 == 0));

        List<Integer> evens = result.get(true);
        List<Integer> odds = result.get(false);

        System.out.println("Even Numbers: "+ evens);
        System.out.println("Count Odds: "+ odds.size());
        System.out.println("First Even Number:"+ (evens.isEmpty()? "None": evens.get(0)));
    }

    // 👉 Tasks:

    // Filter names starting with "A"
    // Convert to uppercase
    // Sort alphabetically
    // Collect into List
    public void Task3(){
        List<String> names = Arrays.asList("Raj", "Amit", "Ankit", "John", "Rahul", "Aman");
        List<String> result = names.stream()
        .filter(name -> name.startsWith("A"))
        .map(String::toUpperCase)
        .sorted()
        .collect(Collectors.toList());

        System.out.println("Result: "+ result);

    }

    // 👉 Tasks:

    // Find sum using reduce()
    // Find max number
    // Find min number

    public void Task4(){
        List<Integer> list = Arrays.asList(1,2,3,2,4,5,1,6);
        Long sum = list.stream()
        .reduce(0,(a,b)-> a+b)
        .longValue();
        System.out.println("Sum: "+ sum);

        Integer max = list.stream()
        .max(Integer::compareTo)
        .orElse(null);

        System.out.println("Max Value: "+ max);

        Integer min = list.stream()
        .min(Integer::compareTo)
        .orElse(null);

        System.out.println("Min Value:"+ min);
    }

    // 👉 Tasks:

    // Remove duplicates
    // Find duplicate elements
    // Count frequency of each number

    public void Task5(){
        List<Integer> list = Arrays.asList(1,2,3,2,4,5,1,6);

        List<Integer> result = list.stream()
        .distinct()
        .collect(Collectors.toList());

        System.out.println("Unique Numbers"+ result);

        Set<Integer> seen = new HashSet<>();

        List<Integer> duplicates = list.stream()
        .filter(x-> !seen.add(x))
        .collect(Collectors.toList());

        System.out.println("Duplicates: "+ duplicates);

        Map<Integer, Long> map = list.stream()
        .collect(Collectors.groupingBy(x->x, Collectors.counting()));

        System.out.println(map);
    }

    // class Employee {
    // int id;
    // String name;
    // double salary;
    // String department;
    // }

    // 👉 Tasks:

    // Sort by salary
    // Sort by name
    // Get top 3 highest salary employees

    public void Task6(){
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Rajesh", 100000, "IT"));
        employees.add(new Employee(2, "Rama", 112000, "IT"));
        employees.add(new Employee(3, "Neha", 50000, "HR"));
        employees.add(new Employee(4, "Ajay", 60000, "ACCOUNT"));
        employees.add(new Employee(5, "Shreya", 40000, "SALES"));
        employees.add(new Employee(6, "Afsha", 45000, "MARKET"));

        employees.stream()
        .sorted(Comparator.comparingDouble(Employee:: getSalary))
        .forEach(System.out::println);

        employees.stream()
        .sorted(Comparator.comparing(Employee:: getName))
        .forEach(System.out::println);

        employees.stream()
        .sorted(Comparator.comparingDouble(Employee:: getSalary).reversed())
        .limit(3)
        .forEach(System.out::println);
    }

    // 👉 Tasks:

    // Group employees by department
    // Count employees in each department
    // Find highest salary in each department

    public void Task7(){
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Rajesh", 100000, "IT"));
        employees.add(new Employee(2, "Rama", 112000, "IT"));
        employees.add(new Employee(3, "Neha", 50000, "HR"));
        employees.add(new Employee(4, "Ajay", 60000, "ACCOUNT"));
        employees.add(new Employee(5, "Shreya", 40000, "SALES"));
        employees.add(new Employee(6, "Afsha", 45000, "MARKET"));

        Map<String, List<String>> grouped =  employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getDeparment,
            Collectors.mapping(Employee:: getName, Collectors.toList())
        )
        );

        grouped.forEach((dept, list)->{
            System.out.println(dept+ "->"+ list);
        });


        Map<String, Long> groupCounting = employees.stream()
        .collect(Collectors.groupingBy(Employee:: getDeparment,
            Collectors.counting()
        ));

        groupCounting.forEach((dept, list)->{
            System.out.println(dept+ "->"+ list);
        });


        Map<String, Employee> maxSalaryByDept = employees.stream()
        .collect(Collectors.groupingBy(
            Employee:: getDeparment,
            Collectors.collectingAndThen(
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                Optional::get
            )
        ));

        maxSalaryByDept.forEach((dept, emp)->{
            System.out.println(dept + " -> "+ emp.getName()+" : "+ emp.getSalary());
        });


    }

    // 👉 Tasks:

    // Partition employees into:
    // salary > 50k
    // salary <= 50k

    public void Task8(){
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Rajesh", 100000, "IT"));
        employees.add(new Employee(2, "Rama", 112000, "IT"));
        employees.add(new Employee(3, "Neha", 50000, "HR"));
        employees.add(new Employee(4, "Ajay", 60000, "ACCOUNT"));
        employees.add(new Employee(5, "Shreya", 40000, "SALES"));
        employees.add(new Employee(6, "Afsha", 45000, "MARKET"));
        employees.add(new Employee(7, "Vikash", 15000, "MARKET"));

        Map<Boolean, List<Employee>> partitionMap = employees.stream()
        .collect(Collectors.partitioningBy(employee -> employee.getSalary()>50000));

        System.out.println("Result:"+ partitionMap.get(true));
    }

    // 👉 Tasks:

    // Flatten list
    // Convert all to uppercase
    // Collect into single list

    public void Task9(){
        List<List<String>> list = Arrays.asList(
            Arrays.asList("Java", "Spring"),
            Arrays.asList("Angular", "React"),
            Arrays.asList("Docker", "Kubernetes")
        );

        List<String> flattenList = list.stream()
        .flatMap(List::stream)
        .map(String::toUpperCase)
        .collect(Collectors.toList());

        System.out.println("Flattent List"+ flattenList);
    }

    // 👉 Tasks:

    // Count each word frequency

    public void Task10(){
        List<String> sentences = Arrays.asList(
            "Java is powerful",
            "Java is fast",
            "Streams are powerful"
        );

        Map<String, Long> map =  sentences.stream()
        .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
        .collect(Collectors.groupingBy(x->x, Collectors.counting()));

        System.out.println("Result: "+ map);
    }

    // 👉 Tasks:

    // Find all transactions in 2020 and sort by value
    // Get unique traders
    // Find highest transaction
    // Find total transaction value

    public void Task11(){
        List<Transaction> transactions = Arrays.asList(
            new Transaction("Rajesh", 2020, 20000),
            new Transaction("Rajesh", 2020, 20000),
            new Transaction("Rama", 2021, 60000),
            new Transaction("Rakesh", 2020, 10000),
            new Transaction("Raj", 2019, 2000),
            new Transaction("Ramesh", 2026, 20000),
            new Transaction("Akash", 2020, 20000)
        );

        List<Transaction> filterData = transactions.stream()
        .filter(transaction -> transaction.getYear() == 2020)
        .sorted(Comparator.comparingInt(Transaction::getValue))
        .collect(Collectors.toList());

        System.out.println("Transaction on 2020: "+filterData);

        List<String> uniqueTrader = transactions.stream()
        .map(Transaction::getTrader)
        .distinct()
        .collect(Collectors.toList());

        System.out.println("Unique Traders: "+ uniqueTrader);

        Optional<Transaction> highestTransaction = transactions.stream()
        .max(Comparator.comparingInt(Transaction::getValue));

        highestTransaction.ifPresent(x-> System.out.println("Highest Transaction: "+ x));

        Integer totalTransaction = transactions.stream()
        .map(Transaction::getValue)
        .reduce(0,(a,b)-> a+b);

        System.out.println("Total Transaction Value: "+ totalTransaction);
    }

  //Assignment 16: Anagram Grouping

  public void Task12(){
    List<String> words = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
    Map<String, List<String>> result = words.stream()
    .collect(Collectors.groupingBy(
        word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    ));

    List<List<String>> finalResult = new ArrayList<>(result.values());
    System.out.println("Final Results: "+ finalResult);
  }

    //   🚀 Challenge 1:

    //   Find longest string in list

    public void Task13(){
        List<String> list = Arrays.asList("Java", "is", "powerful","abcdefght");
        Optional<String> longestString = list.stream()
        .max(Comparator.comparingInt(String::length));

        longestString.ifPresent(str-> System.out.println("Longest String: "+ str));
    }

    // 🚀 Challenge 2:

    // Find first non-repeating character


    public void Task14(){
        String str = "swiss";

        String ch = Arrays.asList(str.split("")).stream()
        .collect(Collectors.groupingBy(chr -> chr, LinkedHashMap::new, Collectors.counting()))
        .entrySet()
        .stream()
        .filter(mp -> mp.getValue() == 1)
        .map(Map.Entry::getKey)
        .findFirst()
        .orElse(null);

        System.out.println("Non Repeating Character: "+ ch);
    }

    public void Task15(){
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 4);
        map.put("C", 30);

        Map<String, Integer> result = map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(),(e1, e2) -> e1, // merge function (important)
            LinkedHashMap::new));

        System.out.println("Sorted map: "+ result);
    }
}
