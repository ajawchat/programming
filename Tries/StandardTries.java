// An implementation of a standard trie to hold strings


package Tries;


class TrieNode{
	char title;
	TrieNode child;
	TrieNode sibling;
	boolean isFinalNode;
	
	public TrieNode(char character){
		title = character;
		child = null;
		sibling = null;
		isFinalNode = true;
	}
}


class BuildTrie{
	
	TrieNode root = new TrieNode('*'); // * represents the root node
	
	public void createTrie(String[] doc){
		// Access each word of the sentence
		for(int i = 0; i < doc.length; i++){
			// Access each character of the sentence
			
			char firstChar = doc[i].charAt(0);
			
			TrieNode temp = root;
			if(temp.child == null){
				TrieNode newFirstChar = new TrieNode(firstChar);
				temp.child = newFirstChar;
				temp.isFinalNode = false;
				temp = newFirstChar;
			}
			else{
				temp = temp.child;
				while(temp.sibling != null){
					temp = temp.sibling;
					if(temp.title == doc[i].charAt(0)){
						break;
					}
				}
				// Check if the first character is already entered into the root node, else enter it manually
				if(temp.title != doc[i].charAt(0)){
					TrieNode newFirstChar = new TrieNode(doc[i].charAt(0));
					temp.sibling = newFirstChar;
					temp.sibling.isFinalNode = false;
					temp = newFirstChar;
				}
			}
			
			
			
			for(int j = 1; j < doc[i].length(); j++){
				temp = insertNode(temp,doc[i].charAt(j));
				System.out.println("Entered char into trie");
			}
		}
	}
	
	
	public TrieNode insertNode(TrieNode curr, char current){
		
		if(curr.child == null){
			// No characters have been inserted yet. Insert the first One by creating it
			TrieNode newNode = new TrieNode(current);
			curr.child = newNode;
			curr.isFinalNode = false;
			return newNode;
		}
		else{
			// traverse the link list till the end
			TrieNode tempLink = curr.child;
			while(tempLink.child != null){
				tempLink = tempLink.child;
				// Find the character we require
				if(tempLink.title == current){
					// Go inside the object and further traverse it
					return tempLink;
				}
			}
			// Reaching at this point would mean there is no such character in the trie as of now. So we insert it
			TrieNode newNode = new TrieNode(current);
			tempLink.isFinalNode = false;
			tempLink.child = newNode;
			return newNode;
		}
		
		
	}
	
	
	// Function to diplay the trie
	public void displayTrie(){
		TrieNode temp = root;
		System.out.println("The root is "+temp.title);
		//System.out.println(temp.child.title);
		//System.out.println(temp.child.sibling.title);
		while(temp != null){
			System.out.print(temp.title+" -> ");
			temp = temp.child;
		}
	}
	
	
	
}


public class StandardTries {
	
	public static void main(String[] args){ 
	
		String doc[] = {"this","is","a","test"};
		
		BuildTrie trie = new BuildTrie();
		trie.createTrie(doc);
		trie.displayTrie();
		
	}
	
}
