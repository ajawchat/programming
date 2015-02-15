package CLL;


class Node{
	int data;
	Node next;

	Node(int data){
		this.data = data;
		next = null;
	}
}

public class CLLList {
	
	Node headNode = null;
	
	public void insert(int elem){
		Node newNode = new Node(elem);
		
		if (headNode == null){
			headNode = newNode;
			newNode.next = headNode;
		}
		else{
			Node temp = headNode;
			while(temp.next != headNode){
				temp = temp.next;
			}
			
			temp.next = newNode;
			newNode.next = headNode;
		}
	}
	
	
	public void displayLL(){
		
		Node temp = headNode;
		System.out.print(temp.data+"->");
		
		temp = temp.next;
		
		while(temp != headNode){
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		
	}
	
	
	public void deleteNode(Node delNode){
		Node temp = headNode;
		
		while(!(temp.next.equals(delNode))){
			temp = temp.next;
		}
		
		if(delNode == headNode){
			headNode = headNode.next;
		}
		
		temp.next = temp.next.next;
		
	}
	
	
	public void delNodeFast(Node delNode){
		if(delNode.equals(headNode)){
			headNode = null;
		}
		else if (delNode.next == headNode){
			delNode.data = delNode.next.data;
			delNode.next = delNode.next.next;
			headNode = delNode;
		}
		else{
			delNode.data = delNode.next.data;
			delNode.next = delNode.next.next;
		}
	}
	
	
	// Function to get the size of the linked list
	public int getSize(){
		Node temp;
		int size = 0;
		
		if(headNode != null){
			temp = headNode;
			size = 1;
		}
		else
			return 0;
		while(temp.next != headNode){
			size++;
			temp = temp.next;
		}
		return size;
	}
	
	
	
}
