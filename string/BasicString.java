package string;

public class BasicString {
    String str;
    public BasicString(String str){
        this.str = str;
    }

    public void show(){
        System.out.println("Enter String Lenght: " + this.str.length());
        System.out.println("Array of string characters: "+ this.str.toCharArray().toString());
        System.out.println("UpperCase Of given string: "+ this.str.toUpperCase());
        System.out.println("LowerCase Of given string: "+ this.str.toLowerCase());
        System.out.println("Is String is Empty: "+ this.str.isEmpty());
        System.out.println("Is String Blank: "+ this.str.isBlank());
    }

    public void subString(int s, int e){
        if(s> this.str.length() || e<1){
            System.out.println("substring npt possible");
        }else{
            System.out.println("Substring is : "+ this.str.substring(s,e));
        }
    }

    public void startWith(String s){
        System.out.println("Is String start with "+ s +" : "+ this.str.startsWith(s));
    }

    public void endWith(String s){
        System.out.println("Is String end with "+ s +" : "+ this.str.endsWith(s));
    }

    public void reverseString(){
        String reverse = new StringBuilder(this.str).reverse().toString();
        System.out.println("Reverse of given String: "+ reverse);
    }

    public void charAt(int index){
        if(index>= this.str.length()){
            System.out.println("Index out of bound");
        }else{
            System.out.println("Character at "+ index + " : "+ this.str.charAt(index) );
        }
    }

    public void substringCheck(String str){
        System.out.println("Is Substring "+ str + " is present in "+ this.str + " : "+ this.str.contains(str));
    }

    public void indexOfChar(char ch){
        System.out.println("Index of given character "+ ch+ "is :"+ this.str.indexOf(ch));
    }
}
