package collections.set;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import oops.classes_object.Student;

public class SetOperation {
     public void sortedSet(Set<Integer> set){
        Set<Integer> sortedSet = new TreeSet<>(set);
        System.out.println("Sorted set using Tree set"+ sortedSet);
        Set<Integer> reverseSet = new TreeSet<>(Comparator.reverseOrder());
        reverseSet.addAll(set);
         System.out.println("Sorted set using Tree set in reverse order:-> "+ reverseSet);

        Set<Integer> streamSet = set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(streamSet);

     }

     public void sortStudentByName(Set<Student> set){
      Set<Student> sortedStudent = set.stream().sorted(Comparator.comparing(s-> s.name)).collect(Collectors.toCollection(LinkedHashSet::new));
      System.out.println(sortedStudent);
     }
}
