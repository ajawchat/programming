package practiceSLL;

import java.util.Stack;



class Node{
	int data;
	Node next;

	
	Node(int data){
		this.data = data;
		next = null;
	}
}


class LL{
	
	Node headNode = null;
	
	
	// Check if palindrome using stack
	public boolean checkPalindrome(){
		// Create a new stack for storing the 
		Stack dataStack = new Stack();
		
		Node tempNode = headNode;
		while(tempNode != null){
			dataStack.push(tempNode.data);
			tempNode = tempNode.next;
		}
		
		// Traverse again for verification
		tempNode = headNode;
		int N = dataStack.size();
		for(int i =0; i < (N/2)+1; i++){
			
			if(tempNode.data == (int)dataStack.pop()){
				tempNode = tempNode.next;
			}
			else{
				return false;
			}
		}
		
		return true;
		
		
	}
	
	
	public void insert(int elem){
		Node newNode = new Node(elem);
		
		if (headNode == null){
			headNode = newNode;
			newNode.next = null;
		}
		else{
			Node temp = headNode;
			while(temp.next != null){
				temp = temp.next;
			}
			
			temp.next = newNode;
			newNode.next = null;
		}
	}
	
	public void displayLinkedList(){
		Node temp = headNode;
		while(temp != null){
			System.out.print(" -> "+temp.data);
			temp = temp.next;
		}
		
	}
	
	
	public void deleteNode(int elem){
		Node temp = headNode;
		
		while(temp.next.data != elem){
			temp = temp.next;
			if(temp.next == null){
				System.out.println("Element "+elem+" not found");
				return;
			}
				
		}
		temp.next = temp.next.next;
		
	}
	
	
	public void insertAhead(int val){
		Node newNode = new Node(val);
		newNode.next = headNode;
		headNode = newNode;
	}
	
	
	
	public boolean isEmpty(){
		return (headNode == null);
	}

	
	public void search(int elem){
		
	}
	
	// Call to reverse the linked list using recursion
	public void reverse(){
		this.headNode = reverseLL(headNode, headNode.next);
	}
	
	// Code for reversing the singly link list. Returns the new head node
	public Node reverseLL(Node temp1, Node temp2 ){
		// If we reach the ending node, start the backtracking
		if(temp2.next == null){
			temp2.next = temp1;
			temp1.next = null;
			return temp2;
		}
		// Recurse into the loop giving the new arguments
		else{
			Node newHead = reverseLL(temp2, temp2.next);
			temp2.next = temp1;
			temp1.next = null;
			return newHead;
		}
	}
	
	
	
}

