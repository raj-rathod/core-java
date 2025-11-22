package oops.classes_object;

public class BasicClass {
    private int age;
    private String name;

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String toString(){
        return "Name "+this.name+"\n age "+ this.age;
    }
}
