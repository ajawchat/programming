package practiceSLL;

public class ReverseKNodes {

	// 
	public void reverseKNodes(LL list, int k){
		
		Node firstNode = list.headNode;
		Node lastNodeInList = firstNode;
		
		// Flag to determine whether the reversal is the first one or not
		boolean firstRound = true;
		
		while(true){
			// check if the list has k nodes from the node firstNode
			Node kNode = checkKNodes(list, firstNode, k-1);
			
			
			if(kNode != null){
				list.displayLinkedList();
				
				System.out.println("FirstNode: "+ firstNode.data);
				// Get the (k+1)th node
				Node kNext = getKNextNode(list, firstNode, k);
				if(kNext != null)
					System.out.println("knext: "+kNext.data);
				
				Node temp = firstNode;
				
				// Join the previous end of the link to the kth node
				//Node kNode = getKthNode(list,firstNode,k-1);
				
				if(firstRound == false){
					lastNodeInList.next = kNode;
				}
				
				
				// Recurse the nodes k times and reverse them, return the currNode
				lastNodeInList = recReverse(list,temp,1,k, firstRound);
				System.out.println("last node in list: "+lastNodeInList.data);
				
				// Change the flag after the first round
				firstRound = false;
				
				if(kNext != null){
					// Link the last node after reversal to the (k+1)th node
					lastNodeInList.next = kNext;
				
					// Repeat the loop with kNext as the first loop
					firstNode = kNext;
				}
				else{
					// This is to stop the linked list from printing an infinite loop
					lastNodeInList.next = null;
					list.displayLinkedList();
					break;
				}
			}
			// If there are no more k nodes in the list, after reversals, return to the main function
			else{
				System.out.println("In ELSE");
				list.displayLinkedList();
				break;
			}
		}
	}

	
	// Function to perform recursion to reverse the list
	public Node recReverse(LL list, Node temp, int currCnt, int k, boolean firstRound){
		System.out.println("currNode in recursion: "+temp.data);
		// Terminating condition
		if(currCnt == k){
			if(firstRound == true){
				// Point the head Node to this node and start backtracking
				list.headNode = temp;
			}
			return temp;
		}
		else{
			// The node returned is the next node. Point the next of this node to the current node and backtrack
			Node nextNode = recReverse(list, temp.next, currCnt+1, k, firstRound);
			nextNode.next = temp;
			System.out.println("In this step: "+nextNode.data+" -> "+temp.data);
			return temp;
		}
	}
	
	
	// Function to return the (K+1)th node
	public Node getKNextNode(LL list, Node firstNode, int k){
		Node temp = firstNode;
		while(k > 0){
			k--;
			//System.out.println(temp.data);
			if(temp.next == null)
				return null;
			else
				temp = temp.next;
			
		}
		return temp;
	}
	
	
	
	
	// Function to check if there are k nodes or not
	public Node checkKNodes(LL list, Node firstNode, int k){
		Node temp = firstNode;
		while(k > 0){
			k--;
			temp = temp.next;
			if(temp == null)
				return null;
		}
		return temp;
	}
	
	
	
	public static void main(String[] args) {
		
		// Create a linked list
		LL list1 = new LL();
		list1.insert(1);
		list1.insert(2);
		list1.insert(3);
		list1.insert(4);
		list1.insert(5);
		list1.insert(6);
		list1.insert(7);
		list1.insert(8);
		list1.insert(9);
		list1.insert(10);
		
		int K = 5;
		
		list1.displayLinkedList();
		System.out.println();
		
		
		// Create a local instance
		ReverseKNodes reverseK = new ReverseKNodes();
		reverseK.reverseKNodes(list1, K);
		
		

	}

}
