// program to create a BST from a sorted array

package Trees;

import java.util.HashSet;
import java.util.Set;

public class Tree2 {
	
	Set indexSet = new HashSet();
	
	private BSTTree newTree = new BSTTree();
	
	public void createBSTFromArray(int[] arr, int low, int high, int len){
		
		System.out.println("low="+low+" high="+high);
		
		if(low == high){
			System.out.println("arr["+low+"] inserting...value ="+arr[low]);
			if(!indexSet.contains(low)){
				newTree.insertNode(arr[low]);
				indexSet.add(low);
			}
		}
		else if (high - low == 1){
			System.out.println("In else-if arr["+low+"] inserting...value ="+arr[low]);
			if(!indexSet.contains(low)){
				newTree.insertNode(arr[low]);
				indexSet.add(low);
			}
			if(high == len && len%2 == 0){
				System.out.println("In length arr["+high+"] inserting...value ="+arr[high]);
				if(!indexSet.contains(high)){
					newTree.insertNode(arr[high]);
					indexSet.add(high);
				}
			}
		}
		else{
			int mid = (low + high) / 2;
			System.out.println("In else part arr["+mid+"] inserting...value ="+arr[mid]);
			if(!indexSet.contains(mid)){
				newTree.insertNode(arr[mid]);
				indexSet.add(mid);
			}
			createBSTFromArray(arr, low, mid, len);
			System.out.println("mid+1="+(mid+1)+" to high="+high);
			createBSTFromArray(arr, mid+1, high, len);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,8,9};
		
		Tree2 tree = new Tree2();
		
		tree.createBSTFromArray(arr, 0, arr.length-1, arr.length-1);
		tree.newTree.displayTree();
		
		
	}

}
