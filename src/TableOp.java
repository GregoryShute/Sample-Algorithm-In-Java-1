
public class TableOp {
	
	int[] t;
	String[] tableAnagrams;
	int lastindex; // this is just a quick patch for reclaiming space

	public TableOp(int height) {
		t = new int[height];
		tableAnagrams = new String[height];
	}
	//updates a location in the table of anagrams with the updated string of anagrams and the updated number
	//of anagrams at this location
	public void update(int location, String anagrams, int acount){
		tableAnagrams[location] = anagrams;
		t[location] = acount;
	}
	
	//Reclaims space by shortening the table
	public void reclaimSpace(){
		int i = 1;
		String[] tempTableAnagrams;
		while(tableAnagrams[i] != null){
			i++;
		}
		tempTableAnagrams = new String[i];
		for(int j = 0; j < i; j++){
			tempTableAnagrams[j] = tableAnagrams[j];
		}
		tableAnagrams = new String[i];
		for(int j = 0; j < i; j++){
			tableAnagrams[j] = tempTableAnagrams[j];
		}
		lastindex = i;
	}
	
	//prints the table
	public void printTable(){
		
		int i = 0; //changed to 1 for removal method
		//while(tableAnagrams[i] != null){
		while(i < lastindex){
			//if(t[i] > 1){
			if(t[i] >= 1){
				//uncomment this if you want to see how many anagrams are on each line
				//System.out.println(tableAnagrams[i] + ": " + t[i]);
				System.out.println(tableAnagrams[i]);
			}
			i++;
			
		}
		//System.out.println("classes: " + (i-1));
	}

}
