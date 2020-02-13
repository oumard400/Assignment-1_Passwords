package Exceptions;

@SuppressWarnings("serial")
public class InvalidSequenceException extends Exception {
  
   /**
   * Constructor that will take in a message, which will be displayed if InvalidSequenceException is thrown.
   */
   public InvalidSequenceException()
   {  
       super("The password cannot contain more than two of the same character in sequence");  
   }
}