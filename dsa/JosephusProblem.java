package dsa;
// The Josephus problem is a classical mathematical and algorithmic puzzle that models a 
// circular elimination process. It asks which position in a circle of n participants ensures 
// survival when every k-th person is removed sequentially until only one remains. 
// The problem illustrates recursion, modular arithmetic, and cyclic data structures.

import java.util.*;

public class JosephusProblem {
    // n is represent the size of the circle and k is the step to remove on each time.
    public void lastSurvivalInCircle(int n, int k){
        List<Integer> list = new LinkedList<>();

        for(int i=1; i<=n; i++){
            list.add(i);
        }

        int index = 0;

        while(list.size() > 1){
            index = (index+(k-1))% list.size();

            list.remove(index);

            System.out.println(list);
        }

        System.out.println("Last survival: " + list.get(0));
    }

}
