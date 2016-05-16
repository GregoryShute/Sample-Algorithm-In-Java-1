import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.lang.management.*;

//Resource I used to figure out how to time a methods execution:
//http://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java

public class AnagramFinderOp {
	
	public AnagramFinderOp(int tableSize) {	
	}

	public static void main(String[] args) throws IOException {
		
		//long startTime = System.nanoTime();
		File dict1 = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(dict1));
		String dictLine;
		int dictLength = dictCount(dict1);
		AnagramFinderOp aF = new AnagramFinderOp(dictLength);
		
		STreeOp sT = new STreeOp(dictLength);
		while((dictLine = br.readLine()) != null){
			String key = aF.alphabetCountingSort(dictLine);
			sT.insert(key, dictLine);
		}
		
		TableOp tableOp = sT.getT();
		tableOp.reclaimSpace();
		tableOp.printTable();
		
		br.close();
		long endTime = System.nanoTime();
	//	System.out.println(endTime-startTime); 
		
	}
	

	/*Returns the count of words in a dictionary File. 
	 *Run Complexity O(words) = O(n).
	 */
	public static int dictCount(File f) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(f));
		String dictLine;
		int dictLength = 0;
		while((dictLine = br.readLine()) != null){
			dictLength++;
		}
		br.close();
		return dictLength;
	}

	/*Returns the letters of a word in alphabetical order.
	 *Run Complexity O(w.length() + k) = O(w.length + 26).
	 *Worst case will be on the longest word in the dictionary.
	 */
	public String alphabetCountingSort(String w){
		int[] count = new int[26];
		for(int i = 0; i < w.length(); i++){
			count[w.charAt(i)-97]++;
		}
		for(int k = 1; k < 26; k++){
			count[k] = count[k-1] + count[k];
		}
		int[] alphabeticallySorted = new int[w.length()];
		for(int i = w.length() - 1; i >= 0; i--){
			int loc = (w.charAt(i)-97);
			count[loc]--;	
			alphabeticallySorted[count[loc]] = loc;
		}
		String alphabeticallySortedString = "";
		for(int i = 0; i < alphabeticallySorted.length; i++){
			int letter = alphabeticallySorted[i] + 97;
			alphabeticallySortedString = alphabeticallySortedString + (char)letter;
		}
		return alphabeticallySortedString;
	}
	
}
