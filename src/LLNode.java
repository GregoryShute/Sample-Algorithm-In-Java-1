
public class LLNode {
	
	LLNode nextNode;
	String value;
	int nodeCount;
	LLNode lastNode;
	String key;

	public LLNode() {
		nodeCount = 1;
		//this creates a wild chain of lastNodes, need another way to deal with this. Actually I think this is fine I think I was looking at the array
		lastNode = this;
		nextNode = null;
		key = null;
	}
	
	public void addNode(String value){
		//create the new node
		LLNode newNode = new LLNode();
		newNode.setValue(value);
		//newNode does not have a nextNode
		//place it in
		lastNode.setNextNode(newNode);
		lastNode = newNode;
	}
	
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public LLNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(LLNode nextNode) {
		this.nextNode = nextNode;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}

	public LLNode getLastNode() {
		return lastNode;
	}

	public void setLastNode(LLNode lastNode) {
		this.lastNode = lastNode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	

}
