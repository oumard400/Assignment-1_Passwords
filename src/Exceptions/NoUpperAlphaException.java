package Exceptions;

@SuppressWarnings("serial")
public class NoUpperAlphaException extends Exception {
  
   /**
   * Constructor that will take in a message, which will be displayed if NoUpperAlphaException is thrown.
   */
   public NoUpperAlphaException()
   {  
       super("The password must contain at least one uppercase alphabetic character");  
   }

}