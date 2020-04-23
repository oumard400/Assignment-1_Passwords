package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Oumar Diallo
 */
public class MorseCodeConverter {

	private static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * @param
	 * @return text converted into English
	 */
	public static String convertToEnglish(String text) {
		String english = "";
		String[] fullCode = text.split("/");
		String[][] codeSets = new String[fullCode.length][];

		for (int i = 0; i < codeSets.length; i++) {
			codeSets[i] = fullCode[i].split(" ");
		}

		for (int i = 0; i < codeSets.length; i++) {
			
			for (int j = 0; j < codeSets[i].length; j++) {
				codeSets[i][j] = tree.fetch(codeSets[i][j]);
				english += codeSets[i][j];
			}
			
			english += (i == codeSets.length - 1) ? "" : " ";
		}

		return english;
	}

	/**
	 * @param
	 * @return text converted into English
	 */
	public static String convertToEnglish(File selectedFile) throws FileNotFoundException{

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(selectedFile);
		String text = "";

		while (sc.hasNextLine()) {
			text += sc.nextLine();
		}
		
		return convertToEnglish(text);
	}

	/**
	 * @return string representation of tree
	 */
	public static String printTree() {
		
		String treeString = "";
		
		for (String t : tree.toArrayList()) {
			treeString += t + " ";
		}
		
		return treeString;
	}
	
}