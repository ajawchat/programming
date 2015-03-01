package Trees;

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
	
	
}


public class Tree1 {

	
	public static void main(String[] args) {
		BSTTree newTree = new BSTTree();
		
		newTree.insertNode(4);
		newTree.insertNode(2);
		newTree.insertNode(5);
		newTree.insertNode(1);
		newTree.insertNode(3);
		//newTree.insertNode(6);
		newTree.insertNode(2);
		
		newTree.displayTree();
		
		newTree.isBalanced();

	}

}
