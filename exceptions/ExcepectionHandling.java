package exceptions;

public class ExcepectionHandling {
    public void divide(int a, int b){
        try{
               int result = a/b;
               System.out.println(result); 
        } catch( Exception e){
            System.out.println(e);
        } finally {
           System.out.println("Finally block run !");
        }
    }


    public void addToCart(int n) throws OutOfStackException{
        if(n>4){
            throw new OutOfStackException(n +" Items not available now only "+ (n-2) + " Available");
        }
        System.out.println(n+ "Items added to the cart!");
    }


    public boolean isMailValid(String mail){
        if(mail == null || mail.length()<5){
          throw new MailInvalidException("Given mail is not valid: "+ mail);
        }

        return true;
    }
}
