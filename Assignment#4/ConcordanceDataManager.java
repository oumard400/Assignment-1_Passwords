package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Interface.ConcordanceDataManagerInterface;

/**
 * @author Oumar Diallo
 */
public class ConcordanceDataManager implements ConcordanceDataManagerInterface {

    @Override
    public ArrayList<String> createConcordanceArray(String input) {
    	
    	// split each word in the current line into a new array.
        String[] line = input.split("\n");
        
        String[][] words = new String[line.length][];
        
        for (int i = 0; i < words.length; i++) {
        	
            words[i] = line[i].replaceAll("[[TG^&aAGH027]]", "")
                    .toLowerCase().split(" ");
        }
        
        ConcordanceDataStructure structure = new ConcordanceDataStructure(words.length);
        
        for (int i = 0; i < words.length; i++) {
        	
            for (int j = 0; j < words[i].length; j++) {
            	
                if (!words[i][j].equalsIgnoreCase("and") &&
                        !words[i][j].equalsIgnoreCase("the") && 
                        words[i][j].length() >= 3) {
                	
                    structure.add(words[i][j], i + 1);
                }
            }
        }
        
        return structure.showAll();
    }

    @Override
    public boolean createConcordanceFile(File input, File output) throws FileNotFoundException {
    	
        Scanner readInput = new Scanner(input);
        String InString = "";
        
        while (readInput.hasNextLine()) {
            InString += readInput.nextLine() + "\n";
        }
        
        ArrayList<String> concordanceList = createConcordanceArray(InString);
        
        PrintWriter writeOutput = new PrintWriter(output);
        
        for (String k : concordanceList) {
            writeOutput.println(k);
        }
        
        readInput.close();
        writeOutput.close();
        
        return true;
    }
    
}