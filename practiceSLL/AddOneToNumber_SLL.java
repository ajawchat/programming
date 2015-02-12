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
	
	
	public static void main(String[] args) {
		
		AddOneToNumber_SLL addone = new AddOneToNumber_SLL();
		
		// Create a LL
		LL newLL = new LL();
		newLL.insert(1);
		newLL.insert(9);
		newLL.insert(9);
		newLL.insert(9);
				
		newLL.displayLinkedList();
		
		// Reverse the linked list containing numbers
		ReverseUsingTwoPointers reverse1 = new ReverseUsingTwoPointers();
		newLL.headNode = reverse1.reverseLL(newLL.headNode, newLL.headNode.next);
		
		int numToAdd = 1;
		
		LL addedNum = addone.addOneToLL(newLL, numToAdd);
		addedNum.headNode = reverse1.reverseLL(addedNum.headNode, addedNum.headNode.next);
		
		System.out.println();
		addedNum.displayLinkedList();
	}

}
