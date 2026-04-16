package collections.fail_fast_fail_safe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastAndFailSafe {
    List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));
    List<Integer> list2 = new CopyOnWriteArrayList<>(List.of(1,2,3,4,5));


    public void failFast(){
        for(Integer el: list){
            if(el==3){
                //list.remove(el); // failed here 
            }

            //list.add(100);
        }

        list.forEach((el)->{
            if(el == 3){
                //list.remove(el); // failed here
            }
            System.out.println(el);
        });
    }

    public void failSafe(){
        Iterator<Integer> it = list.iterator();

        while(it.hasNext()){
            if(it.next() == 3){
                it.remove();
            }
        }
        System.out.println("List: "+ list);

        list.removeIf(el -> el==2);

        System.out.println("List: "+ list);

        list2.forEach((el)->{
            if(el == 3){
                list2.remove(el-1);
            }
        });

        System.out.println("List: "+ list2);
    }

}
