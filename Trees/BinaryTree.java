// Program to build a binary tree (not BST) based on a queue

package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class BinaryTreeCreation {
	private Node rootNode = null;
	private Node currNode = null;
	private Queue<Node> queue;
	
	BinaryTreeCreation(){
		queue = new LinkedList<Node>();
	}
	
	
	public void insert(int val){
		
		Node newNode = new Node(val);
		
		if(rootNode == null){
			rootNode = newNode;
			
		}
		else{
			if(currNode == null){
				currNode = queue.remove();
				if(currNode.left == null)
					currNode.left = newNode;
				else if(currNode.right == null)
					currNode.right = newNode;
			}
			else{
				if(currNode.left == null)
					currNode.left = newNode;
				else if(currNode.right == null){
					currNode.right = newNode;
					currNode = null;
				}
			}
		}
		
		newNode.left = null;
		newNode.right = null;
		queue.add(newNode);
	}
	
	
	
	// Function to display the tree
		public void displayTree(){
			inorder(rootNode);
			
		}
		
		public void inorder(Node root){
			if(root != null){
				inorder(root.left);
				System.out.print(" -> "+root.data);
				inorder(root.right);
			}
		}
		
		
		
		
		// Function to check if the binary tree is symmetric
		Stack stack = new Stack();
		
		public void checkSymmetry(){
			// Push each node data into a stack during an in-order traversal
			inorderPush(rootNode);
			
			// Pop and check each node data into a stack during an in-order traversal
			inorderPop(rootNode);
		}
		
		public void inorderPush(Node root){
			if(root != null){
				inorderPush(root.left);
				stack.push(root.data);
				inorderPush(root.right);
			}
		}
	
		public void inorderPop(Node root){
			if(root != null){
				inorderPop(root.left);
				if(root.data != (int)stack.pop()){
					System.out.println("Not symmetric");
					System.exit(0);
				}
				inorderPop(root.right);
			}
		}
		
}



public class BinaryTree{
	public static void main(String[] a){
		BinaryTreeCreation binaryTree = new BinaryTreeCreation();
		binaryTree.insert(5);
		binaryTree.insert(2);
		binaryTree.insert(2);
		binaryTree.insert(3);
		binaryTree.insert(4);
		binaryTree.insert(4);
		binaryTree.insert(3);
		
		binaryTree.displayTree();
		System.out.println();
		binaryTree.checkSymmetry();
		
	}
}

