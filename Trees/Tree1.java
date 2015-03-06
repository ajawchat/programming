package Trees;

import java.util.HashSet;
import java.util.Stack;

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data){
		this.data =data;
	}
}


class BSTTree{
	
	Node root = null;
	
	public void insertNode(int val){
		Node newNode = new Node(val);
		
		Node x = root;
		Node y = null;
		
		while(x != null){
			y = x;
			
			if(newNode.data < x.data)
				x = x.left;
			else
				x = x.right;
			
		}
		
		if(y != null){
			if(newNode.data < y.data){
				y.left = newNode;
				
			}
			else{
				y.right = newNode;
				
			}
		}
		else{
			root = newNode;
			
		}
	}
	
	
	
	// Function to display the tree
	public void displayTree(){
		inorder(root);
		
	}
	
	public void inorder(Node root){
		if(root != null){
			inorder(root.left);
			System.out.print(" -> "+root.data);
			inorder(root.right);
		}
	}
	
	
	// Check if the tree is balanced or not
	public void isBalanced(){
		int balanced = checkBalanced(root);
		if(balanced == -1)
			System.out.println("Tree is unbalanced");
		else
			System.out.println("Tree is balanced");
	}
	
	private int checkBalanced(Node root){
		
		if(root!=null){
			
			int left = checkBalanced(root.left);
			int right = checkBalanced(root.right);
			
			System.out.println(root.data+ " l-"+left+",r-"+right);
			
			if(left == -1 | right == -1){
				// unbalanced
				return -1;
			}
			
			else if(Math.abs(left - right) < 2){
				System.out.println("balanced at root="+root.data);
				if(left > right)
					return (left+1);
				else{
					System.out.println("in else clause");
					return (right+1);
				}
			}
			else{
				System.out.println("unbalanced tree at root="+root.data);
				return -1;
			}
			
		}
		else{
			return 0;
		}
		
	}
	
	
	
	// Get the maximum depth of a BST, works for any tree
	public void maxDepth(){
		int maxDepth = 0;
		int currDepth = 0;
		int newMaxDepth = traverseTree(root, currDepth); 
		System.out.println("The max depth is "+newMaxDepth);
	}

	public int traverseTree(Node curr, int depth){
		if(curr != null){
			int left = traverseTree(curr.left, depth+1);
			int right = traverseTree(curr.right, depth +1); 

			if(left == 0 && right == 0)
				return depth;
			else if (left <= right)
				return right;
			else if (left > right)
				return left; 
		}
		else{
			return 0;
		}
		return 0;
		
	} 
	
	
	//**********************************************************************
	// Print the sum of all the nodes in the tree excluding the leaf nodes
	public void getTotalSum(){
		int sum = getSum(root);
		System.out.println("Sum : "+sum);
	}

	private int getSum(Node curr){
		if(curr.left == null && curr.right == null){
			return 0;
		}
		else {
			int left = 0;
			if(curr.left != null) 
				left = getSum(curr.left);
			int right = 0;
			if(curr.right != null) 
				right = getSum(curr.right);
			return (curr.data + left + right);
		}
		
	}


	//*****************************************************
	// This function prints the stack in a pre-order manner iteratively. 
	public void preorderIterative(Node root){
		Stack stack = new Stack();
		
		HashSet<Integer> printed = new HashSet<Integer>();
		
		Node curr = root;
		System.out.print(curr.data+"-");
		

		stack.push(curr);

		while(!stack.isEmpty()){
			while(curr.left != null){
				if(curr.left != null){
					curr = curr.left;
					stack.push(curr);
					System.out.print(curr.data+"-");
					printed.add(curr.data);
				}
			}
			
			
			curr = (Node)stack.pop();
			while(curr.right == null){
				//System.out.print(curr.data+"-");
				if(curr.right == null && curr.left == null){
					if(!printed.contains(curr.data)){
						System.out.print(curr.data+"-");
						printed.add(curr.data);
					}
						
					break;
				}
				else{
					System.out.println("in loop "+curr.data+"-");
					curr = (Node)stack.pop();
					System.out.println("after pop "+curr.data+"-");
				}
			}

			// 	The current node has a right subtree, child
			if(curr.right != null){
				curr = curr.right;
				if(!printed.contains(curr.data)){
					System.out.print(curr.data+"-");
					printed.add(curr.data);
				}
				stack.push(curr);
			}
	}
	}
	
	
	

	
	
	
	
}


public class Tree1 {

	
	public static void main(String[] args) {
		BSTTree newTree = new BSTTree();
		
		newTree.insertNode(4);
		newTree.insertNode(2);
		newTree.insertNode(5);
		newTree.insertNode(1);
		newTree.insertNode(3);
		newTree.insertNode(6);
		//newTree.insertNode(8);
		//newTree.insertNode(2);
		
		newTree.displayTree();
		
		//newTree.isBalanced();
		
		System.out.println();
		//newTree.maxDepth();
		
		//newTree.getTotalSum();
		newTree.preorderIterative(newTree.root);
		
		

	}

}
