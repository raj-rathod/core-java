package stream;
import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    List<String> subjects;

    Student(String name, List<String> subjects) {
        this.name = name;
        this.subjects = subjects;
    }
}

class Item {
    String name;
    int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    int id;
    int amount;
    List<Item> items;

    Order(int id, int amount, List<Item> items) {
        this.id = id;
        this.amount = amount;
        this.items = items;
    }
}

public class FlatMapPractice {
    List<List<Integer>> nestedNumbers = List.of(
    List.of(1, 2),
    List.of(3, 4),
    List.of(5, 6)
    );

    List<Student> students = List.of(
        new Student("Raj", List.of("Math", "Science")),
        new Student("Amit", List.of("English", "Math")),
        new Student("Neha", List.of("Science", "English"))
    );

    Map<String, List<Integer>> mapData = Map.of(
        "A", List.of(1, 2),
        "B", List.of(3, 4),
        "C", List.of(5, 6)
    );

    List<Order> orders = List.of(
        new Order(1, 6000, List.of(
            new Item("Laptop", 50000),
            new Item("Mouse", 500)
        )),
        new Order(2, 3000, List.of(
            new Item("Keyboard", 1500),
            new Item("Mouse", 500)
        )),
        new Order(3, 8000, List.of(
            new Item("Laptop", 50000),
            new Item("Headphone", 2000)
        ))
    );

    List<String> words = List.of("java", "stream", "api");

    public void flattenNestedNumbers(){
        List<Integer> flattenNumbers = this.nestedNumbers.stream()
        .flatMap(List::stream)
        .toList();

        System.out.println("Faltten List: "+ flattenNumbers);
    }

    public void nestedListSum(){
        double sum = this.nestedNumbers.stream()
        .flatMap(List::stream)
        .reduce(0, (a,b)-> a+b);

        System.out.println("Sum of nested List: "+sum);
    }

    public void allSubjects(){
        List<String> subjects = this.students.stream()
        .flatMap( student -> student.subjects.stream())
        .toList();

        System.out.println("All Subjects: " +subjects);
    }

    public void allUniqueSubjects(){
        List<String> subjects = this.students.stream()
        .flatMap( student -> student.subjects.stream())
        .distinct()
        .toList();

        System.out.println("All Unique Subjects: " +subjects);
    }

    public void countSubjects(){
       Map<String, Long> subjects = this.students.stream()
        .flatMap( student -> student.subjects.stream())
        .collect(Collectors.groupingBy(
            s->s,
            Collectors.counting()
        ));

        System.out.println("Subject count: " +subjects); 
    }


    public void convertWordsToCharacter(){
        List<Character> list = this.words.stream()
        .flatMap(word -> word.chars().mapToObj( c -> (char)c))
        .toList();

        System.out.println(list);
    }

    public void findAllUniqiueCharacter(){
        List<Character> list = this.words.stream()
        .flatMap(word -> word.chars().mapToObj( c -> (char)c))
        .distinct()
        .toList();

        System.out.println("All Unique Characters: "+list);
    }

    public void findFrequencyOfAllCharacters(){
        Map<Character, Long> list = this.words.stream()
        .flatMap(word -> word.chars().mapToObj( c -> (char)c))
         .collect(Collectors.groupingBy(
            ch->ch,
            Collectors.counting()
        ));

        System.out.println("All Unique Characters: "+list);
    }



    public void findAllItemsFromOrders(){
        List<String> list = this.orders.stream()
        .flatMap(order -> order.items.stream())
        .map(item -> item.name)
        .toList();

        System.out.println("All items name: "+ list);
    }

    public void findAllItemsCountFromOrders(){
        long count = this.orders.stream()
        .flatMap(order -> order.items.stream())
        .count();

        System.out.println("Count of all items: "+ count);
    }


    public void findAllUniqueItemsFromOrders(){
        List<String> list = this.orders.stream()
        .flatMap(order -> order.items.stream())
        .map(item -> item.name)
        .distinct()
        .toList();

        System.out.println("All Unique items name: "+ list);
    }


      public void findFrequencyAllItems(){
        Map<String, Long> list = this.orders.stream()
        .flatMap(order -> order.items.stream())
         .collect(Collectors.groupingBy(
            ch->ch.name,
            Collectors.counting()
        ));

        System.out.println("All items Frequency: "+list);
    }


    public void findMostExpensiveItem(){
        Optional<Item> item = this.orders.stream()
        .flatMap(order -> order.items.stream())
        .max(Comparator.comparing(i -> i.price));

        item.ifPresent(i -> System.out.println("Most expensive item is: "+ i.name));
    }

    public void totalRevenueFromOrders(){
        double totalRevenue = this.orders.stream()
        .flatMap(order -> order.items.stream())
        .map(item -> item.price)
        .reduce(0, (a,b)-> a+ b);

        System.out.println("Total Revenue form the orders: "+ totalRevenue);
    }

    public void cartesianProduct() {
    List<Integer> list1 = List.of(1, 2);
    List<String> list2 = List.of("A", "B");

    List<String> result = list1.stream()
        .flatMap(i -> list2.stream()
            .map(j -> i + j)
        )
        .toList();

    System.out.println(result);
}






}
