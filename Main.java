import java.util.*;

import equals_hash_code.Student;

public class Main {
    public static void main(String[] arg) {
        Student s1 = new Student(1, "Rajesh", 28);
        Student s2 = new Student(1,"Rajesh", 29);
        System.out.println("S1 and S2 are Equals ?: "+ s1.equals(s2));
        System.out.println("HashCode for s1: "+ s1.hashCode());
        System.out.println("HashCode for s2: "+ s2.hashCode());

        Map<Student, String> map = new HashMap<>();
        Set<Student> set = new HashSet<>();
        map.put(s1, "Developer");
        map.put(s2, "Acountant");

        System.out.println("Size of the map: "+ map.size() + map);

        set.add(s1);
        set.add(s2);

        System.out.println("Size of the set: "+ set.size()+ set);
    }
  
}
