package Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import Interface.ConcordanceDataStructureInterface;

/**
 * @author Oumar Diallo
 */
public class ConcordanceDataStructure implements ConcordanceDataStructureInterface {

	private LinkedList<ConcordanceDataElement>[] concordanceTable;

	/**
	 * @param size size of the concordance table
	 */
	@SuppressWarnings("unchecked")
	public ConcordanceDataStructure(int size) {

		boolean num = false;
		boolean aprimeNum = false;
		int primeNum, divisor, div;
		primeNum = (int)(size / 1.5);

		if(primeNum % 2 == 0) {
			primeNum = primeNum +1;
		}

		while(num == false) {

			while(aprimeNum == false) {

				divisor = (int)(Math.sqrt(primeNum) + 0.5);

				for(div = divisor; div > 1; div--) { 

					if(primeNum % div == 0)
						break;
				}
				if(div != 1) {
					primeNum = primeNum + 2;	
				}
				else
					aprimeNum = true;
			} 
			if((primeNum - 3) % 4 == 0) {
				num = true;
			}
			else {  
				primeNum = primeNum + 2;
				aprimeNum = false;
			}
		} 

		concordanceTable = new LinkedList[primeNum];

		for (int i = 0; i < concordanceTable.length; i++){
			concordanceTable[i] = new LinkedList<>();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ConcordanceDataStructure(String testing, int size) {
		
		concordanceTable = new LinkedList[size];
		
		for (int i = 0; i < concordanceTable.length; i++){
			concordanceTable[i] = new LinkedList<>();
		}
	}

	@Override
	public int getTableSize() {
		
		return concordanceTable.length;
	}

	@Override
	public ArrayList<String> getWords(int index) {
		
		ArrayList<String> wordList = new ArrayList<>();
		
		for (ConcordanceDataElement e : concordanceTable[index]) {
			wordList.add(e.getWord());
		}		
		return wordList;
	}

	@Override
	public ArrayList<LinkedList<Integer>> getPageNumbers(int index) {
		
		ArrayList<LinkedList<Integer>> pageNumbers = new ArrayList<>();
		
		for (ConcordanceDataElement e : concordanceTable[index]) {
			pageNumbers.add(e.getList());
		}
		return pageNumbers;
	}

	@Override
	public void add(String word, int lineNum) {
		
		ConcordanceDataElement element = new ConcordanceDataElement(word);
		
		int hashId = Math.abs(element.hashCode() % concordanceTable.length), i;
		boolean contains = false;
		
		for (i = 0; i < concordanceTable[hashId].size(); i++) {
			
			if (concordanceTable[hashId].get(i)
					.getWord().equalsIgnoreCase(word)) {
				
				contains = true;
				break;
			}   
		}

		if (contains) {
			
			concordanceTable[hashId].get(i).addPage(lineNum);
		}
		else {
			element.addPage(lineNum);
			concordanceTable[hashId].add(element);
		}

	}

	@Override
	public ArrayList<String> showAll() {
		
		ArrayList<String> concordanceList = new ArrayList<>();
		
		for (LinkedList<ConcordanceDataElement> list : concordanceTable) {
			
			for (ConcordanceDataElement e : list) {
				concordanceList.add(e.toString());
			}
		}
		
		Collections.sort(concordanceList);
		
		for (int j = 0; j < concordanceList.size(); j++) {
			
			if (concordanceList.get(j).contains("'")) {
				
				String conList = concordanceList.get(j);
				
				concordanceList.set(j, concordanceList.get(j + 1));
				concordanceList.set(j + 1, conList);
				j++;
			}
		}
		return concordanceList;
	}
}
