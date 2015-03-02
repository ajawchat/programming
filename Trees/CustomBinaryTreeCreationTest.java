package Trees;

import java.util.Stack;

class CustomBinaryTreeCreation{
	private Node rootNode = null;
	
	public Node insertRoot(int val){
		if(rootNode == null){
			Node newNode = new Node(val);
			rootNode = newNode;
			newNode.left = null;
			newNode.right = null;
		}
		return rootNode;
	}
	
	
	public Node insertNode(Node parent, String side, int val){
		Node newNode = new Node(val);
		
		if(side.equals("left")){
			if(parent.left == null)
				parent.left = newNode;
		}
		else{
			if(parent.right == null)
				parent.right = newNode;
		}
		newNode.left = null;
		newNode.right = null;
		return newNode;
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


public class CustomBinaryTreeCreationTest {

	public static void main(String[] args) {
		
		CustomBinaryTreeCreation customTree = new CustomBinaryTreeCreation();
		Node root = customTree.insertRoot(5);
		Node twoLeft = customTree.insertNode(root,"left",2);
		Node twoRight = customTree.insertNode(root,"right",2);
		Node threeLeft = customTree.insertNode(twoLeft,"right",3);
		Node threeRight = customTree.insertNode(twoRight,"left",3);
		
		customTree.displayTree();
		System.out.println();
		customTree.checkSymmetry();
		
	}

}
