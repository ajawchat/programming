// Program to print out all the paths in a BST which add up to a particular value
package Trees;

import java.util.ArrayList;

public class Tree3 {
	
	// Do an inorder traversal and send some information to each node ahead: 
	// <the requested value, ArrayList of path traversed till current node>
	public void printPathsValue(BSTTree tree, int val){
		if(tree.root == null){
			System.out.println("Tree Empty");
		}
		else{	
			ArrayList coveredPath = new ArrayList();
			traversePath(tree.root, val, coveredPath);
		}
	}
	
	
	public void traversePath(Node curr, int val, ArrayList coveredPath){
		System.out.println("In traverse");
		
		if(curr != null){
			// Iterate over the ArrayList and check for each node from the end
			int sum = curr.data;
			for(int i = coveredPath.size() - 1; i >= 0; i--){
				System.out.println("Curr Node: "+curr.data+" , curr comp:"+coveredPath.get(i));
				sum += (int)coveredPath.get(i);
				
				if (sum == val){
					// The values added upto the required value. Print the path
					System.out.println("Path Found");
					for(int j = i; j < coveredPath.size(); j++)
						System.out.print(coveredPath.get(j) +" "+ curr.data);
				}
				else if (sum > val){
					// No path found ending in this node. Break out of the loop
					break;
				}
				// Keep looking if sum < val
			}	
			// Add currNode to the array of coveredPaths, and explore child nodes
			coveredPath.add(curr.data);
			
			// Traverse the left of the currNode
			traversePath(curr.left, val, coveredPath);		
			
			// Before traversing to the right side, remove the children from the left child in the arraylist
			
			// Traverse the right of the currNode
			traversePath(curr.right, val, coveredPath);
		}
		else
			return;
	}


	
	
	public static void main(String[] args) {
		BSTTree newTree = new BSTTree();
		
		newTree.insertNode(5);
		newTree.insertNode(2);
		newTree.insertNode(3);
		newTree.insertNode(4);
		newTree.insertNode(1);
		newTree.insertNode(9);
		newTree.insertNode(6);
		newTree.insertNode(10);
		
		newTree.displayTree();
		
		Tree3 tree = new Tree3();
		tree.printPathsValue(newTree, 14);
		

	}

}
