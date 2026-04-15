package collections.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Order {
    int id;
    int parentId;
    String name;
    List<Order> children;

    Order(int id, int parentId, String name){
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.children = new ArrayList<>();
    }
}

public class BuildTreeFromList {
    
    public void buildTree(){
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, 0, "name1"));
        orders.add(new Order(2, 0, "name2"));
        orders.add(new Order(3, 1, "name3"));
        orders.add(new Order(4, 1, "name4"));
        orders.add(new Order(5, 3, "name5"));
        orders.add(new Order(6, 3, "name6"));
        orders.add(new Order(7, 5, "name7"));

        List<Order> result =  ordermanupulation(orders);
        printTree(result);
    }

    public List<Order> ordermanupulation(List<Order> orders){
        Map<Integer, Order> map = new HashMap<>();

        List<Order> finalOrder = new ArrayList<>();

        for(Order order:orders){
            map.put(order.id, order);
        }

        orders.forEach(order -> {
            if(order.parentId == 0){
                finalOrder.add(order);
                
            }else{
                Order parent = map.get(order.parentId);
                if(parent != null){
                    parent.children.add(order);
                }
            }
        });

        return finalOrder;


    }


    public  void printTree(List<Order> orders) {
        for (Order order : orders) {
            printOrder(order, "", true);
        }
    }

    private static void printOrder(Order order, String prefix, boolean isLast) {
        System.out.println(prefix + (isLast ? "|__ " : "|-- ") + order.name);

        for (int i = 0; i < order.children.size(); i++) {
            boolean last = (i == order.children.size() - 1);
            printOrder(order.children.get(i), 
                    prefix + (isLast ? "    " : "|   "), 
                    last);
        }
    }
}
