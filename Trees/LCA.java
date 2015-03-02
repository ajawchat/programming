/*
 * Program to find the lowest common ancestor of nodes in a binary tree (not a BST)
 */

package Trees;

public class LCA {
	
	// Function to print the LCA. The function is recursive. It returns 0 if the subtree does not contain any of the nodes.
	// It returns 1 if it finds the first node in the subtree. It returns 2 if it finds the second node in the subtree.
	public int getLowestCommonAncestor(Node currNode, int node1, int node2){
		
		if(currNode == null){
			return 0;
		}
		
		
		if(currNode.data == node1){
			System.out.println("in node 1 -Node "+currNode.data);
			return node1;
		}	
		else if(currNode.data == node2){
			System.out.println("in node 2 -Node "+currNode.data);
			return node2;
		}
			
		else{
			
			int leftChild = getLowestCommonAncestor(currNode.left, node1, node2);
			int rightChild = getLowestCommonAncestor(currNode.right, node1, node2);
			
			System.out.println("Node "+currNode.data+" leftC: "+leftChild+" ,rightC: "+rightChild);
			
			if((leftChild == node1 && rightChild == node2) || (leftChild == node2 && rightChild == node1)){
				System.out.println("Found LCA. It is node "+currNode.data);
				System.exit(0);
			}
			else if ((leftChild == node1 && rightChild != node2) || (leftChild == node2 && rightChild != node1)){
				return leftChild;
			}
			else if ((leftChild != node1 && rightChild == node2) || (leftChild != node2 && rightChild == node1)){
				return rightChild;
			}
			else if ((leftChild != node1 && rightChild != node2) || (leftChild != node2 && rightChild != node1)){
				return 0;
			}
			
		}
		return 0;
		
	}
	
	
	

	public static void main(String[] args) {
		BSTTree newTree = new BSTTree();
		
		newTree.insertNode(4);
		newTree.insertNode(2);
		newTree.insertNode(5);
		newTree.insertNode(1);
		newTree.insertNode(3);
		newTree.insertNode(6);
		
		
		newTree.displayTree();
		
		LCA tree = new LCA();
		int lcaStatus = tree.getLowestCommonAncestor(newTree.root, 3, 9);
		
		// If it comes to this state, then no LCA was found. Which would mean that one or both of the nodes did not exist
		System.out.println("It seems one of the nodes does not exist");
			
	}

}
