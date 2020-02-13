package JunitTests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Exceptions.InvalidSequenceException;
import Exceptions.LengthException;
import Exceptions.NoDigitException;
import Exceptions.NoLowerAlphaException;
import Exceptions.NoUpperAlphaException;
import UtilityClass.PasswordCheckerUtility;

import static org.junit.Assert.*;

public class PasswordCheckerSTUDENT_Test {
    
    ArrayList<String> passwords;
    
    
    @Before
    public void setUp() throws Exception {
        String[] passwordStrings = {"cHnccut23", "pfhd9cy82jfrr", "EQx7b",
            "stJUkPveae", "eKgsssK8q7", "W5CK9LXG", "7YNMdbRQh6"};
        
        passwords = new ArrayList<>(Arrays.asList(passwordStrings));
    }
    
    @After
    public void tearDown() throws Exception {
        passwords = null;
    }

    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testIsValidPasswordInvalidSequence() {
        try {
            PasswordCheckerUtility.isValidPassword("Qxxx9Lb3q3");
            assertTrue("InvalidSequenceException isn't thrown", false);
        } catch (InvalidSequenceException e) {
            assertTrue("InvalidSequenceException successfully thrown", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Wrong exception is thrown", false);
        }
    }

    /**
     * Test if the password has at least one digit
     * One test should throw a NoDigitException
     */
    @Test
    public void testIsValidPasswordNoDigit() {
        try {
            PasswordCheckerUtility.isValidPassword("ksDIABoumar");
            assertTrue("NoDigitException isn't thrown", false);
        } catch (NoDigitException e) {
            assertTrue("NoDigitException successfully thrown", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Wrong exception thrown", false);
        }
    }

    /**
     * Test if the password has at least one lowercase alpha character
     * This test should throw a NoLowerAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoLowerAlpha() {
        try {
            PasswordCheckerUtility.isValidPassword("Z1T0LNDL2");
            assertTrue("NoLowerAlphaException isn't thrown", false);
        } catch (NoLowerAlphaException e) {
            assertTrue("NoLowerAlphaException successfully thrown", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Wrong exception thrown", false);
        }
    }

    /**
     * Test if the password has at least one uppercase alpha character
     * This test should throw a NoUpperAlphaException for second case
     */
    @Test
    public void testIsValidPasswordNoUpperAlpha() {
        try {
            PasswordCheckerUtility.isValidPassword("hiib7lakeu0kuzma");
            assertTrue("NoUpperAlphaException isn't thrown", false);
        } catch (NoUpperAlphaException e) {
            assertTrue("NoUpperAlphaException successfully thrown", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Wrong exception thrown", false);
        }
    }

    /**
     * Test correct passwords
     * This test should not throw an exception
     */
    @Test
    public void testIsValidPasswordSuccessful() {
        try {
            PasswordCheckerUtility.isValidPassword("HJpXN27Sfh");
            PasswordCheckerUtility.isValidPassword("8WQ7n9A4cE0");
            PasswordCheckerUtility.isValidPassword("TR3WAAYYCrYet");
            PasswordCheckerUtility.isValidPassword("rAUzE8008h6T");
            assertTrue("Valid password", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Unexpected exception thrown", false);
        }
    }

    /**
     * Test if the password is less than 8 characters long.
     * This test should throw a LengthException for second case.
     */
    @Test
    public void testIsValidPasswordTooShort() {
        try {
            PasswordCheckerUtility.isValidPassword("CaLc3");
            assertTrue("LengthException isn't thrown", false);
        } catch (LengthException e) {
            assertTrue("LengthException successfully thrown", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Wrong exception thrown", false);
        }
    }

    /**
     * Test if the password has more than 2 of the same character in sequence
     * This test should throw a InvalidSequenceException for second case
     */
    @Test
    public void testIsWeakPassword() {
        try {
            assertEquals(true, PasswordCheckerUtility.isValidPassword("Abcdef1"));
            assertTrue(PasswordCheckerUtility.isWeakPassword("Abcdef1"));
        } catch (Exception e) {
            assertTrue("Unexpected exception thrown: " + e.getMessage(), false);
        }
    }

    /**
     * Test the validPasswords method
     * Check the results of the ArrayList of Strings returned by the validPasswords method
     */
    @Test
    public void testValidPasswords() {
        ArrayList<String> results;
        results = PasswordCheckerUtility.validPasswords(passwords);
		
        //assertEquals(scan.nextLine(), " The password must contain at least 
        //one uppercase alphabetic character.");
        Scanner scan = new Scanner(results.get(0));
        assertEquals("pfhd9cy82jfrr", scan.next());
        String nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("uppercase"));
        
		//assertEquals(scan.nextLine(), " The password must contain at least 6 digits.");
        scan = new Scanner(results.get(1));    
        assertEquals("EQx7b", scan.next());
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("at least 6"));
        
		//assertEquals(scan.nextLine(), " The password must contain at least one digit.");
        scan = new Scanner(results.get(2));    
        assertEquals("stJUkPveae", scan.next());
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("digit"));
		
        //assertEquals(scan.nextLine(), " The password cannot contain more
        //than two of the same character in sequence.");
        scan = new Scanner(results.get(3));    
        assertEquals("eKgsssK8q7", scan.next());
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("more than two"));
		
        //assertEquals(scan.nextLine(), " The password must contain at least 
        //one lowercase alphabetic character.");
        scan = new Scanner(results.get(4));    
        assertEquals("W5CK9LXG", scan.next());
        nextResults = scan.nextLine().toLowerCase();
        assertTrue(nextResults.contains("lowercase"));
    }
}
