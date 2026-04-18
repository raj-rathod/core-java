package collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetPractice {
    public void setMethodPractice(){
        Set<Integer> set  = new HashSet<>();
        Set<Integer> set2  = new HashSet<>();
        for(int i=0; i<6;i++){
            int random = (int)(Math.random()*10+1);
            set.add(random);
            set2.add(i);
        }
        
        System.out.println("Set: "+ set);
        System.out.println("Set2: "+ set2);
        set.addAll(set2);
        System.out.println("Union of Sets: "+ set);

    }


    public void treeSetMethods(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0; i<6;i++){
            int random = (int)(Math.random()*100+1);
            treeSet.add(random);
        }

        System.out.println("Tree Set: "+ treeSet);

        System.out.println("First: "+ treeSet.first()+","+ treeSet.getFirst());
        System.out.println("First: "+ treeSet.last()+","+ treeSet.getLast());

    }
}
