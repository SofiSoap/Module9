import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.io.FileInputStream;

/**
 * 
 * @author Sophia
 *
 */

public class Module7 {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	
	public static void main(String[] args) throws  IOException {
		

		TreeMap<String, Integer> wordTree = new TreeMap<>(Collections.reverseOrder());
		
		wordTree = countWords("text.txt");

		// flip
		// *****************************************************************************

		Set<Entry<String, Integer>> entries = wordTree.entrySet();

		Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
				Integer v1 = e1.getValue();
				Integer v2 = e2.getValue();
				return v2.compareTo(v1);

			}
		};

		// we will need a list
		List<Entry<String, Integer>> wordTree2List = new ArrayList<Entry<String, Integer>>(entries);

		// sort
		Collections.sort(wordTree2List, valueComparator);

		LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(wordTree2List.size());

		// copy
		for (Entry<String, Integer> entry : wordTree2List) {
			sortedByValue.put(entry.getKey(), entry.getValue());
		}
		
		printWords(sortedByValue);
		
		
	}
	//END OF MAIN*******************************************************************************************************************************

	/**
	 * 
	 * @return correctedWord, with no UpperCase or Special Values 
	 */
	public static String correctWord(String word) {
		String correctedWord = "";
		
		correctedWord = word.toLowerCase().
				replaceAll("\\!", " "). 
				replaceAll("\\”", "")
				.replaceAll("\\“", "");
		
		return correctedWord;
	} 
	
	/**
	 * 
	 * @param textDocument
	 * @return
	 * @throws IOException
	 */
	public static TreeMap<String, Integer> countWords(String txtFile) throws  IOException{ 
		
		FileInputStream fin = new FileInputStream(txtFile); 
		Scanner fileInput = new Scanner(fin);

		// We need the key to be the string that is how we are identifying it
		TreeMap<String, Integer> wordTree = new TreeMap<>(Collections.reverseOrder());

		while (fileInput.hasNext()) {
			String nextWord = fileInput.next(); 					

			nextWord = correctWord(nextWord);

			if (wordTree.containsKey(nextWord)) {
				wordTree.put(nextWord, wordTree.get(nextWord) + 1); // increase associated key's(string)'s value

				// wordFromFille (KEY IS WORD, SECOND IS FREQUENCY)
				// map.put(key, map.get(key) + 1);
			} else {
				wordTree.put(nextWord, 1); // put value in tree
				// increase associated key's(string)'s value
			}
		}
		
		//close
		fileInput.close();
		fin.close();
		
		return wordTree;
	}
	
	/**
	 * 
	 * @param sortedByValue
	 * @throws IOException
	 */
	
	public static void printWords(LinkedHashMap<String, Integer> sortedByValue) throws  IOException{ 
		
		System.out.println("Top 20 most common words: ");
		System.out.println(" ");
		Set<Entry<String, Integer>> wordsSortedByValue = sortedByValue.entrySet();

		int j = 0;
		int k = 1;
		for (Entry<String, Integer> mapping : wordsSortedByValue) {

			if (j <= 19) {
				System.out.print(k + ".");
				System.out.println(mapping.getKey() + "\t:" + mapping.getValue());
			} else {
				break;
			}
			k++;
			j++;
		}
		
	}

}
