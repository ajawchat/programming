package practiceSLL;

public class ReverseUsingTwoPointers {

	// Method to reverse a singly link list using recursion
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
	
	
	public static void main(String[] args) {
		
		// Create a LL
		LL newLL = new LL();
		newLL.insert(1);
		newLL.insert(2);
		newLL.insert(3);
		newLL.insert(4);
		newLL.insert(5);
		newLL.insert(6);
		
		newLL.displayLinkedList();
		ReverseUsingTwoPointers reverse1 = new ReverseUsingTwoPointers();
		newLL.headNode = reverse1.reverseLL(newLL.headNode, newLL.headNode.next);
		
		System.out.println();
		newLL.displayLinkedList();
	}

}
