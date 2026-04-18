package collections.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapPractice {
    public void sortByXor(int k, int n){
        List<Integer> arr = new ArrayList<>();

        Map<Integer, Integer> treeMap = new TreeMap<>();
        String result = "";
        for(int i=0;i<n;i++){
            int random = (int)(Math.random()*100);
            arr.add(random);
        }


        for(int el:arr){
            int xor = el^k;
            if(treeMap.containsKey(xor)){
                treeMap.put(el,el);
            }else{
                treeMap.put(xor, el);
            }
        }

        for(Map.Entry<Integer, Integer> el: treeMap.entrySet()){
           result+= el.getValue()+" ";
        }



        System.out.println(result);

    } 
}
