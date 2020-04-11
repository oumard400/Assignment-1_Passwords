package Data;

import java.util.LinkedList;

/**
 * This is the class representation of the concordance
 * @author Oumar Diallo
 */
public class ConcordanceDataElement {

	private String word;
	private LinkedList<Integer> list;

	/**
	 * @param word in text or file
	 */
	public ConcordanceDataElement(String word){
		
		this.word = word;
		
		list = new LinkedList<>();
	}

	/**
	 * @return word in text or file
	 */
	public String getWord() {
		
		return word;
	}

	/**
	 * @return pages or line numbers to find the word
	 */
	public LinkedList<Integer> getList() {
		
		return list;
	}

	// Add page to concordance element  
	public void addPage(int lineNum) {

		if (!list.contains(lineNum)){

			list.add(lineNum);
		}
	}

	/**
	 * @return word with page or line numbers
	 */
	public String toString(){

		String display;

		display = word + ": ";

		for(int i = 0; i < list.size(); i++){

			// add a "," after the page number up until before the last page number in the linked list. 
			if(i < list.size() - 1){

				display +=  list.get(i) + ", ";
			}
			// do not add a "," at the end of the last page number that will be displayed. 
			else{
				display +=  list.get(i) + "\n";
			}
		}

		return display;		
	}

	/**
	 * Compare current concordance element with another
	 */
	public int compareTo(ConcordanceDataElement element) {        
		throw new UnsupportedOperationException();
	}

	/**
	 * @return hash code of the word in concordance element
	 */
	@Override
	public int hashCode() {

		return word.hashCode();
	}
}