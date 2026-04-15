package oops.classes_object;

public class Product implements Comparable<Product> {
    public int id;
    public String name;
    public double price;

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public Double getPrice(){
        return this.price;
    }

    @Override
    public int compareTo(Product o) {
       return Double.compare(this.price, o.price);
    }

    public String toString(){
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}