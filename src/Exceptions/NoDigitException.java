package Exceptions;

@SuppressWarnings("serial")
public class NoDigitException extends Exception {
  
   /**
   * Constructor that will take in a message, which will be displayed if NoDigitException is thrown.
   */
   public NoDigitException()
   {  
       super("The password must contain at least one digit");  
   }

}
