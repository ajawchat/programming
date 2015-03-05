package Trees;

import java.util.ArrayList;
import java.util.List;

public class Tree4 {
	
	public List<List<Integer>> pathSum(Node root, int sum) {
        List<List<Integer>> elements = new ArrayList<List<Integer>>();
        
        List<Integer> currPath = new ArrayList<Integer>();
        
        traverseTree(root, currPath, sum, 0, elements);
        
        return elements;
    }
    
    
    public void traverseTree(Node curr, List<Integer> currPath, int sum, int total, List<List<Integer>> elements){
        if(curr != null){
        	List<Integer> thisPath = new ArrayList<Integer>();
        	for(int k=0; k <currPath.size(); k++)
        		 thisPath.add(currPath.get(k));
            
            // check if the sum equals till now
            if(curr.left == null && curr.right == null){
                if(curr.data + total == sum){
                    //print path
                	System.out.println("Found");
                	currPath.add(curr.data);
                    for(int i = 0; i < currPath.size(); i++){
                        System.out.print("-"+currPath.get(i));
                    }
                    elements.add(currPath);
                    return;
                }
                else
                    return;
            }
            else{
                currPath.add(curr.data);
                if(currPath == thisPath)
                	System.out.println("Equal");
                traverseTree(curr.left, currPath, sum, total+curr.data, elements);
                thisPath.add(curr.data);
                traverseTree(curr.right, thisPath, sum, total+curr.data, elements);
            }
        }
        else{
            return;
        }
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
		newTree.insertNode(7);
		
		newTree.displayTree();
		System.out.println();
		
		Tree4 tree4 = new Tree4();
		
		List<List<Integer>> list = tree4.pathSum(newTree.root, 27);
		
		System.out.println("[");
		for(int i = 0; i < list.size(); i++){
			System.out.print("[");
			for(int j = 0; j < list.get(i).size(); j++)
				System.out.print(list.get(i).get(j));
			System.out.print("],");	
			}
		System.out.println("]");
			
}
}