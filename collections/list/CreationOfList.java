package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import oops.classes_object.Product;

public class CreationOfList {
    public <T> List<T> createList(T[] arr){
        return Arrays.asList(arr);
    }

    public List<Integer> createList(int[] arr){
       return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public List<String> createList(String[] arr){
     List<String> strList = new ArrayList<>();
     for(String str: arr){
        strList.add(str);
     }
     return strList;
    }

    public void sortProductUsingComparable(){
        List<Product> products = new ArrayList<>();

        products.add(new Product(1,"a", 1300));
        products.add(new Product(2,"b", 4000));
        products.add(new Product(3,"c", 500));
        products.add(new Product(4,"d", 1600));
        products.add(new Product(5,"e", 3700));
        products.add(new Product(6,"f", 2800));

       // Collections.sort(products); //comparable
       //products.sort(Comparator.comparingDouble(Product:: getPrice)); // comparator
       // stream version
        products = products.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).toList();
        System.out.println("Sorted products: "+ products);
       //Optional<Product> product = products.stream().min(Comparator.comparingDouble(Product::getPrice));
       //product.ifPresent(e-> System.out.println("Minimum Order: "+e));
    }
}
