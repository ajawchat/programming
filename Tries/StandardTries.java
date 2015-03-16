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
					if(temp.title == firstChar){
						System.out.println("Found char "+firstChar);
						break;
					}
					temp = temp.sibling;
				}
				// Check if the first character is already entered into the root node, else enter it manually
				if(temp.title != firstChar){
					TrieNode newFirstChar = new TrieNode(firstChar);
					temp.sibling = newFirstChar;
					temp.sibling.isFinalNode = false;
					temp = newFirstChar;
				}
			}
			
			for(int j = 1; j < doc[i].length(); j++){
				temp = insertNode(temp,doc[i].charAt(j));
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
			TrieNode tempLink2 = tempLink;
			while(tempLink != null){
				// Find the character we require
				if(tempLink.title == current){
					// Go inside the object and further traverse it
					System.out.println("Found character "+current+", not re-entering it...");
					return tempLink;
				}
				tempLink2 = tempLink;
				tempLink = tempLink.sibling;
			}
			// Reaching at this point would mean there is no such character in the trie at that level. So we insert it
			//System.out.println("Current char to be aded is "+current);
			TrieNode newNode = new TrieNode(current);
			tempLink2.isFinalNode = false;
			tempLink2.sibling = newNode;
			return newNode;
		
		}
		
		
	}
	
	
	// Function to diplay the trie
	public void displayTrie(){
		TrieNode temp = root;
		System.out.println("The root is "+temp.title);
		//System.out.println(temp.child.title);
		//System.out.println(temp.child.sibling.title);
		temp = temp.child;
		// navigate the siblings
		while(temp != null){
			System.out.println("\nstarting with "+temp.title);
			TrieNode rootChild = temp;
			while(rootChild != null){
				System.out.println("\nCurr char: "+rootChild.title);
				TrieNode splits = rootChild.child;
				while(splits != null){
					System.out.print("siblings:"+splits.title+",");
					splits = splits.sibling;
				}
				rootChild = rootChild.child;
			}
			temp = temp.sibling;
		}
	}
	
	
	// Implement the searching functionality
	public boolean isPresentinTrie(String word){
		
		TrieNode temp = root;
		
		int i = 0;
		boolean found = false;
		
		while(temp != null && i < word.length()){
			found = false;
			// we need to select the right child
			TrieNode tempChild = temp.child;
			while(tempChild != null){
				if(tempChild.title == word.charAt(i)){
					System.out.println("Found char "+word.charAt(i));
					temp = tempChild;
					found = true;
				}
				tempChild = tempChild.sibling;
			}
			
			if(!found)
				return false;
			else
				i++;
		}
		if(!found && i >= word.length())
			return false;
		else
			return true;
	}
	
	
	
}


public class StandardTries {
	
	public static void main(String[] args){ 
	
		String doc[] = {"this","is","a","test","testing","them"};
		
		BuildTrie trie = new BuildTrie();
		trie.createTrie(doc);
		trie.displayTrie();
		System.out.println(trie.isPresentinTrie("testing"));
		
	}
	
}
