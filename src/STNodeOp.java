
public class STNodeOp {

	//the position this node takes in our table
	int nodeNumber;
	//the number of anagrams contained in this node
	int anagramsCount = 0;
	//the array of nodes this node may lead to
	boolean d[];
	//the array of nodes this leads to
	STNodeOp[] nodes;
	//list of anagrams
	String anagrams;
	
	public STNodeOp(int nodeNumber) {
		this.nodeNumber = nodeNumber;
		//should default to false on creation
		d = new boolean[26];
		nodes = new STNodeOp[26];
		anagrams = "";
	}
	
	public int getAnagramsCount() {
		return anagramsCount;
	}

	public void incrAnagramsCount(){
		anagramsCount++;
	}
	
	//appends an anagram to the end of a string of anagrams
	public void addAnagram(String anagram){
		anagrams = anagram + ", " + anagrams;
		incrAnagramsCount();
		//need to make update table whenever I incrAnagramsCount()
	}
	
	//returns the node of the tree associated with this letter
	public STNodeOp getSTNode(char letter){
		int value = letterToInt(letter) - 97;
		return(nodes[value]);	
	}
	
	//adds a node to the tree for this letter and the number of this node
	public void addSTNode(char letter, int nextNumber){
		STNodeOp newNode = new STNodeOp(nextNumber);
		int value = letterToInt(letter) - 97;
		d[value] = true;
		nodes[value] = newNode;
	}
	//isSTNode determines whether you call getSTNode or addSTNode
	public boolean isSTNode(char letter){
		int value = letterToInt(letter) - 97;
		if(d[value]){
			return true;
		}else{
			return false;
		}
	}
	
	//returns the char as an int
	public int letterToInt(char letter){
		return (int)letter;
	}

}
