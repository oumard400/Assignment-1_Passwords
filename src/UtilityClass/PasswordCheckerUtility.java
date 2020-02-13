package UtilityClass;

import java.util.ArrayList;

import Exceptions.InvalidSequenceException;
import Exceptions.LengthException;
import Exceptions.NoDigitException;
import Exceptions.NoLowerAlphaException;
import Exceptions.NoUpperAlphaException;
/**
 * Create an application that will check for valid passwords.
 * @author Oumar Diallo
 *
 */
public class PasswordCheckerUtility {

	public PasswordCheckerUtility() {}


	/**
	 * 
	 * Determines whether a password is valid or not.
	 * @param passwordString: the password passed by user input.
	 * @return password validity
	 * @throws LengthException: the given password is less than 6 characters.
	 * @throws NoDigitException: the given password has no digits.
	 * @throws NoUpperAlphaException: the given password has no uppercase 
	 * characters.
	 * @throws NoLowerAlphaException: the given password has no lowercase 
	 * characters.
	 * @throws InvalidSequenceException: the given password has more than 
	 * 2 characters in sequence.
	 */
	
	public static boolean isValidPassword(String passwordString)
			throws LengthException, NoDigitException, NoUpperAlphaException, 
			NoLowerAlphaException, InvalidSequenceException {
		if (passwordString.length() < 6) {
			throw new LengthException();
		}

		for (int i = 0; i < passwordString.length(); i++) {
			if (!Character.isDigit(passwordString.charAt(i))) {
				if (i == passwordString.length() - 1) {
					throw new NoDigitException();
				}
			} 
			else {
				break;
			}
		}

		for (int i = 0; i < passwordString.length(); i++) {
			if (!Character.isUpperCase(passwordString.charAt(i))) {
				if (i == passwordString.length() - 1) {
					throw new NoUpperAlphaException();
				}
			} 
			else {
				break;
			}
		}

		for (int i = 0; i < passwordString.length(); i++) {
			if (!Character.isLowerCase(passwordString.charAt(i))) {
				if (i == passwordString.length() - 1) {
					throw new NoLowerAlphaException();
				}
			} 
			else {
				break;
			}
		}

		int length = passwordString.length();

		for (int i = 0; i < length; i++) {
			if ((i + 1 < length) && (i + 2 < length)) {
				if ((passwordString.charAt(i) == passwordString.charAt(i + 1))
						&& (passwordString.charAt(i + 1) == passwordString.charAt(i + 2))) {
					throw new InvalidSequenceException();
				}
			}
		}
		return true;
	}

	/**
	 * Determines whether a password is weak or not.
	 * @param passwordString the password passed by user input.
	 * @return whether the given password is weak or not.
	 */
	public static boolean isWeakPassword(String passwordString) {
		return (passwordString.length() >= 6) && (passwordString.length() <= 9);
	}

	/**
	 * This static method is responsible for validating passwords
	 * from a password and returning invalid password with exception messages.
	 * @param passwords the array list of password to be validated obtained 
	 * from a file.
	 * @return invalid passwords with their respective exception message.
	 */
	public static ArrayList<String> validPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPassword = new ArrayList<>();

		for (String password : passwords) {
			try {
				isValidPassword(password);
			} catch (Exception exception) {
				invalidPassword.add(password + " " + exception.getMessage() + "\n");
			}
		}

		return invalidPassword;
	}
}