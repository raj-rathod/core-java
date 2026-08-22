package exceptions;

public class MailInvalidException extends RuntimeException {// unchecked exception
      public MailInvalidException(String message){
        super(message);
      } 
}
