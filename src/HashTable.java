
public class HashTable {

	String[] keyTable;
	LLNode[] valueTable;
	int Size_m;
	
	// need to do this linked list style
	public HashTable(int Size_m) {
		keyTable = new String[Size_m];
		valueTable = new LLNode[Size_m];
		this.Size_m = Size_m;
	}

	public void insert(String key, String value){
		//Step 1: look for the key
		//System.out.println(key);
		for(int i = 0; i < Size_m; i++){
			if(keyTable[i] == null){
				keyTable[i] = key;
				valueTable[i] = new LLNode();
				//System.out.println(key);
				valueTable[i].setKey(key);
				valueTable[i].setValue(value);
				break;
			}
			if(key.equals(keyTable[i])){
				addAnagram(valueTable[i], value);
				break;
			}
		}
	}
	//Problem is with this method
	public void addAnagram(LLNode node, String value){
		if(!node.getValue().equals(null)){
			node.setValue(value);
		}else{
			node.addNode(value);
		}
	}
	
	public void lookupAnagrams(){
		
		for(int i = 0; i < valueTable.length; i++){
			LLNode tNode = new LLNode();
			if(valueTable[i] != null){
				tNode = valueTable[i];
				System.out.println(valueTable[i].getValue() + ", ");
				while(tNode.nextNode != null){
					tNode = tNode.nextNode;
					System.out.print(tNode.getValue() + ", ");
				}
				System.out.println();
			}
		}
		
	}
	
}
