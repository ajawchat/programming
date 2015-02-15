package CLL;

public class CLL_Test {

	// Function to circulate through the linked list and delete every m node
	public void deleteMthNode(CLLList list, int m){
		Node temp = list.headNode;
		
		while(list.getSize() > 1){
			
			for(int i = 1; i < m; i++){
				temp = temp.next;
			}
			
			// Delete the node
			list.deleteNode(temp);
		}
		
		// The game stops as we have a winner
		System.out.println("The winner is ");
		list.displayLL();
		
	}
	
	
	public static void main(String[] args) {
		
		CLLList newList = new CLLList();
		
		newList.insert(1);
		newList.insert(2);
		newList.insert(3);
		newList.insert(4);
		newList.insert(5);

		newList.displayLL();
		System.out.println("\n"+newList.getSize());
		
		CLL_Test circularListTest = new CLL_Test();
		circularListTest.deleteMthNode(newList, 3);
		
		
	}

}
