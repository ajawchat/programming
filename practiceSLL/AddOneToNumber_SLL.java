package practiceSLL;

public class AddOneToNumber_SLL {

	public LL addOneToLL(LL numLL, int numToAdd){
		
		Node temp = numLL.headNode.next;
		
		boolean carry = false;
		
		// Create a new LL to store the result and return it
		LL addedNum = new LL();
		
		// Add the first digit of the linked list
		int val = numLL.headNode.data + numToAdd;
		if(val >= 10){
			carry = true;
			addedNum.insert(val%10);
		}
		
		// Add the other digits of the LL
		while(temp != null){
			if(carry == true){
				val = temp.data + 1;
				if(val >= 10){
					addedNum.insert(val%10);
				}
				else{
					addedNum.insert(val);
					carry = false;
				}
			}
			// If no carry from the pervious addition
			else{
				addedNum.insert(temp.data);
			}
			temp = temp.next;
		}
		
		return addedNum;
	}
	
	
	
	// Call to add
	
	public void addOneRecursiveCall(LL numLL, int num){
		
		// Create a new LL. For the result
		LL newLL = new LL();
		
		Object[] receivedData = addOneRecursive(numLL.headNode, num);
		
		// Assign the node received as the headNode
		newLL.headNode = (Node)receivedData[0];
		
		// Display the new added number
		System.out.println();
		newLL.displayLinkedList();
		
	}
	
	
	//**********************************************
	// Function to add 1 to the linked list without reversing
	
	public Object[] addOneRecursive(Node currNode, int num){
		// This is the object that will be returned
		Object[] returnData = new Object[2];
		
		if(currNode.next == null){
			// Last digit. add one to it
			int val = currNode.data + num;
			if(val >= 10){
				returnData[1] = 1;//(Integer)(1);
				returnData[0] = new Node(val%10);
			}
			else{
				returnData[1] = 0;//(Integer)(1);
				returnData[0] = new Node(val);
			}
			return returnData;
		}
		else{
			Object[] receivedData = addOneRecursive(currNode.next, num);
			
			// Unpack the objects received from the earlier call
			int carry = (Integer)receivedData[1];
			Node receivedNode = (Node)receivedData[0];
			
			//Create a new node and point it to the earlier node
			Node newNode;
			
			if(carry == 1){
				int val = currNode.data + 1;
				if(val >= 10){
					returnData[1] = 1;//(Integer)(1);
					newNode = new Node(val%10);
					// POint the current node to the receivedNode
					newNode.next = receivedNode;
					returnData[0] = newNode;
				}
				else{
					returnData[1] = 0;//(Integer)(1);
					newNode = new Node(val);
					// POint the current node to the receivedNode
					newNode.next = receivedNode;
					returnData[0] = newNode;
				}
				
				// Return the object array to the previous calls
				return returnData; 
			}
			// If carry is zero, just append the current digits [as they would be added by 0]
			else{
				returnData[1] = 0;//(Integer)(1);
				newNode = new Node(currNode.data);
				// POint the current node to the receivedNode
				newNode.next = receivedNode;
				returnData[0] = newNode;
			}
			
		}
		return returnData;
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		AddOneToNumber_SLL addone = new AddOneToNumber_SLL();
		
		// Create a LL
		LL newLL = new LL();
		newLL.insert(1);
		newLL.insert(9);
		newLL.insert(9);
		newLL.insert(9);
		newLL.insert(2);
				
		newLL.displayLinkedList();
		
		/*
		// Reverse the linked list containing numbers
		ReverseUsingTwoPointers reverse1 = new ReverseUsingTwoPointers();
		newLL.headNode = reverse1.reverseLL(newLL.headNode, newLL.headNode.next);
		
		int numToAdd = 1;
		
		LL addedNum = addone.addOneToLL(newLL, numToAdd);
		addedNum.headNode = reverse1.reverseLL(addedNum.headNode, addedNum.headNode.next);
		
		System.out.println();
		addedNum.displayLinkedList();
		*/
		
		// Adding number to 1 without reversing
		addone.addOneRecursiveCall(newLL, 9);
		
	}

}
