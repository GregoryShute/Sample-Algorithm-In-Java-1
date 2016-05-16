
public class STreeOp {
	
	//the number of nodes in the tree
	int totalNodes = 0;
	STNodeOp root;
	TableOp t;

	public STreeOp(int height) {
		root = new STNodeOp(totalNodes);
		t = new TableOp(height);
		
	}
	
	public TableOp getT() {
		return t;
	}

	//updates the table
	public void upDateTable(int loc, String ana, int acount){
		t.update(loc, ana, acount);
	}
	
	//inserts a key, word pair into the tree. Encapsulates into nodes (existing or new).
	public void insert(String key, String word){
		STNodeOp temp = root;
		int keyLength = key.length();
		for(int i = 0; i < keyLength; i++){
			//if there is a node already there
			if(temp.isSTNode(key.charAt(i))){ //this should always be false when i == keyLength - 1
				if(i == keyLength - 1){
					temp = temp.getSTNode(key.charAt(i));
					temp.addAnagram(word);
					if(temp.nodeNumber == -1){
						totalNodes++;
						temp.nodeNumber = totalNodes;
					}
					upDateTable(temp.nodeNumber,temp.anagrams, temp.getAnagramsCount());
				}else{
					temp = temp.getSTNode(key.charAt(i));
				}
				
			}else{
				//if we are on the last letter
				if(i == keyLength - 1){
					totalNodes++;
					temp.addSTNode(key.charAt(i),totalNodes);
					temp = temp.getSTNode(key.charAt(i));
					temp.addAnagram(word);
					upDateTable(totalNodes,temp.anagrams, temp.getAnagramsCount());
				}else{
				//-1 means this node is empty and should not be included in table
				temp.addSTNode(key.charAt(i), -1);
				temp = temp.getSTNode(key.charAt(i));
				}
			}
		
		}
	}
	
	//final placement occurs when keyLength == 1
}
