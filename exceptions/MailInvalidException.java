package exceptions;

public class MailInvalidException extends RuntimeException {
      public MailInvalidException(String message){
        super(message);
      } 
}
